package com.ly.common.gameutil.mw.sign;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class EncryUtil {

	/**
	 * 对返回的结果进行验签
	 * @param data 业务数据密文
	 * @param key 加密后的密文
	 * @param merchantPublicKey 接入平台的公钥
	 * @param privateKey 私钥
	 * @return 验签是否通过
	 * @throws Exception
	 */
	public static TreeMap<String, String> checkSignature(String data, String key, String merchantPublicKey, String privateKey)
	throws Exception {
		// 使用平台私钥解密后获得AES key
		String AESKey = "";
		try {
			AESKey = RSA.decrypt(key, privateKey);
		} catch (Exception e) {
			// AES密钥解密失败
			throw new Exception("签名失败");
		}

		// AES解密获得明文data数据
		String realData = AES.decryptFromBase64(data, AESKey);
		TreeMap<String, String> map = JSON.parseObject(realData,
				new TypeReference<TreeMap<String, String>>() {});
		// 从明文中获得加密sign
		String sign = StringUtils.trimToEmpty(map.get("sign"));

		// 获取加密源数据
		Iterator<Entry<String, String>> iter = map.entrySet().iterator();
		StringBuffer oridinalData = new StringBuffer();
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			String keyInfo = (String) entry.getKey();
			String valueInfo = entry.getValue() == null ? "" : entry.getValue();
			if (StringUtils.equals(keyInfo, "sign")) {
				continue;
			}

			oridinalData.append(keyInfo);
			oridinalData.append("=");
			oridinalData.append(valueInfo);
		}

		// RSA验签
		boolean result = RSA.checkSign(oridinalData.toString(), sign, merchantPublicKey);
		if (!result) {
			throw new Exception("签名失败");
		}
		return map;
	}




	/**
	 * 生成RSA签名
	 * @param map
	 * @param privateKey
	 * @return
	 */
	public static String handleRSA(TreeMap<String, Object> map, String privateKey) {
		StringBuffer sbuffer = new StringBuffer();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			sbuffer.append(entry.getValue());
		}
		String signTemp = sbuffer.toString();

		String sign = "";
		if (StringUtils.isNotEmpty(privateKey)) {
			sign = RSA.sign(signTemp, privateKey);
		}
		return sign;
	}



	/**
	 * 生成hmac
	 */
	public static String handleHmac(TreeMap<String, String> map, String hmacKey) {
		StringBuffer sbuffer = new StringBuffer();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sbuffer.append(entry.getValue());
		}
		String hmacTemp = sbuffer.toString();

		String hmac = "";
		if (StringUtils.isNotEmpty(hmacKey)) {
			hmac = Digest.hmacSHASign(hmacTemp, hmacKey, Digest.ENCODE);
		}
		return hmac;
	}
}
