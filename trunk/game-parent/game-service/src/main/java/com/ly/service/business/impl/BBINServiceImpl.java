package com.ly.service.business.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ly.common.gameutil.BYType;
import com.ly.common.util.CollectionUtil;
import com.ly.common.util.DateTimeUtil;
import com.ly.common.util.DateUtils;
import com.ly.common.util.FastJsonUtils;
import com.ly.game.mapper.FontanaBetBoinlotteryMapper;
import com.ly.game.mapper.FontanaBetBoinsportMapper;
import com.ly.game.mapper.FontanaBetBoinvideoMapper;
import com.ly.game.mapper.FontanaFetchdateMapper;
import com.ly.game.mapper.FontanaUserMapper;
import com.ly.game.model.FontanaBetBoinlottery;
import com.ly.game.model.FontanaBetBoinsport;
import com.ly.game.model.FontanaBetBoinvideo;
import com.ly.game.model.FontanaFetchdate;
import com.ly.game.model.FontanaUser;
import com.ly.service.business.BBINService;
import com.ly.service.game.impl.BasecodeServiceImpl;
import com.ly.service.remote.BbinBetRemoteService;
import com.ly.service.remote.BbinBetRemoteService.BBinGameKind;

@Service
public class BBINServiceImpl extends BasecodeServiceImpl implements BBINService{
	private final static Logger logger =  LoggerFactory.getLogger(BBINServiceImpl.class);
	
	@Autowired
	FontanaFetchdateMapper fetchMapper;

	@Autowired
	FontanaBetBoinvideoMapper betvideoMapper;

	@Autowired
	FontanaBetBoinlotteryMapper betlotteryMapper;

	@Autowired
	FontanaBetBoinsportMapper betsportMapper;
	
	@Autowired
	FontanaUserMapper userMapper;
	
	@Autowired
	BbinBetRemoteService bbinService;
	
	private final static String BYDZ = "BYDZ";
    private final static String BYSX = "BYSX";
    private final static String BYCP = "BYCP";
    private final static String BYTY = "BYTY";
    private final static long sleep = 10000L;
    private final static long time=5000L;
    
    public static volatile int count=0;
    
    private final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final static String DATE_FORMAT = "yyyy-MM-dd";
	private final static String AETimeZone = "GMT-4:00";
	private final static String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	private final static String bbinnameprefix = "igp";
	private static String prefix = "";
	private static String prefix2 = "";
	
	

	@Override
	public void loadingRemoteGameData() {
		try {
		// TODO Auto-generated method stub
		//1：球类，3：视讯，5：电子机率，12：彩票，15：3D厅
        List<String> gameKinds = new ArrayList<String>();
        int[] games = {1,3,5,12};//
        String[] cpGames = {"LT","OTHER"};//彩票
        String[] dzGames = {"1","2","3","5"};//电子
        for (int i : games) {
            gameKinds.add(i+"");
        }
        FontanaFetchdate record =new FontanaFetchdate();
        for (String gameKind : gameKinds) {//根据游戏种类，获取投注历史数据
			if ("3".equals(gameKind)) {// 视讯
				Date now = new Date();
				record = fetchMapper.selectByPrimaryGametype(BYSX);
				Date date = record.getEtchstarttime();
				if(now.getTime() - date.getTime() > 60 * 1000) {
					//为保证美东时间不报错所以-4分钟（美东时间比较接近当前时间的话有时报时间格式不规范的错误）
					Date start = dealDate(date,-4);// 计算开始时分秒
					Date end = dealDate(start, 1);// 计算结束时分秒
					String sd = getAEDate(start);//计算美东时间
					String md = getAEDate(end);//计算美东时间
					Date s = DateTimeUtil.getFormatDate(sd, DATE_FORMAT );
					Date d = DateTimeUtil.getFormatDate(md, DATE_FORMAT );
					Date endDate = saveVideo(s, d, getSFMTime(sd), getSFMTime(md), 1,date);
					if(endDate!=null) {
						record.setEtchstarttime(endDate);
						fetchMapper.updateByPrimaryKeySelective(record);
					}
				}
			} else if ("12".equals(gameKind)) {
				logger.info("caipi "+gameKind);
				// 彩票
				record = fetchMapper.selectByPrimaryGametype(BYCP);
				Date date = record.getEtchstarttime();
				for(String game : cpGames){
					Date endate=saveLot(game,gameKind, date ,false,1,false);//处理彩票抓票
					if(endate!=null) {
						record.setEtchstarttime(endate);
						fetchMapper.updateByPrimaryKeySelective(record);
					}
					//结算的单因为也包含其他公司的单，数据量比较大，所以每次抓取一分钟
					endate=saveLot(game,gameKind, date,true,1,true);//同步结算时间
					if(endate!=null) {
						record.setEtchstarttime(endate);
						fetchMapper.updateByPrimaryKeySelective(record);
					}
					Thread.sleep(1000);
					//请求jsp补一次，因为jsp总能把票抓回来
					/*String ip = SystemUtil.getServerIP();
					Date date = DateTimeUtil.getFormatDateTime(lastFetchTime, dateTimePattern);
					Date dates = dealDate(date, -10);
					Date datee = dealDate(dates, 1);
					String url = String.format("http://%s/api/bets/bbinlotfetch.jsp?starttime=%s&endtime=%s",ip, URLEncoder.encode(DateFormatUtils.format(dates, dateTimePattern),"UTF-8"),
							URLEncoder.encode(DateFormatUtils.format(datee, dateTimePattern),"UTF-8"));
					logger.info("[LOT] get jsp url:" + url);
		            String result = HttpUtil.readGetAsString(url, "UTF-8");
		            logger.info("[LOT] from jsp:" + result);*/
				}
			} else if ("5".equals(gameKind)) {// 电子游戏
				Date now = new Date();
				record = fetchMapper.selectByPrimaryGametype(BYDZ);
				Date date = record.getEtchstarttime();
				if(now.getTime() - date.getTime() > 60 * 1000) {
					Date start = dealDate(date,-4);// 计算开始时分秒
					Date end = dealDate(start, 1);// 计算结束时分秒
					//判断是否即将跨天，跨天需要自动将时间转成11:59:00 ~ 11:59:59,否则现在的API会漏掉这一分钟的单
					Calendar ex = Calendar.getInstance();
					ex.setTime(end);
					int h = ex.get(Calendar.HOUR_OF_DAY);
					int m = ex.get(Calendar.MINUTE);
					if(h == 12 && m == 0){
						ex.set(Calendar.SECOND, 0);
						logger.info("[lot] reset fetch time 11:59:00 ~ 11:59:59");
						ex.add(Calendar.SECOND, -1);
						end = ex.getTime();
						ex.set(Calendar.SECOND, 0);
						start = ex.getTime();
					}
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(end);
					String md = getAEDate(end);//计算美东时间
					Date d =DateTimeUtil.getFormatDate(md, DATE_FORMAT );
					int min = calendar.get(Calendar.MINUTE);
					logger.info("-- EGAME NowMin:" + min);
					calendar.add(Calendar.MINUTE, -10);
					try{
						int errcount = 0;
						for(String game : dzGames){
							errcount += saveEgame(game,gameKind, d, getAEDate(start), md,1);//处理电子抓票
							//电子请求速度过快，容易导致返回API BUSY，这里固定休息半秒
							Thread.sleep(500);
							//部分糖果派对的单返回非常慢，这里每10分钟同步一次前十分钟的单
							if(min % 10 == 0){
								String st = getAEDate(calendar.getTime());
								Thread.sleep(500);
								logger.info("-- EGAME GET TEN MIN:" + st + "~" + md);
								errcount += saveEgame(game,gameKind, d, st, md,1);//处理电子抓票
								Thread.sleep(500);
							}
						}
						if(errcount < 1){//未出错才更新时间
							record.setEtchstarttime(dealDate(date, 1));
							fetchMapper.updateByPrimaryKeySelective(record);
						}else{
							logger.info("-- EGAME ERRCOUNT:" + errcount + "END TINE:" + md);
						}
					}catch(Throwable e){
						e.printStackTrace();
						logger.info("-- EGAME ERROR:" + e.getMessage());
					}
				}
			} else if("1".equals(gameKind)) {//bbin体育
				fetchSport(false,null,true);
				fetchSport(true,null,true);
				
			}
       }
		} catch (Exception e) {
        	e.printStackTrace();
            logger.error("BbinFetch run() " + e.getMessage(), e);
            try {
                logger.info("exception sleep.");
                Thread.sleep(sleep);
            } catch (InterruptedException e1) {
                logger.error("exception sleep error:" + e1.getMessage(), e1);
            }
        }
	}
	
	/**
	    * 
	    * @param isFinished 是否查询已结算的订单
	    * @param date 查询时间
	    * @param isUpdate 是否更新抓票时间到数据库
	    */
		public void fetchSport(boolean isFinished,Date date,boolean isUpdate) {
			//bbin体育
			String gameKind = "1";
			logger.info("caipi "+gameKind);
			Date now = new Date();
			FontanaFetchdate record = fetchMapper.selectByPrimaryGametype(BYTY);
			if(date==null) {
				if(record==null) {
					date = new Date();
				} else {
					date = record.getEtchstarttime();
				}
			}
			if(now.getTime() - date.getTime() > 60 * 1000) {
				Date entime=saveSport(1,gameKind, date,isFinished,isUpdate);
				record.setEtchstarttime(entime);
				fetchMapper.updateByPrimaryKeySelective(record);
			} else {
				try {
					Thread.sleep(sleep);
				}catch(Throwable e) {
					e.printStackTrace();
				}
			}
		}
	   
		/**
		 * 
		 * @param page 页数
		 * @param gameKind 游戏类型
		 * @param fetchDate 抓票时间
		 * @param isFinished 是否查询结算订单
		 * @param isUpdate 是否更新抓票时间到数据库
		 */
	    public Date saveSport(int page,String gameKind,Date fetchDate,boolean isFinished,boolean isUpdate){
		    long l1 = System.currentTimeMillis();
			List<FontanaBetBoinsport> list = new ArrayList<FontanaBetBoinsport>();
			List<FontanaBetBoinsport> addList = new ArrayList<FontanaBetBoinsport>();
			JSONObject jsonObj = null;
			int TotalPage = 0;
			try {
				if(isFinished) {
					if(isUpdate) {
						jsonObj = getResponseSettled(dealDate(fetchDate, -61),dealDate(fetchDate, -60), page,BBinGameKind.ball, "");
					} else {
						//这是补票操作，不用减1小时,一次抓4分钟
						jsonObj = getResponseSettled(dealDate(fetchDate, -4),fetchDate, page,BBinGameKind.ball, "");
					}
				} else {
					if(count%2==0) {
//						System.out.println(count+":fetch this day data");
						logger.info(count+":fetch this day data");
						jsonObj = getResponse(fetchDate, "00:00:00", "23:59:59", page,BBinGameKind.getBBinGameKindByCode(Integer.valueOf(gameKind)), "");
					} else if(count%5==0) {
//						System.out.println(count+":fetch 2 day data");
						logger.info(count+":fetch 2 day data");
						jsonObj = getResponse(DateUtils.addDays(fetchDate, 1), "00:00:00", "23:59:59", page,BBinGameKind.getBBinGameKindByCode(Integer.valueOf(gameKind)), "");
					} else if(count%7==0) {
//						System.out.println(count+":fetch 3 day data");
						logger.info(count+":fetch 3 day data");
						jsonObj = getResponse(DateUtils.addDays(fetchDate, 2), "00:00:00", "23:59:59", page,BBinGameKind.getBBinGameKindByCode(Integer.valueOf(gameKind)), "");
					} else if(count%11==0) {
//						System.out.println(count+":fetch 4 day data");
						logger.info(count+":fetch 4 day data");
						jsonObj = getResponse(DateUtils.addDays(fetchDate, 3), "00:00:00", "23:59:59", page,BBinGameKind.getBBinGameKindByCode(Integer.valueOf(gameKind)), "");
					} else if(count%23==0) {
//						System.out.println(count+":fetch 5 day data");
						logger.info(count+":fetch 5 day data");
						jsonObj = getResponse(DateUtils.addDays(fetchDate, 4), "00:00:00", "23:59:59", page,BBinGameKind.getBBinGameKindByCode(Integer.valueOf(gameKind)), "");
					} else {
//						System.out.println(count+":fetch this day data2");
						logger.info(count+":fetch this day data2");
						jsonObj = getResponse(fetchDate, "00:00:00", "23:59:59", page,BBinGameKind.getBBinGameKindByCode(Integer.valueOf(gameKind)), "");
					}
				}
				
//				System.out.println("[SP "+(isFinished?"Y":"N")+"]Read BY BbinSport  source :" + response.getResult());
				logger.info("[SP "+(isFinished?"Y":"N")+"]Read BY BbinSport  source :" + jsonObj);
				
				if (jsonObj == null || !"true".equals(jsonObj.getString("result"))) {
					logger.info("[SP]BbinSport get data response error.");
					Thread.sleep(sleep);
					return null;
				}
				TotalPage = jsonObj.getJSONObject("pagination").getInteger("TotalPage");
				list = FastJsonUtils.json2List(jsonObj.getString("data"), FontanaBetBoinsport.class);
			} catch (Exception e) {
				logger.error("[SP]BbinSport get data response exception " + e.getMessage(), e);
			}
			
			Set<String> setName = new HashSet<String>();
			if (!CollectionUtil.isEmpty(list)) {
				for (FontanaBetBoinsport boinVideo : list) {
					String loginname = removePrefix(boinVideo.getUsername());
					logger.info("FightAllFetch_record userName:" + loginname);
					if (!"".equals(loginname)) {
						setName.add(loginname);
					}
				}
			}
			List<String> listname=new ArrayList<>(setName);
			if(listname ==null || listname.size()==0) return dealDate(fetchDate, 1);
			List<FontanaUser> listUser=userMapper.selectListByLoginNames(listname);
			Map<String, FontanaUser> mapUser=new HashMap<>();
			for (FontanaUser user : listUser) {
				mapUser.put(user.getLoginname(), user);
			}
			if (!CollectionUtil.isEmpty(list)) {
				for (FontanaBetBoinsport boinSport : list) {
					String loginname = removePrefix(boinSport.getUsername());
					logger.info("[SP] BbinSport loginname (" + loginname + ") .");
					FontanaUser user = mapUser.get(loginname.toUpperCase());
					
					if(!isFinished && betsportMapper.exists(String.valueOf(boinSport.getBetnum()), loginname,getBcvalue())>=1) {
						logger.info("[SP]BbinSport repeat:"+boinSport.getBetnum());
						continue;
					}
					boinSport.setUsername(loginname);
					boinSport.setGameplatformchild(BYType.BYSPORT.getName());
					String betTime = DateUtils.format(boinSport.getBettime());
					boinSport.setBettime(DateUtils.parse(DateTimeUtil.formatDateTime(betTime, "yyyy-MM-dd HH:mm:ss", 0, 0, +12)));
					DateTimeUtil.formatDateTime(DateUtils.format(boinSport.getUptime()), "yyyy-MM-dd HH:mm:ss", 0, 0, 12);
					Date date=boinSport.getUptime() != null ? DateUtils.parse(DateTimeUtil.formatDateTime(DateUtils.format(boinSport.getUptime()), "yyyy-MM-dd HH:mm:ss", 0, 0, 12)) : null;
					boinSport.setUptime(date);
					if(user != null && user.getId() > 0) {
						boinSport.setUid(user.getId());
						boinSport.setCid(user.getCid());
						boinSport.setPid(user.getPid());
						boinSport.setGid(user.getGid());
						boinSport.setAid(user.getAid());
						boinSport.setSid(user.getSid());
						addList.add(boinSport);
					}
				}
				if (CollectionUtil.isNotEmpty(addList)) {// 要添加到数据库的数据
					betsportMapper.insertReplaceRecordBatch(addList);
					//判断数据是否溢出，翻页
					if(TotalPage > page && TotalPage != 0) {
						//翻页
						saveSport(page+1, gameKind,fetchDate,isFinished,isUpdate);
					}
				}
			   long l2 = System.currentTimeMillis();  
		        logger.info("[SP]BbinSport 	once  time: "+( l2 - l1));
			}else {
				logger.info("[SP]BbinSport game  data is empty.");
			}
			if(isFinished && isUpdate && (TotalPage == 0 || TotalPage == page) ) {
				count++;
				return dealDate(fetchDate, 1);
			}
			return null;

	    }
	public int saveEgame(String game,String gameKind,Date d,String start,String end,int page)  {
    	long l1 = System.currentTimeMillis();  
    	List<FontanaBetBoinvideo> list = new ArrayList<FontanaBetBoinvideo>();
        JSONObject jsonObj=null;
        int TotalPage = 0;
        //请求失败，请求错误的次数，如果有请求错误，则不改变时间
  		int errorcount = 0;
        //for (int i = 0; i <dzGames.length; i++) {
        	 List<FontanaBetBoinvideo> addList = new ArrayList<FontanaBetBoinvideo>();
			try {
				jsonObj = getResponse(d, getSFMTime(start), getSFMTime(end), page,BBinGameKind.getBBinGameKindByCode(Integer.valueOf(gameKind)), game);
				logger.info("-- EGAME source :" + jsonObj);
				if (jsonObj == null || !"true".equals(jsonObj.getString("result"))) {
					logger.info("-- EGAME get data response error.");
					return 1;//continue;
				}
				TotalPage = jsonObj.getJSONObject("pagination").getInteger("TotalPage");
				list = FastJsonUtils.json2List(jsonObj.getString("data"), FontanaBetBoinvideo.class);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("-- EGAME get data response exception " + e.getMessage(), e);
			}
	        if(CollectionUtil.isEmpty(list)){
	            logger.info("-- EGAME game kind (" + gameKind + ") data is empty.");
	            return 0;//continue;
	        }
	        Set<String> setName = new HashSet<String>();
			if (!CollectionUtil.isEmpty(list)) {
				for (FontanaBetBoinvideo boinVideo : list) {
					if("0".equals(boinVideo.getResult())||"-77".equals(boinVideo.getResult())) { //"0","-77"表示未结算
		        		logger.info("BbinEgame betNum (" + boinVideo.getBetnum() + ") is not finished.");
		        		continue;
					}
					String loginname = removePrefix(boinVideo.getUsername());
					logger.info("FightAllFetch_record userName:" + loginname);
					if (!"".equals(loginname)) {
						setName.add(loginname);
					}
				}
			}
			List<String> listname=new ArrayList<>(setName);
			if(listname ==null || listname.size()==0) return errorcount;
			List<FontanaUser> listUser=userMapper.selectListByLoginNames(listname);
			Map<String, FontanaUser> mapUser=new HashMap<>();
			for (FontanaUser user : listUser) {
				mapUser.put(user.getLoginname(), user);
			}
	        for (FontanaBetBoinvideo boinVideo: list) {
	        	if("0".equals(boinVideo.getResult())||"-77".equals(boinVideo.getResult())) { //"0","-77"表示未结算
	        		logger.info("BbinEgame betNum (" + boinVideo.getBetnum() + ") is not finished.");
	        		continue;
				}
	            String loginname = removePrefix(boinVideo.getUsername());
	            logger.info("BOYINEgame loginname (" + loginname + ") .");
	            FontanaUser user = null;
	            try {
	                user = mapUser.get(loginname.toUpperCase());
	                if (user == null) {
	                    logger.info("-- EGAME [" + loginname + "] is not exit.");
	                    continue;
	                }
	                if(user.getId() == 0){
	                	logger.info("-- EGAME [" + loginname + "] id is 0.");
	                    continue;
	                }
	                if(betvideoMapper.exists(String.valueOf(boinVideo.getBetnum()), loginname,getBcvalue())==0){
	                	String strDate=BYType.BYEGAME.getName().equals(BYType.BYEGAME.toString())?DateTimeUtil.formatDateTime(boinVideo.getModifiedDate(), "yyyy-MM-dd HH:mm:ss", 0, 0, +12) : null;
						boinVideo.setModifiedDate(strDate);
						String betTime = DateUtils.format(boinVideo.getBettime());
						boinVideo.setBettime(DateUtils.parse(DateTimeUtil.formatDateTime(betTime, "yyyy-MM-dd HH:mm:ss", 0, 0, +12)));
	                	boinVideo.setUid(user.getId());
	                	boinVideo.setParentid(user.getParentid());
	                	boinVideo.setCid(user.getCid());
	                    addList.add(boinVideo);
	                    
	                }
	            } catch (Throwable e) {
	                logger.error("-- EGAME get user by name: " + loginname + " error: " + e.getMessage(), e);
	            }
	        }
	        if(CollectionUtil.isNotEmpty(addList)){
	        	betvideoMapper.insertReplaceRecordBatch(addList);
	        }
	      //判断数据是否溢出，翻页
        	logger.info("-- EGAME TotalPage:" + TotalPage + ";page:" + page);
			if(TotalPage != page && TotalPage != 0) {
				logger.info("-- EGAME Change pagenum:" + page + 1);
				errorcount += saveEgame(game, gameKind, d, start, end, page + 1);
			}
     //}
        long l2 = System.currentTimeMillis();  
        //System.out.println("BOYINEgame once  time: "+( l2 - l1));  
        logger.info("-- EGAME once  time: "+( l2 - l1));
        return errorcount;
	}
	
	 //settled 是否已结算（按照结算查询）
		public Date saveLot(String game,String gameKind,Date date,boolean settled,int page,boolean isupdate) {
			String lstr = settled ? "[Y]" : "[F]";
			 long l1 = System.currentTimeMillis();  
			List<FontanaBetBoinlottery> list = new ArrayList<FontanaBetBoinlottery>();
			Date now = new Date();
			if(now.getTime() - date.getTime() > 60 * 1000) {
				Date startD = dealDate(date, -2);// 计算开始时分秒
				Date endD =  dealDate(startD,1);// getEndTime(date, now);// 计算结束时分秒
				DateFormat df = new SimpleDateFormat(dateTimePattern);
				logger.info("[LOT Y]this fetch time :" + df.format(startD) + " ~ " + df.format(endD));
				
				//给抓普通票计算具体的美东  日期，和时间
				String md = getAEDate(startD);//计算美东时间
				Date d = DateTimeUtil.getFormatDate(md, DATE_FORMAT );
				String start1 = getAEDate(startD);
				String end = getAEDate(endD);
				JSONObject jsonObj;
				int TotalPage = 1;
				boolean dateError = false;
				//for (int i = 0; i < cpGames.length; i++) {
					String start = start1;
					List<FontanaBetBoinlottery> addList = new ArrayList<FontanaBetBoinlottery>();
					try {	
						if(!settled) {
							jsonObj = getResponse(d, getSFMTime(start), getSFMTime(end), page,BBinGameKind.getBBinGameKindByCode(Integer.valueOf(gameKind)), game);
						}else {
							//Util里面会转成美东
							if("LT".equals(game)) {
								//六合彩游戏的抓票，需要延迟一个小时再同步，否则渠道那边可能还没处理完。
								jsonObj = getResponseSettled(dealDate(startD, -15),dealDate(endD, -15), page,BBinGameKind.Ltlottery, game);
							} else {
								jsonObj = getResponseSettled(dealDate(startD, -1),dealDate(endD, -1), page,BBinGameKind.Ltlottery, game);
							}
						}
						logger.info(lstr + "Read BY source :" + jsonObj.getString("data"));
						if (jsonObj == null || !"true".equals(jsonObj.getString("result"))) {
							logger.info(lstr + "BbinLottery get data response error.");
							Thread.sleep(sleep);
							return null;//continue;
						}
						if(settled) {
							try {
								//如果报了时间不规范的错时间不变，休息继续
								//{"result":false,"data":{"Message":"Date Error","Code":"40014"}}
								//{"result":true,"pagination":{"TotalPage":1,"TotalNumber":"10","Page":1,"PageLimit":500},"data":[{"Game
								if(!jsonObj.getBoolean("result") && jsonObj.getJSONObject("data").getString("Code").equals("40014")) {
									dateError = true;
									logger.info(lstr + "Date Error.sleep " + sleep + " ms");
									Thread.sleep(sleep);
									return null;//break;
								}
							}catch(Throwable e) {
								e.printStackTrace();
								dateError = true;
							}
						}
						TotalPage = jsonObj.getJSONObject("pagination").getInteger("TotalPage");
						list = FastJsonUtils.json2List(jsonObj.getString("data"), FontanaBetBoinlottery.class);
					} catch (Exception e) {
						e.printStackTrace();
						logger.error(lstr + "BBbinLottery get data response exception " + e.getMessage(), e);
					}
					if (CollectionUtil.isEmpty(list)) {
						logger.info(lstr + "BBbinLottery game kind (" + gameKind + ") data is empty.");
					}
					Set<String> setName = new HashSet<String>();
					if (!CollectionUtil.isEmpty(list)) {
						for (FontanaBetBoinlottery boinVideo : list) {
							String loginname = removePrefix(boinVideo.getUsername());
							logger.info("BBbinLottery userName:" + loginname);
							if (!"".equals(loginname)) {
								setName.add(loginname);
							}
						}
					}
					List<String> listname=new ArrayList<>(setName);
					if(listname ==null || listname.size()==0) return dealDate(date,1);
					List<FontanaUser> listUser=userMapper.selectListByLoginNames(listname);
					Map<String, FontanaUser> mapUser=new HashMap<>();
					for (FontanaUser user : listUser) {
						mapUser.put(user.getLoginname(), user);
					}
					
					for (FontanaBetBoinlottery boinLottery : list) {
						String loginname = removePrefix(boinLottery.getUsername());
						logger.info(lstr + "BBbinLottery loginname (" + loginname + ") .");
						FontanaUser user = mapUser.get(loginname.toUpperCase());
						if(user != null && user.getId() > 0) {
							//不存在(只判断单号和用户名)和  已结算（带结算时间的接口）的单都覆盖
							if (betlotteryMapper.exists(String.valueOf(boinLottery.getBetnum()), loginname,getBcvalue())<=0 || settled) {
								boinLottery.setUsername(loginname);
								boinLottery.setUid(user.getId());
								boinLottery.setGamebigtype(0);
								String betTime = DateUtils.format(boinLottery.getBettime());
								boinLottery.setBettime(DateUtils.parse(DateTimeUtil.formatDateTime(betTime, "yyyy-MM-dd HH:mm:ss", 0, 0, +12)));
								Date groupfor=settled ? DateUtils.parse(DateTimeUtil.formatDateTime(boinLottery.getModifiedDate(), "yyyy-MM-dd")) : null;
								boinLottery.setGroupfor(groupfor);
								Date Settledtime=settled ? DateUtils.parse(DateTimeUtil.formatDateTime(boinLottery.getModifiedDate(), "yyyy-MM-dd", 0, 0, +12)) : null;
								boinLottery.setSettledtime(Settledtime);
								boinLottery.setParentid(user.getParentid());
								boinLottery.setCid(user.getCid());
								addList.add(boinLottery);
							}
						}
					}
					if (CollectionUtil.isNotEmpty(addList)) {
						betlotteryMapper.insertReplaceRecordBatch(addList);
					}
					if(TotalPage != page && TotalPage != 0) {
						//翻页
						saveLot(game, gameKind, date, settled, page + 1,isupdate);
					}
			   long l2 = System.currentTimeMillis();  
		        System.out.println(lstr + "BbinLottery once  time: "+( l2 - l1));  
		        logger.info("BbinLottery 	once  time: "+( l2 - l1));
		        if(settled && (TotalPage == page || TotalPage == 0) && !dateError) {
		        	if(isupdate) {
		        		logger.info(lstr + "BbinLottery change time,this start time : " +  DateTimeUtil.getFormatDate(dealDate(startD, -1),TIME_FORMAT));
		        		return dealDate(date,1);
		        	}
		        }
			}else {
				try {
					Thread.sleep(sleep);
				}catch(Throwable e) {
					e.printStackTrace();
				}
			}
			return null;
		}
	   public Date saveVideo(Date s,Date d,String start,String end,int page,Date eend){
		   long l1 = System.currentTimeMillis();  
			List<FontanaBetBoinvideo> list = new ArrayList<FontanaBetBoinvideo>();
			List<FontanaBetBoinvideo> addList = new ArrayList<FontanaBetBoinvideo>();
			int TotalPage = 0;
			JSONObject jsonObj;
			try {
				jsonObj = getResponseVedio(s, d, start, end, page);
				String vl=jsonObj.getString("data");
				System.out.println("[SX]Read BY BbinVideo  source :" + vl);
				logger.info("[SX]Read BY BbinVideo  source :" + vl);
				if (jsonObj == null || !"true".equals(jsonObj.getString("result"))) {
					logger.info("[SX]BbinVideo get data response error.");
					Thread.sleep(sleep);
					return null;
				}
				TotalPage = jsonObj.getJSONObject("pagination").getInteger("TotalPage");
				list = FastJsonUtils.json2List(vl, FontanaBetBoinvideo.class);
			} catch (Exception e) {
				logger.error("[SX]BbinVideo get data response exception " + e.getMessage(), e);
			}
			Set<String> setName = new HashSet<String>();
			if (!CollectionUtil.isEmpty(list)) {
				for (FontanaBetBoinvideo boinVideo : list) {
					if(boinVideo.getGameresult()==null||"".equals(boinVideo.getGameresult())){
		        		continue;
		        	}
					if(!boinVideo.getUsername().startsWith(bbinnameprefix)) {
						//非本公司的这段过滤
						logger.info("[sx]BbinVideo other company name (" + boinVideo.getUsername() + ") . settledtime:" + boinVideo.getModifiedDate());
						continue;
					}
					String loginname = removePrefix(boinVideo.getUsername());
					logger.info("FightAllFetch_record userName:" + loginname);
					if (!"".equals(loginname)) {
						setName.add(loginname);
					}
				}
			}
			List<String> listname=new ArrayList<>(setName);
			if(listname ==null || listname.size()==0) return dealDate(eend, 1);
			List<FontanaUser> listUser=userMapper.selectListByLoginNames(listname);
			Map<String, FontanaUser> mapUser=new HashMap<>();
			for (FontanaUser user : listUser) {
				mapUser.put(user.getLoginname(), user);
			}
			if (!CollectionUtil.isEmpty(list)) {
				for (FontanaBetBoinvideo boinVideo : list) {
					String loginname = removePrefix(boinVideo.getUsername());
					boinVideo.setUsername(loginname);
					logger.info("[SX] BbinVideo loginname (" + loginname + ") .");
					FontanaUser user = null;
					if (StringUtils.isNotBlank(loginname)) {
						user = mapUser.get(loginname.toUpperCase());
					}
					try {
						if("0".equals(boinVideo.getResultType())) {//-1表示注销，0表示未结算
							//未结算的单先不入库
							logger.info("[SX]BbinVideo betNum (" + boinVideo.getBetnum() + ") is not finished.");
							continue;
						}		
					} catch (Throwable e) {
						logger.error("[SX]BbinVideo get user by name: " + loginname + " error: " + e.getMessage(), e);
					}
					String strDate=BYType.BYLIVE.getName().equals(BYType.BYLIVE.toString())?DateTimeUtil.formatDateTime(boinVideo.getModifiedDate(), "yyyy-MM-dd HH:mm:ss", 0, 0, +12) : null;
					boinVideo.setModifiedDate(strDate);
					String betTime = DateUtils.format(boinVideo.getBettime());
					boinVideo.setBettime(DateUtils.parse(DateTimeUtil.formatDateTime(betTime, "yyyy-MM-dd HH:mm:ss", 0, 0, +12)));
					boinVideo.setUid(user.getId());
					if(user != null && user.getId() > 0) {
						boinVideo.setUid(user.getId());
						boinVideo.setParentid(user.getParentid());
						boinVideo.setCid(user.getCid());
						addList.add(boinVideo);
					}
				}
				if (CollectionUtil.isNotEmpty(addList)) {// 要添加到数据库的数据
					betvideoMapper.insertReplaceRecordBatch(addList);
					//判断数据是否溢出，翻页
					if(TotalPage != page && TotalPage != 0) {
						//翻页
						saveVideo(s, d, start, end, page + 1, eend);
					}
				}
			   long l2 = System.currentTimeMillis();  
		        System.out.println("[sx]BbinVideo once  time: "+( l2 - l1));  
		        logger.info("[sx]BbinVideo 	once  time: "+( l2 - l1));
			}else {
				logger.info("[SX]BbinVideo game  data is empty.");
			}
			if(TotalPage == page || TotalPage == 0) {
				return dealDate(eend, 1);//DateTimeUtil.getFormatDate(dealDate(eend, 1), TIME_FORMAT);
			}
			return null;
	    }
	   /***
	     * 视讯专用，只拿已结算
	     * @param start
	     * @param end
	     * @param starttime
	     * @param endtime
	     * @param page
	     * @param kind
	     * @param code
	     * @return
	     * @throws InterruptedException
	     */
	    public JSONObject getResponseVedio(Date start,Date end, String starttime, String endtime,int page) throws InterruptedException {
			logger.info(" [sx]BbinVideo fetch date :" + DateFormatUtils.format(start, DATE_FORMAT) + starttime + " ~ " + DateFormatUtils.format(end, DATE_FORMAT));
			logger.info(" [sx]BbinVideo page " + page);
	    	JSONObject jsonObj =bbinService.betRecordModifiedLive(start, end, starttime, endtime, page);
	    	if (jsonObj!=null&&!"".equals(jsonObj.getString("data"))&&String.valueOf(jsonObj).indexOf("Now the API is busy")>0) {
		    	Thread.sleep(time);
		    	System.out.println("[sx]Now the API is busy 5m after again requst!");
		    	jsonObj =bbinService.betRecordModifiedLive(start, end, starttime, endtime, page);//重试调用一次
			}
	    	return jsonObj;
	    }
	    /**
	     * 读取已结算的单
	     * @param start
	     * @param end
	     * @param page
	     * @param code
	     * @return
	     * @throws InterruptedException
	     */
	    public JSONObject getResponseSettled(Date start, Date end,int page,BBinGameKind kind,String code) throws InterruptedException {
	    	logger.info(" BbinLottery rounddate "+DateFormatUtils.format(start, dateTimePattern) + " ~ " + DateFormatUtils.format(end, dateTimePattern));
			logger.info(" BbinLottery page "+page);
			
			logger.info(" BbinLottery code "+code);
	    	JSONObject jsonObj=null;
	    	//彩票通过结算时间查询
	    	jsonObj = bbinService.betRecordModifiedBet(start, end, page,kind, code);
	    	if (jsonObj!=null&&!"".equals(jsonObj.getString("data"))&&String.valueOf(jsonObj).indexOf("Now the API is busy")>0) {
		    	Thread.sleep(time);
		    	logger.info("Now the API is busy 5m after again requst!");
		    	System.out.println("Now the API is busy 5m after again requst!");
		    	jsonObj = bbinService.betRecordModifiedBet(start, end, page, kind, code);//重试调用一次
			}
	    	return jsonObj;
	    }
	/**
	 * 获取结束时间
	 * @param lastDate
	 * @param now
	 * @return
	 */
	public static Date dealDate(Date lastDate ,int min) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(lastDate);
		calendar.add(Calendar.MINUTE, min);
		return calendar.getTime();
	}
	/**
	 * 获取美东时间的日期格式
	 * @return
	 */
	public static String getAEDate(Date d){
		String mdTime=DateFormatUtils.format(d, dateTimePattern, TimeZone.getTimeZone(AETimeZone));
		return mdTime;
	}
	
	/**
	 * 获取时间时分秒
	 * 
	 * @return
	 */
	public static String getSFMTime(String time) {
		String[] arr = time.split("\\s+");
		return arr[1];
	}
	
	public static String removePrefix(String username) {
		if (username.startsWith(prefix) || username.startsWith(prefix.toUpperCase())) {
			username = username.substring(prefix.length());
			// System.out.println("first substring: "+username);
			if (username.startsWith(prefix2) || username.startsWith(prefix2.toUpperCase())) {
				username = username.substring(prefix2.length());
				// System.out.println("second substring: "+username);
			}
		}
		return username;
	}
    public JSONObject getResponse(Date rounddate, String starttime, String endtime,int page,BBinGameKind kind,String code) throws InterruptedException {
    	logger.info(" BbinLottery rounddate "+rounddate);
		logger.info(" BbinLottery gameKind "+starttime);
		logger.info(" BbinLottery endtime "+endtime);
		logger.info(" BbinLottery page "+page);
		logger.info(" BbinLottery code "+code);
    	JSONObject jsonObj =bbinService.betRecord(rounddate,starttime, endtime,page,kind,code);
	    if (jsonObj!=null&&!"".equals(jsonObj.getString("data"))&&String.valueOf(jsonObj).indexOf("Now the API is busy")>0) {
	    	Thread.sleep(time);
	    	logger.info("Now the API is busy 5m after again requst!");
	    	System.out.println("Now the API is busy 5m after again requst!");
	    	jsonObj =bbinService.betRecord(rounddate,starttime, endtime,page,kind,code);//重试调用一次
		}
    	return jsonObj;
    }
	
	public static void main(String[] args) {
		/*Date date = new Date();
		Date now = new Date();
		Date startD = dealDate(date, -2);// 计算开始时分秒
		Date endD =  dealDate(startD,1);// getEndTime(date, now);// 计算结束时分秒
		DateFormat df = new SimpleDateFormat(dateTimePattern);
		logger.info("[LOT Y]this fetch time :" + df.format(startD) + " ~ " + df.format(endD));
		int page=1;
			//给抓普通票计算具体的美东  日期，和时间
		String md = getAEDate(startD);//计算美东时间
		Date d = DateTimeUtil.getFormatDate(md, DATE_FORMAT );
		String start1 = getAEDate(startD);
		String end = getAEDate(endD);
		String start = start1;
		String game="OTHER";
		String gameKind="3";
//		JSONObject obj=BbinBetRemoteService.betRecordModifiedLive(s, d, getSFMTime(sd), getSFMTime(md), 1);
//		List<FontanaBetBoinvideo> list = FastJsonUtils.json2List(obj.getString("data"), FontanaBetBoinvideo.class);
		Object jsonObj="";
		try {
			jsonObj = getResponse(d, getSFMTime(start), getSFMTime(end), page,BBinGameKind.getBBinGameKindByCode(Integer.valueOf(gameKind)), game);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(JSONObject.toJSONString(jsonObj));*/
	}
}
