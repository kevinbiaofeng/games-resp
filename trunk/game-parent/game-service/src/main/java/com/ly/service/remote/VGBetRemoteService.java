package com.ly.service.remote;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VGBetRemoteService extends BaseBetRemoteService{
	
	private final static Logger logger =  LoggerFactory.getLogger(VGBetRemoteService.class);
	@Value("${ly.games.vg.domain}")
	private String domain;
	@Value("${ly.games.vg.password}")
	private String password;
	
	public String getFightAllRecord(Integer versionKey){
		String result = null;
		String channel = "10";
		StringBuffer url = new StringBuffer();
		url.append(domain).append("/gamerecordid.aspx?channel=")
		.append(channel).append("&id=").append(versionKey)
		.append("&verifyCode=").append(genSecret(channel,versionKey+""));
		result = sendGet(String.valueOf(url));
		logger.info("getFightAllRecord url:" + url + " result:" + result);
		return result;
	}
	public static void main(String[] args) {
//		String hh= getFightAllRecord(6719970);
//		JSONObject jsonObj=JSONObject.parseObject(hh);
//		String val= jsonObj.getString("value");
//		JSONArray arr=JSONArray.parseArray(val);
//		String message="";
//		FontanaBetVggame info=new FontanaBetVggame();
//		System.out.println(val);
//		List<FontanaBetVggame> nnf=FastJsonUtils.json2List(val, FontanaBetVggame.class);
//		System.out.println(JSONObject.toJSONString(nnf));
	}
	public String genSecret(String... args) {
		StringBuilder builder = new StringBuilder();
		for (String str : args) {
			builder.append(str);
		}
		builder.append(password);
		String result = builder.toString();
		String key = bytesToHexString(bytesToMd5(result.getBytes()));
		return key;
	}
	
	public String bytesToHexString(byte[] array) {
		StringBuffer buf = new StringBuffer(array.length * 2);
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 0xff) < 16)
				buf.append("0");
			//这里一定要大写，要不当遇到中文问题时逆转时就会出错
			buf.append(Long.toString(array[i] & 0xff, 16).toUpperCase());
		}
		return buf.toString();
	}
	
	public byte[] bytesToMd5(byte[] bytes) {
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			return mdTemp.digest(bytes);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("md5转码出错", e);
		}
	}
}
