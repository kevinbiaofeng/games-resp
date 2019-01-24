package com.ly.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.Response;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientsUtil {
	public static final String REQUESTTYPE_GET = "get";
	public static final String REQUESTTYPE_POST = "post";
	private static PoolingHttpClientConnectionManager cm = null;
	private static RequestConfig requestConfig = null;  
	private static String CHARSET = "utf-8";
	
	private static void initCm(){
		if(cm==null){
			cm = new PoolingHttpClientConnectionManager();
			cm.setMaxTotal(2000);
			cm.setDefaultMaxPerRoute(50);
		}
		
	    if( requestConfig == null) {
	    	requestConfig = RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(10000).setSocketTimeout(10000).setRedirectsEnabled(false).build(); 
	    }
	}
	
	private static CloseableHttpClient getHttpClient(){
		initCm();
		return HttpClients.custom().setConnectionManager(cm).build();
	}

	/**
	 * httpClient请求执行方法
	 * @param url 请求地址
	 * @param code 请求方式
	 * @param timeout 请求超时（秒）
	 * @return
	 */
	public static String execute(String url,String code , int timeout, String logPrefix){
		HttpRequestBase request = null;
		if(REQUESTTYPE_GET.equals(code)){
			request = new HttpGet(url);
		}else if(REQUESTTYPE_POST.equals(code)){
			request = new HttpPost(url);
		}
		if(request == null)throw new RuntimeException("错误的请求类型!"+code);
		request.setConfig(RequestConfig.custom().setConnectTimeout(timeout * 1000).setConnectionRequestTimeout(timeout * 1000).setSocketTimeout(timeout * 1000).build()); 
		return getResult(request, logPrefix);
	}
	
	/**
	 * httpClient请求执行方法
	 * @param url 请求地址
	 * @param code 请求方式
	 * @return
	 */
	public static String execute(String url,String code){
		HttpRequestBase request = null;
		if(REQUESTTYPE_GET.equals(code)){
			request = new HttpGet(url);
		}else if(REQUESTTYPE_POST.equals(code)){
			request = new HttpPost(url);
		}
		if(request == null)throw new RuntimeException("错误的请求类型!"+code);
		request.setConfig(requestConfig); 
		return getResult(request, "execute url-code ");
	}
	
	/**
	 * httpClient请求执行方法
	 * @param url 请求地址
	 * @param code 请求方式
	 * @return
	 */
	public static String execute(String url,String code, String logPrefix){
		HttpRequestBase request = null;
		if(REQUESTTYPE_GET.equals(code)){
			request = new HttpGet(url);
		}else if(REQUESTTYPE_POST.equals(code)){
			request = new HttpPost(url);
		}
		if(request == null)throw new RuntimeException("错误的请求类型!"+code);
		request.setConfig(requestConfig); 
		return getResult(request, logPrefix);
	}
	
	/**
	 * httpClient请求执行方法
	 * @param url 请求地址
	 * @param code 请求方式
	 * @param params 具体参数,以Map方式存储
	 * @return
	 */
	public static String execute(String url,String code,Map<String,Object> params) throws Exception{
		HttpRequestBase request = null;
		List<org.apache.http.NameValuePair> nvps = cover2nvps(params);
		
		if(REQUESTTYPE_GET.equals(code)){
			URIBuilder ub = new URIBuilder();
			ub.setPath(url);
			ub.addParameters(nvps);
			request = new HttpGet(ub.build());
		}else if(REQUESTTYPE_POST.equals(code)){
			request = new HttpPost(url);
			((HttpPost) request).setEntity(new UrlEncodedFormEntity(nvps,"utf-8"));
		}
		if(request == null)throw new RuntimeException("错误的请求类型!"+code);
		request.setConfig(requestConfig); 
		return getResult(request, "execute url-code-params ");
	}
	
	/**
	 * httpClient请求执行方法
	 * @param url 请求地址
	 * @param code 请求方式
	 * @param params 具体参数,以Map方式存储
	 * @return
	 */
	public static String execute(String url,String code,Map<String,Object> params, String logPrefix) throws Exception{
		HttpRequestBase request = null;
		List<org.apache.http.NameValuePair> nvps = cover2nvps(params);
		
		if(REQUESTTYPE_GET.equals(code)){
			URIBuilder ub = new URIBuilder();
			ub.setPath(url);
			ub.addParameters(nvps);
			request = new HttpGet(ub.build());
		}else if(REQUESTTYPE_POST.equals(code)){
			request = new HttpPost(url);
			((HttpPost) request).setEntity(new UrlEncodedFormEntity(nvps,"utf-8"));
		}
		if(request == null)throw new RuntimeException("错误的请求类型!"+code);
		request.setConfig(requestConfig); 
		return getResult(request, logPrefix);
	}
	
	/**
	 * httpClient请求执行方法,返回值为head 的Location 值
	 * @param url 请求地址
	 * @param code 请求方式
	 * @param params 具体参数,以Map方式存储
	 * @return
	 */
	public static String executeRedirect(String url,String code,Map<String,Object> params, String logPrefix) throws Exception{
		HttpRequestBase request = null;
		List<org.apache.http.NameValuePair> nvps = cover2nvps(params);
		
		if(REQUESTTYPE_GET.equals(code)){
			URIBuilder ub = new URIBuilder();
			ub.setPath(url);
			ub.addParameters(nvps);
			request = new HttpGet(ub.build());
		}else if(REQUESTTYPE_POST.equals(code)){
			request = new HttpPost(url);
			((HttpPost) request).setEntity(new UrlEncodedFormEntity(nvps,"utf-8"));
		}
		if(request == null)throw new RuntimeException("错误的请求类型!"+code);
		request.setConfig(requestConfig); 
		return getLocationResult(request, logPrefix);
	}
	
	/**
	 * httpClient请求执行方法
	 * @param url 请求地址
	 * @param code 请求方式
	 * @param params 具体参数,以Map方式存储
	 * @param headers 请求头参数,以Map方式存储
	 * @return
	 */
	public static String execute(String url,String code,Map<String,Object> params,Map<String,Object> headers, String logPrefix) throws Exception{
		HttpRequestBase request = null;
		List<NameValuePair> nvps = cover2nvps(params);
		
		if(REQUESTTYPE_GET.equals(code)){
			URIBuilder ub = new URIBuilder();
			ub.setPath(url);
			ub.setParameters(nvps);
			request = new HttpGet(ub.build());
		}else if(REQUESTTYPE_POST.equals(code)){
			request = new HttpPost(url);
			((HttpPost) request).setEntity(new UrlEncodedFormEntity(nvps,"utf-8"));
		}
		if(request == null)throw new RuntimeException("错误的请求类型!"+code);
		
		for(Map.Entry<String, Object> param : headers.entrySet()){
			request.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}
		request.setConfig(requestConfig); 
		return getResult(request, logPrefix);
	}
	
	/***
	 * httpClient POST请求执行方法,请求数据根式为json
	 * @param url 请求地址
	 * @param headers headers 请求头参数,以Map方式存储
	 * @param json json字符串
	 * @return
	 * @throws Exception
	 */
	public static String executeOld(String url,Map<String,Object> headers,String json) throws Exception{
		HttpRequestBase request = null;
		request = new HttpPost(url);
		StringEntity se = new StringEntity(json);
		se.setContentType("text/json");
		((HttpPost) request).setEntity(se);
		//if(request == null)throw new RuntimeException("错误的请求类型!"+code);
		
		for(Map.Entry<String, Object> param : headers.entrySet()){
			request.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}
		request.setConfig(requestConfig); 
		return getResult(request, "execute url-headers-json ");
	}
	
	/***
	 * httpClient POST请求执行方法,请求数据根式为json
	 * @param url 请求地址
	 * @param headers headers 请求头参数,以Map方式存储
	 * @param json json字符串
	 * @return
	 * @throws Exception
	 */
	public static String execute(String url,Map<String,Object> headers,String json, String logPrefix) throws Exception{
		HttpRequestBase request = null;
		request = new HttpPost(url);
		StringEntity se = new StringEntity(json);
		se.setContentType("text/json");
		((HttpPost) request).setEntity(se);
		//if(request == null)throw new RuntimeException("错误的请求类型!"+code);
		
		for(Map.Entry<String, Object> param : headers.entrySet()){
			request.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}
		request.setConfig(requestConfig); 
		return getResult(request, logPrefix);
	}
	
	/***
	 * httpClient POST请求执行方法,请求数据根式为json
	 * @param url 请求地址
	 * @param headers headers 请求头参数,以Map方式存储
	 * @param json json字符串
	 * @return
	 * @throws Exception
	 */
	public static String execute(String url,Map<String,Object> headers,String sec,String conttype, String logPrefix) throws Exception{
		HttpRequestBase request = null;
		request = new HttpPost(url);
		StringEntity se = new StringEntity(sec);
		se.setContentType(conttype);
		((HttpPost) request).setEntity(se);
		//if(request == null)throw new RuntimeException("错误的请求类型!"+code);
		
		for(Map.Entry<String, Object> param : headers.entrySet()){
			request.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}
		request.setConfig(requestConfig); 
		return getResult(request, logPrefix);
	}
	
	/***
	 * httpClient POST请求执行方法,请求数据根式为json
	 * @param url 请求地址
	 * @param headers headers 请求头参数,以Map方式存储
	 * @param json json字符串
	 * @param timeout 超时时间
	 * @return
	 * @throws Exception
	 */
	public static String execute(String url,Map<String,Object> headers,String sec,String conttype, String logPrefix,int timeout) throws Exception{
		HttpRequestBase request = null;
		request = new HttpPost(url);
		StringEntity se = new StringEntity(sec);
		se.setContentType(conttype);
		((HttpPost) request).setEntity(se);
		//if(request == null)throw new RuntimeException("错误的请求类型!"+code);
		
		for(Map.Entry<String, Object> param : headers.entrySet()){
			request.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}
		request.setConfig(RequestConfig.custom().setConnectTimeout(timeout).setConnectionRequestTimeout(timeout).setSocketTimeout(timeout).setRedirectsEnabled(false).build()); 
		return getResult(request, logPrefix);
	}
	
	
	
	/**
	 * httpClient请求执行方法
	 * @param url 请求地址
	 * @param code 请求方式
	 * @param params 具体参数,以Map方式存储
	 * @param headers 请求头参数,以Map方式存储
	 * @return
	 */
	public static String execute(String url,Map<String,Object> headers) throws Exception{
		HttpRequestBase request = null;
		URIBuilder ub = new URIBuilder();
		ub.setPath(url);
		request = new HttpGet(ub.build());

		for(Map.Entry<String, Object> param : headers.entrySet()){
			request.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}
		request.setConfig(requestConfig); 
		return getResult(request, "execute url-headers ");
	}
	
	/**
	 * httpClient请求执行方法
	 * @param url 请求地址
	 * @param code 请求方式
	 * @param params 具体参数,以Map方式存储
	 * @param headers 请求头参数,以Map方式存储
	 * @return
	 */
	public static String execute(String url,Map<String,Object> headers, String logPrefix) throws Exception{
		HttpRequestBase request = null;
		URIBuilder ub = new URIBuilder();
		ub.setPath(url);
		request = new HttpGet(ub.build());

		for(Map.Entry<String, Object> param : headers.entrySet()){
			request.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}
		request.setConfig(requestConfig); 
		return getResult(request, logPrefix);
	}
	
	private static String getResult(HttpRequestBase request, String logPrefix){
		CloseableHttpClient httpClient = getHttpClient();
		try {
			CloseableHttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			if(entity!=null){
				String result = EntityUtils.toString(entity,CHARSET);
				response.close();
				return result;
			}else{
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	private static String getLocationResult(HttpRequestBase request, String logPrefix){
		CloseableHttpClient httpClient = getHttpClient();
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(request);
			Header[] headers = response.getAllHeaders();
			
			for(Header h : headers) {
				if(h.getName().equals("Location")) {
					String result = h.getValue();
					return result;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(response!=null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return "request error";
	}
	
	private static ArrayList<NameValuePair> cover2nvps(Map<String,Object> params){
		ArrayList<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for(Map.Entry<String, Object> param : params.entrySet()){
			nvps.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
		}
		return nvps;
	}
	
	/*private static TrustManager myX509TrustManager = new X509TrustManager() {
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}
	};*/
	
	private static HostnameVerifier trustAnyHostnameVerifier = new TrustAnyHostnameVerifier();
	
	
	public static String sendHttps(String url,String code, Map<String, Object> param,Map<String, Object> head, String logPrefix) {
		String result = null;
		// 使用此工具可以将键值对编码成"Key=Value&amp;Key2=Value2&amp;Key3=Value3&rdquo;形式的请求参数
		String requestParam = null;
		OutputStream out = null;
		HttpsURLConnection httpsConn = null;
		if(param!=null) {
			requestParam = URLEncodedUtils.format(cover2nvps(param), "UTF-8");
		}
		//String data = JSONObject.fromObject(param).toString();
		
		try {
			// 设置SSLContext
			//SSLContext sslcontext = SSLContext.getInstance("TLS");
			//sslcontext.init(null, new TrustManager[] { myX509TrustManager }, null);

			// 打开连接
			// 要发送的POST请求url?Key=Value&amp;Key2=Value2&amp;Key3=Value3的形式
			String u = null;
			if("POST".equalsIgnoreCase(code)) {
				u = url;
			} else {
				u = url+(requestParam!=null?"?"+requestParam:"");
			}
			
			URL requestUrl = new URL(u);
			httpsConn = (HttpsURLConnection) requestUrl.openConnection();

			// 设置套接工厂
			httpsConn.setSSLSocketFactory(new TSLSocketConnectionFactory());

			// 加入数据
			httpsConn.setRequestMethod(code);
			httpsConn.setDefaultUseCaches(false);
			httpsConn.setDoOutput(true);
			httpsConn.setDoInput(true);
			httpsConn.setHostnameVerifier(trustAnyHostnameVerifier);
			httpsConn.setRequestProperty("Content-type", "application/json"); 
			httpsConn.setConnectTimeout(10000);
			if(head!=null) {
				for(Entry<String, Object> entry : head.entrySet()) {
					httpsConn.setRequestProperty(entry.getKey(), entry.getValue()+"");
				}
			}
			
			if("POST".equalsIgnoreCase(code)) {
				out = httpsConn.getOutputStream();
				if (requestParam != null) {
					out.write(requestParam.getBytes("UTF-8"));
				}

				out.flush();
				out.close();
			}
			
			
			InputStream response = httpsConn.getInputStream();
			
			result = IOUtils.toString(response, "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpsConn.disconnect();
				if(out!=null) {
					out.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}
	
	public static String sendHttpsGet(String url,Map<String, Object> param,Map<String, Object> head, String logPrefix) {
		return sendHttps(url,"GET",param,head,logPrefix);
	}
	
	public static String sendHttpsPost(String url,Map<String, Object> param,Map<String, Object> head, String logPrefix) {
		return sendHttps(url,"POST",param,head,logPrefix);
	}

}

class TrustAnyHostnameVerifier implements HostnameVerifier {

	@Override
	public boolean verify(String s, SSLSession sslsession) {
		return true;
	}
}
