package com.ly.service.remote;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSONObject;
import com.ly.common.gameutil.im.HttpClientUtil;

public class IMBetRemoteService {
	// 主商家名称=R_WUKONG
	@Value("${ly.games.im.merchantName}")
	private String merchantName;// 商家名称
	@Value("${ly.games.im.merchantCode}")
	private String merchantCode;// 测试环境商家密钥
	@Value("${ly.games.im.brandcode}")
	private String brandcode;// 会员前缀
	@Value("${ly.games.im.apiUrl}")
	private String apiUrl;// 测试环境，URL连接

	public static final String reqg_betLogId = "/Report/GetBetLog";// 获取玩家下注日志的id列表（检验是否漏单）
	public static final String reqg_betLog = "/Report/GetBetLog";// 获取下注日志
	public static final int I_M_SLOT_WALLET = 101;// IM 老虎机钱包
	public static final int I_M_LIVE_DEALER_WALLET = 201;// IM 娱乐场钱包
	public static final int I_M_SPORTSBOOK_WALLET = 301; // IM 体育博彩钱包
	public static final int I_M_SPORTS_WALLET = 401;// 电子竞技钱包
	public static final String LANGUAGE_EN = "EN";// 英文
	public static final String LANGUAGE_ZH_CN = "ZH-CN";// 简体中文
	public static final String SPORTS_GAMES_CODE = "IMSB";// 皇冠体育游戏代码

	public String getBetLog(String startDate, String endDate, String LastUpdatedDate, int page, int dateFilterType, int betStatus) {
		return getBetLog(startDate, endDate, page, I_M_SPORTSBOOK_WALLET, LANGUAGE_ZH_CN, dateFilterType, LastUpdatedDate, betStatus);
	}

	/**
	 * 获取玩家下注日志
	 * 
	 * @param startDate
	 *            (必须)开始日期时间(• 时间格式：yyyy-MM-dd HH.mm.ss )
	 * @param endDate
	 *            (必须)结束日期时间(• 时间格式：yyyy-MM-dd HH.mm.ss )
	 * @param page
	 *            (必须)页数
	 * @param productWallet
	 *            (必须)钱包代码
	 * @param language
	 *            (必须)语言（LANGUAGE_EN or LANGUAGE_ZH_CN）
	 * @param dateFilterType
	 *            (必须)• 此参数用于决定 StartDate 和 EndDate 的定义, • 必须的参数 (当 ProductWallet = 301 或 401)（1=下注时间，2=比赛时间）
	 * @param lastUpdatedDate
	 *            (• 此参数将根据注单的最后跟新时间加以过滤响应结果。 • 此参数值必须在日期区间内。 • 可选参数。如果提供此参数，系统则只返回所有最后跟新时间大于此值的注单 • 时间格式：yyyy-MM-dd HH.mm.ss )
	 * @param betStatus
	 *            此参数用于决定回传那种注单 (-1=没有条件,0=未结算 or 1=结算 )
	 * @return
	 */
	public String getBetLog(String startDate, String endDate, int page, int productWallet, String language, int dateFilterType, String lastUpdatedDate, int betStatus) {
		String logPre = String.format("IMUtil.getBetLog:[startDate:%s,endDate:%s,page:%s,productWallet:%s,language:%s,dateFilterType:%s,lastUpdatedDate:%s,betStatus:%s]", startDate, endDate, page,
				productWallet, language, dateFilterType, lastUpdatedDate, betStatus);
		// 2.6.1 玩家下注日志 (IM 体育博彩，IM 电子竞技)===请看这个内容来修改
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("MerchantCode", merchantCode);
		jsonObject.put("StartDate", startDate);// 起始时间
		jsonObject.put("EndDate", endDate);// 结束时间
		jsonObject.put("Page", page);// 日志页码
		jsonObject.put("ProductWallet", productWallet);// 钱包代码
		// jsonObject.put("Currency", CURRENCY_CODE);// 接受的货币代码

		// • 此参数用于决定 StartDate 和 EndDate 的定义
		// • 必须的参数 (当 ProductWallet = 301 或 401)
		// • Int
		// • 1 = 下注时间 (Bet Date 注单的下注时间)
		// • 2 = 比赛时间 (Event Date 所投注比赛的开赛时间)
		jsonObject.put("DateFilterType", dateFilterType);

		// • 此参数用于决定回传那种注单.
		// • 可选参数。如果未传此参数，系统则返回所有结算与未结算注单。
		// • Int
		// • 0 = 未结算 (Not Settled)
		// • 1 = 结算 (Settled)
		if (betStatus > -1) {
			jsonObject.put("BetStatus", betStatus);
		}

		// • 此参数将根据注单的最后跟新时间加以过滤响应结果。
		// • 此参数值必须在日期区间内。
		// • 可选参数。如果提供此参数，系统则只返回所有最后跟新时间大于此值的注单。
		// • 时间格式：yyyy-MM-dd HH.mm.ss
		jsonObject.put("LastUpdatedDate", lastUpdatedDate);

		// • 响应将根据此参数值的语言为回传结果作翻译(本地化)。系统只翻译 League Name, Home Team 和 Away Team。
		// • 必须的参数 (当 ProductWallet = 301 或 401)
		// • String (5)
		// • EN for English（英文）
		// • ZH-CN for Simplified Chinese（简体中文）
		jsonObject.put("Language", language);
		String json = HttpClientUtil.postString(jsonObject.toString(), logPre, apiUrl + reqg_betLog);
		// logger.info("IMUtil.getBetLog.parameter:" + json);
		return json;
	}
	public static void main(String[] args) {
//		String r8 = getBetLog("2018-06-01 00.00.00", "2018-06-02 00.05.00", 1, I_M_SPORTSBOOK_WALLET, LANGUAGE_ZH_CN, 1, "2018-06-01 00.05.00", -1);// 查询日志
//		System.out.println(r8);
	}
}
