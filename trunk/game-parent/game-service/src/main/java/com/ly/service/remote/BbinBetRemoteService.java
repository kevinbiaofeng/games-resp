package com.ly.service.remote;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ly.common.util.MD5Util;

/**
 * BBIN抓票信息
 * 波音游戏 BBIN   BbinFishing捕鱼	
 * @author Administrator
 *
 */
@Service
public class BbinBetRemoteService extends BaseBetRemoteService{
	@Value("${ly.games.bbin.bbinwebsite}")
	private String bbinwebsite = "wukong";
	@Value("${ly.games.bbin.bbinname}")
	private String bbinname = "dtest444";
	@Value("${ly.games.bbin.websiteApi}")
	private String websiteApi = "http://linkapi.qtds699.com";
	@Value("${ly.games.bbin.prefix}")
	private String prefix = "";
	@Value("${ly.games.bbin.prefix2}")
	private String prefix2 = "";

	private static final String AETimeZone = "GMT-4:00";

	private static String jsonPath = "/app/WebService/JSON/display.php";

	private static String betRecordModifiedDate3 = "/BetRecordByModifiedDate3";
	private static String WagersRecordBy30 = "/WagersRecordBy30";// BB捕鱼达人抓票
	private static String WagersRecordBy38 = "/WagersRecordBy38";// BB捕鱼大师抓票
	private static String betRecord = "/BetRecord";

	public static final String ACTION_TYPE_BET_TIME = "BetTime";// 使用下注时间查询信息
	public static final String ACTION_TYPE_MODIFIED_TIME = "ModifiedTime";// 使用异动时间查询资讯
	private static final String AETimePattern = "yyyyMMdd";// 美东时间格式化
	private static final String datePattern = "yyyy-MM-dd";
	private static final String AETIMEHourPattern = "HH:mm:ss";
	
	public enum BBinGameKind {
		ball("ball", 1), // BB体育
		Ltlottery("Ltlottery", 12), // 彩票
		live("live", 3), // 视讯
		game("game", 5);// 电子

		private String name;
		private int code;

		BBinGameKind(String name, int code) {
			this.name = name;
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public int getCode() {
			return code;
		}

		public static BBinGameKind getBBinGameKindByCode(int code) {
			for (BBinGameKind b : BBinGameKind.values()) {
				if (b.getCode() == code) {
					return b;
				}
			}
			return null;
		}
	}
	
	/**
	 * 获取波音视讯游戏的修改过的注单报表
	 * @param start_date
	 * @param end_date
	 * @param starttime
	 * @param endtime
	 * @param page
	 * @return
	 */
	public JSONObject betRecordModifiedLive(Date startDate, Date endDate, String startTime, String endTime, int page) {
		String st = DateFormatUtils.format(startDate, datePattern);
		String et = DateFormatUtils.format(endDate, datePattern);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("website", bbinwebsite);
		// 这里该传北京时间还是美东时间？//TODO
		params.put("start_date", st);
		params.put("end_date", et);
		params.put("starttime", startTime);
		params.put("endtime", endTime);
		params.put("gamekind", BBinGameKind.live.getCode());
		// params.put("page", page);
//		HttpClientsUtil
		params.put("key", encode(null, "OaecJ1D8", 8, 2));
		JSONObject ressultStr = getPostResult(websiteApi, betRecordModifiedDate3, params);
		return ressultStr;
	}
	/**
	 * 获取波音游戏的报表，时间是算美东时间的
	 * 
	 * @param rounddate
	 *            日期
	 * @param starttime
	 *            开始时间： 00:00:00
	 * @param endtime
	 *            结束时间： 23:59:59
	 * @param page
	 *            第几页，每页的行数，固定为最大值500
	 * @return
	 */
	public JSONObject betRecord(Date rounddate, String starttime, String endtime, int page, BBinGameKind kind, String code) {
		String rd = DateFormatUtils.format(rounddate, datePattern);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("website", bbinwebsite);
		params.put("uppername", bbinname);
		// 这里该传北京时间还是美东时间？
		params.put("rounddate", rd);
		params.put("starttime", starttime);
		params.put("endtime", endtime);
		params.put("gamekind", kind.getCode());
		if (kind == BBinGameKind.Ltlottery) {
			params.put("gametype", code);
		}
		if (kind == BBinGameKind.game) {
			params.put("subgamekind", code);
		}
		params.put("page", page);
		// params.put("pagelimit", 500);//固定是500
		params.put("key", encode(null, "OaecJ1D8", 8, 2));
		String logPrefix = "BbinUtil.betRecordLot website[" + websiteApi + "] uppername[" + bbinname + "] rounddate[" + rd
				+ "] starttime[" + starttime + "] endtime[" + endtime + "] kind[" + kind + "] code[" + code + "]";
		JSONObject ressultStr = getPostResult(websiteApi, betRecord, params);
		return ressultStr;
	}
	/**
	 * 获取波音彩票游戏的修改过的注单报表
	 * 
	 * @param start_date
	 * @param end_date
	 * @param starttime
	 * @param endtime
	 * @param page
	 * @return
	 */
	public JSONObject betRecordModifiedBet(Date start_date, Date end_date, int page, BBinGameKind kind, String code) {
		String st = DateFormatUtils.format(start_date, datePattern, TimeZone.getTimeZone(AETimeZone));
		String et = DateFormatUtils.format(end_date, datePattern, TimeZone.getTimeZone(AETimeZone));

		String sd = DateFormatUtils.format(start_date, AETIMEHourPattern, TimeZone.getTimeZone(AETimeZone));
		String ed = DateFormatUtils.format(end_date, AETIMEHourPattern, TimeZone.getTimeZone(AETimeZone));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("website", bbinwebsite);
		// 这里该传美东时间
		params.put("start_date", st);
		params.put("end_date", et);
		params.put("starttime", sd);
		params.put("endtime", ed);
		params.put("gamekind", kind.getCode());
		if (kind.equals(BBinGameKind.Ltlottery)) {
			params.put("gametype", code);
		}
		params.put("page", page);
		params.put("key", encode(null, "OaecJ1D8", 8, 2));
		String logPrefix = "BbinUtil.betRecordModifiedBet website[" + websiteApi + "] GameKind[" + kind + "] GameCode[" + code + "] "
				+ "AETimeZone[" + AETimeZone + "] start_date[" + st + "] end_date[" + et
				+ "] starttime[" + sd + "] endtime[" + ed + "] ";
		JSONObject ressultStr = getPostResult(websiteApi, betRecordModifiedDate3, params);
		return ressultStr;
	}
	
	/**
	 * 捕鱼大师下注纪录(action=ModifiedTime时，捞取区间限定5分钟且无法捞取7天前，被异动的资料)
	 * 
	 * @param action
	 *            类型：BetTime / ModifiedTime：须选一。（BetTime：使用下注时间查询信息/
	 *            ModifiedTime：使用异动时间查询资讯）
	 * @param username
	 *            会员帐号
	 * @param date
	 *            日期:yyyy-MM-dd, 注意：开始和结束日期必须是一天。
	 * @param startTime
	 *            开始时间: HH:mm:ss, 注意：开始和结束时间必须是一天内。
	 * @param endTime
	 *            结束时间: HH:mm:ss, 注意：开始和结束时间必须是一天内。
	 * @param page
	 *            页数
	 * @param pagelimit
	 *            条数
	 * @return Response
	 */
	public JSONObject wagersRecordBy38(String action, String username, String date, String startTime, String endTime, int page, int pagelimit) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("website", bbinwebsite);
		// action=BetTime时，需强制带入
		params.put("action", action);
		if (StringUtils.isNotEmpty(username)) {
			params.put("username", username);
		}
		if (ACTION_TYPE_BET_TIME.equals(action)) {
			params.put("uppername", bbinname);
		}
		params.put("date", date);
		params.put("starttime", startTime);
		params.put("endtime", endTime);
		params.put("gametype", 38001);
		if (page > 0) {
			params.put("page", page);
		}
		if (pagelimit > 0) {
			params.put("pagelimit", pagelimit);
		}
		params.put("key", encode(null, "OaecJ1D8", 8, 2));
		String logPrefix = "BbinUtil.wagersRecordBy38 website[" + websiteApi + "] date[" + date + "] startTime[" + startTime + "] endTime[" + endTime
				+ "] ";
//		website + jsonPath + actionName, null, params,
		return getPostResult(websiteApi, WagersRecordBy38, params);
	}
	/**
	 * BB捕鱼达人下注纪录（action = ModifiedTime时，捞取区间限定5分钟且无法捞取7天前，被异动的资料）
	 * 
	 * @param action
	 *            类型：BetTime / ModifiedTime：须选一。（BetTime：使用下注时间查询信息/
	 *            ModifiedTime：使用异动时间查询资讯）
	 * @param date
	 *            日期:yyyy-MM-dd, 注意：开始和结束日期必须是一天。
	 * @param startTime
	 *            开始时间: HH:mm:ss, 注意：开始和结束时间必须是一天内。
	 * @param endTime
	 *            结束时间: HH:mm:ss, 注意：开始和结束时间必须是一天内。
	 * @param page
	 *            页数
	 * @param pagelimit
	 *            条数
	 * @return Response
	 */
	public JSONObject wagersRecordBy30(String action, String date, String startTime, String endTime, int page, int pagelimit) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("website", bbinwebsite);
		// action=BetTime时，需强制带入
		params.put("action", action);
		if (ACTION_TYPE_BET_TIME.equals(action)) {
			params.put("uppername", bbinname);
		}
		params.put("date", date);
		params.put("starttime", startTime);
		params.put("endtime", endTime);
		params.put("gametype", 30599);
		if (page > 0) {
			params.put("page", page);
		}
		if (pagelimit > 0) {
			params.put("pagelimit", pagelimit);
		}
		params.put("key", encode(null, "OaecJ1D8", 8, 2));

		// System.out.println(params.toString());
		String logPrefix = "BbinUtil.wagersRecordBy30 website[" + websiteApi + "] date[" + date + "] startTime[" + startTime + "] endTime[" + endTime
				+ "]";
		return getPost(websiteApi, WagersRecordBy30, params);
	}
	
	private JSONObject getPost(String website, String actionName, Map<String, Object> params) {
		String url = website + jsonPath + actionName;
		System.out.println(url);
		System.out.println(createLinkStringByGet(params));
		String result=sendPost(url,createLinkStringByGet(params));
		System.out.println("BBIN请求结果："+result);
		if(result==null) {
			return null;
		}
		return JSONObject.parseObject(result);
	}
	private JSONObject getPostResult(String website, String actionName, Map<String, Object> params) {
		String url = website + jsonPath + actionName;
		System.out.println(url+"?"+createLinkStringByGet(params));
		String result=sendGet(url+"?"+createLinkStringByGet(params));
		System.out.println("BBIN请求结果："+result);
		if(result==null) {
			return null;
		}
		return JSONObject.parseObject(result);
	}
	private String encode(String username, String keyb, int preSize, int sufSize) {
		String sign = null;
		if (username != null) {
			sign = MD5Util.MD5Encode(bbinwebsite + addPrefix(username) + keyb + getAEDate());
		} else {
			sign = MD5Util.MD5Encode(bbinwebsite + keyb + getAEDate());
		}
		return (getPreStr(preSize) + sign + getPosStr(sufSize)).toLowerCase();
	}
	/**
	 * 获取加密字符串的前9位随机字符串
	 * 
	 * @return
	 */
	private String getPreStr(int size) {
		return getRandomString(size);
	}
	private String addPrefix(String username) {
		return (prefix + prefix2 + username).toUpperCase();
	}
	/**
	 * 获取加密字符串的后6位随机字符串
	 * 
	 * @return
	 */
	private String getPosStr(int size) {
		return getRandomString(size);
	}
	/**
	 * 获取指定长度的字符串
	 * 
	 * @param length
	 * @return
	 */
	private String getRandomString(int length) { // length琛ㄧず鐢熸垚瀛楃涓茬殑闀垮害
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	public String removePrefix(String username) {
		if (username.startsWith(prefix) || username.startsWith(prefix.toUpperCase())) {
			username = username.substring(prefix.length());
			if (username.startsWith(prefix2) || username.startsWith(prefix2.toUpperCase())) {
				username = username.substring(prefix2.length());
			}
		}
		return username;
	}
	/**
	 * 获取美东时间的日期格式
	 * 
	 * @return
	 */
	private String getAEDate() {
		return DateFormatUtils.format(new Date(), AETimePattern, TimeZone.getTimeZone(AETimeZone));
	}
}
