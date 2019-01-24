package com.ly.service.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ly.common.util.CollectionUtil;
import com.ly.common.util.DateTimeUtil;
import com.ly.common.util.DateUtils;
import com.ly.common.util.FastJsonUtils;
import com.ly.game.mapper.FontanaBetCq9Mapper;
import com.ly.game.mapper.FontanaFetchdateMapper;
import com.ly.game.mapper.FontanaUserMapper;
import com.ly.game.model.FontanaBetCq9;
import com.ly.game.model.FontanaFetchdate;
import com.ly.game.model.FontanaUser;
import com.ly.service.business.CQ9Service;
import com.ly.service.game.impl.BasecodeServiceImpl;
import com.ly.service.remote.CQ9BetRemoteService;

@Service
public class CQ9ServiceImpl extends BasecodeServiceImpl implements CQ9Service{
	private final static Logger logger =  LoggerFactory.getLogger(CQ9ServiceImpl.class);
	
	private Map<String, String> gamenameMap = null;
	
	@Autowired
	FontanaFetchdateMapper fetchMapper;

	@Autowired
	FontanaBetCq9Mapper betMapper;
	
	@Autowired
	FontanaUserMapper userMapper;

	@Autowired
	CQ9BetRemoteService cq9Service;
	
	private final String gametype="CQ9";
	
	@Override
	public void loadingRemoteGameData() {
		fetchCQ9(null,true);
	}
	public void fetchCQ9(Date date,boolean isUpdate) {
    	FontanaFetchdate record = fetchMapper.selectByPrimaryGametype(gametype);
		Date now = new Date();
		if(date==null) {
			if(record==null) {
				date = new Date();
				record=new FontanaFetchdate();
				record.setGametype(gametype);
				record.setEtchstarttime(date);
				fetchMapper.insert(record);
			} else {
				date = record.getEtchstarttime();
			}
		}
		if(now.getTime() - date.getTime() > 10 * 1000) {
			saveCQ9(date);
			if(isUpdate) {
				record.setEtchstarttime(dealDate(date, 1));
				fetchMapper.updateByPrimaryKeySelective(record);
			}
		}
	}
	private boolean saveCQ9(Date date) {
		try {
			doSaveCq9(date,1);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("CQ9 get data response exception " + e.getMessage(), e);
			return false;
		} 
		return true;
	}
	private void doSaveCq9(Date date,int page) {
		List<FontanaBetCq9> addList = new ArrayList<FontanaBetCq9>();
		//抓票往前抓3分钟
		String resJson = cq9Service.betList(DateUtils.addMinutes(date, -3), date, page);
		logger.info("Read CQ9 source:" + resJson);
		if (StringUtils.isBlank(resJson)) {
			logger.info("CQ9 get data response empty :"+resJson);
			return ;
		}
		JSONObject jb = JSONObject.parseObject(resJson);
		if (StringUtils.isBlank(jb.getString("data"))) {
			logger.info("CQ9 get data response empty :"+jb.getString("data"));
			return ;
		}
		
		int totalSize = jb.getIntValue("TotalSize");
		
//		List<FontanaBetCq9> rlist = gson.fromJson(jb.getString("Data"), new com.google.gson.reflect.TypeToken<List<CQ9Bet>>(){}.getType());
		List<FontanaBetCq9> rlist=FastJsonUtils.json2List(jb.getJSONObject("data").getString("Data"), FontanaBetCq9.class);
		Set<String> setName=new HashSet<>();
		for (FontanaBetCq9 cq9 : rlist) {
			String loginName = cq9.getUsername();// 如果用户不存在的话，不入库
			logger.info("FightAllFetch_record userName:" + loginName);
			if (!"".equals(loginName)) {
				try {
					setName.add(loginName);
				} catch (Throwable e) {
					e.printStackTrace();
					logger.error("FightAllFetch get User By Name Error!" + e.getMessage());
				}
			}
		}
		List<String> listname=new ArrayList<>(setName);
		List<FontanaUser> listUser=userMapper.selectListByLoginNames(listname);
		Map<String, FontanaUser> mapUser=new HashMap<>();
		for (FontanaUser user : listUser) {
			mapUser.put(user.getLoginname(), user);
		}
		if (!CollectionUtil.isEmpty(rlist)) {
			for(FontanaBetCq9 kb : rlist) {
				FontanaUser user = null;
				String loginname = kb.getUsername();
				try {
					user = mapUser.get(loginname.toUpperCase());
				} catch (Throwable e) {
					logger.error("CQ9 get user by name: " + loginname + " error: " + e.getMessage(), e);
					continue;
				}
				if(betMapper.exists(kb.getBetnum(), loginname,getBcvalue())>=1) {
					logger.info("CQ9 repeat:"+kb.getBetnum()+" - " + loginname);
					continue;
				}
				String groupfor=DateTimeUtil.formatDateTime(kb.getCreatetime(),FORMAT_MAP.get(kb.getCreatetime().length()),"yyyy-MM-dd", 0, 0, 0);
				kb.setGroupfor(groupfor);
				String betTime=DateTimeUtil.formatDateTime(kb.getBettime(),FORMAT_MAP.get(kb.getBettime().length()),"yyyy-MM-dd HH:mm:ss", 0, 0, 12);
				kb.setBettime(betTime);
				kb.setCreatetime(DateTimeUtil.formatDateTime(kb.getCreatetime()
	            		,FORMAT_MAP.get(kb.getCreatetime().length()),"yyyy-MM-dd HH:mm:ss", 0, 0, 12));
	            if(kb.getEndroundtime()!=null) {
	            	kb.setEndroundtime(DateTimeUtil.formatDateTime(kb.getEndroundtime()
	            		,FORMAT_MAP.get(kb.getEndroundtime().length()),"yyyy-MM-dd HH:mm:ss", 0, 0, 12));
	            }
				if(gamenameMap==null) {
					gamenameMap = getGameMap();
				}
				kb.setResult(kb.getWin().subtract(kb.getBetamount()));
				kb.setValidamount(kb.getBetamount());
				kb.setGamename(gamenameMap.get(kb.getGamecode()));
				if(kb.getDetail()!=null&&kb.getDetail().size()>0) {
					for(Map<String, Integer> m : kb.getDetail()) {
						if(m.containsKey("freegame")) {
							kb.setFreegame(m.get("freegame"));
						} else if(m.containsKey("luckydraw")) {
							kb.setLuckydraw(m.get("luckydraw"));
						} else if(m.containsKey("bonus")) {
							kb.setBonus(m.get("bonus"));
						}
					}
				}
				
				if(user != null && user.getId() > 0) {
					kb.setUid(user.getId());
					kb.setCid(user.getCid());
					kb.setPid(user.getPid());
					kb.setGid(user.getGid());
					kb.setAid(user.getAid());
					kb.setSid(user.getSid());
					addList.add(kb);
				}
			}
			if (CollectionUtil.isNotEmpty(addList)) {// 要添加到数据库的数据
				betMapper.insertReplaceRecordBatch(addList);
			}
			if(totalSize>=page*CQ9BetRemoteService.pageSize) {
				doSaveCq9(date, page+1);
			}
		}
	}
	
	private Map<String, String> getGameMap () {
		String json = cq9Service.gameList();
		JSONArray jar = JSONArray.parseArray(JSONObject.parseObject(json).getString("data"));
		Map<String, String> map = new HashMap<String, String>();
		for(int i = 0; i<jar.size(); i++) {
			JSONObject job = jar.getJSONObject(i);
			String gamecode = job.getString("gamecode");
			JSONArray nameArr = job.getJSONArray("nameset");
			String gamename = "";
			for(int j=0; j<nameArr.size(); j++) {
				JSONObject namejob = nameArr.getJSONObject(j);
				if("zh-cn".equalsIgnoreCase(namejob.getString("lang"))) {
					gamename = namejob.getString("name");
					break;
				}
			}
			map.put(gamecode, gamename);
		}
		return map;
	}
	private static final Map<Integer,String> FORMAT_MAP = new ConcurrentHashMap<Integer, String>();
    
    static {
    	String format1 = "yyyy-MM-dd'T'HH:mm:ss-04:00";
    	String format2 = "yyyy-MM-dd'T'HH:mm:ss.S-04:00";
    	String format3 = "yyyy-MM-dd'T'HH:mm:ss.SS-04:00";
    	String format4 = "yyyy-MM-dd'T'HH:mm:ss.SSS-04:00";
    	FORMAT_MAP.put(format1.length()-2, format1);
    	FORMAT_MAP.put(format2.length()-2, format2);
    	FORMAT_MAP.put(format3.length()-2, format3);
    	FORMAT_MAP.put(format4.length()-2, format4);
    }
	private Date dealDate(Date lastDate ,int min) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(lastDate);
		calendar.add(Calendar.MINUTE, min);
		return calendar.getTime();
	}
}
