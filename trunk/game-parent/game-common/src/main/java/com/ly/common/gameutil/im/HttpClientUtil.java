package com.ly.common.gameutil.im;

import java.net.URI;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	private static SSLContextBuilder builder = null;
	private static final String HTTP = "http";
	private static final String HTTPS = "https";
	private static SSLConnectionSocketFactory sslsf = null;
	private static PoolingHttpClientConnectionManager cm = null;
	private static RequestConfig requestConfig = null;

	static {
		try {
			builder = new SSLContextBuilder();
			// 全部信任 不做身份鉴定
			builder.loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
					return true;
				}
			});
			sslsf = new SSLConnectionSocketFactory(builder.build(), new String[] { "SSLv2Hello", "SSLv3", "TLSv1" }, null, NoopHostnameVerifier.INSTANCE);
			Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().register(HTTP, new PlainConnectionSocketFactory()).register(HTTPS, sslsf).build();
			cm = new PoolingHttpClientConnectionManager(registry);
			cm.setMaxTotal(2000);// max connection
			if (requestConfig == null) {
				// 用于内部环境使用到代理。不然无法发送和接受返回请求
				// HttpHost proxy = new HttpHost("127.0.0.1", 8888);
				// requestConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(3000).setSocketTimeout(5000).setProxy(proxy).setRedirectsEnabled(false).build();
				requestConfig = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(20000).setSocketTimeout(30000).setRedirectsEnabled(false).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * String格式字符串get请求
	 * 
	 * @author 阿布
	 * @param logPrefix
	 *            日志前缀
	 * @param url
	 *            请求地址
	 * @return String
	 */
	public static String getString(String logPrefix, String url) {
		return getString(logPrefix, url, null, null);
	}

	/**
	 * 
	 * String格式字符串get请求
	 * 
	 * @author 阿布
	 * @param logPrefix
	 *            日志前缀
	 * @param url
	 *            请求地址
	 * @param header
	 *            头部信息
	 * @return String
	 */
	public static String getString(String logPrefix, String url, Map<String, Object> header) {
		return getString(logPrefix, url, header, null);
	}

	/**
	 * 
	 * String格式字符串get请求
	 * 
	 * @author 阿布
	 * @param logPrefix
	 *            日志前缀
	 * @param parameter
	 *            参数map
	 * @param url
	 *            请求地址
	 * @return String
	 */
	public static String getString(String logPrefix, Map<String, Object> parameter, String url) {
		return getString(logPrefix, url, null, parameter);
	}

	/**
	 * 
	 * String格式字符串get请求
	 * 
	 * @author 阿布
	 * @param logPrefix
	 *            日志前缀
	 * @param url
	 *            请求地址
	 * @param header
	 *            头部信息
	 * @param parameter
	 *            地址栏后跟随参数
	 * @return String
	 */
	public static String getString(String logPrefix, String url, Map<String, Object> header, Map<String, Object> parameter) {
		// System.out.println(logPrefix + " post=url:" + url);
		HttpGet httpGet = new HttpGet();
		httpGet.setConfig(requestConfig);
		// 判断请求得抬头集合不为空，循环加入抬头
		httpGet.setHeader("Content-Type", "application/json");
		httpGet.setHeader("Content-Encoding", "utf-8");
		httpGet.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
		if (header != null) {
			for (Map.Entry<String, Object> entry : header.entrySet()) {
				httpGet.setHeader(entry.getKey(), entry.getValue() + "");
			}
		}
		if (parameter != null) {
			StringBuilder sb = new StringBuilder("?");
			for (Map.Entry<String, Object> entry : parameter.entrySet()) {
				sb.append(entry.getKey());
				sb.append("=");
				sb.append(entry.getValue());
				sb.append("&");
			}
			url += sb.substring(0, sb.lastIndexOf("&")).toString();
		}

		String str = null;
		try {
			httpGet.setURI(new URI(url));
			str = sendEntity(logPrefix, httpGet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 
	 * String格式JSON字符串 post请求
	 * 
	 * @author 阿布
	 * @param jsonObject
	 *            json字符串
	 * @param logPrefix
	 *            日志前缀
	 * @param url
	 *            请求地址
	 * @return
	 */
	public static String postString(String jsonObject, String logPrefix, String url) {
		return postString(jsonObject, logPrefix, url, null, null);
	}

	/**
	 * 
	 * String格式JSON字符串 post请求
	 * 
	 * @author 阿布
	 * @param jsonObject
	 *            json字符串
	 * @param logPrefix
	 *            日志前缀
	 * @param url
	 *            请求地址
	 * @param header
	 *            header信息map
	 * @return
	 */
	public static String postString(String jsonObject, String logPrefix, String url, Map<String, Object> header) {
		return postString(jsonObject, logPrefix, url, header, null);
	}

	/**
	 * 
	 * parameterMap格式post请求
	 * 
	 * @author 阿布
	 * @param logPrefix
	 *            日志前缀
	 * @param url
	 *            请求地址
	 * @param parameterMap
	 *            请求参数map
	 * @return
	 */
	public static String postString(String logPrefix, String url, Map<String, Object> parameterMap) {
		return postString(null, logPrefix, url, null, parameterMap);
	}

	/**
	 * 
	 * parameterMap格式post请求
	 * 
	 * @author 阿布
	 * @param logPrefix
	 *            日志前缀
	 * @param url
	 *            请求地址
	 * @param header
	 *            header信息map
	 * @param parameterMap
	 *            请求参数map
	 * @return
	 */
	public static String postString(String logPrefix, String url, Map<String, Object> header, Map<String, Object> parameterMap) {
		return postString(null, logPrefix, url, header, parameterMap);
	}

	/**
	 * String格式JSON字符串 post请求
	 * 
	 * @author 阿布
	 * @param jsonObject
	 *            json字符串
	 * @param logPrefix
	 *            日志前缀
	 * @param url
	 *            请求地址
	 * @param header
	 *            头部参数
	 * @return String
	 * 
	 */
	public static String postString(String jsonObject, String logPrefix, String url, Map<String, Object> header, Map<String, Object> parameterMap) {
		// System.out.println(logPrefix + " post=url:" + url);
		HttpPost httpPost = new HttpPost();
		httpPost.setConfig(requestConfig);
		// 判断JSON字符串不为空
		if (StringUtils.isNotEmpty(jsonObject)) {
			try {
				StringEntity se = new StringEntity(jsonObject);
				// System.out.println(jsonObject);
				// se.setContentType("application/json");
				se.setContentType("text/xml");
				httpPost.setEntity(se);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 装填参数
		if (parameterMap != null) {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (Entry<String, Object> entry : parameterMap.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue() + ""));
			}
			// 设置参数到请求对象中
			try {
				httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		httpPost.setHeader("Content-Type", "application/json");
		httpPost.setHeader("Content-Encoding", "utf-8");
		httpPost.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
		// 判断请求得抬头集合不为空，循环加入抬头
		if (header != null) {
			for (Map.Entry<String, Object> entry : header.entrySet()) {
				httpPost.setHeader(entry.getKey(), entry.getValue() + "");
			}
		}
		String str = null;
		try {
			httpPost.setURI(new URI(url));
			str = sendEntity(logPrefix, httpPost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * http请求方法
	 * 
	 * @author 阿布
	 * @param logPrefix
	 *            日志前缀
	 * @param httpRequestBase
	 *            (HttpPost,HttpPut,HttpGet,HttpDelete)
	 * @return String
	 * @throws Exception
	 */
	private static String sendEntity(String logPrefix, HttpRequestBase httpRequestBase) throws Exception {
		CloseableHttpClient client = getHttpClient();
		CloseableHttpResponse httpResponse = null;
		String resp = null;
		try {
			httpResponse = client.execute(httpRequestBase);
			resp = EntityUtils.toString(httpResponse.getEntity(), Charset.forName("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (client != null) {
				try {
					client.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (httpResponse != null) {
				try {
					httpResponse.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return resp;
	}

	/**
	 * 
	 * @author 阿布
	 * @return CloseableHttpClient
	 * @throws Exception
	 */
	public static CloseableHttpClient getHttpClient() throws Exception {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).setConnectionManager(cm).setConnectionManagerShared(true).build();
		return httpClient;
	}

	/**
	 * 
	 * @author 阿布
	 * @param cookie
	 *            密匙
	 * @return CloseableHttpClient
	 * @throws Exception
	 */
	public static CloseableHttpClient getHttpClient(Cookie cookie) throws Exception {
		CookieStore cookieStore = new BasicCookieStore();
		if (cookie != null) {
			cookieStore.addCookie(cookie);
		}
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).setConnectionManager(cm).setConnectionManagerShared(true).setDefaultCookieStore(cookieStore).build();
		return httpClient;
	}

}
