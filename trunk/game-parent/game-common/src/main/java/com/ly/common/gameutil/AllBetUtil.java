package com.ly.common.gameutil;

import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Response;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 欧博工具类
 * @author cgx
 */
public class AllBetUtil {
/*
	private static String propertyId="5802820";
	private static String desKey="VsBCqeuMvMkaU15KQYmVw5HMZmtY//7F";
	private static String md5Key="4C+LvjpI8AQSGMG3A2PL2jzJhR7KOM28su24cgPmmkk=";
	private static String agentName="g668aa";
	private static String apiHost="https://api3.apidemo.net:8443";
	private static String h5Host="https://www.apidemo.net:8443/h5";
	private static String orHallRebate = "0.5";
	
	private static final String betlogHistoriesIn30Day = "/betlog_pieceof_histories_in30days";//30天内投注历史分块查询
	private static final String egameBetlogHistories = "/egame_betlog_histories";//查询电子游戏投注记录历史
	
	private static final String AB_code = "error_code";
	private static final String AB_OK = "OK";
	
	private static final String scode = "0";
	private static final String ecode = "1";
	
	private static final String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	private static final String datePattern = "yyyy-MM-dd";
	
	*//**
	 * 30天内投注历史分块查询
	 * 用于查询30天内任意时间段(最多60分钟)的客户的投注记录
	 * <p style="color:red">调用次数限制：8次/10分钟</p>
	 * @param startTime
	 * @param endTime
	 * @return
	 *//*
	public static Response betlogQueryIn30Day(Date startTime, Date endTime) {
		String st = DateFormatUtils.format(startTime, dateTimePattern);
		String et = DateFormatUtils.format(endTime, dateTimePattern);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("startTime", st);
		params.put("endTime", et);
		
		params.put("random", new SecureRandom().nextLong());
		String qs = getQueryString(params);
		String logPrefix = "AllBetUtil.betlogQueryIn30Day startTime["+st+"] endTime["+et+"]";
		JSONObject obj = getPostResult(betlogHistoriesIn30Day,qs,logPrefix);
		return getObjResult(obj);
	}
	
	*//**
	 * 查询电子游戏投注记录历史
	 * <p style="color:red">返回电子游戏投注记录至服务器时，最大延迟时间为30分钟</p>
	 * <p style="color:red">调用次数限制：8次/10分钟</p>
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param pageIndex 起始页，正整数，从1开始计数
	 * 
	 * @return
	 *//*
	public static Response egameBetlogHistories(String egameType, Date startTime,Date endTime, int pageIndex, int pageSize) {
		String st = DateFormatUtils.format(startTime, dateTimePattern);
		String et = DateFormatUtils.format(endTime, dateTimePattern);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("random", new SecureRandom().nextLong());
		params.put("startTime", st);
		params.put("endTime", et);
		params.put("pageIndex", pageIndex);
		params.put("pageSize", pageSize);
		params.put("egameType", egameType);
		
		String qs = getQueryString(params);
		String logPrefix = "AllBetUtil.egameBetlogHistories egameType["+egameType+"] startTime["+st+"] endTime["+et+"] pageIndex["+pageIndex+"] ";
		JSONObject obj = getPostResult(egameBetlogHistories,qs,logPrefix);
		return getObjResult(obj);
	}
	
	private static JSONObject getPostResult(String actionName,String qs, String logPrefix) {
		System.out.println("欧博请求参数："+qs);
		String data = getData(qs);
		String sign = Base64.encodeBase64String(DigestUtils.md5((data + md5Key)));
		String url = null;
		try{
			url = String.format("%s%s?propertyId=%s&data=%s&sign=%s", apiHost, actionName, propertyId,
					data,
					sign);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("欧博请求url："+url);
		String result = HttpClientsUtil.execute(url, HttpClientsUtil.REQUESTTYPE_POST, 30, logPrefix);
		System.out.println("欧博请求结果："+result);
		if(result==null) {
			return null;
		}
		return JSONObject.parseObject(result);
	}
	private static Response getObjResult(JSONObject obj) {
		if(obj==null) {
			return new Response(ecode, "查询失败", null);
		}
		if(AB_OK.equals(obj.getString(AB_code))) {
			return new Response(scode,null,obj.toString());
		}
		return new Response(ecode, String.format("%s:%s", obj.getString(AB_code),obj.getString("message")), null);
	}*/
}
