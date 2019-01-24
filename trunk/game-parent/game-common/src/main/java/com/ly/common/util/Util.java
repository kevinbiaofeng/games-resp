package com.ly.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Util {
	
	public static String genSecret(String... args) {
		String password = "Jiumu!@#";
//		password="9uBuOX1Bw7UFRFST";
//		password = "iwM@7QF@czioNoP7";
//		password = "2a9FuNPMONo7!S3f";
		StringBuilder builder = new StringBuilder();
		for (String str : args) {
			builder.append(str);
		}
		builder.append(password);
		String result = builder.toString();
		String key = bytesToHexString(bytesToMd5(result.getBytes()));
		return key;
	}
	
	public static byte[] bytesToMd5(byte[] bytes) {
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			return mdTemp.digest(bytes);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("md5转码出错", e);
		}
	}
	
	public static String bytesToHexString(byte[] array) {
		StringBuffer buf = new StringBuffer(array.length * 2);
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 0xff) < 16)
				buf.append("0");
			//这里一定要大写，要不当遇到中文问题时逆转时就会出错
			buf.append(Long.toString(array[i] & 0xff, 16).toUpperCase());
		}
		return buf.toString();
	}
	
	public static String md5String(String source) {
		String res=null;
		try {
			res = bytesToHexString(bytesToMd5(source.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return res; 
	}
	
	public static String getQueryString(Map<String, Object> params,boolean isURLEncode) {
		
		StringBuffer sb = new StringBuffer();
		Set<String> keySet = params.keySet();
		for(String s : keySet) {
			sb.append(s).append("=");
			
			if(isURLEncode) {
				try {
					sb.append(URLEncoder.encode(params.get(s)+"", "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			} else {
				sb.append(params.get(s));
			}
			
			sb.append("&");
		}
		if(sb.length()==0) {
			return sb.toString();
		}
		return sb.substring(0, sb.length()-1);
	}
	
	//http://gi.hgline88.com:81/doBusiness.do?params=XEWtB/KuTH9NvIzgPuC0VO1teQab5TuByenHMh/RZizRaWUaNZIgpJ9/PTCTSMp7KXM3gGswUM1eh6bRmTqHu5k5MvlPFMzUpsTz+4GljXP/WdaQffrLGaqh6X5nz3Ye0QBk9JYm98/qzmwVGZIx94uCrA/wh4jh/rlZt9RkL8s=&key=71f6098427c68855775e4aa5d3d00673
	public static void test2() {
//		String param = "XEWtB/KuTH9NvIzgPuC0VO1teQab5TuByenHMh/RZizRaWUaNZIgpJ9/PTCTSMp7KXM3gGswUM1eh6bRmTqHu5k5MvlPFMzUpsTz+4GljXP/WdaQffrLGaqh6X5nz3Ye0QBk9JYm98/qzmwVGZIx94uCrA/wh4jh/rlZt9RkL8s=";
//		String key = "123123";
//		String res = md5String(param + key);
		//String res = md5String("qwertyuiop/api/CreateMember?OpCode=local&PlayerName=eddiechan&FirstName=Eddie&LastName=Chan&OddsType=1&MaxTransfer=1000&MinTransfer=100");
		String res = md5String("CWERUSYSSJXNSGQBDCG2/api/CreateMember?OddsType=2&MinTransfer=1&OpCode=LY963CN&MaxTransfer=1000000&PlayerName=NWCGXWIN1");
		System.out.println(md5String(res));
		System.out.println(MD5Util.MD5Encode(res));
		
	}
	
	public static void main(String[] args) {
		test2();
	}
}
