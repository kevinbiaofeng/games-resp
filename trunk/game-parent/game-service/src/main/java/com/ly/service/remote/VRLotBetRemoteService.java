package com.ly.service.remote;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSONObject;
import com.ly.common.util.AesEncrypt;
import com.ly.common.util.HttpClientsUtil;

public class VRLotBetRemoteService {
	@Value("${ly.games.vrlot.vr_apihost}")
	private String vr_apihost;// "http://fe.vrbetdemo.com";//api域名
	@Value("${ly.games.vrlot.vr_secretkey}")
	private String vr_secretkey;//加解密密钥
	@Value("${ly.games.vrlot.vr_uid}")
	private String vr_uid;//商户名称
	@Value("${ly.games.vrlot.vr_version}")
	private String vr_version;//版本号
	private static  boolean vr_logctrl = true;
	private static final String MEMBERBET = "/MerchantQuery/Bet";//捞取注单
	private static final String DONATE_RECORD_URL = "/MerchantQuery/Donate";//打赏记录URL
	public static final int DEPOSIT = 0;//存款
	public static final int DEBIT = 1;//取款
	
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	
	/***
	 * 获取VR投注记录
	 * @param start 开始时间
	 * @param end 结束时间
	 * @param pageindex 页码
	 * @param pagesize 每页数量
	 * @param isupdate 是否用updatetime对比，用于同步线程
	 * @return
	 */
	public String getLotteryBet(Date start,Date end,int pageindex,int pagesize,boolean isupdate){
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		//参数封包
		JSONObject obj = new JSONObject();
		String starttime = df.format(start);
		String endtime = df.format(end);
		obj.put("startTime", starttime);
		obj.put("endTime", endtime);
		obj.put("channelId", -1);
		obj.put("state", -1);
		obj.put("recordPage", pageindex -1);//查询的页数(从 0 开始)
		obj.put("recordCountPerPage", pagesize);
		obj.put("isUpdateTime", isupdate);
		
		String json = obj.toString();
		String data = AesEncrypt.encrypt(vr_secretkey, json);
		String url = getPostUrl(MEMBERBET,data);
		if(vr_logctrl)
			System.out.println("THIS FETCH:" + url);
		String logPrefix = "LotteryUtil.getLotteryBet starttime["+starttime+"] endtime["+endtime+"]";
		String res = doPost(url, logPrefix);
		return res;
	}
	
	/***
	 * 获取打赏记录
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public String getDonateRecord(Date startTime, Date endTime, int page, int pageSize){
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		String start = df.format(startTime);
		String end = df.format(endTime);
	    int channelId = -1;//-1表示全部
	    JSONObject param = new JSONObject();
	    param.put("startTime", start);//查询的起始时间，使用 UTC(+0)的时间表示法，格式:"yyyy-MM-ddTHH:mm:ssZ"。
	    param.put("endTime", end);//查询的结束时间，使用 UTC(+0)的时间表示法，格式:"yyyy-MM-ddTHH:mm:ssZ"。
	    param.put("channelId", channelId);//频道 ID(-1 表示全部)
	    param.put("playerName", "");//
	    param.put("serialNumber", "");//
	    param.put("recordPage", page - 1);//查询的页数(从 0 开始)
	    param.put("recordCountPerPage", pageSize);//查询的数量
        String url = getPostUrl(DONATE_RECORD_URL, AesEncrypt.encrypt(vr_secretkey, param.toString()));
        String logPrefix = "LotteryUtil.getDonateRecord startTime["+startTime+"] endTime["+endTime+"] downLoadFile["+page+"] recordCountPerPage["+pageSize+"] ";
        String res = doPost(url, logPrefix);
        return res;

	}
	/**
	 * 请求VR_API
	 * @param url 请求地址
	 * @param type POST 或 GET
	 * @return 
	 */
	public String doPost(String url, String logPrefix){
		return HttpClientsUtil.execute(url, HttpClientsUtil.REQUESTTYPE_POST, logPrefix);
	}
	/**
	 * 获取请求的URL
	 * @param type 类型
	 * @param data 加密数据,需要urlcode后再送
	 * @return
	 */
	public String getPostUrl(String type,String data){
		try{
			return vr_apihost + type + "?version=" + vr_version + "&id=" + vr_uid + "&data=" + URLEncoder.encode(data, "utf-8");
		}catch(Throwable e){
			e.printStackTrace();
			return "";
		}
	}
	public static void main(String[] args) throws ParseException {
		//getLotteryBet(new Date(), new Date(), 1, 100);
//		System.out.println(AesEncrypt.decrypt(vr_secretkey, "L%2F%2FEITKQCTGA3dJszkB%2BZEtnBtAMSk1KS2qOAj%2Fa7owHR9VEq1OIxxGtu0aSQw4ZQq%2FCNkU4XBfH8vmJ2hw4DhBwve3Vu%2BMGN00zQRyvybuCyuLIxOvqV2OiKWxaNT1n%2BknJUUh4FnZ4pE41%2F0T0W2KqXNig0OA1hmTfeUpOTY5BByCMbo%2BHOSRsUJ5L9ZeT5ENx1tNoeUYpBKn12%2FUuWA%3D%3D"));
//		System.out.println();
//		System.out.println(doBalance("lll001").getResult());
//		doDeposit(0, "lll001", "H4B61MN5JJJ485G2B57", 20.0);
//		System.out.println(loginLottery("lll001", 1940));
//		doDeposit(0, "lll001", "G4B61MN5JJJ485G2B67", 20.0);
//		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date start = df1.parse("2017-09-05 18:12:00");
//		Date end = df1.parse("2017-09-05 18:13:00");
//		System.out.println(getLotteryBet(start, end, 1, 100,true));
	}
}
