package com.ly.service.remote.mv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSONObject;
import com.ly.common.gameutil.mw.sign.AES;
import com.ly.common.gameutil.mw.sign.RSA;

public class BaseDemo {
	private final static Logger logger =  LoggerFactory.getLogger(BaseDemo.class);
	@Value("${ly.games.mv.siteId}")
	public String siteId;
	// 代理ID
	@Value("${ly.games.mv.merchantId}")
	public String merchantId;
	
	@Value("${ly.games.mv.MW_public_key}")
	public String MW_public_key;
	
	@Value("${ly.games.mv.EC_private_key}")
	public String EC_private_key;
	
	@Value("${ly.games.mv.EC_public_key}")
	public String EC_public_key;

	String EC_AES_key = "abc1234567812345";// EC 隨機產生
	String apiURL = "";
	String resultType = "json";
	String lang = "cn";
	String data = "";
	String key = "";

	public static String dataSign = "";
	public static String contentSign = "";

	protected static final String ENCODE_TYPE = "UTF-8";

	protected String sendApi(TreeMap dataMap, String domainURL, String func) throws Exception {
		if (func.equals("siteUsergamelog"))
			domainURL = domainURL.replace("as-lobby", "as-service");

		if (func.equals("domain"))
			apiURL = "http://www.168at168.com/as-lobby/api/domain?"; // Domain請求網址
		else
			apiURL = domainURL + "api/" + func + "?";

		if ("transferPrepare".equals(func) || "transferPay".equals(func)) {
			logger.info("BaseDemo.sendApi." + func + ".url:" + apiURL + "&dataMap:" + dataMap);
		}

		String contentJson = setDataContent(dataMap);

		EC_AES_key = getAesKey();
		data = AES.encryptToBase64(contentJson, EC_AES_key);
		key = RSA.encrypt(EC_AES_key, MW_public_key);

		URL url = new URL(apiURL);
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("func", func);
		params.put("resultType", resultType);
		params.put("siteId", siteId);
		params.put("lang", lang);
		params.put("data", data);
		params.put("key", key);

		String response = httpPostRequest(url, params);
		logger.info("BaseDemo.sendApi.url:" + url + "&params:" + params.toString() + "&dataMap:" + dataMap + "&response:" + response);
		// JSONObject json = new JSONObject(response);

		return response;
	}

	protected void appLaunchReq(String domainURL, String inter) throws Exception {
		String loginURL = domainURL + inter;
		httpPostRequest(new URL(loginURL), new HashMap());
	}

	private String httpPostRequest(URL url, Map<String, Object> params) throws IOException {
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			if (postData.length() != 0)
				postData.append('&');
			postData.append(URLEncoder.encode(param.getKey(), ENCODE_TYPE));
			postData.append('=');
			postData.append(URLEncoder.encode(String.valueOf(param.getValue()), ENCODE_TYPE));
		}

		// 如果请求 有问题, 请把这串请求串 提供给MW技术检视
		// System.out.printf("[%s_RequestURL]:%s%s\n",params.get("func"), url,
		// postData);
		byte[] postDataBytes = postData.toString().getBytes(ENCODE_TYPE);

		HttpURLConnection conn = null;
		InputStream is = null;
		OutputStream out = null;
		Reader in = null;
		StringBuffer resInfo = new StringBuffer();
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(60000);// 请求超时1分钟
			conn.setReadTimeout(60000);// 设置读取超时1分钟
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
			conn.setDoOutput(true);
			out = conn.getOutputStream();
			out.write(postDataBytes);
			out.flush();
			is = conn.getInputStream();
			in = new BufferedReader(new InputStreamReader(is, ENCODE_TYPE));

			for (int c; (c = in.read()) >= 0;) {
				char ch = (char) c;
				resInfo.append(ch);
			}
		} catch (Exception e) {
			logger.error("BaseDemo.httpPostRequest.Exception:" + e.getMessage() + "=body:" + e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					logger.error("BaseDemo.httpPostRequest.OutputStream:" + e.getMessage() + "=body:" + e);
				}
			}

			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					logger.error("BaseDemo.httpPostRequest.Reader:" + e.getMessage() + "=body:" + e);
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
					logger.error("BaseDemo.httpPostRequest.InputStream:" + e.getMessage() + "=body:" + e);
				}
			}
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (Exception e) {
					logger.error("BaseDemo.httpPostRequest.HttpURLConnection:" + e.getMessage() + "=body:" + e);
				}
			}
		}
		// System.out.printf("[%s_Response]:%s\n\n",params.get("func"),
		// resInfo);
		return resInfo.toString();
	}

	private String setDataContent(TreeMap<String, Object> map) {

		contentSign = StringUtils.EMPTY;

		for (Map.Entry<String, Object> item : map.entrySet()) {
			String key = item.getKey();
			Object obj = item.getValue();
			String value = (obj == null) ? "" : obj.toString();
			contentSign += (key + "=" + value);
		}

		dataSign = RSA.sign(contentSign, EC_private_key);

		// step4. 将步骤3 获得的参数sign，和步骤1 涉及的参数，构建JSON 数据
		map.put("sign", dataSign);
		JSONObject jsonObject = new JSONObject(map);
		String jsonContent = jsonObject.toString();

		return jsonContent;
	}

	// 執行異步通知 解開收到的 key & data
	public String decryptNotifierData(String key, String data, String ecPrivateKey) throws Exception {
		String aesKey = RSA.decrypt(key, ecPrivateKey);
		String resultData = AES.decryptFromBase64(data, aesKey);
		return resultData;
	}

	public boolean verifyNotifierData(String notifierData, String mwPublicKey) throws Exception {
		JSONObject json = JSONObject.parseObject(notifierData);
		String sign = json.getString("sign");

		TreeSet<String> keySortSet = new TreeSet<String>(json.keySet());
		String jsonSortContent = "";

		for (String jsonKey : keySortSet) {
			if (jsonKey.equals("sign"))
				continue;
			jsonSortContent += jsonKey + "=" + json.get(jsonKey);
		}

		return RSA.checkSign(jsonSortContent, sign, mwPublicKey);
	}

	private String getAesKey() {
		String key = "";
		String strPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		int max = strPool.length() - 1;

		for (int i = 0; i < 16; i++)
			key += strPool.charAt((int) (Math.random() * max));

		return key;
	}
}
