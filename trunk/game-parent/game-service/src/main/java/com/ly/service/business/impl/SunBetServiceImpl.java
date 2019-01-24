package com.ly.service.business.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.common.util.DateTimeUtil;
import com.ly.game.mapper.FontanaBetSunbetMapper;
import com.ly.game.mapper.FontanaFetchdateMapper;
import com.ly.game.mapper.FontanaUserMapper;
import com.ly.game.model.FontanaBetSunbet;
import com.ly.game.model.FontanaFetchdate;
import com.ly.game.model.FontanaUser;
import com.ly.service.business.SunberBetService;
import com.ly.service.game.impl.BasecodeServiceImpl;
import com.ly.service.remote.SunBetRemoteService;

@Service
public class SunBetServiceImpl extends BasecodeServiceImpl implements SunberBetService{
	private final static Logger logger =  LoggerFactory.getLogger(SunBetServiceImpl.class);
	@Autowired
	FontanaFetchdateMapper fetchMapper;

	@Autowired
	FontanaBetSunbetMapper betMapper;
	
	@Autowired
	FontanaUserMapper userMapper;
	
	@Autowired
	SunBetRemoteService sunService;
	
	private final String gametype="Sunbet";
	
	public long sleep = 60000L;//每分钟同步一次
	
	public static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void loadingRemoteGameData() {
		// TODO 抓票并插入数据库
		fetchSB(null,true);
	}
	public void fetchSB(Integer versionKey,boolean isUpdate) {
		FontanaFetchdate record=fetchMapper.selectByPrimaryGametype(gametype);
		long start = System.currentTimeMillis();
		Date syncdate;
		if(record == null){
			logger.info("GET SUNCDATE,IT'S ONLY FIRSTTIME TO GET");
			//从数据库获取开始同步的时间
			syncdate = new Date();
		}else{
			syncdate=record.getEtchstarttime();
			logger.info("SYNCDATE:" + sdf1.format(syncdate));
			//判断时间是否大于今年,为了防止时间获取出错
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(syncdate);
			int synyear = calendar.get(Calendar.YEAR);
			
			Calendar cnew = Calendar.getInstance();
			cnew.setTime(new Date());
			int ynew = cnew.get(Calendar.YEAR);
			
			if(synyear != ynew){
				logger.info("GET SUNCDATE YEAR ERROR!,GET SYNCDATE AGAIN");
				//重新获取读取时间
				syncdate = record.getEtchstarttime();
			}else{
				Date now = new Date();
				if((now.getTime() - syncdate.getTime()) > (1 * 60 * 1000)){
					//当前时间与抓票时间相差超过5分钟，需要调整抓票间隔
					sleep = 10000l;//10秒判断一次
				}else{
					sleep = 60000l;//恢复正常的一分钟
				}
				if((now.getTime() - syncdate.getTime()) > (1 * 60 * 1000)){
					//当前时间与抓票开始时间相差一定要超过2分钟，才能执行同步，不然需要等待
					try {
						long syncmil = syncdate.getTime();
						Date enddate = new Date();
						enddate.setTime(syncmil);
						enddate = dealDate(enddate, 1);
						Date ts = dealDate(enddate, -5);
						Date te = dealDate(enddate, -4);
						//先同步5分钟前的，怕有漏抓,同步线程不改时间
						Date date=doSaveData(ts, te, true);
						if(date!=null) {
							record.setEtchstarttime(date);
							fetchMapper.updateByPrimaryKeySelective(record);
						}
						//正常同步
						Date date1=doSaveData(syncdate, enddate, false);
						if(date!=null) {
							record.setEtchstarttime(date1);
							fetchMapper.updateByPrimaryKeySelective(record);
						}
//						
					} catch (Throwable e) {
						e.printStackTrace();
					}
//					try {
//						Thread.sleep(sleepMill);
//					} catch (Exception ex) {
//						ex.printStackTrace();
//					}
					long end = System.currentTimeMillis();
					logger.info("This SunbetFetch" + (end - start) + "ms");
					//GenUtil.close(con1);
				}else{
					//间隔小于15分钟，等待
//					try {
//						Thread.sleep(sleep);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}
			}
		}
	}
	public static void main(String[] args) {
//		Date date=new Date();
//		Date ts = dealDate(date, -15);
//		Date te = dealDate(date, -1);
//		String hh=SunbetBetRemoteService.getBet(ts,te);
//		System.out.println(hh);
	}
	public Date doSaveData(Date start, Date end, boolean f) {
		String c = f ? "[async]" : "[main]";
		String result = sunService.getBet(start, end);
		logger.info(c + "THIS FETCH JSON:" + result);
		if (!result.equals("")) {
			final List<FontanaBetSunbet> listHtml = parseHTML(result);
			if (listHtml != null && listHtml.size()>=1) {
				Set<String> setName=new HashSet<>();
				for (FontanaBetSunbet sun : listHtml) {
					String loginName = sun.getUsername();// 如果用户不存在的话，不入库
					logger.info("SunberBetServiceImpl userName:" + loginName);
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
				if(listname.size()==0) {
					return dealDate(start, 1);
				}
				List<FontanaUser> listUser=userMapper.selectListByLoginNames(listname);
				Map<String, FontanaUser> mapUser=new HashMap<>();
				for (FontanaUser user : listUser) {
					mapUser.put(user.getLoginname(), user);
				}
				List<FontanaBetSunbet> listSunbet=new ArrayList<>();
				for (FontanaBetSunbet sun : listHtml) {
					String loginName = sun.getUsername();// 如果用户不存在的话，不入库
					if(loginName==null || loginName.equals("")) {
						continue;
					}
					FontanaUser user=mapUser.get(loginName.toUpperCase());
					if(user==null||user.getId()== 0) {
						continue;
					}
					sun.setParentid(user.getCid().intValue());
					listSunbet.add(sun);
				}
				logger.info(c + "THIS RESULT SIZE:" + listSunbet.size());
				if (listSunbet.size() > 0) {
					try {
						betMapper.insertReplaceRecordBatch(listSunbet);
					} catch (Exception ex) {
						ex.printStackTrace();
						logger.info(c + "EXEC ERROR:" + ex.getMessage());
					} finally {
						if (!f) {
							return dealDate(start, 1);
						}
					}
				} else {
					if (!f) {
						return dealDate(start, 1);
					}
				}
			}
		} else {
			// 返回空字符串（可能是请求超时，请求失败，签名校验不通过等情况），隔10s再请求一次
			try {
				Thread.sleep(10000); // 当获取超时，服务器维护等出错情况，隔10s再次执行
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return start;
		}
		return dealDate(start, 1);
	}

	// 字段的位置
	private static int UGSBETID = 0;
	private static int TXID = 1;// 来自游戏的交易或投注的标识符
	private static int BETID = 2;// 投注编号
	private static int BETON = 3;// 这个赌注的时间和在TGP记录服务器，包括时区
	private static int BETCLOSEDON = 4;// 这个赌注关闭的时间，包括时区
	private static int BETUPDATEDON = 5;// 这个赌注更新的时间（结算时间），包括时区
	private static int TIMESTAMP = 6;// 从游戏传出的外部时间戳提供商，包括时区
	private static int ROUNDID = 7;// 游戏提供者的身份识别码游戏交易发生。 所有交易都是按轮分组
	private static int ROUNDSTATUS = 8;// 注单状态New，Open,Closed
	private static int USERID = 9;// 用户ID
	private static int USERNAME = 10;// 用户名
	private static int RISKAMT = 11;// 金额下注的风险
	private static int WINAMT = 12;// 下注金额。
	private static int WINLOSS = 13;// 净赌注（winamt-riskamt）
	private static int BEFOREBAL = 14;// 玩家在这个赌注之前的余额的金额交易
	private static int POSTBAL = 15;// 此赌注后玩家余额的金额
	private static int CUR = 16;// 货币
	private static int GAMEPROVIDER = 17;// 游戏提供商
//	private static int GAMEPROVIDERCODE = 18;// 游戏提供商code
	private static int GAMENAME = 19;// 游戏名称
	private static int GAMEID = 20;// 游戏ID
	private static int PLATFORMTYPE = 21;// 游戏平台Desktop，Mobile
	private static int IPADDRESS = 22;// IP地址
	private static int BETTYPE = 23;// 游戏动作的类型，永远为PlaceBet
	private static int PLAYTYPE = 24;// 玩游戏类型，由游戏提供商定义
//	private static int PLAYERTYPE = 25;// 玩家类型，1：真实玩家，2：测试玩家
//	private static int TURNOVER = 26;// 总投注额。 这是一个正数
	private static int VALIDBETE = 27;// 有效投注额
		/**
		 * 解析HTML对象
		 * @param html文本
		 * @return
		 */
		public List<FontanaBetSunbet> parseHTML(String html) {
			if(html.equals(""))
				return null;
//			List<StringBuilder> list = new LinkedList<StringBuilder>();//注单数据
			List<FontanaBetSunbet> listBet=new ArrayList<>();
			try {
				//数据格式是，列头   + 换行 +  数据1 +  换行 + 数据2 + ...
				String[] items = html.split("\n");
				if(items.length > 1){
					//排除掉第一行，因为第一行是列头，没有实际意义
			        for (int i = 0;i < items.length;i ++) {
			        	if(i == 0){
			        		continue;//跳过第一行（列头）
			        	}
			        	FontanaBetSunbet sunInto=new FontanaBetSunbet();
			        	//拼接语句
			        	try {
			        		String[] child = items[i].split(",");
			        		String ugsbetid = child[UGSBETID];
			        		int hasBet = betMapper.exists(ugsbetid,getBcvalue());
				        	if(hasBet>=1) {
				        		logger.info("单号" + ugsbetid + "已存在");
				        		continue;
				        	}
			        		sunInto.setUgsbetid(ugsbetid);
			        		String txid = child[TXID];
			        		sunInto.setTxid(txid);
			        		String betid = child[BETID];
			        		sunInto.setBetid(betid);
			        		String beton = child[BETON];
			        		sunInto.setBeton(toUTC8(beton).equals("") ? null :  toUTC8(beton) );
			        		String betclosedon = child[BETCLOSEDON];
			        		sunInto.setBetclosedon(toUTC8(betclosedon).equals("") ? null : toUTC8(betclosedon));
			        		String betupdatedon = child[BETUPDATEDON];
			        		sunInto.setBetupdatedon(toUTC8(betupdatedon).equals("") ? null :  toUTC8(betupdatedon) );
			        		String timestamp = child[TIMESTAMP];
			        		Date betTime = toUTC8(timestamp);
			        		String gameprovider = child[GAMEPROVIDER];
			        		sunInto.setGameplatformchild(gameprovider.equals("Sunbet") ? "SBSX" : "SBDZ");
		        			if(gameprovider != null && gameprovider.equalsIgnoreCase("Laxino")) {
		        				betTime = toUTC8(betclosedon);
		        			}
			        		sunInto.setTimestamp(betTime);
			        		String roundid = child[ROUNDID];
			        		sunInto.setRoundid(roundid);
			        		String roundstatus = child[ROUNDSTATUS];
			        		sunInto.setRoundstatus(roundstatus);
			        		String userid = child[USERID];
			        		sunInto.setUserid(Long.valueOf(userid));
			        		double riskamt = Math.abs(Double.parseDouble(child[RISKAMT] == null ? "0" : child[RISKAMT]));
			        		sunInto.setRiskamt(new BigDecimal(riskamt));
			        		String winamt = child[WINAMT];
			        		sunInto.setWinamt(new BigDecimal(winamt));
			        		String winloss = child[WINLOSS];
			        		sunInto.setWinloss(new BigDecimal(winloss));
			        		String beforebal = child[BEFOREBAL];
			        		sunInto.setBeforebal(new BigDecimal(beforebal));
			        		String postbal = child[POSTBAL];
			        		sunInto.setPostbal(new BigDecimal(postbal));
			        		String cur = child[CUR];
			        		sunInto.setCur(cur);
			        		sunInto.setGroupfor(DateTimeUtil.formatDateTime(toDate(toUTC8(beton)),"yyyy-MM-dd", 0, 0, -12));
			        		String gamename = child[GAMENAME];
			        		sunInto.setGamename(gamename.replace("'", ""));
			        		sunInto.setCreatetime(new Date());
			        		String gameid = child[GAMEID];
			        		sunInto.setGameid(gameid);
			        		String platformtype = child[PLATFORMTYPE];
			        		sunInto.setGameplatformtype(platformtype);
			        		String ipaddress = child[IPADDRESS];
			        		sunInto.setIpaddress(ipaddress);
			        		String bettype = child[BETTYPE];
			        		sunInto.setBettype(bettype);
			        		String playtype = child.length > 23 ?  child[PLAYTYPE] : "";
			        		sunInto.setPlaytype(playtype);
			        		double validbet = Math.abs(Double.parseDouble(child[VALIDBETE] == null ? "0" : child[VALIDBETE]));
			        		sunInto.setValidbet(validbet);
			        		String username = child[USERNAME];
			        		sunInto.setUsername(username);
			        		sunInto.setGameplatformid("SB");
			        		//构建新增对象list
			        		listBet.add(sunInto);
			        		
			        		
			        		
			        		/*UserImpl userImpl = null;
		        			userImpl = UserManager.getInstance().getUserByLoginname(username);
		        			if(userImpl == null){
		        				logger.info("parseHTML user["+username+"] is not exit.");
		        				continue;
		        			}
		        			if(userImpl.getId() == 0){
		        				logger.info("parseHTML user["+username+"] id is 0.");
		        				continue;
		        			}
				        	//平台收集时间当前服务器时间
				        	String createtime = sdf1.format(new Date());
				        	boolean hasBet = isExsit(ugsbetid);
				        	if(hasBet)
				        		logger.info("单号" + ugsbetid + "已存在");
				        	
			        		if (userImpl != null && !hasBet) {
			        			String betTime = toUTC8(timestamp);
			        			if(gameprovider != null && gameprovider.equalsIgnoreCase("Laxino")) {
			        				betTime = toUTC8(betclosedon);
			        			}
			        			//主表
			        			StringBuilder sb = new StringBuilder();
				        		sb.append("(");
				        		sb.append("'").append(userImpl.getCid()).append("',");
				        		sb.append("'").append(ugsbetid).append("',");
				        		sb.append("'").append(txid).append("',");
				        		sb.append("'").append(betid).append("',");
				        		
				        		sb.append(toUTC8(beton).equals("") ? "null" : "'" + toUTC8(beton) + "'").append(",");
				        		sb.append(toUTC8(betclosedon).equals("") ? "null" : "'" + toUTC8(betclosedon) + "'").append(",");
				        		sb.append(toUTC8(betupdatedon).equals("") ? "null" : "'" + toUTC8(betupdatedon) + "'").append(",");
				        		sb.append("".equals(betTime) ? "null" : "'" + betTime + "'").append(",");
				        		
//				        		sb.append("'").append(toUTC8(beton)).append("',");
//				        		sb.append("'").append(toUTC8(betclosedon)).append("',");
//				        		sb.append("'").append(toUTC8(betupdatedon)).append("',");
//				        		sb.append("'").append(toUTC8(timestamp)).append("',");
//				        		System.out.println("before beton:"+beton+"betclosedon:"+betclosedon+"timestamp:"+timestamp+"betupdatedon:"+betupdatedon);
				        		logger.info("before beton:"+beton+"betclosedon:"+betclosedon+"timestamp:"+timestamp+"betupdatedon:"+betupdatedon);
//				        		System.out.println("after beton:"+toUTC8(beton)+"betclosedon:"+toUTC8(betclosedon)+"timestamp:"+toUTC8(timestamp)+"betupdatedon:"+toUTC8(betupdatedon));
				        		logger.info("after beton:"+toUTC8(beton)+"betclosedon:"+toUTC8(betclosedon)+"timestamp:"+toUTC8(timestamp)+"betupdatedon:"+toUTC8(betupdatedon));
				        		sb.append("'").append(roundid).append("',");
				        		sb.append("'").append(roundstatus).append("',");
				        		sb.append("'").append(userid).append("',");
				        		sb.append("'").append(username).append("',");
				        		sb.append("'").append(riskamt).append("',");
				        		sb.append("'").append(winamt).append("',");
				        		sb.append("'").append(winloss).append("',");
				        		sb.append("'").append(beforebal).append("',");
				        		sb.append("'").append(postbal).append("',");
				        		sb.append("'").append(cur).append("',");
				        		sb.append("'").append(gameprovider).append("',");
				        		sb.append("'").append(gamename.replace("'", "")).append("',");
				        		sb.append("'").append(gameid).append("',");
				        		sb.append("'").append(platformtype).append("',");
				        		sb.append("'").append(ipaddress).append("',");
				        		sb.append("'").append(bettype).append("',");
				        		sb.append("'").append(playtype).append("',");
				        		sb.append("'").append(createtime).append("',");
				        		sb.append("'").append("SB").append("',");//申博游戏
				        		//如果游戏提供商是申博，那类型为申博视讯，否则为申博电子
				        		sb.append("'").append(gameprovider.equals(GameType.Sunbet.toString()) ? "SBSX" : "SBDZ").append("',");
				        		sb.append("'").append(DateTimeUtil.formatDateTime(toUTC8(beton),"yyyy-MM-dd", 0, 0, -12)).append("',");
				        		sb.append("'").append(validbet).append("')");
				        		list.add(sb);
			        		}*/
			        		
			        	} catch (Exception ex) {
			        		ex.printStackTrace();
			        	}
			        }
				}
				return listBet;
			} catch (Throwable ex) {
				ex.printStackTrace();
				return null;
			}
		}
		/***
		 * 处理时间
		 * @param date
		 * @param min
		 * @return
		 */
		public static Date dealDate(Date date,int min){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MINUTE, min);
			return calendar.getTime();
			
		}
		public static Date toDate(String dt){
			SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date d=null;
			try {
				d = df1.parse(dt);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return d;
		}
		public static String toDate(Date dt){
			SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String d = df1.format(dt);
			return d;
		}
		/***
		 * 将UTC转成本地时间
		 * @param dt UTC时间字符串
		 * @return
		 */
		public static Date toUTC8(String dt){
			if(dt == null || dt.equals(""))
				return null;
			try {
				if(dt.length() > 19)
					dt = dt.substring(0,19);
				SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				Date d = df1.parse(dt);
				Calendar calendar = Calendar.getInstance();  
				calendar.setTime(d);
//				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return calendar.getTime();
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}

	 

}
