package com.ly.service.remote;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * CQ9 抓票
 * @author Administrator
 *
 */
@Service
public class CQ9BetRemoteService extends BaseBetRemoteService{
	@Value("${ly.games.cq9.token}")
	private String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyaWQiOiI1YTY5MzQyODYxODk0MjAwMDFkMGNmZDYiLCJhY2NvdW50IjoibHkiLCJvd25lciI6IjVhNjkzNDI4NjE4OTQyMDAwMWQwY2ZkNiIsInBhcmVudCI6InNlbGYiLCJjdXJyZW5jeSI6IkNOWSIsImp0aSI6IjcwMjgxMjQ2NSIsImlhdCI6MTUxNjg0NDA3MiwiaXNzIjoiQ3lwcmVzcyIsInN1YiI6IlNTVG9rZW4ifQ.ByL41a-CBlnfRTAkFGfgdFbeYQjnNLAXxbVGSKn_AAI";
	@Value("${ly.games.cq9.apiUrl}")
	private String apiUrl = "http://api.cqgame.games";
	
	private final String reqBetView = "/gameboy/order/view"; //注單查詢 get
	private final String reqGameHall = "/gameboy/game/list/";//遊戲列表 get
	
	private final String TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss-04:00";
	private final String TIME_FORMAT_END = "yyyy-MM-dd'T'HH:mm:ss.999-04:00";
	private final String AETimeZone = "GMT-4:00";;
	
	public static int pageSize = 2000;
	/**
	 * 获取注单报表
	 * @param starttime 请传北京时间，接口会自动转换成美东时间 往前面推三分钟
	 * @param endtime 请传北京时间，接口会自动转换成美东时间
	 * @param page 第几页
	 * @return
	 */
	public String betList(Date starttime, Date endtime, int page) {
		String stime = DateFormatUtils.format(starttime, TIME_FORMAT, TimeZone.getTimeZone(AETimeZone));
		String etime = DateFormatUtils.format(endtime, TIME_FORMAT_END, TimeZone.getTimeZone(AETimeZone));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("starttime",stime);
		params.put("endtime",etime);
		params.put("page", page);
		//params.put("account", "test01");
		params.put("pagesize", pageSize );//默认500，最大2000
		Map<String,Object> head=new HashMap<>();
		head.put("Authorization", token);
		String json =sendGetData(apiUrl+reqBetView+"?"+createLinkStringByGet(params));
		return json;
	}
	public  void main(String[] args) {
//		Date date=new Date();
//		String hh=CQ9BetRemoteService.betList(DateUtils.addMinutes(date, -3), date, 1);
////		String hh=CQ9BetRemoteService.gameList();
//		System.out.println(hh);
	}
	private String sendGetData(String url) {
		Map<String,Object> head=new HashMap<>();
		head.put("Authorization", token);
		String json = sendGet(url,head);
		return json;
	}
	public String gameList() {
		String json = sendGetData(apiUrl+reqGameHall+"cq9");
		return json;//JSONObject.parseObject(json).getString("data");
	}
}
