package com.ly.service.remote;

import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ly.service.remote.mv.ApiMW;

@Service
public class MWBetRemoteService extends BaseBetRemoteService{
	
	public static String backstageUrl = "";// 测试环境，URL连接
	// 语言
	public static final String LANGUAGE_CN = "cn";// 中文
	// 货币代码
	public static final String CURRENCY_CODE_CNY = "CNY";// 人民币

	
	public static JSONObject getBetLog(int page, String startDate, String endDate) throws Exception {
		return getBetLog(page, startDate, endDate, 2, 0);
	}
	/**
	 * 获取玩家下注日志
	 * 
	 * @author 阿布
	 * @param page
	 *            (必须)页数
	 * @param startDate
	 *            (必须)开始日期时间(• 时间格式：yyyy-MM-dd HH:mm:ss )
	 * @param endDate
	 *            (必须)结束日期时间(• 时间格式：yyyy-MM-dd HH:mm:ss )
	 * @param getType
	 *            0 不返回货币单位 1 游戏信息数据单位为MW币 2 游戏信息数据单位为用户注册货币
	 * @param iGetLogInfoType
	 *            0 为不返回，1 为返回转帐及流水纪 录，默认不返回
	 * @return Response
	 */
	public static JSONObject getBetLog(int page, String startDate, String endDate, int getType, int iGetLogInfoType) throws Exception {
		String logPrefix = String.format("MWUtil.getBetLog:[page:%s,startDate:%s,endDate:%s]", page, startDate, endDate);
		String domain = ApiMW.getInstance().domain();
		TreeMap<String, Object> data = new TreeMap<String, Object>();
		// beginTime endTime getType iGetLogInfoType page
		data.put("beginTime", startDate);
		data.put("endTime", endDate);
		data.put("getType", getType);
		data.put("iGetLogInfoType", iGetLogInfoType);
		data.put("page", page);
		JSONObject json = ApiMW.getInstance().siteUsergamelog(domain, data);
		return json;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(getBetLog(1, "2019-01-8 10:10:00", "2019-01-8 10:15:00", 1, 0));
	}
	 
}
