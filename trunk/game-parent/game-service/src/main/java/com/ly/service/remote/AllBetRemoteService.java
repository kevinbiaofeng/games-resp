package com.ly.service.remote;

import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ly.common.util.allbet.DataUtils;
import com.ly.game.model.FontanaBetAgbm;

@Service
public class AllBetRemoteService extends BaseBetRemoteService{
	
	private final Logger logger =  LoggerFactory.getLogger(AllBetRemoteService.class);
	
	@Value("${ly.games.all.propertyId}")
	private String propertyId;
	@Value("${ly.games.all.desKey}")
	private String desKey;
	@Value("${ly.games.all.md5Key}")
	private String md5Key;
	@Value("${ly.games.all.agentName}")
	private String agentName;
	@Value("${ly.games.all.apiHost}")
	private String apiHost;
	
	private static final String egameBetlogHistories = "/egame_betlog_histories";//查询电子游戏投注记录历史
	private static final String queryHandicap = "/query_handicap";//查询系统盘口信息
	private static final String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 查询系统盘口信息
	 * @return
	 */
	public JSONObject queryHandicap() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("agent",agentName);
		params.put("random", new SecureRandom().nextLong());
		String qs = DataUtils.getQueryString(params);
		//String qs = "agent=g668aa&random=7211698878763002878";
		//String qs = String.format("agent=%s&random=%s", agentName,new SecureRandom().nextLong());
		JSONObject obj = getPostResult(queryHandicap,qs);
		return obj;
	}
	
	/**
	 * 查询电子游戏投注记录历史
	 * <p style="color:red">返回电子游戏投注记录至服务器时，最大延迟时间为30分钟</p>
	 * <p style="color:red">调用次数限制：8次/10分钟</p>
	 * @param egameType 电子游戏类型:
	 *		lax: 电子游戏厅 A (暂未推出)
	 *		lst: 电子游戏厅 B (暂未推出)
	 *		dv: 欧博电子游戏厅(暂未推出)
	 *		ec: 电子游戏厅 C - 鱼乐无穷游戏(暂未推出)
	 *	 	af: 电子游戏厅 D - 空战世纪游戏
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param pageIndex 起始页，正整数，从1开始计数
	 * 
	 * @return
	 */
	public JSONObject egameBetlogHistories(String egameType, Date startTime,Date endTime, int pageIndex, int pageSize) {
		String st = DateFormatUtils.format(startTime, dateTimePattern);
		String et = DateFormatUtils.format(endTime, dateTimePattern);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("random", new SecureRandom().nextLong());
		params.put("startTime", st);
		params.put("endTime", et);
		params.put("pageIndex", pageIndex);
		params.put("pageSize", pageSize);
		params.put("egameType", egameType);
		String qs = DataUtils.getQueryString(params);
		JSONObject obj = getPostResult(egameBetlogHistories,qs);
		return obj;
    }
    private JSONObject getPostResult(String actionName,String qs) {
		System.out.println("欧博请求参数："+qs);
		String data = DataUtils.getData(qs, desKey);
		String sign = Base64.encodeBase64String(DigestUtils.md5((data + md5Key)));
		String url = null;
		try{
			url = String.format("%s%s?propertyId=%s&data=%s&sign=%s", apiHost, actionName, propertyId,
					URLEncoder.encode(data, "UTF-8"),
					URLEncoder.encode(sign, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("欧博请求url："+url);
		String result=sendGet(url);
		System.out.println("欧博请求结果："+result);
		if(result==null) {
			return null;
		}
		return JSONObject.parseObject(result);
	}
    
    
    public static void main(String[] args) {
//    	String egameType="af";
//    	String startTime="2018-12-21 10:10:20";
//    	String endTime="2018-12-22 09:30:20";
//    	int pageIndex=1;
//    	int pageSize=200;
//    	JSONObject ss=new AllBetRemoteService().egameBetlogHistories(egameType,startTime,endTime, pageIndex, pageSize);
//    	System.out.println(ss);
	}

    
    public void remoteTest(String jsonParam) {
    	ResponseEntity<FontanaBetAgbm> res= restTemplate.getForEntity("http://127.0.0.1:10030/getById", FontanaBetAgbm.class);
    	logger.info(res.toString());
    }
}
