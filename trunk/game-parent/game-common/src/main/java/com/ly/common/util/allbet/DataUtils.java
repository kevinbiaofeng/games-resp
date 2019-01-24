package com.ly.common.util.allbet;

import java.util.Map;
import java.util.Set;

public class DataUtils {

	public static String getQueryString(Map<String, Object> params) {
		StringBuffer sb = new StringBuffer();
		Set<String> keySet = params.keySet();
		for (String s : keySet) {
			sb.append(s).append("=").append(params.get(s)).append("&");
		}
		if (sb.length() == 0) {
			return sb.toString();
		}
		return sb.substring(0, sb.length() - 1);
	}
	
	public static String getData(String qs,String desKey) {
		String data = null;
		try {
			data = TripleDES.encrypt(qs, desKey, null);
		} catch (java.io.UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (java.security.GeneralSecurityException e) {
			e.printStackTrace();
		}
		return data;
	}
}
