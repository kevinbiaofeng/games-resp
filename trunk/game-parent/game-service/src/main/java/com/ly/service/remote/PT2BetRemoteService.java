package com.ly.service.remote;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.ly.common.util.HttpsUtils;

public class PT2BetRemoteService {
	@Value("${ly.games.pt2.merchantName}")
	private String merchantName;
	
	@Value("${ly.games.pt2.merchantCode}")
	private String merchantCode;

	@Value("${ly.games.pt2.apiUrl}")
	private String apiUrl;
	
	public static final String reqg_betLog = "/v2/agent_game_log_by_id/start_num/%s/size/5000/";//获取玩家下注日志
	public static final String reqg_betLogId = "/v2/agent_game_log_by_time/start_time/%s/end_time/%s/";//获取玩家下注日志的id列表（检验是否漏单）
	
	private enum HttpType {
		GET,
		POST,
		PUT,
		DELETE
	}
	
	/**
	 * 获取玩家下注日志的id列表（检验是否漏单）
	 * @param sd
	 * @param ed
	 * @return
	 */
	public String getBetLogId(Date sd, Date ed) {
		String logPre = String.format("PT2Util.getBetLogId:[sd:%s,ed:%s]", sd.getTime(),ed.getTime());
		String actionUrl = String.format(reqg_betLogId, sd.getTime()/1000,ed.getTime()/1000);
		String json = send(apiUrl+actionUrl,HttpType.GET, null, logPre);
		return json;
	}
	
	/**
	 * 获取玩家下注日志
	 * @param startNum
	 * @return
	 */
	public String getBetLog(int startNum) {
		String logPre = String.format("PT2Util.getBetLog:[start_num:%s]", startNum);
		String actionUrl = String.format(reqg_betLog, startNum);
		String json = send(apiUrl+actionUrl,HttpType.GET, null, logPre);
		return json;
	}
	private String send(String url, HttpType httpType, Map<String, Object> params,String logPre) {
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("Accept", "application/json");
		head.put("merchantname",merchantName);
		head.put("merchantcode",merchantCode);
		String result = "";
		if(httpType.equals(HttpType.GET)) {
			result = HttpsUtils.get(url, head, params, logPre);
		} else if(httpType.equals(HttpType.POST)) {
			result = HttpsUtils.post(url, head, params, null,logPre);
		} else if(httpType.equals(HttpType.PUT)){
			result = HttpsUtils.put(url, head, params, null,logPre);
		} else if(httpType.equals(HttpType.DELETE)){
			result = HttpsUtils.delete(url, head, params,logPre);
		}
		return result;
	}
	
	public static void main(String[] args) {
//		String hh=getBetLog(174);
//		System.out.println(hh);
	}
	
}
