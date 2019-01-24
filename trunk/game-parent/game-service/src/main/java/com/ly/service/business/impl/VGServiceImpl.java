package com.ly.service.business.impl;

import java.util.ArrayList;
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
import com.ly.common.util.DateUtils;
import com.ly.common.util.FastJsonUtils;
import com.ly.game.mapper.FontanaBetVggameMapper;
import com.ly.game.mapper.FontanaFetchdateMapper;
import com.ly.game.mapper.FontanaUserMapper;
import com.ly.game.model.FontanaBetVggame;
import com.ly.game.model.FontanaFetchdate;
import com.ly.game.model.FontanaUser;
import com.ly.service.business.VGService;
import com.ly.service.game.impl.BasecodeServiceImpl;
import com.ly.service.remote.VGBetRemoteService;

@Service
public class VGServiceImpl extends BasecodeServiceImpl implements VGService{
	private final static Logger logger =  LoggerFactory.getLogger(VGServiceImpl.class);
	@Autowired
	FontanaFetchdateMapper fetchMapper;

	@Autowired
	FontanaBetVggameMapper betMapper;
	
	@Autowired
	FontanaUserMapper userMapper;

	@Autowired
	VGBetRemoteService vgService;
	
	private final String gametype="VG";
	
	@Override
	public void loadingRemoteGameData() {
		// TODO 抓票并插入数据库
		fetchVG(null,true);
	}
	public void fetchVG(Integer versionKey,boolean isUpdate) {
		FontanaFetchdate record=fetchMapper.selectByPrimaryGametype(gametype);
		if(versionKey==null) {
			if(record==null) {
				record=new FontanaFetchdate();
				record.setVersionkey(versionKey+"");
				record.setGametype(gametype);
				fetchMapper.insert(record);
			} else {
				versionKey = Integer.parseInt(record.getVersionkey());
			}
		}
		Integer vk = saveVG(versionKey);
		if(!vk.equals(versionKey) && isUpdate) {
			record.setVersionkey(vk+"");
			fetchMapper.updateByPrimaryKeySelective(record);
		}
	}
	
	private Integer saveVG(Integer versionKey) {
		List<FontanaBetVggame> list=fetchFightAll_record(versionKey);
		List<FontanaBetVggame> insertList = new ArrayList<FontanaBetVggame>();
		Set<String> setName=new HashSet<>();
		Integer rvk=0;
		for (FontanaBetVggame vg : list) {
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
		for (FontanaBetVggame vg : list) {
			rvk = Integer.parseInt(vg.getBetnum());
			FontanaUser user = null;
			String loginName = vg.getUsername();// 如果用户不存在的话，不入库
			logger.info("FightAllFetch_record userName:" + loginName);
			if (StringUtils.isNotBlank(loginName)) {
				user = mapUser.get(loginName.toUpperCase());
			}
			if (user == null) {// 不存在该用户则不插入
				logger.info("FightAllFetch getUserByLoginname  NO has user :" + loginName);
				continue;
			}
			if (user.getId() == 0) {
				logger.info("FightAllFetch getUserByLoginname user[" + loginName + "] id is 0.");
				continue;
			}

			if (betMapper.exists(vg.getBetnum(),getBcvalue())>=1) {
				logger.info(String.format("FightAllFetch repeat bet:%s,%s", vg.getBetnum(), vg.getUsername()));
				continue;
			}
			logger.info("update FightAllFetch into database" + loginName);
			vg.setUid(user.getId());
			vg.setCid(user.getCid());
			vg.setPid(user.getPid());
			vg.setGid(user.getGid());
			vg.setAid(user.getAid());
			vg.setSid(user.getSid());
			vg.setBettime(vg.getCreatetime());//将创建时间赋值到bettime
			vg.setGroupfor(DateUtils.getGroupforDate(vg.getCreatetime()));
			insertList.add(vg);
		}
		if(insertList.size()>0) {
			betMapper.insertReplaceRecordBatch(insertList);
		}
		return rvk;
	}
	
	private List<FontanaBetVggame> fetchFightAll_record(Integer versionKey) {
		JSONObject jo = null;
		try {
			String result = vgService.getFightAllRecord(versionKey);
			jo = JSONObject.parseObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (jo == null) {
			return new ArrayList<FontanaBetVggame>(0);
		}
		String vs = jo.getString("value");
		List<FontanaBetVggame> nnf=FastJsonUtils.json2List(vs, FontanaBetVggame.class);
		return nnf;
	}

}
