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
import com.ly.common.util.DateUtils;
import com.ly.common.util.FastJsonUtils;
import com.ly.game.mapper.FontanaBetLylotContentMapper;
import com.ly.game.mapper.FontanaBetLylotMapper;
import com.ly.game.mapper.FontanaFetchdateMapper;
import com.ly.game.mapper.FontanaUserMapper;
import com.ly.game.model.FontanaBetLylot;
import com.ly.game.model.FontanaBetLylotContent;
import com.ly.game.model.FontanaFetchdate;
import com.ly.game.model.FontanaUser;
import com.ly.service.business.LyLotService;
import com.ly.service.game.impl.BasecodeServiceImpl;
import com.ly.service.remote.LyLotBetRemoteService;

@Service
public class LyLotServiceImpl extends BasecodeServiceImpl implements LyLotService{
	private final static Logger logger =  LoggerFactory.getLogger(LyLotServiceImpl.class);
	public static long sleep = 30000L;
	@Autowired
	FontanaFetchdateMapper fetchMapper;

	@Autowired
	FontanaBetLylotMapper betMapper;

	@Autowired
	FontanaBetLylotContentMapper betContentMapper;
	
	@Autowired
	FontanaUserMapper userMapper;

	@Autowired
	LyLotBetRemoteService lylotService;
	
	private final static String LYLOT = "LYLOT";
	public int step = 1; //往后跳多少分钟
	
	@Override
	public void loadingRemoteGameData() {
		fetchLyLot(null,true);
	}
	public void fetchLyLot(Date date,boolean isUpdate) {
    	FontanaFetchdate record = fetchMapper.selectByPrimaryGametype(LYLOT);
		Date now = new Date();
		if(date==null) {
			if(record==null) {
				date = new Date();
				record=new FontanaFetchdate();
				record.setGametype(LYLOT);
				record.setEtchstarttime(date);
				fetchMapper.insert(record);
			} else {
				date = record.getEtchstarttime();
			}
		}
		if(now.getTime()-date.getTime()>10*60* 1000) {
			//延迟超过10分钟，加快抓票速度
			sleep = 1000L;
			step = 2;
		} else {
			//10分钟内的，回复正常的抓票速度
			if(sleep<30000L) {
				sleep = 30000L;
				step = 1;
			}
		}
		if(now.getTime() - date.getTime() > sleep) {
			boolean re = save(date);
			if(re&&isUpdate) {
				record.setEtchstarttime(dealDate(date, step));
				fetchMapper.updateByPrimaryKey(record);
			}
			
		} else {
			try {
				Thread.sleep(sleep);
			}catch(Throwable e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean save(Date date) {
		
		try {
			doSave(date,1);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("LYLOT get data response exception " + e.getMessage(), e);
			return false;
		} 
		return true;
	}
	
	
	private void doSave(Date date,int page) {
		List<FontanaBetLylot> addList = new ArrayList<FontanaBetLylot>();
		List<FontanaBetLylotContent> addListContent = new ArrayList<FontanaBetLylotContent>();
		String reqStr = null;
		//抓票往前抓20分钟
		reqStr = lylotService.getBetLogAll(DateUtils.addMinutes(date, -step-20), date, page);
		logger.info("Read LYLOT source:" + reqStr);
		
		if (StringUtils.isBlank(reqStr)) {
			logger.info("LYLOT get data response empty :"+reqStr);
			return ;
		}
		JSONObject jb = JSONObject.parseObject(reqStr);
		int totalSize = jb.getIntValue("Total");
		logger.info(String.format("doSaveLYLOT info:totalSize:%s,page:%s,date:",
				totalSize, page, DateUtils.date2String(date, DateUtils.PATTERN_DATE_TIME)));
		List<FontanaBetLylot> rlist = FastJsonUtils.json2List(jb.getString("Data"), FontanaBetLylot.class);
		if (!CollectionUtil.isEmpty(rlist)) {
			Set<String> setName = new HashSet<String>();
			for (FontanaBetLylot vg : rlist) {
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
			for(FontanaBetLylot kb : rlist) {
				FontanaUser user = null;
				String loginname = kb.getUsername();
				if(StringUtils.isBlank(loginname)) {
					continue;
				}
				user=mapUser.get(loginname);
				if(betMapper.exists(kb.getBetnum(),loginname,String.valueOf(kb.getStatus()),getBcvalue())>=1) {
					logger.info("LyLotBet repeat:"+kb.getBetnum()+" - " + loginname);
					continue;
				}
				if(user != null && user.getId() > 0) {
					double result = kb.getBettingbalance()+kb.getTotalkickback()-kb.getBetamount();
		            result = kb.getWinningstatus()==1?0:result;//处理平局情况
					if(kb.getStatus()==1) { //已结算的单才有有效投注额和输赢金额
						kb.setValidamount(kb.getBetamount());//有效投注额
						kb.setResult(result);//输赢金额 
		            } else {
		            	kb.setValidamount(0.0);//有效投注额
						kb.setResult(0.0);//输赢金额 
		            }
					if(kb.getSettletime()!=null) {
						kb.setGroupfor(DateUtils.addHours(kb.getSettletime(), -12)); 
					}
					kb.setUid(user.getId());
					kb.setCid(user.getCid());
					kb.setPid(user.getPid());
					kb.setGid(user.getGid());
					kb.setAid(user.getAid());
					kb.setSid(user.getSid());
					addList.add(kb);
					FontanaBetLylotContent content=new FontanaBetLylotContent();
					content.setBetnum(kb.getBetnum());
					content.setContent(kb.getContent());
					addListContent.add(content);
				}
			}
			if (CollectionUtil.isNotEmpty(addList)) {// 要添加到数据库的数据
				betMapper.insertReplaceRecordBatch(addList);
				betContentMapper.insertReplaceRecordBatch(addListContent);
			}
			if(totalSize>=page*100) {
				doSave(date, page+1);
			}
		}
	}

	private Date dealDate(Date lastDate ,int min) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(lastDate);
		calendar.add(Calendar.MINUTE, min);
		return calendar.getTime();
	}
}
