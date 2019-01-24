package com.ly.service.remote;

import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ly.common.util.DateUtils;
import com.ly.common.util.HttpsUtils;

@Service
public class KAGABetRemoteService {
	private final static Logger logger = LoggerFactory.getLogger(KAGABetRemoteService.class);

	private final static char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
	@Value("${ly.games.kaga.SecretKey}")
	private String SecretKey;
	@Value("${ly.games.kaga.KAServerURL}")
	private String KAServerURL;
	@Value("${ly.games.kaga.operatorName}")
	private String operatorName = "";
	@Value("${ly.games.kaga.PartnerName}")
	private String PartnerName = "LINDINA";
	@Value("${ly.games.kaga.AccessKey}")
	private String AccessKey = "761008A9EC7F4F968EEB8E6C6B34C190";

	private static final String reqBetReport = "playerReport";
	private static final String DatePattern = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 获取注单表，最小间隔不能小于10秒，否则会查不出数据
	 * 
	 * @param sdate
	 * @param edate
	 * @return
	 */
	public String betReport(Date sdate, Date edate) {
		String sd = DateFormatUtils.format(sdate, DatePattern);
		String ed = DateFormatUtils.format(edate, DatePattern);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("randomId", Math.abs(new SecureRandom().nextInt()));
		params.put("from", sd);
		params.put("to", ed);
		setCommParams(params);

		String logPrefix = "KagaUtil.betReport  sdate[" + sd + "] edate[" + ed + "]";

		return getPostResult(reqBetReport, params, logPrefix);
	}

	public void main(String[] args) {
		System.out.println(betReport(DateUtils.addHours(new Date(), -1000), DateUtils.addHours(new Date(), -0)));
		/*
		 * try { Date sd = DateUtils.parseDate("2018-01-23 02:21:25",
		 * DateUtils.FORMAT_TIME); Date ed = DateUtils.parseDate("2018-01-23 02:21:31",
		 * DateUtils.FORMAT_TIME); System.out.println(betReport(sd, ed)); } catch
		 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
		 * }
		 */

	}

	private void setCommParams(Map<String, Object> params) {
		if (!operatorName.equals("")) {
			params.put("operatorName", operatorName);
		}
		params.put("partnerName", PartnerName);
		params.put("accessKey", AccessKey);
		params.put("currency", "CNY");
	}

	private String getPostResult(String action, Map<String, Object> params, String logPrefix) {
		String result = null;
		try {
			System.out.println(KAServerURL + action);
			System.out.println(params);
			result = sendHttpsPOST(KAServerURL + action, params, logPrefix);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(logPrefix + " result: " + result);
		return result;
	}

	public String sendHttpsPOST(String url, Map<String, Object> param, String logPrefix) {
		String result = null;
		// 使用此工具可以将键值对编码成"Key=Value&amp;Key2=Value2&amp;Key3=Value3&rdquo;形式的请求参数
		// String requestParam = URLEncodedUtils.format(param, "UTF-8");
		String data = JSONObject.toJSONString(param);
		String json = generateHMAC(data);
		// OutputStream out = null;
		// HttpsURLConnection httpsConn = null;

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("Content-type", "application/json");
		HttpEntity entity = null;
		if (data != null) {
			entity = new StringEntity(data, "UTF-8");
		}
		result = HttpsUtils.post(url + "?hash=" + json, head, null, entity, logPrefix);
		return result;
	}

	public String generateHMAC(String json) {
		try {
			SecretKeySpec keySpec = new SecretKeySpec(SecretKey.getBytes("UTF-8"), "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(keySpec);
			byte[] bytes = mac.doFinal(json.getBytes("UTF-8"));
			char[] hexChars = new char[bytes.length * 2];
			for (int j = 0; j < bytes.length; j++) {
				int v = bytes[j] & 0xFF;
				hexChars[j * 2] = HEX_ARRAY[v >>> 4];
				hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
			}
			return new String(hexChars);
		} catch (Throwable t) {
			throw new RuntimeException("Error generating HMAC", t);
		}
	}
}
