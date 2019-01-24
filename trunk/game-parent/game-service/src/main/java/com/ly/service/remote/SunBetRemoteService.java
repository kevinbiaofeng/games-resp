package com.ly.service.remote;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;

/**
 * 申博 抓票
 * @author Administrator
 *
 */
@Service
public class SunBetRemoteService extends BaseBetRemoteService{
	@Value("${ly.games.sun.sb_apihost}")
	private String sb_apihost;
	@Value("${ly.games.sun.sb_clientid}")
	private String sb_clientid;
	@Value("${ly.games.sun.sb_clientsecret}")
	private String sb_clientsecret;
	private static  boolean logctrl =false;
	
	public static final int DESKTOP = 0;//PC端授权
	public static final int MOBILE = 1;//移动端授权
	public static final int DEPOSIT = 0;//存款动作
	public static final int DEBIT = 1;//取款动作
	private static final String bet = "/api/report/bethistory";
	/***
	 * 捞取申博注单
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public String getBet(Date starttime,Date endtime){
		try{
			String url = sb_apihost + bet + "?startdate=" + parseTime(starttime) + "&enddate=" + parseTime(endtime) + "&includetestplayers=true&issettled=true";
			if(logctrl)
				System.out.println("Sunbet getbet:" + url);
			String res = doSunbetGet(url, "application/text/csv");
			if(logctrl)
				System.out.println("Sunbet getbet result:" +res);
			if(res.indexOf("ugsbetid") == -1)
				return "";
			return res;
		}catch(Throwable e){
			e.printStackTrace();
			return "";
		}
		
	}
	
	/***
	 * 申博特有的get请求
	 * @param url
	 * @param header
	 * @return
	 */
	public String doSunbetGet(String url,String header){
		try{
			StringBuffer buffer = new StringBuffer();
			//发送get请求
	        URL serverUrl = new URL(url);  
	        HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();  
	        //conn.setConnectTimeout(5 * 60 * 1000);
	        conn.setConnectTimeout(30 * 1000);
	        conn.setRequestMethod("GET");  
	        //必须设置false，否则会自动redirect到重定向后的地址  
	        conn.setInstanceFollowRedirects(false);
	        String au = getAuthorization();
	        if(logctrl)
	        	System.out.println("Authorization:" + au);
	        conn.addRequestProperty("Authorization", au);  
	        
	        String t = toUtctime(new Date());
	        if(logctrl)
	        	System.out.println("X-Sgs-Date:" + t);
	        conn.addRequestProperty("X-Sgs-Date", t);  
	        conn.addRequestProperty("Accept", "application/json");  
	        conn.addRequestProperty("Content-Type", header); 
	        conn.connect();
	        
	      //将返回的输入流转换成字符串  
	        InputStream inputStream = null;
    		if (conn.getResponseCode() >= 400) {
    			inputStream = conn.getErrorStream();//为了防止400的情况
    		}else{		
    			inputStream = conn.getInputStream();    
    		}
	        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");  
	        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); 
	        String str = null;  
	        while ((str = bufferedReader.readLine()) != null) {  
	            buffer.append(str).append(header.equals("application/text/csv") ? "\n" : "");  
	        }  
	        bufferedReader.close();  
	        inputStreamReader.close();  
	        // 释放资源  
	        inputStream.close();  
	        inputStream = null;  

        	return buffer.toString();
		}catch(Throwable e){
			e.printStackTrace();
			return "";
		}
	}
	/***
	 * 获取授权令牌
	 * @return
	 */
	public String getAuthorization(){
		return  "SGS" + " " + sb_clientid + ":" + getSignature();
	}
	/***
	 * 获取签名字串
	 * @return
	 */
	public String getStringToSign(){
		return  sb_clientsecret  + toUtctime(new Date());
	}
	/***
	 * 转utc时间
	 * @param date
	 * @return
	 */
	public String toUtctime(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		return df.format(date);
	}
	/***
	 * 获取签名
	 * @return
	 */
	public String getSignature(){
		//HmacSHA.calculateRFC2104HMAC(sb_clientsecret, )
		try{
			String stringToSign = getStringToSign();
			byte[] keys = sb_clientsecret.getBytes("utf-8");
			byte[] bytes = stringToSign.getBytes("utf-8");
			
			SecretKey secretKey = new SecretKeySpec(keys, "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(secretKey); 
			
			byte[] hashed = mac.doFinal(bytes); 
			 
			return base64Encode(hashed);
			
		}catch(Throwable e){
			e.printStackTrace();
			return "";	
		}
	}
	public String base64Encode(byte[] s) {
        if (s == null)
            return null;
        BASE64Encoder b = new sun.misc.BASE64Encoder();
        return b.encode(s);
    }
	public String parseTime(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		try{
			return df.format(date) + URLEncoder.encode("+", "UTF-8") + "08:00";
		}catch(Throwable e){
			e.printStackTrace();
			return df.format(date) + "%2B08:00";
		}
	}
}
