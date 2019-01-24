package com.ly.common.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class EncodeUtil {

	public static final String SECRECT_KEY = "1234567812345678";
	static final String KEY_ALGORITHM = "AES";
	static final String CIPHER_ALGORITHM_ECB = "AES/ECB/PKCS5Padding";
	//static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private static String byteArrayToHexString(byte[] b) {
		StringBuilder resultSb = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String md5Encode(String origin) {
		String resultString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(origin
					.getBytes("UTF-8")));
		} catch (Exception ex) {

		}
		return resultString;
	}

	public static String stringToBase64String(String source, String charset) {
		try {
			byte[] bytes = source.getBytes(charset);
			return bytesToBase64String(bytes);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static byte[] base64StringToBytes(String source) {
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			return decoder.decodeBuffer(source);
		} catch (IOException e) {
			throw new RuntimeException("解码出错");
		}
	}

	public static String bytesToBase64String(byte[] bytes) {
		return new BASE64Encoder().encode(bytes);
	}

	public static synchronized String genUUID() {
		UUID obj = UUID.randomUUID();
		return obj.toString();
	}

	public static String aesEncrypt(String content, String key)
			throws Exception {
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypt = cipher.doFinal(content.getBytes());
		return EncodeUtil.bytesToBase64String(encrypt);
	}

	public static String aesDecrypt(String content, String key) throws Exception {
		byte[] array = base64StringToBytes(content);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decrypt = cipher.doFinal(array);
		return new String(decrypt,"UTF-8");
	}

	public static String test() throws Exception {
		// api地址
		String url = "http://192.168.0.23/api/api.jsp";
		String host = "192.168.3.154";
		String systemversion = "5.0.1";
		String username = "DENG1990";
		String appversion = "v1.8.0";
		String action = "loginInfo";
		String uuid = "5156b388-e1b5-4f02-9012-74bb0a960c13";
		String phonemodel = "samsungGT-I9500";
		String gametype = "1";
		String devicetype = "android";
		String token = EncodeUtil.md5Encode("userbalanceDENG1990zh_CN192.168.3.15485425aac-6660-4eac-80e1-59d4f875c3f6" + SECRECT_KEY);
		String queryStr = String.format(
				"host=%s&systemversion=%s&username=%s&token=%s&appversion=%s&action=%s&uuid=%s&phonemodel=%s&gameType=%s&devicetype=%s",
				host, systemversion, username, token, appversion, action, uuid, phonemodel, gametype, devicetype);
		System.out.println("queryStr:" + queryStr);

		String encryContent = aesEncrypt(queryStr, SECRECT_KEY);

		url += url + "?content=" + encryContent;
		System.out.println("发送：" + url);

		// 将返回数据解密
		String outStr = aesDecrypt(encryContent, SECRECT_KEY);
		System.out.println("解密返回：" + outStr);
		// 处理后续逻辑
		return outStr;
	}

	public static void main(String[] args) throws Exception {
		//String queryStr = "action=loginInfo&username=DENG1990&host=192.168.3.154&devicetype=android&phonemodel=samsungGT-I9500&systemversion=5.0.1&appversion=v1.8.0&gameType=1&uuid=3824ceed-8674-407b-8066-12b5408303e6&token=884ecc73a97175e2699a31fb40ce22b6";
		//String queryStr = "lang=zh_CN&action=userbalance&username=QD@MIMIMI8&uuid=QD@MIMIMI81473753609642&host=127.0.0.1&token=fdd3d0c3d1bae824845349347cc01f75";
		//String encryContent = aesEncrypt(queryStr, SECRECT_KEY);
		//System.out.println(encryContent);
		
		
		
		//String queryStr2 = "Qcv5pHC//lJtO/cp6NMtviYp5I4cfCL/L7a+dzZ4RB6fo3fplnggjRbrFnuxDpS+st9fs1MqU3pFvTZKrYP6R+mcubLeygOF8PclBAo0LD43HiNqj6OC0i1Whxz/GV4i1sPBAkjE1XP1UtTW/g+up8Sm7XOeqwjZXEVKonTuI2QHT/J2K/7HY+pBCi/zzIAx13mMmM7g3ZKYNSwDnrP/8Roj6tRf9u0M1o0LpLKn0XOPYRXQCd0Xh3gyEphTWAYfdHL57MLHRCxvFO9WGCHuyLS5wtLq0xaKeRJ0uuPCJWptBoR6GuBowqHvOOGMTHK80NfwxlUZ7KQUyiOSSnYx9y+wEH+DfbDW4ahNEr5cIzT8xFblM0pxBVnW0PDjV+zboE7jGwOL55VfHiW9zRT5ifDz9wNZ7uWCBwpwOkPDW00M60+8A9zbFpp4yhpbpjCLUB+YDDrPy87ms2sfXsvBuEzSwoLt+OW11MVaXAj4uKsAj2luegeBER8SH9G089m4H0YhDqcJliT8+xwH3fI0wA==";
		//System.out.println(aesDecrypt(URLDecoder.decode(queryStr2,"utf-8"),SECRECT_KEY));
		String queryStr2 = "ya4p9xfRDEGo+0Nyva+ltx/1/42MYqT+NoE6U1eP0OH3ZUnf8aoWtL7hxfks11YAzWx9qYQKYzgjWjzxkKP49hruYhvgU3dLNXABeFS1T3uw/f8A9BohU4JUKsHd+D3jUn32hhnoBzgNZWajvsbfsVRKxgp8LIbOYVKmcygRmQk=";
		System.out.println(aesDecrypt(queryStr2,SECRECT_KEY));
//		String encryContent = "dx0LLtaPYSg%2BQp17FEkexxFJ73fE00MK59YvxRKBHONtvux5PiiiGdmEsOh0kDHH5ihxN97R0P1mYTQoQqCekkL2E1OPWhEht63Uc5seOJhS7o3bv56bKsu3KahrCKBpABtDZeMvkcRSq%2FXXvriKusZy5%2FGWT4oI7MT9%2FQ03n132vId09y%2FLUwpLB9s9oZhrny%2BykbUAKYIi8uFThXMHGXS5PH6tzyugRySiGhDeq2rtsCCtTHkCq27Ij%2BgTg63uh7fAjT27FBs%2BMmuRfOZfE4WemiCTLhBcIHkoojHZIWeYdDNiKVOEwEl7nUvFUC2D";
//		byte[] array = EncodeUtil.base64StringToBytes(encryContent);
//		String outStr = aesDecrypt(array, "1234567812345678");
//		System.out.println("解密返回：" + outStr);
//		test();
		

		//String token = EncodeUtil.md5Encode("userbalanceDENG1990zh_CN192.168.3.15409da7db3-96ba-4d87-b7ac-15fd736d66ff" + SECRECT_KEY);
		
		//System.out.println(token);
	}

}
