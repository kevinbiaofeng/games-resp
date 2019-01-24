package com.ly.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpsUtils {
    /*private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;
    private static SSLContextBuilder builder = null;*/
	private static RequestConfig requestConfig = null;  
    
    enum HttpProto {
    	GET,
    	POST,
    	PUT,
    	DELETE
    }
    
    
    
    static {
        try {
            /*builder = new SSLContextBuilder();
            // 全部信任 不做身份鉴定
            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            });
            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory())
                    .register(HTTPS, sslsf)
                    .build();
            cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(2000);//max connection
            cm.setDefaultMaxPerRoute(100);*/
            if( requestConfig == null) {
    	    	requestConfig = RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(1000).setSocketTimeout(10000).setRedirectsEnabled(false).build(); 
    	    }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * httpClient post请求
     * @param url 请求url
     * @param header 头部信息
     * @param param 请求参数 form提交适用
     * @param entity 请求实体 json/xml提交适用
     * @return 可能为空 需要处理
     * @throws Exception
     *
     */
    private static String sendEntity(String  url,HttpProto proto, Map<String, Object> header, Map<String, Object> param, HttpEntity entity,String logPrefix) {
        String result = "";
        CloseableHttpClient httpClient = null;
        HttpEntityEnclosingRequestBase httpPost = null;
        HttpResponse httpResponse = null;
        try {
            httpClient = getHttpClient();
            if(proto.equals(HttpProto.POST)) {
            	httpPost = new HttpPost(url);
            } else if(proto.equals(HttpProto.PUT)) {
            	httpPost = new HttpPut(url);
            }
            httpPost.setConfig(requestConfig);  
            // 设置头信息
            if (header!=null && header.size()>0) {
                for (Map.Entry<String, Object> entry : header.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue()+"");
                }
            }
            // 设置请求参数
            if (param!=null && param.size()>0 ) {
                List<NameValuePair> formparams = new ArrayList<NameValuePair>();
                for (Map.Entry<String, Object> entry : param.entrySet()) {
                    //给参数赋值
                    formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()+""));
                }
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
                httpPost.setEntity(urlEncodedFormEntity);
            }
            // 设置实体 优先级高
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
//            System.out.println(statusCode);
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity resEntity = httpResponse.getEntity();
                result = EntityUtils.toString(resEntity,"UTF-8");
            } else {
            	result = readHttpResponse(httpResponse);
            }
        } catch (Exception e) {
        	if(httpPost!=null) {
        		httpPost.abort();
        	}
        	e.printStackTrace();
        } finally {
        	if(httpResponse!=null) {
        		try {
					EntityUtils.consume(httpResponse.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	if(httpPost!=null) {
        		httpPost.releaseConnection();
        	}
            /*if (httpClient != null) {
                try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }*/
        }
        return result;
    }
    
    /**
     * httpClient post请求
     * @param url 请求url
     * @param header 头部信息
     * @param param 请求参数 form提交适用
     * @param entity 请求实体 json/xml提交适用
     * @return 可能为空 需要处理
     * @throws Exception
     *
     */
    public static String post(String  url,Map<String, Object> header, Map<String, Object> param, HttpEntity entity,String logPrefix){
    	try {
			return sendEntity(url, HttpProto.POST, header, param, entity,logPrefix);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "request error";
    }
    
    /**
     * httpClient PUT请求
     * @param url 请求url
     * @param header 头部信息
     * @param param 请求参数 form提交适用
     * @param entity 请求实体 json/xml提交适用
     * @return 可能为空 需要处理
     * @throws Exception
     *
     */
    public static String put(String  url,Map<String, Object> header, Map<String, Object> param, HttpEntity entity,String logPrefix){
    	try {
			return sendEntity(url, HttpProto.PUT, header, param, entity,logPrefix);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "request error";
    }
    
    /**
     * httpClient GET请求
     * @param url 请求url
     * @param header 头部信息
     * @param param 请求参数 form提交适用
     * @param entity 请求实体 json/xml提交适用
     * @return 可能为空 需要处理
     * @throws Exception
     *
     */
    public static String get(String  url,Map<String, Object> header, Map<String, Object> param,String logPrefix){
    	try {
			return sendBase(url, HttpProto.GET, header, param,logPrefix);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "request error";
    }

    /**
     * httpClient DELETE请求
     * @param url 请求url
     * @param header 头部信息
     * @param param 请求参数 form提交适用
     * @param entity 请求实体 json/xml提交适用
     * @return 可能为空 需要处理
     * @throws Exception
     *
     */
    public static String delete(String  url,Map<String, Object> header, Map<String, Object> param,String logPrefix){
    	try {
			return sendBase(url, HttpProto.DELETE, header, param,logPrefix);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "request error";
    }
    
    private static String sendBase(String  url,HttpProto proto, Map<String, Object> header, Map<String, Object> param,String logPrefix) throws Exception {
        String result = "";
        CloseableHttpClient httpClient = null;
        HttpResponse httpResponse = null;
        HttpRequestBase httpGet = null;
        try {
            httpClient = getHttpClient();
            
            if(param!=null && param.size()>0) {
            	 String requestParam = URLEncodedUtils.format(cover2nvps(param), "UTF-8");
            	 String splitStr = url.indexOf("?")>0?"&":"?";
            	 url = url + splitStr + requestParam;
            }
            
            if(proto.equals(HttpProto.GET)) {
            	httpGet = new HttpGet(url);
            } else if(proto.equals(HttpProto.DELETE)) {
            	httpGet = new HttpDelete(url);
            }
            
            httpGet.setConfig(requestConfig);  
            
            // 设置头信息
            if (header!=null && header.size()>0 ) {
                for (Map.Entry<String, Object> entry : header.entrySet()) {
                	httpGet.addHeader(entry.getKey(), entry.getValue()+"");
                }
            }
            
            httpResponse = httpClient.execute(httpGet);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
//            System.out.println(statusCode);
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity resEntity = httpResponse.getEntity();
                result = EntityUtils.toString(resEntity,"UTF-8");
            } else {
            	result = readHttpResponse(httpResponse);
            }
        } catch (Exception e) {
        	if(httpGet!=null) {
        		httpGet.abort();
        	}
        	e.printStackTrace();
        } finally {
        	if(httpResponse!=null) {
        		try {
					EntityUtils.consume(httpResponse.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	if(httpGet!=null) {
        		httpGet.releaseConnection();
        	}
            /*if (httpClient != null) {
                httpClient.close();
            }*/
        }
        return result;
    }
    
	private static List<NameValuePair> cover2nvps(Map<String,Object> params){
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for(Map.Entry<String, Object> param : params.entrySet()){
			nvps.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
		}
		return nvps;
	}
    
    public static CloseableHttpClient getHttpClient() throws Exception {
        /*CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setConnectionManager(cm)
                .setConnectionManagerShared(true)
                .build();
        return httpClient;*/
    	return HttpClientPool.getClient();
    }
    public static String readHttpResponse(HttpResponse httpResponse)
            throws ParseException, IOException {
    	String result = "";
        // 获取响应消息实体
        HttpEntity entity = httpResponse.getEntity();
        
        // 判断响应实体是否为空
        if (entity != null) {
            result = EntityUtils.toString(entity,"UTF-8");
        }
        return result;
    }
}
