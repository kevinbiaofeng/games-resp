package com.ly.service.remote;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ly.common.util.HttpsUtils;

/**
 * FG抓票信息
 * @author Administrator
 *
 */
@Service
public class FGBetRemoteService extends BaseBetRemoteService{
	
	public enum GameType {
		fish,
		poker,
		slot,
		fruit
	}
	private final String reqg_betLog = "/v2/agent/log_by_page/gt/%s/";
	private final String reqg_gameList = "/v2/games/game_type/%s/language/zh_CN";//获取游戏列表
	@Value("${ly.games.fg.apiUrl}")
	private String apiUrl;
	@Value("${ly.games.fg.merchantName}")
	private String merchantName;
	@Value("${ly.games.fg.merchantCode}")
	private String merchantCode;
	
	/**
	 * 获取玩家下注日志
	 * @param gameType 抓哪种类型的票
	 * @param pageKey 分页标识符，首次调用这个方法时，传null，然后会返回page_key参数，需要保存page_key，以便下去传过来
	 * @return
	 */
	public String getBetLog(GameType gameType,String  pageKey) {
		String actionUrl = String.format(reqg_betLog, gameType.name());
		if(StringUtils.isNotEmpty(pageKey)) {
			actionUrl = actionUrl+"page_key/"+pageKey;
		}
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("Accept", "application/json");
		head.put("merchantname",merchantName);
		head.put("merchantcode",merchantCode);
		String json = HttpsUtils.get(apiUrl+actionUrl, head, null, null);
		return json;
	}
	/**
	 * 获取游戏列表
	 * @param terminal
	 * @return
	 */
	public String getGameList() {
		String actionUrl = String.format(reqg_gameList, Terminal.h5.name());
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("Accept", "application/json");
		head.put("merchantname",merchantName);
		head.put("merchantcode",merchantCode);
		String json = HttpsUtils.get(apiUrl+actionUrl,head,null, null);
		return json;
	}
	public enum Terminal {
		as,
		h5
	}
	public static void main(String[] args) { 
//		String hh=FGBetRemoteService.getGameList();
//		System.out.println("000"+hh);
	}
}
