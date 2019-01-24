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
import com.ly.common.gameutil.im.KagaBonusPick;
import com.ly.common.util.CollectionUtil;
import com.ly.common.util.DateTimeUtil;
import com.ly.common.util.FastJsonUtils;
import com.ly.game.mapper.FontanaBetKagaMapper;
import com.ly.game.mapper.FontanaFetchdateMapper;
import com.ly.game.mapper.FontanaUserMapper;
import com.ly.game.model.FontanaBetKaga;
import com.ly.game.model.FontanaFetchdate;
import com.ly.game.model.FontanaUser;
import com.ly.service.business.KAGAService;
import com.ly.service.game.impl.BasecodeServiceImpl;
import com.ly.service.remote.KAGABetRemoteService;

@Service
public class KAGAServiceImpl extends BasecodeServiceImpl implements KAGAService{
	private final static Logger logger =  LoggerFactory.getLogger(KAGAServiceImpl.class);
	@Autowired
	FontanaFetchdateMapper fetchMapper;

	@Autowired
	FontanaBetKagaMapper betMapper;
	
	@Autowired
	FontanaUserMapper userMapper;

	@Autowired
	KAGABetRemoteService kagaService;
	
	private final static String KAGA = "KAGA";
	private volatile int repeatTimes = 0;
	
	@Override
	public void loadingRemoteGameData() {
		// TODO 抓票并插入数据库
		fetchKAGA(null,true);
	}
	public void fetchKAGA(Date date,boolean isUpdate) {
		FontanaFetchdate record=fetchMapper.selectByPrimaryGametype(KAGA);
		Date now = new Date();
		if(date==null) {
			if(record==null) {
				date=new Date();
				record=new FontanaFetchdate();
				record.setEtchstarttime(date);
				record.setGametype(KAGA);
				fetchMapper.insert(record);
			} else {
				date = record.getEtchstarttime();
			}
		}
		if(now.getTime() - date.getTime() > 60 * 1000) {
			saveKaga(date,isUpdate);
			if(isUpdate) {
				record.setEtchstarttime(dealDate(date, 1));
				fetchMapper.updateByPrimaryKeySelective(record);
			}
				
		}
	}
	private boolean saveKaga(Date date,boolean isUpdate) {
		List<FontanaBetKaga> addList = new ArrayList<FontanaBetKaga>();
		String reStr = null;
		try {
			//kaga的报表时间是utc0 时区，所以要把时间减8个小时
			reStr = kagaService.betReport(dealDate(date,-3-60*8),dealDate(date,1-60*8));
			
			if(reStr==null) {
				logger.info("Kaga get data response null.");
				if(repeatTimes<=5) {
					repeatTimes ++;
					return false;
				}
				
			}
			logger.info("Read Kaga source:" + reStr);
			JSONObject jb = JSONObject.parseObject(reStr);
			if(jb==null||jb.getIntValue("statusCode")!=0||jb.get("spinReport")==null) {
				logger.info("Kaga get data response empty:"+jb);
				return true;
			}
			List<FontanaBetKaga> rlist = FastJsonUtils.json2List(jb.getString("spinReport"), FontanaBetKaga.class);
			//小游戏派彩处理
			List<KagaBonusPick> kbplist = null;
			if(jb.get("bonusPickReport") !=null){
				logger.info("Kaga bonusPickReport:" + jb.get("bonusPickReport"));
				kbplist = FastJsonUtils.json2List(jb.getString("bonusPickReport"), KagaBonusPick.class);
			}
			if (!CollectionUtil.isEmpty(rlist)) {
				Set<String> setName=new HashSet<>();
				for (FontanaBetKaga vg : rlist) {
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
				for(FontanaBetKaga kb : rlist) {
					FontanaUser user = null;
					String loginname = kb.getUsername();
					logger.info("FightAllFetch_record userName:" + loginname);
					if (StringUtils.isNotBlank(loginname)) {
						user = mapUser.get(loginname.toUpperCase());
					}
					
					if(betMapper.exists(kb.getBetnum(),String.valueOf(kb.getRound()),loginname,getBcvalue())>0) {
						logger.info("Kaga repeat:"+kb.getBetnum()+" - "+kb.getRound() + " - " + loginname);
						continue;
					}
					
					if(user != null && user.getId() > 0) {
						//处理小游戏派彩的金额
						if(kbplist != null){
							for(KagaBonusPick kbp : kbplist){
								if(kb.getBetnum().equalsIgnoreCase(kbp.getTransactionId())){
									kb.setCashwon(kb.getCashwon() + kbp.getCashWon());
									kb.setSmallgamepayout(Double.valueOf(kbp.getCashWon()));//小游戏派彩
									logger.info("Kaga bonusPickReport TransactionId:" + kbp.getTransactionId());
								}
							}
						}
						kb.setBettime(DateTimeUtil.formatDateTime(kb.getBettime(),"yyyy-MM-dd HH:mm:ss", 0, 0, 8));
						kb.setBetamount("true".equals(kb.getFreespin())?0:kb.getCashplayed()/100.0D);
						kb.setValidamount("true".equals(kb.getFreespin())?0:kb.getCashplayed()/100.0D);
						kb.setResult("true".equals(kb.getFreespin())?kb.getCashwon()/100.0D:(kb.getCashwon()-kb.getCreditsplayed())/100.0D);
						kb.setGroupfor(DateTimeUtil.formatDateTime(kb.getBettime(),"yyyy-MM-dd", 0, 0, -4));		 
						kb.setSmallgamepayout(kb.getSmallgamepayout()!=null?kb.getSmallgamepayout()/ 100.0D:null);
						kb.setUid(user.getId());
						kb.setCid(user.getCid());
						kb.setPid(user.getPid());
						kb.setGid(user.getGid());
						kb.setAid(user.getAid());
						kb.setSid(user.getSid());
						addList.add(kb);
					}
				}
				if (addList!=null && addList.size()>0) {// 要添加到数据库的数据
					betMapper.insertReplaceRecordBatch(addList);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("KAGA get data response exception " + e.getMessage(), e);
		} 
		return true;
	}
	private Date dealDate(Date lastDate ,int min) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(lastDate);
		calendar.add(Calendar.MINUTE, min);
		return calendar.getTime();
	}

}
