package com.ly.service.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ly.common.util.CollectionUtil;
import com.ly.common.util.DateTimeUtil;
import com.ly.common.util.DateUtils;
import com.ly.common.util.FastJsonUtils;
import com.ly.game.mapper.FontanaBetAllbetMapper;
import com.ly.game.mapper.FontanaFetchdateMapper;
import com.ly.game.mapper.FontanaUserMapper;
import com.ly.game.model.FontanaBetAllbet;
import com.ly.game.model.FontanaFetchdate;
import com.ly.game.model.FontanaUser;
import com.ly.service.business.AllBetService;
import com.ly.service.constant.AllBetConstant;
import com.ly.service.game.impl.BasecodeServiceImpl;
import com.ly.service.remote.AllBetRemoteService;

@Service
public class AllBetServiceImpl extends BasecodeServiceImpl implements AllBetService{
	private final static Logger logger =  LoggerFactory.getLogger(AllBetServiceImpl.class);
	
	@Autowired
	FontanaFetchdateMapper fetchMapper;

	@Autowired
	FontanaBetAllbetMapper betMapper;
	
	@Autowired
	FontanaUserMapper userMapper;

	@Autowired
	AllBetRemoteService allService;
	
	private final static String GAMETYPE = "AllBetEgame";
//	public long sleep =180000L;// 3分钟请求一次
	
	@Override
	public void loadingRemoteGameData() {
		fetchAllBet(null,true);
	}
	public void fetchAllBet(Date date,boolean isUpdate) {
    	FontanaFetchdate record = fetchMapper.selectByPrimaryGametype(GAMETYPE);
    	try {
			Date starttime = null;// 本次抓票开始时间
			Date endtime = null;// 本次抓票结束时间
			if (record!=null && record.getEtchstarttime() != null) {
				Date startDate = record.getEtchstarttime();
				Calendar calendar = Calendar.getInstance();
				//欧博的接口有调用限制，不要加快抓票速度,改为每次多往后抓15分钟
				if (System.currentTimeMillis() - startDate.getTime() > 180000L) {// 当前时间距离上次抓票时间超过2分5秒，需要加快一些
					calendar.setTime(startDate);
					calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - 15);
					starttime = calendar.getTime();
					calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 40);
					endtime = calendar.getTime();
				} else {
					endtime = calendar.getTime();
					calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - 15);
					starttime = calendar.getTime();
				}
				//gameDao.updateLastFetchTime(GAMETYPE, DateTimeUtil.getFormatDate(endtime, TIME_FORMAT));
			} else {// 新的开始
				Calendar calendar = Calendar.getInstance();
				endtime = calendar.getTime();
				calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - 15);
				starttime = calendar.getTime();
				//gameDao.insertLastFetchTime(GAMETYPE, DateTimeUtil.getFormatDate(endtime, TIME_FORMAT));
			}
			JSONObject jsonObj = allService.egameBetlogHistories("af", starttime, endtime, 1, 1000);
			if (jsonObj == null || !"OK".equals(jsonObj.getString("error_code"))
					|| StringUtils.isBlank(jsonObj.getString("page"))) {
				logger.info("AllBetEgameFetch get data response error.:" +String.valueOf(jsonObj));
				if("1".equals(jsonObj.getString("error_code"))&&"SYSTEM_MATAINING:SYSTEM_MATAINING".equals(jsonObj.getString("message"))) {
					//系统维护状态，时间不要停
					record.setEtchstarttime(endtime);
					fetchMapper.updateByPrimaryKeySelective(record);
				}
				return;
			}
		 //String  json="{\"error_code\":\"OK\",\"message\":\"ok\",\"page\":{\"count\":2,\"datas\":[{\"betAmount\":190.6,\"betTime\":\"2017-09-29 18:47:36\",\"client\":\"CESHI0418\",\"egameType\":\"af\",\"gameType\":1100,\"gameround\":\"4105\",\"jackpotBetAmount\":0.4,\"jackpotValidAmount\":0,\"jackpotWinOrLoss\":-0.4,\"validAmount\":190.6,\"winOrLoss\":-55.55},{\"betAmount\":10,\"betTime\":\"2017-09-29 18:44:10\",\"client\":\"AAA12356\",\"egameType\":\"af\",\"gameType\":1100,\"gameround\":\"4104\",\"jackpotBetAmount\":0,\"jackpotValidAmount\":0,\"jackpotWinOrLoss\":0,\"validAmount\":10,\"winOrLoss\":10}]}}";
			List<FontanaBetAllbet> list=new ArrayList<>();
			try {
				String json=jsonObj.getJSONObject("page").getString("datas");
				list = FastJsonUtils.json2List(json, FontanaBetAllbet.class);
				logger.info("AllBetEgameFetch result:"+json);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (CollectionUtil.isEmpty(list)) {
				logger.info("AllBetEgameFetch histories is empty.");
				record.setEtchstarttime(endtime);
				fetchMapper.updateByPrimaryKeySelective(record);
				return;
			}
			List<FontanaBetAllbet> addList = new ArrayList<FontanaBetAllbet>();
			Set<String> setName = new HashSet<String>();
			for (FontanaBetAllbet vg : list) {
				String loginName = vg.getUsername();
				logger.info("FightAllFetch_record userName:" + loginName);
				if (!"".equals(loginName)) {
					setName.add(loginName);
				}
			}
			List<String> listname=new ArrayList<>(setName);
			List<FontanaUser> listUser=userMapper.selectListByLoginNames(listname);
			Map<String, FontanaUser> mapUser=new HashMap<>();
			for (FontanaUser user : listUser) {
				mapUser.put(user.getLoginname(), user);
			}
			for (FontanaBetAllbet allBetRecord : list) {
				String loginname = allBetRecord.getUsername();
				FontanaUser user = mapUser.get(loginname.toUpperCase());
				try {
					if (user == null) {
						logger.info("AllBetEgameFetch [" + loginname + "] is not exit.");
						continue;
					}
					if(user.getId() == 0){
						logger.info("AllBetEgameFetch [" + loginname + "] id is 0.");
						continue;
					}
					Long betnum = allBetRecord.getBetnum();// 注单编号，全局唯一
					if (betMapper.exists(String.valueOf(betnum), loginname,getBcvalue())>=1) {
						logger.info("AllBetEgameFetch [" + loginname + "] betnum [" + betnum + "] already in database.");
						continue;// 已存在数据库中，不再新增
					}
					Integer gameBigType = AllBetConstant.getGameBigType(allBetRecord.getGametype());
		            if(gameBigType == null){//没有对应的游戏大类
		               gameBigType = -1;//先赋值-1，后期根据gametype修补回来
		            }
		            allBetRecord.setGameroundid(betnum);
		            allBetRecord.setGamebigtype(gameBigType);
		            allBetRecord.setGameplatformchild("ABEG");
		            allBetRecord.setExchangerate(0D);
		            allBetRecord.setCurrency("");
		            allBetRecord.setCtime(DateUtils.parse(DateTimeUtil.formatDateTime(DateUtils.format(allBetRecord.getBettime()), "yyyy-MM-dd", 0, 0, -12)));
					allBetRecord.setUid(user.getId());
					allBetRecord.setParentid(user.getParentid());
					allBetRecord.setCid(user.getCid());
					addList.add(allBetRecord);
				} catch (Throwable e) {
					logger.error("AllBetEgameFetch get user by name: " + loginname + " error: " + e.getMessage(), e);
				}
			}
			// 插入数据到数据库中
			betMapper.insertReplaceRecordBatch(addList);
			
			record.setEtchstarttime(endtime);
			fetchMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			logger.error("AllBetEgameFetch run() " + e.getMessage(), e);
		}
	}
}
