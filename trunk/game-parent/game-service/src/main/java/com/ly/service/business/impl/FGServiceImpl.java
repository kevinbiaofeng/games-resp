package com.ly.service.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ly.common.util.CollectionUtil;
import com.ly.common.util.DateUtils;
import com.ly.common.util.FastJsonUtils;
import com.ly.game.mapper.FontanaBetFgMapper;
import com.ly.game.mapper.FontanaBetFgdzMapper;
import com.ly.game.mapper.FontanaFetchdateMapper;
import com.ly.game.mapper.FontanaUserMapper;
import com.ly.game.model.FontanaBetFg;
import com.ly.game.model.FontanaBetFgdz;
import com.ly.game.model.FontanaFetchdate;
import com.ly.game.model.FontanaUser;
import com.ly.service.business.FGService;
import com.ly.service.game.impl.BasecodeServiceImpl;
import com.ly.service.remote.FGBetRemoteService;
import com.ly.service.remote.FGBetRemoteService.GameType;

@Service
public class FGServiceImpl extends BasecodeServiceImpl implements FGService{
	private final static Logger logger =  LoggerFactory.getLogger(FGServiceImpl.class);
	private static Map<String, String> map = new ConcurrentHashMap<String, String>();
	
	@Autowired
	FontanaFetchdateMapper fetchMapper;

	@Autowired
	FontanaBetFgMapper betMapper;
	@Autowired
	FontanaBetFgdzMapper betdzMapper;
	
	@Autowired
	FGBetRemoteService fgService;
	@Autowired
	FontanaUserMapper userMapper;
	
	private final static String FGfish = "FGfish";
    private final static String FGpoker = "FGpoker";
    private final static String FGslot = "FGslot";
    private final static String FGfruit = "FGfruit";
	
	@Override
	public void loadingRemoteGameData() {
		
		//开始抓票  四个游戏  分四次抓取
		fetchFG(null,true,FGfish);//捕鱼
		//电子
		fetchFGDZ(null,true,FGpoker);
		fetchFGDZ(null,true,FGslot);
		fetchFGDZ(null,true,FGfruit);
	}
	public void fetchFGDZ(String versionKey, boolean isUpdate,String FG) {
    	FontanaFetchdate record = fetchMapper.selectByPrimaryGametype(FG);
		if(versionKey==null) {
			if(record==null) {
				record=new FontanaFetchdate();
				record.setVersionkey(null);
				fetchMapper.insert(record);
			} else {
				versionKey = record.getVersionkey();
			}
		}
		GameType gameType=null; 
		if(FG.equals(FGpoker)) {
			gameType=FGBetRemoteService.GameType.poker;
		}else if(FG.equals(FGslot)) {
			gameType=FGBetRemoteService.GameType.slot;
		}else if(FG.equals(FGfruit)) {
			gameType=FGBetRemoteService.GameType.fruit;
		}
		String vk = saveFGDZ(versionKey,gameType);
		if(vk!=null && isUpdate&&!vk.equals(versionKey)) {
			record.setVersionkey(vk);
			fetchMapper.updateByPrimaryKeySelective(record);
		}
	}
	public void fetchFG(String versionKey, boolean isUpdate,String FG) {
		FontanaFetchdate record = fetchMapper.selectByPrimaryGametype(FG);
		if(versionKey==null) {
			if(record==null) {
				record=new FontanaFetchdate();
				record.setVersionkey(null);
				fetchMapper.insert(record);
			} else {
				versionKey = record.getVersionkey();
			}
		}
		GameType gameType=FGBetRemoteService.GameType.fish;
		String vk = saveFG(versionKey,gameType);
		if(vk!=null && isUpdate&&!vk.equals(versionKey)) {
			record.setVersionkey(vk);
			fetchMapper.updateByPrimaryKeySelective(record);
		}
	}
	
	
	private String saveFGDZ(String versionKey,GameType gameType) {
		List<FontanaBetFgdz> addList = new ArrayList<FontanaBetFgdz>();
		String resStr = null;
		String LastVersionKey = versionKey;
		try {
			resStr = fgService.getBetLog(gameType,versionKey);
			if(resStr==null) {
				logger.info("FG get data response null.");
				return versionKey;
			}
			logger.info("FG bet:" + resStr);
			System.out.println("FG bet:" + resStr);
			JSONObject obj=JSONObject.parseObject(resStr);
			JSONArray data = obj.getJSONArray("data");
			if(data==null || data.size()==0) {
				logger.info("FG get data response empty.");
				return versionKey;
			}
			JSONArray datanew=new JSONArray(); 
			for (Object object : data) {
				JSONObject infoObj=JSONObject.parseObject(JSONObject.toJSONString(object));
				infoObj.put("dtime", infoObj.get("time"));
				datanew.add(infoObj);
			}
			List<FontanaBetFgdz> rlist = FastJsonUtils.json2List(datanew.toJSONString(), FontanaBetFgdz.class);
			if (!CollectionUtil.isEmpty(rlist)) {
				Set<String> setName = new HashSet<String>();
				for (FontanaBetFgdz vg : rlist) {
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
				for(FontanaBetFgdz b : rlist) {
					String loginname = b.getUsername();
					b.setUsername(loginname);
					FontanaUser user = mapUser.get(loginname);
					//FG 使用VersionKey进行无差别查询，正常是不会出现重复插入的情况的,预防补票操作，还是判断下吧。。。
					if(betdzMapper.exists(b.getBetnum(),loginname,getBcvalue())>=1) {
						logger.info("FG repeat:"+b.getBetnum()+ " - " + loginname);
						continue;
					}
					if(user == null || user.getId() <= 0) {
						continue;
					}
					b.setBettime(new Date(b.getDtime()*1000L));
					b.setValidamount(b.getBetamount());
					b.setResult(b.getResult()+b.getJackpotbonus());
					b.setGroupfor(DateUtils.addHours(new Date(b.getDtime()*1000L), -12));
					b.setTime(new Date(b.getDtime()*1000L));
					b.setGresult(b.getResult());
					b.setUid(user.getId());
					b.setCid(user.getCid());
					b.setPid(user.getPid());
					b.setGid(user.getGid());
					b.setAid(user.getAid());
					b.setSid(user.getSid());
					b.setGamename(getGameName(b.getGameid()));
					addList.add(b);
				}
				if (CollectionUtil.isNotEmpty(addList)) {// 要添加到数据库的数据
					betdzMapper.insertReplaceRecordBatch(addList);
				}
				LastVersionKey=obj.get("page_key").toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("FGDZ get data response exception " + e.getMessage(), e);
		} 
		return LastVersionKey;
	}
	
	private String saveFG(String versionKey,FGBetRemoteService.GameType gameType) {
		List<FontanaBetFg> addList = new ArrayList<FontanaBetFg>();
		String retStr = null;
		String LastVersionKey = versionKey;
		try {
			retStr = fgService.getBetLog(gameType,versionKey);
			if(retStr==null ) {
				logger.info("FG get data response null.");
				return versionKey;
			}
			logger.info("FG bet:" + retStr);
			System.out.println("FG bet:" + retStr);
			JSONObject obj=JSONObject.parseObject(retStr);
			String data=obj.getString("data");
			if(data==null) {
				logger.info("FG get data response empty.");
				return versionKey;
			}
			List<FontanaBetFg> rlist = FastJsonUtils.json2List(data, FontanaBetFg.class);
			if (!CollectionUtil.isEmpty(rlist)) {
				Set<String> setName = new HashSet<String>();
				for (FontanaBetFg vg : rlist) {
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
				for(FontanaBetFg b : rlist) {
					String loginname = b.getUsername();
					b.setUsername(loginname);
					FontanaUser user = mapUser.get(loginname);
					//FG 使用VersionKey进行无差别查询，正常是不会出现重复插入的情况的,预防补票操作，还是判断下吧。。。
					if(betMapper.exists(b.getBetnum(),loginname,getBcvalue())>=1) {
						logger.info("FG repeat:"+b.getBetnum()+ " - " + loginname);
						continue;
					}
					if(user == null || user.getId() <= 0) {
						continue;
					}
					b.setBettime(new Date(b.getsTime()*1000L));
					b.setValidamount(b.getBetamount());
					b.setResult(b.getFishdeadchips()+b.getTranships()-b.getBetamount());
					b.setGroupfor(DateUtils.addHours(new Date(b.geteTime()*1000L), -12));
					b.setStarttime(new Date(b.getsTime()*1000L));
					b.setEndtime(new Date(b.geteTime()*1000L));
					if(b.getBtime()!=null) {
						b.setBuytime(new Date(b.getBtime()*1000L));
					}
					b.setUid(user.getId());
					b.setCid(user.getCid());
					b.setPid(user.getPid());
					b.setGid(user.getGid());
					b.setAid(user.getAid());
					b.setSid(user.getSid());
					b.setSource(user.getSource());
					b.setGamename(getGameName(b.getGameid()));
					addList.add(b);
				}
				if (CollectionUtil.isNotEmpty(addList)) {// 要添加到数据库的数据
					betMapper.insertReplaceRecordBatch(addList);
				}
				LastVersionKey=obj.get("page_key").toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("FG get data response exception " + e.getMessage(), e);
		} 
		return LastVersionKey;
	}
	private String getGameName(int gameId) {
		if(map.size()==0) {
			String res = fgService.getGameList();
			JSONObject objres=JSONObject.parseObject(res);
			JSONArray array = objres.getJSONArray("data");
			for(int i=0 ; i<array.size(); i++) {
				 JSONObject obj = array.getJSONObject(i);
				 map.put(obj.getString("service_id"), obj.getString("name"));
			}
		}
		return map.get(gameId+"");
	}
}
