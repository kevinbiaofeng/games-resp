package com.ly.common.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;

public class HttpClientPool {

    // Single-element enum to implement Singleton.
    private static enum Singleton {

        // Just one of me so constructor will be called once.

        Client;
        // The thread-safe client.
        private final CloseableHttpClient threadSafeClient;
        // The pool monitor.
        private final IdleConnectionMonitor monitor;
        
        private static final String HTTP = "http";
        private static final String HTTPS = "https";
        
        // The constructor creates it - thus late
        private Singleton() {
            
            SSLContextBuilder sslBuilder = new SSLContextBuilder();
            // 全部信任 不做身份鉴定
            try {
				sslBuilder.loadTrustMaterial(null, new TrustStrategy() {
				    @Override
				    public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
				        return true;
				    }
				});
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (KeyStoreException e) {
				e.printStackTrace();
			}
            
            SSLContext sslCont = null;
            
            try {
            	sslCont = sslBuilder.build();
			} catch (KeyManagementException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
            
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslCont, new String[]{"SSLv2Hello", "SSLv3", "TLSv1"}, null, NoopHostnameVerifier.INSTANCE);
            
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory())
                    .register(HTTPS, sslsf)
                    .build();
            
            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
            // Increase max total connection to 500
            cm.setMaxTotal(500);
            // Increase default max connection per route to 500
            cm.setDefaultMaxPerRoute(500);

            // Make my builder.
            //HttpClientBuilder builder = HttpClients.custom()
                    //.setRedirectStrategy(new LaxRedirectStrategy())
                    //.setConnectionManager(cm);
            
            threadSafeClient = HttpClients.custom()
                    .setSSLSocketFactory(sslsf)
                    .setConnectionManager(cm)
                    .setConnectionManagerShared(true)
                    .build();
            
            // Start up an eviction thread.
            monitor = new IdleConnectionMonitor(cm);
            // Start up the monitor.
            Thread monitorThread = new Thread(monitor);
            monitorThread.setDaemon(true);
            monitorThread.start();
        }

        public CloseableHttpClient get() {
            return threadSafeClient;
        }

    }

    public static CloseableHttpClient getClient() {
        // The thread safe client is held by the singleton.
        return Singleton.Client.get();
    }

    public static void shutdown() throws InterruptedException, IOException {
        // Shutdown the monitor.
        Singleton.Client.monitor.shutdown();
    }

    // Watches for stale connections and evicts them.
    private static class IdleConnectionMonitor implements Runnable {

        // The manager to watch.

        private final PoolingHttpClientConnectionManager cm;
        // Use a BlockingQueue to stop everything.
        private final BlockingQueue<Stop> stopSignal = new ArrayBlockingQueue<Stop>(1);

        IdleConnectionMonitor(PoolingHttpClientConnectionManager cm) {
            this.cm = cm;
        }

        public void run() {
            try {
                // Holds the stop request that stopped the process.
                Stop stopRequest;
                // Every 5 seconds.
                while ((stopRequest = stopSignal.poll(5, TimeUnit.SECONDS)) == null) {
                    // Close expired connections
                    cm.closeExpiredConnections();
                    // Optionally, close connections that have been idle too long.
                    cm.closeIdleConnections(60, TimeUnit.SECONDS);
                }
                // Acknowledge the stop request.
                stopRequest.stopped();
            } catch (InterruptedException ex) {
                // terminate
            }
        }

        // Pushed up the queue.
        private static class Stop {

            // The return queue.
            private final BlockingQueue<Stop> stop = new ArrayBlockingQueue<Stop>(1);

            // Called by the process that is being told to stop.
            public void stopped() {
                // Push me back up the queue to indicate we are now stopped.
                stop.add(this);
            }

            // Called by the process requesting the stop.
            public void waitForStopped() throws InterruptedException {
                // Wait until the callee acknowledges that it has stopped.
                stop.take();
            }

        }

        public void shutdown() throws InterruptedException, IOException {
            // Signal the stop to the thread.
            Stop stop = new Stop();
            stopSignal.add(stop);
            // Wait for the stop to complete.
            stop.waitForStopped();
            // Close the pool.
            HttpClientPool.getClient().close();
            // Close the connection manager.
            cm.close();
        }

    }

}