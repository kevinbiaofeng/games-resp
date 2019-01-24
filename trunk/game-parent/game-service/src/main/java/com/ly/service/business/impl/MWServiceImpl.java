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
import com.ly.game.mapper.FontanaBetMwMapper;
import com.ly.game.mapper.FontanaFetchdateMapper;
import com.ly.game.mapper.FontanaUserMapper;
import com.ly.game.model.FontanaBetMw;
import com.ly.game.model.FontanaFetchdate;
import com.ly.game.model.FontanaUser;
import com.ly.service.business.MWService;
import com.ly.service.game.impl.BasecodeServiceImpl;
import com.ly.service.remote.MWBetRemoteService;

@Service
public class MWServiceImpl extends BasecodeServiceImpl implements MWService{
	private final static Logger logger =  LoggerFactory.getLogger(MWServiceImpl.class);
	
	@Autowired
	FontanaFetchdateMapper fetchMapper;

	@Autowired
	FontanaBetMwMapper betMapper;
	
	@Autowired
	FontanaUserMapper userMapper;
	
	private final static String MW_YES = "MW_Settled";// 即时获取
	
	@Override
	public void loadingRemoteGameData() {
		fetchMWSettled(null, true, MW_YES);// 即时获取
	}
	/**
	 * 获取结算数据，一个从当前时间推前12小时为开始时间,endtime
	 * 
	 * @author 阿布
	 * @param versionKey
	 *            开始日期字符串
	 * @param isUpdate
	 *            验证是否保存结束日期时间到数据库
	 * @param str
	 *            存储数据库KET
	 */
	public void fetchMWSettled(String versionKey, boolean isUpdate, String str) {
		FontanaFetchdate fect=fetchMapper.selectByPrimaryGametype(MW_YES);
		Date date = new Date();
		if (StringUtils.isEmpty(versionKey)) {
			if (fect.getVersionkey()==null) {
				versionKey = "2018-08-17 17:00:00";
				fect.setVersionkey(versionKey);
				fetchMapper.insertSelective(fect);
			} else {
				versionKey = fect.getVersionkey();
			}
		}
		String endDate = DateUtils.date2String(date, DateUtils.PATTERN_DATE_TIME);
		// 强烈注意：减少当前日期时间2分钟
		versionKey = reduceTime(DateUtils.string2Date(versionKey, DateUtils.PATTERN_DATE_TIME));
		String vk = save(versionKey, endDate, versionKey, 1);
		if (vk != null && isUpdate && !vk.equals(versionKey)) {
			fect.setVersionkey(vk);
			fetchMapper.updateByPrimaryKey(fect);
		}
	}
	// 减少当前日期时间2分钟
	private String reduceTime(Date date) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		c1.add(Calendar.MINUTE, -2);
		return DateUtils.date2String(c1.getTime(), DateUtils.PATTERN_DATE_TIME);
	}
	 /* 
	 * @author 阿布
	 * @param sd
	 *            开始时间
	 * @param ed
	 *            结束时间
	 * @param username
	 *            账户名
	 * @return true|false
	 */
	public boolean fetchMWNotSettled(String sd, String ed) {
		try {
			save(sd, ed, sd, 1);
			return true;
		} catch (Exception e) {
			logger.error("MWGameFetch.fetchMWNotSettled:补票异常:Title=" + e.getMessage() + ",Body=" + e);
			return false;
		}
	}
	/**
	 * 
	 * @param id
	 *            序列ID
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param lastDateTime
	 *            最后日期时间，用于判断
	 * @param qpage
	 *            当前页数
	 * @param username
	 *            账户名
	 * @return
	 */
	private String save(String startTime, String endTime, String lastDateTime, int qpage) {
		List<FontanaBetMw> addList = new ArrayList<FontanaBetMw>();
		JSONObject jsonObj = null;
		try {
			jsonObj = MWBetRemoteService.getBetLog(qpage, startTime, endTime);
			if (jsonObj == null) {
				logger.info("MW get data response null.");
				return lastDateTime;
			}
			logger.info("MW bet:" + JSONObject.toJSONString(jsonObj));
			String result = jsonObj.getString("userGameLogs");
			if (StringUtils.isEmpty(result) || "[]".equals(result) || "null".equals(result)) {
				logger.info("MW get data response empty.");
				return endTime;
			}
			List<FontanaBetMw> rlist = FastJsonUtils.json2List(result, FontanaBetMw.class);
			if (!CollectionUtil.isEmpty(rlist)) {
				Set<String> setName = new HashSet<String>();
				for (FontanaBetMw vg : rlist) {
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
				for (FontanaBetMw bet : rlist) {
					String betNum = bet.getBetnum();
					boolean is = (betNum.toUpperCase().indexOf("VG") == 0);
					if (is) {
						continue;
					}
					String loginname = bet.getUsername();
					bet.setUsername(loginname);
					FontanaUser user = mapUser.get(loginname);
					if (user == null || user.getId() <= 0) {
						continue;
					}
					// MW 使用VersionKey进行无差别查询，正常是不会出现重复插入的情况的,预防补票操作，还是判断下吧。。。
					int ois = betMapper.exists(betNum, loginname,getBcvalue());
					if (ois>=1) {// 判断当前这条数据是不是已经结算， 已结算就跳出当前循环
						logger.info("MW repeat:" + betNum + " - " + loginname);
						continue;
					}
					Date date = bet.getBettime();
					if (bet.getValidamount() != null && bet.getValidamount() > 0.0) {
						bet.setValidamount(bet.getValidamount());
					} else if (bet.getValidamount() != null && bet.getValidamount() < 0.0) {
						bet.setValidamount(Math.abs(bet.getValidamount()));
					} else {
						bet.setValidamount(0.0);
					}
					Date date2 = DateUtils.addHours(date, -12);
					bet.setGroupfor(date2);
					bet.setUid(user.getId());
					bet.setCid(user.getCid());
					bet.setPid(user.getPid());
					bet.setGid(user.getGid());
					bet.setAid(user.getAid());
					bet.setSid(user.getSid());
					bet.setSource(user.getSource());
					bet.setValidamount(bet.getBetamount());
					bet.setResult(bet.getWinmoney() - bet.getBetamount());
					addList.add(bet);
				}
				if (CollectionUtil.isNotEmpty(addList)) {// 要添加到数据库的数据
					betMapper.insertReplaceRecordBatch(addList);
				}
				int totalPage = jsonObj.getIntValue("page");// 总页数
				if (qpage < totalPage) {// 递归查询记录
					save(startTime, endTime, lastDateTime, ++qpage);
				}
			}
			return endTime;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("MW get data response exception " + e.getMessage(), e);
			return lastDateTime;
		}
	}
}
