package com.ly.service.remote;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ly.common.util.HttpClientsUtil;
import com.ly.common.util.MD5Util;

@Service
public class LyLotBetRemoteService extends BaseBetRemoteService{
	@Value("${ly.games.lylot.Merchantkey}")
	private String Merchantkey;
	@Value("${ly.games.lylot.apiUrl}")
	private String apiUrl;
	private static final String reqEncode = "GetUrlEncode";
	private static final String reqGetAllReportDetail = "GetAllReportDetail";
	
	public enum Platform {
		pc,
		mobile
	}
	/**
	 * 请求第三方的加密接口，获取参数加密后的结果
	 * @param param
	 * @return
	 */
	private String encode (String param) {
		String url = apiUrl + reqEncode;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("param", param);
		try {
			return HttpClientsUtil.execute(url,HttpClientsUtil.REQUESTTYPE_POST,map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 注单报表查询接口,不区分代理
	 * @param startDate 开始时间  格式:”2018-01-01 02:00:00”
	 * @param endDate 结束时间  格式:”2018-01-01 02:00:00”
	 * @param pageIndex 页码，默认值1，必须大于0，每页固定大小100
	 * @return
	 */
	public String getBetLogAll(Date startDate, Date endDate,int pageIndex) {
		String sd = DateFormatUtils.format(startDate, com.ly.common.util.DateUtils.FORMAT_TIME);
		String ed = DateFormatUtils.format(endDate, com.ly.common.util.DateUtils.FORMAT_TIME);
		String logpre = String.format("LyLotUtil.getBetLogAll[startDate:%s,endDate:%s,pageIndex:%s]",
				sd, ed, pageIndex);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("StartDate", sd);
		param.put("EndDate", ed);
		param.put("PageIndex", pageIndex);
		param.put("PageSize", 100);
		String json = send(apiUrl+reqGetAllReportDetail,param,logpre);
		return json;
	}
	private String send(String apiUrl, Map<String, Object> map,String logPre) {
		map.put("Merchantkey", Merchantkey);
		String paramStr = JSONObject.toJSONString(map);
		String  desParamStr = encode(paramStr);
		String key = MD5Util.MD5Encode(paramStr+Merchantkey);
		String url = apiUrl+"?param="+desParamStr+"&key="+key;
		return HttpClientsUtil.execute(url, HttpClientsUtil.REQUESTTYPE_GET, logPre);
	}
	public static void main(String[] args) {
//		System.out.println(login("test01", Platform.pc));
//		System.out.println(gameList());
//		System.out.println(getBalance("test01"));
//		System.out.println(deposit("test02",100,"123456798"));
//		System.out.println(withdraw("test02",100,"123456798"));
//		System.out.println(checkOrder("123456798"));
//		Date ed = DateUtils.addHours(new Date(), 24);
//		Date sd = DateUtils.addHours(ed, -86);
//		System.out.println(getBetLogAll(sd, ed, 1));
//		System.out.println(updateKickBack("test01",8));
//		System.out.println(logout("test01"));
	}
	
}
