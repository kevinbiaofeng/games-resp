package com.ly.service.remote;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSONObject;

public class PTBetRemoteService {
	private static PTBetRemoteService instance = new PTBetRemoteService();

	private static String certName = "../../../../key/pt/CNY.p12";
	@Value("${ly.games.pt.certPassword}")
	private String certPassword;
	@Value("${ly.games.pt.entityKey}")
	private String entityKey;
	@Value("${ly.games.pt.cloudlocation}")
	private String cloudlocation;

	private final String host = String.format("https://kioskpublicapi.%s.com", cloudlocation);

	private static final String betLogUrl = "/customreport/getdata";

	private static final String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	private final static Logger logger = LoggerFactory.getLogger(PTBetRemoteService.class);

	public static void main(String[] args) {
//    	Calendar calendar = Calendar.getInstance();
//        Date endtime = calendar.getTime();
//		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - 5);
//		Date starttime = calendar.getTime();
//		String response = betLog(starttime, endtime);
//		JSONObject json=JSONObject.parseObject(response);
//		System.out.println("1111:"+json.getString("pagination"));
	}
	/**
	 * 查询日志
	 * 
	 * @param username
	 * @param newpwd
	 *            新密码
	 * @return
	 */
	public String betLog(Date startdate, Date enddate) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("startdate", DateFormatUtils.format(startdate, dateTimePattern));
		params.put("enddate", DateFormatUtils.format(enddate, dateTimePattern));
		params.put("frozen", "all");
		params.put("reportname", "PlayerGames");
		params.put("showinfo", 1 + "");
		String logPrefix = "PTUtil.betLog startdate[" + startdate + "] enddate[" + enddate + "] ";
		String resultStr = getResult(betLogUrl, params, logPrefix);
		return resultStr;
	}

	private String getResult(String createurl, Map<String, String> params, String logPrefix) {
		String url = getUrl(createurl, params);
		return CallAPI(url, logPrefix);
	}

	private String getUrl(String createurl, Map<String, String> params) {
		String qs = getParamsStr(params);
		return String.format("%s%s%s", host, createurl, qs);
	}

	private String getParamsStr(Map<String, String> params) {
		StringBuffer sb = new StringBuffer();
		if (params == null) {
			return sb.toString();
		}
		Set<String> keys = params.keySet();
		for (String key : keys) {
			String value = params.get(key);
			try {
				sb.append("/").append(key).append("/").append(URLEncoder.encode(value, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	private String CallAPI(String url, String logPrefix) {
		String result = null;
		HttpsURLConnection connection = null;
		try {
			KeyStore ks = KeyStore.getInstance("PKCS12");
			/*
			 * URL fileURL = new File(certName).toURI().toURL();
			 * 
			 * File file = new File(fileURL.getFile());
			 * 
			 * FileInputStream is = new FileInputStream(file);
			 */

			InputStream is = instance.getClass().getResourceAsStream(certName);

			ks.load(is, certPassword.toCharArray());

			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(ks, certPassword.toCharArray());
			KeyManager[] kms = kmf.getKeyManagers();

			// Crete TrustManager to bypass trusted certificate check
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}

			} };

			// Hostname verification bypass method
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			// Set connection properties to use bypass certificate/hostname
			// check methods
			SSLContext sslContext = null;
			sslContext = SSLContext.getInstance("TLS");
			sslContext.init(kms, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
			logger.info(logPrefix + " url:" + url);
			// Send API call together with entity key for validation
			connection = (HttpsURLConnection) new URL(url).openConnection();
			connection.setRequestProperty("X_ENTITY_KEY", entityKey);
			connection.setConnectTimeout(10000);
			InputStream response = connection.getInputStream();
			result = IOUtils.toString(response);
			logger.info(logPrefix + " result:" + result);

		} catch (Exception e) {
			logger.error(logPrefix + " error:" + e.getMessage(), e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return result;
	}

}
