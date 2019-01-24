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
import com.ly.game.mapper.FontanaBetBbinfishingMapper;
import com.ly.game.mapper.FontanaFetchdateMapper;
import com.ly.game.mapper.FontanaUserMapper;
import com.ly.game.model.FontanaBetBbinfishing;
import com.ly.game.model.FontanaFetchdate;
import com.ly.game.model.FontanaUser;
import com.ly.service.business.BbinFishingService;
import com.ly.service.game.impl.BasecodeServiceImpl;
import com.ly.service.remote.BbinBetRemoteService;

@Service
public class BbinFishingServiceImpl extends BasecodeServiceImpl implements BbinFishingService{
	private final static Logger logger =  LoggerFactory.getLogger(BbinFishingServiceImpl.class);
	private final static String BB_YES_DA_REN = "BbinFishing_30599_Immediate";// 即时获取达人
	private final static String BB_YES_DA_SHI = "BbinFishing_38001_Immediate";// 即时获取大师
	@Autowired
	FontanaFetchdateMapper fetchMapper;

	@Autowired
	FontanaBetBbinfishingMapper betMapper;
	
	@Autowired
	FontanaUserMapper userMapper;
	
	@Autowired
	BbinBetRemoteService bbinService;
	
	private final static String END_HHMMSS = "23:59:59";
	private final static String START_HHMMSS = "00:00:00";

	@Override
	public void loadingRemoteGameData() {
		fetchBBSettled(null, true, BB_YES_DA_REN);// 即时获取捕鱼达人
		fetchBBSettledMaster(null, true, BB_YES_DA_SHI);// 即时获取捕鱼大师
	}
	/**
	 * 即时获取捕鱼达人
	 * 
	 * @author 阿布
	 * @param versionKey
	 *            开始日期字符串
	 * @param isUpdate
	 *            验证是否保存结束日期时间到数据库
	 * @param SS
	 *            存储数据库KET
	 */
	public void fetchBBSettled(String versionKey, boolean isUpdate, String BB) {
		FontanaFetchdate fetch=null;
		if (StringUtils.isEmpty(versionKey)) {
			fetch=fetchMapper.selectByPrimaryGametype(BB);
			if (fetch == null) {
				fetch=new FontanaFetchdate();
				fetch.setVersionkey("2018-08-30 00:00:00");
				fetch.setGametype(BB);
				fetchMapper.insert(fetch);
			} else {
				versionKey = fetch.getVersionkey() == null ? "2018-08-30 00:00:00" : fetch .getVersionkey();
				fetch.setVersionkey(versionKey);
			}
		}
		String[] startStr = versionKey.split(" ");
		Date newDate = DateUtils.addTime(new Date(), -12, 0, 0);// 获取最新日期时间
		Date startDate = DateUtils.string2Date(versionKey, DateUtils.FORMAT_TIME);
		Date endDate = DateUtils.addTime(startDate, 0, 1, 0);
		if (newDate.getTime() > endDate.getTime()) {
			long getDaysCount = getDaysCount(DateUtils.string2Date(startStr[0], DateUtils.FORTER_DATE), newDate);
			String vk = null;
			if (getDaysCount > 1) {// 跨天，大于2天。进行循环操作补票
				recursiveSaveB30(newDate, startDate, endDate, BB,fetch);
			} else if (END_HHMMSS.equals(startStr[1])) { // 判断当前数据库的日期时间是否为，当天的23:59:59
				String startD = DateUtils.date2String(startDate, DateUtils.FORTER_DATE);
				String sDate = getNextDay(startD);
				startDate = DateUtils.string2Date(sDate + " " + START_HHMMSS, DateUtils.FORMAT_TIME);
				endDate = DateUtils.string2Date(sDate + " 00:03:59", DateUtils.FORMAT_TIME);
				vk = save(BbinBetRemoteService.ACTION_TYPE_MODIFIED_TIME,
						DateUtils.date2String(startDate, DateUtils.FORTER_DATE),
						DateUtils.date2String(startDate, DateUtils.PATTERN_TIME),
						DateUtils.date2String(endDate, DateUtils.PATTERN_TIME), 1);
			} else {
				Date tempDate = DateUtils.string2Date(startStr[0] + " " + END_HHMMSS, DateUtils.FORMAT_TIME);
				if (endDate.getTime() > tempDate.getTime()) {// 处理跨天操作。
					endDate = tempDate;
				} else {
					int min = DateUtils.getMinute(startDate, newDate);
					int max = 6;
					if (max > min) {// 判断当前时间是否延迟五分钟， 如果没有延迟进行延迟处理。
						logger.error("小于时间区间相差有误。进行恢复。延迟到五分钟：startDate=" + DateUtils.date2String(startDate, DateUtils.FORMAT_TIME) +
								"&newDate=" + DateUtils.date2String(newDate, DateUtils.FORMAT_TIME));
						int num = min - 6;// 当前时间减少6分钟。等于负数。
						startDate = DateUtils.addTime(startDate, 0, num, 0);// 把开始日期时间延迟到五分钟以内。因为6分钟每次时间区间会自动加一。
						endDate = DateUtils.addTime(startDate, 0, 1, 0);// 查询区间+1
					} else if (min > max) {// 当时间区间大于6分钟的时候，补齐到6分钟的差距，不能超过6分钟的时间差距。
						logger.error("大于时间区间相差有误。进行恢复。延迟到五分钟：startDate=" + DateUtils.date2String(startDate, DateUtils.FORMAT_TIME) +
								"&newDate=" + DateUtils.date2String(newDate, DateUtils.FORMAT_TIME));
						// int num = (int) min - 6;
						endDate = DateUtils.addTime(startDate, 0, 4, 0);
					}
				}
				vk = save(BbinBetRemoteService.ACTION_TYPE_MODIFIED_TIME,
						DateUtils.date2String(startDate, DateUtils.FORTER_DATE),
						DateUtils.date2String(startDate, DateUtils.PATTERN_TIME),
						DateUtils.date2String(endDate, DateUtils.PATTERN_TIME), 1);
			}
			if (StringUtils.isNotEmpty(vk) && isUpdate && !vk.equals(versionKey)) {
				fetch.setVersionkey(vk);
				fetch.setGametype(BB);
				fetchMapper.updateByPrimaryKeySelective(fetch);
			}
		}
	}

	private void recursiveSaveB30(Date isDate, Date startDate, Date endDate, String code,FontanaFetchdate fetch) {
		if (endDate.getTime() > isDate.getTime()) {// 判断endDate时间是否大于当前获取的时间。是的话终止递归
			Date date = DateUtils.addTime(isDate, 0, -6, 0);// 只要进来执行大次数，存储最后时候得时候-6分钟。抓票自动推迟5分钟。以防漏票处理
			String vk = DateUtils.date2String(date, DateUtils.FORMAT_TIME);
			if (StringUtils.isNotEmpty(vk)) {
				// System.out.println("30进入VK：" + vk);
				fetch.setGametype(code);
				fetch.setVersionkey(vk);
				fetchMapper.updateByPrimaryKeySelective(fetch);
			}
		} else {
			String startTime = DateUtils.date2String(startDate, DateUtils.PATTERN_TIME);
			String startD = DateUtils.date2String(startDate, DateUtils.FORTER_DATE);
			if (END_HHMMSS.equals(startTime)) {// 判断当前时间是否为23:59:59，是的话。进行换天处理
				String sDate = getNextDay(startD);
				startDate = DateUtils.string2Date(sDate + " " + START_HHMMSS, DateUtils.FORMAT_TIME);
				endDate = DateUtils.string2Date(sDate + " " + END_HHMMSS, DateUtils.FORMAT_TIME);
				save(BbinBetRemoteService.ACTION_TYPE_BET_TIME, DateUtils.date2String(startDate, DateUtils.FORTER_DATE),
						DateUtils.date2String(startDate, DateUtils.PATTERN_TIME),
						DateUtils.date2String(endDate, DateUtils.PATTERN_TIME), 1);
				startDate = endDate;
			} else {
				endDate = DateUtils.string2Date(startD + " " + END_HHMMSS, DateUtils.FORMAT_TIME);
				save(BbinBetRemoteService.ACTION_TYPE_BET_TIME, DateUtils.date2String(startDate, DateUtils.FORTER_DATE),
						DateUtils.date2String(startDate, DateUtils.PATTERN_TIME),
						DateUtils.date2String(endDate, DateUtils.PATTERN_TIME), 1);
				startDate = endDate;
			}
			recursiveSaveB30(isDate, startDate, endDate, code,fetch);
		}
	}
	public static void main(String[] args) {
		/*Date startDate=DateUtils.string2Date("2019-1-1 " + START_HHMMSS, DateUtils.PATTERN_DATE_TIME);
		String startD = DateUtils.date2String(startDate, DateUtils.PATTERN_DATE);
		Date endDate = DateUtils.string2Date(startD + " " + END_HHMMSS, DateUtils.PATTERN_DATE_TIME);
		Object json=BbinBetRemoteService.wagersRecordBy30(BbinBetRemoteService.ACTION_TYPE_BET_TIME, DateUtils.date2String(startDate, DateUtils.PATTERN_DATE),
				DateUtils.date2String(startDate, DateUtils.PATTERN_TIME),
				DateUtils.date2String(endDate, DateUtils.PATTERN_TIME), 0,0);
		System.out.println("0000:"+json.toString());*/
	}
	/**
	 * 操作捕鱼达人30
	 * 
	 * @author 阿布
	 * @param action
	 *            类型：BetTime / ModifiedTime：须选一。（BetTime：使用下注时间查询信息/
	 *            ModifiedTime：使用异动时间查询资讯）
	 * @param date
	 *            日期
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param lastUpdatedDate
	 *            • 此参数将根据注单的最后跟新时间加以过滤响应结果, • 此参数值必须在日期区间内, •
	 *            可选参数。如果提供此参数，系统则只返回所有最后跟新时间大于此值的注单。
	 * @param qpage
	 *            当前页数
	 * @return
	 */
	private String save(String action, String date, String startTime, String endTime, int qpage) {
		List<FontanaBetBbinfishing> addList = new ArrayList<FontanaBetBbinfishing>();
		JSONObject jsonObj = null;
		try {

			jsonObj = bbinService.wagersRecordBy30(action, date,
					startTime, endTime, qpage, 0);
			System.out.println(jsonObj);
			if (jsonObj == null) {
				logger.info("BbinFishingFetch get data response null.");
				return date + " " + startTime;
			}
			boolean is = jsonObj.getBoolean("result");
			if (!is) {
				JSONObject obj2 = jsonObj.getJSONObject("data");
				if (obj2 != null && "40014".equals(obj2.get("Code"))) {
					logger.error("BbinFishingFetch get data fetchBBSettled.DateTime:" + jsonObj);
					return date + " " + endTime;
				}
			}
			String result = jsonObj.getString("data");
			if (StringUtils.isEmpty(result) || "null".equals(result)) {
				logger.info("BbinFishingFetch get data response empty.");
				return date + " " + endTime;
			}
			List<FontanaBetBbinfishing> rlist=FastJsonUtils.json2List(result, FontanaBetBbinfishing.class);
			if (!CollectionUtil.isEmpty(rlist)) {
				Set<String> setName=new HashSet<>();
				for (FontanaBetBbinfishing bet : rlist) {
					String loginName = bet.getUsername();// 如果用户不存在的话，不入库
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
				if(mapUser ==null || mapUser.size()==0) return null;
				for (FontanaBetBbinfishing bet : rlist) {
					String loginname = bbinService.removePrefix(bet.getUsername());
					FontanaUser user = mapUser.get(loginname.toUpperCase());
					if (user == null || user.getId() <= 0) {
						logger.info("BbinFishingFetch user no exist:" + bet.getBetnum() + " - " + loginname);
						continue;
					}
					// BBin捕鱼大师和捕鱼达人
					// 使用VersionKey进行无差别查询，正常是不会出现重复插入的情况的,预防补票操作，还是判断下吧。。。
					if (betMapper.exists(bet.getBetnum(), loginname, "30599",getBcvalue())>=1) {// 判断当前这条数据是不是已经结算，已结算就跳出当前循环
						logger.info("BbinFishingFetch repeat:" + bet.getBetnum() + " - " + loginname);
						continue;
					}
					bet.setBettime(DateUtils.addHours(bet.getBettime(), +12));
					if (bet.getValidamount() != null && bet.getValidamount() > 0.0) {
						bet.setValidamount(bet.getValidamount());
					} else if (bet.getValidamount() != null && bet.getValidamount() < 0.0) {
						bet.setValidamount(Math.abs(bet.getValidamount()));
					} else {
						bet.setValidamount(0.0);
					}
					bet.setResult(bet.getResult() == null ? 0.0 : bet.getResult());
					Date date2 = bet.getModifieddate();
					if ("W".equalsIgnoreCase(bet.getGameresult()) || "L".equalsIgnoreCase(bet.getGameresult())) {
						bet.setGroupfor(date2);
					} else {
						bet.setGroupfor(null);
					}
					bet.setModifieddate(date2 == null ? null : DateUtils.addHours(date2, +12));
					bet.setUid(user.getId());
					bet.setCid(user.getCid());
					bet.setPid(user.getPid());
					bet.setGid(user.getGid());
					bet.setAid(user.getAid());
					bet.setSid(user.getSid());
					bet.setSource(user.getSource());
					addList.add(bet);
				}
				if (CollectionUtil.isNotEmpty(addList)) {// 要添加到数据库的数据
					betMapper.insertReplaceRecordBatch(addList);
				}
				JSONObject pagination = jsonObj.getJSONObject("pagination");
				int totalPage = pagination.getIntValue("TotalPage");// 总页数
				if (totalPage > qpage) {// 递归查询记录
					save(action, date, startTime, endTime, ++qpage);
				}
			}
			return date + " " + endTime;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("BbinFishingFetch get data response exception " + e.getMessage(), e);
			return date + " " + startTime;
		}
	}
	/**
	 * 即时获取捕鱼大师
	 * 
	 * @param versionKey
	 *            开始日期字符串
	 * @param isUpdate
	 *            验证是否保存结束日期时间到数据库
	 * @param SS
	 *            存储数据库KET
	 */
	public void fetchBBSettledMaster(String versionKey, boolean isUpdate, String BB) {
		FontanaFetchdate fetch=null;
		if (StringUtils.isEmpty(versionKey)) {
			fetch=fetchMapper.selectByPrimaryGametype(BB);
			if (fetch == null) {
				fetch=new FontanaFetchdate();
				fetch.setVersionkey("2018-08-30 00:00:00");
				fetch.setGametype(BB);
				fetchMapper.insert(fetch);
			} else {
				versionKey = fetch.getVersionkey() == null ? "2018-08-30 00:00:00" : fetch .getVersionkey();
				fetch.setVersionkey(versionKey);
			}
		}
		String[] startStr = versionKey.split(" ");
		Date newDate = DateUtils.addTime(new Date(), -12, 0, 0);// 获取最新日期时间
		Date startDate = DateUtils.string2Date(versionKey, DateUtils.PATTERN_DATE_TIME);
		Date endDate = DateUtils.addTime(startDate, 0, 2, 0);
		if (newDate.getTime() > endDate.getTime()) {
			long getDaysCount = getDaysCount(DateUtils.string2Date(startStr[0], DateUtils.PATTERN_DATE), newDate);
			String vk = null;
			if (getDaysCount > 1) {// 跨天，大于2天。进行循环操作补票
				recursiveSaveB38(newDate, startDate, endDate, BB,fetch);
			} else if (END_HHMMSS.equals(startStr[1])) { // 判断当前数据库的日期时间是否为，当天的23:59:59
				String startD = DateUtils.date2String(startDate, DateUtils.PATTERN_DATE);
				String sDate = getNextDay(startD);
				startDate = DateUtils.string2Date(sDate + " " + START_HHMMSS, DateUtils.PATTERN_DATE_TIME);
				endDate = DateUtils.string2Date(sDate + " 00:03:59", DateUtils.PATTERN_DATE_TIME);
				vk = save(BbinBetRemoteService.ACTION_TYPE_MODIFIED_TIME, DateUtils.date2String(startDate, DateUtils.PATTERN_DATE),
						DateUtils.date2String(startDate, DateUtils.PATTERN_TIME),
						DateUtils.date2String(endDate, DateUtils.PATTERN_TIME), 1, null);
			} else {
				Date tempDate = DateUtils.string2Date(startStr[0] + " " + END_HHMMSS, DateUtils.PATTERN_DATE_TIME);
				if (endDate.getTime() > tempDate.getTime()) {
					endDate = tempDate;
				}
				vk = save(BbinBetRemoteService.ACTION_TYPE_MODIFIED_TIME, DateUtils.date2String(startDate, DateUtils.PATTERN_DATE),
						DateUtils.date2String(startDate, DateUtils.PATTERN_TIME),
						DateUtils.date2String(endDate, DateUtils.PATTERN_TIME), 1, null);
			}
			if (StringUtils.isNotEmpty(vk) && isUpdate && !vk.equals(versionKey)) {
				fetch.setVersionkey(vk);
				fetch.setGametype(BB);
				fetchMapper.updateByPrimaryKeySelective(fetch);
			}
		}
	}
	// 捕鱼大师,处理下注时间,每次操作当前的最后时间23:59:59，因为下注时间没有限制时间范围。
	private void recursiveSaveB38(Date isDate, Date startDate, Date endDate, String code,FontanaFetchdate fetch) {
		// System.out.println("38进入时间" + DateUtils.date2String(startDate,
		// DateUtils.PATTERN_DATE_TIME)
		// + "=endDate:" + DateUtils.date2String(endDate,
		// DateUtils.PATTERN_DATE_TIME));
		if (endDate.getTime() > isDate.getTime()) {// 判断endDate时间是否大于当前获取的时间。是的话终止递归
			String vk = DateUtils.date2String(isDate, DateUtils.PATTERN_DATE_TIME);
			if (StringUtils.isNotEmpty(vk)) {
				// System.out.println("38进入VK：" + vk);
				fetch.setVersionkey(vk);
				fetchMapper.updateByPrimaryKeySelective(fetch);
			}
		} else {
			String startTime = DateUtils.date2String(startDate, DateUtils.PATTERN_TIME);
			String startD = DateUtils.date2String(startDate, DateUtils.PATTERN_DATE);
			if (END_HHMMSS.equals(startTime)) {// 判断当前时间是否为23:59:59，是的话。进行换天处理
				String sDate = getNextDay(startD);
				startDate = DateUtils.string2Date(sDate + " " + START_HHMMSS, DateUtils.PATTERN_DATE_TIME);
				endDate = DateUtils.string2Date(sDate + " " + END_HHMMSS, DateUtils.PATTERN_DATE_TIME);
				save(BbinBetRemoteService.ACTION_TYPE_MODIFIED_TIME, DateUtils.date2String(startDate, DateUtils.PATTERN_DATE),
						DateUtils.date2String(startDate, DateUtils.PATTERN_TIME),
						DateUtils.date2String(endDate, DateUtils.PATTERN_TIME), 1, null);
				// System.out.println("38结束时间" +
				// DateUtils.date2String(startDate,
				// DateUtils.PATTERN_DATE_TIME)
				// + "=endDate:" + DateUtils.date2String(endDate,
				// DateUtils.PATTERN_DATE_TIME));
				startDate = endDate;
			} else {
				endDate = DateUtils.string2Date(startD + " " + END_HHMMSS, DateUtils.PATTERN_DATE_TIME);
				save(BbinBetRemoteService.ACTION_TYPE_MODIFIED_TIME, DateUtils.date2String(startDate, DateUtils.PATTERN_DATE),
						DateUtils.date2String(startDate, DateUtils.PATTERN_TIME),
						DateUtils.date2String(endDate, DateUtils.PATTERN_TIME), 1, null);
				// System.out.println("38结束时间" +
				// DateUtils.date2String(startDate,
				// DateUtils.PATTERN_DATE_TIME)
				// + "=endDate:" + DateUtils.date2String(endDate,
				// DateUtils.PATTERN_DATE_TIME));
				startDate = endDate;
			}
			recursiveSaveB38(isDate, startDate, endDate, code,fetch);
		}

	}

	/**
	 * 捕鱼大师
	 * 
	 * @author 阿布
	 * @param sd
	 *            开始时间
	 * @param ed
	 *            结束时间
	 * @param type
	 *            类型：1=捕鱼大师，2捕鱼达人
	 * @return
	 */
	public boolean fetchBBSettled(String sd, String ed, String type) {
		try {
			String[] sds = sd.split(" ");
			String[] eds = ed.split(" ");
			if ("1".equals(type)) {
				save(BbinBetRemoteService.ACTION_TYPE_BET_TIME, sds[0], sds[1], eds[1], 1, "");
				return true;
			} else if ("2".equals(type)) {
				save(BbinBetRemoteService.ACTION_TYPE_BET_TIME, sds[0], sds[1], eds[1], 1);
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.error("BbinFishingFetch.fetchSSNotSettled:补票异常:Title=" + e.getMessage() + ",Body=" + e);
			return false;
		}
	}

	/**
	 * 操作捕鱼大师38
	 * 
	 * @author 阿布
	 * @param action
	 *            类型：BetTime / ModifiedTime：须选一。（BetTime：使用下注时间查询信息/
	 *            ModifiedTime：使用异动时间查询资讯）
	 * @param date
	 *            日期
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param lastUpdatedDate
	 *            • 此参数将根据注单的最后跟新时间加以过滤响应结果, • 此参数值必须在日期区间内, •
	 *            可选参数。如果提供此参数，系统则只返回所有最后跟新时间大于此值的注单。
	 * @param qpage
	 *            当前页数
	 * @return
	 */
	private String save(String action, String date, String startTime, String endTime, int qpage, String username) {
		List<FontanaBetBbinfishing> addList = new ArrayList<FontanaBetBbinfishing>();
		JSONObject jsonObj = null;
		try {
			jsonObj = bbinService.wagersRecordBy38(BbinBetRemoteService.ACTION_TYPE_BET_TIME,
					username, date, startTime, endTime, qpage, 0);
			System.out.println(jsonObj);
			if (jsonObj == null) {
				logger.info("BbinFishingFetch get data response null.");
				return date + " " + startTime;
			}
			boolean is = jsonObj.getBoolean("result");
			if (!is) {
				JSONObject obj2 = jsonObj.getJSONObject("data");
				if (obj2 != null && "40014".equals(obj2.get("Code"))) {
					logger.error("BbinFishingFetch get data fetchBBSettledMaster.DateTime:" + jsonObj);
					return date + " " + endTime;
				}
			}
			String result = jsonObj.getString("data");
			if (StringUtils.isEmpty(result) || "null".equals(result)) {
				logger.info("BbinFishingFetch get data response empty.");
				return date + " " + endTime;
			}
			List<FontanaBetBbinfishing> rlist=FastJsonUtils.json2List(result, FontanaBetBbinfishing.class);
			if (!CollectionUtil.isEmpty(rlist)) {
				Set<String> setName=new HashSet<>();
				for (FontanaBetBbinfishing bet : rlist) {
					String loginName = bet.getUsername();// 如果用户不存在的话，不入库
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
				if(mapUser ==null || mapUser.size()==0) return null;
				for (FontanaBetBbinfishing bet : rlist) {
					String loginname = bbinService.removePrefix(bet.getUsername());
					FontanaUser user = mapUser.get(loginname.toUpperCase());
					if (user == null || user.getId() <= 0) {
						logger.info("BbinFishingFetch user no exist:" + bet.getBetnum() + " - " + loginname);
						continue;
					}
					// BBin捕鱼大师和捕鱼达人
					// 使用VersionKey进行无差别查询，正常是不会出现重复插入的情况的,预防补票操作，还是判断下吧。。。
					if (betMapper.exists(bet.getBetnum(), loginname, "38001",getBcvalue())>=1) {// 判断当前这条数据是不是已经结算，已结算就跳出当前循环
						logger.info("BbinFishingFetch repeat:" + bet.getBetnum() + " - " + loginname);
						continue;
					}
					
					bet.setBettime(DateUtils.addHours(bet.getBettime(), +12));
					if (bet.getValidamount() != null && bet.getValidamount() > 0.0) {
						bet.setValidamount(bet.getValidamount());
					} else if (bet.getValidamount() != null && bet.getValidamount() < 0.0) {
						bet.setValidamount(Math.abs(bet.getValidamount()));
					} else {
						bet.setValidamount(0.0);
					}
					bet.setResult(bet.getResult() == null ? 0.0 : bet.getResult());
					Date date2 = bet.getModifieddate();
					if ("W".equalsIgnoreCase(bet.getGameresult()) || "L".equalsIgnoreCase(bet.getGameresult())) {
						bet.setGroupfor(date2);
					} else {
						bet.setGroupfor(null);
					}
					bet.setModifieddate(date2 == null ? null : DateUtils.addHours(date2, +12));
					
					
					bet.setUid(user.getId());
					bet.setCid(user.getCid());
					bet.setPid(user.getPid());
					bet.setGid(user.getGid());
					bet.setAid(user.getAid());
					bet.setSid(user.getSid());
					bet.setSource(user.getSource());
					addList.add(bet);
				}
				if (CollectionUtil.isNotEmpty(addList)) {// 要添加到数据库的数据
					betMapper.insertReplaceRecordBatch(addList);
				}
				JSONObject pagination = jsonObj.getJSONObject("pagination");
				int totalPage = pagination.getIntValue("TotalPage");// 总页数
				if (totalPage > qpage) {// 递归查询记录
					save(action, date, startTime, endTime, ++qpage, username);
				}
			}
			return date + " " + endTime;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("BbinFishingFetch get data response exception " + e.getMessage(), e);
			return date + " " + startTime;
		}

	}
	/**
	 * 根据当前开始日期得到当前日期的后一天
	 * 
	 * @param startDate
	 * @return
	 */
	private String getNextDay(String startDate) {
		Calendar c = Calendar.getInstance();
		Date sDate = DateUtils.string2Date(startDate, DateUtils.FORTER_DATE);
		c.setTime(sDate);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);
		return DateUtils.date2String(c.getTime(), DateUtils.FORTER_DATE);
	}
	/**
	 * 得到天数
	 * 
	 * @param startDate
	 * @param endDate
	 */
	private long getDaysCount(Date startDate, Date endDate) {
		// 跨年不会出现问题
		// 如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 0
		long days = (endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24);
		return days;
	}
}
