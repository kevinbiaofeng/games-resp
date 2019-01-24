package com.ly.common.gameutil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

public enum GameType {
	Casino{
		String cname = "真人游戏";
		String tablename="FONTANA_BET_CASINO";
		int code =202;
		public int code(){return code;}
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	},CasinoVip{
		String cname = "真人VIP";
		int code =202;
		public int code(){return code;}
		String tablename="FONTANA_BET_CASINO";
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	},Fight{
		String cname = "对战游戏";
		String tablename="FONTANA_BETFIGHT";
		int code =518;
		public int code(){return code;}
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	},Sports{
		String cname = "金宝博体育";
		String tablename="FONTANA_BET_SPORT";
		int code =201;
		public int code(){return code;}
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	},Slot{
		String cname = "电子游戏";
		String tablename="FONTANA_BET_SLOT";
		int code =203;
		public int code(){return code;}
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	},Video{
		String cname = "VG游戏";
		String tablename="FONTANA_BET_VIDEO";
		int code = 800;
		public int code(){return code;}
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	},MgSlot{
		String cname = "MG电子";
		String tablename="FONTANA_BET_EGAME";
		int code = 900;
		public int code(){return code;}
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	},Lottery{
		String cname = "彩票游戏";
		String tablename="FONTANA_BET_LOTTERY";
		int code = 700;
		public int code(){return code;}
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	},Sunbet{
		String cname = "申博游戏";
		String tablename="FONTANA_BET_SUNBET";
		int code = 200;
		public int code(){return code;}
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	},AllBet{
        String cname = "欧博游戏";
        String tablename="FONTANA_BET_ALLBET";
        int code = 400;
        public int code(){return code;}
        public String tablename(){return tablename;}
        public String cname(){return cname;}
        public void setCname(String cname){this.cname = cname;}
    },PTGame{
        String cname = "PT游戏";
        String tablename="FONTANA_BET_PTGAME";
        int code = 1000;
        public int code(){return code;}
        public String tablename(){return tablename;}
        public String cname(){return cname;}
        public void setCname(String cname){this.cname = cname;}
    },WGGame{
        String cname = "WG游戏";
        String tablename="FONTANA_BET_WGGAME";
        int code = 1100;
        public int code(){return code;}
        public String tablename(){return tablename;}
        public String cname(){return cname;}
        public void setCname(String cname){this.cname = cname;}
    },BYGame{
        String cname = "BY游戏";
        String tablename="FONTANA_BET_BYGAME";
        int code = 1200;
        public int code(){return code;}
        public String tablename(){return tablename;}
        public String cname(){return cname;}
        public void setCname(String cname){this.cname = cname;}
    },Kaga{
        String cname = "KA游戏";
        String tablename="FONTANA_BET_KAGA";
        int code = 1300;
        public int code(){return code;}
        public String tablename(){return tablename;}
        public String cname(){return cname;}
        public void setCname(String cname){this.cname = cname;}
    },OneWorks{
        String cname = "沙巴体育";
        String tablename="FONTANA_BET_ONEWORKS";
        int code = 1400;
        public int code(){return code;}
        public String tablename(){return tablename;}
        public String cname(){return cname;}
        public void setCname(String cname){this.cname = cname;}
    },CQ9{
        String cname = "CQ9游戏";
        String tablename="FONTANA_BET_CQ9";
        int code = 1500;
        public int code(){return code;}
        public String tablename(){return tablename;}
        public String cname(){return cname;}
        public void setCname(String cname){this.cname = cname;}
    },PT2{
        String cname = "PT2游戏";
        String tablename="FONTANA_BET_PT2";
        int code = 1600;
        public int code(){return code;}
        public String tablename(){return tablename;}
        public String cname(){return cname;}
        public void setCname(String cname){this.cname = cname;}
    },LYLot{
        String cname = "LY彩票";
        String tablename="FONTANA_BET_LYLot";
        int code = 1700;
        public int code(){return code;}
        public String tablename(){return tablename;}
        public String cname(){return cname;}
        public void setCname(String cname){this.cname = cname;}
    },FG{
        String cname = "FG游戏";
        String tablename="FONTANA_BET_FG";
        int code = 1800;
        public int code(){return code;}
        public String tablename(){return tablename;}
        public String cname(){return cname;}
        public void setCname(String cname){this.cname = cname;}
    },BJ{
        String cname = "轰达彩票";
        String tablename="FONTANA_BET_BJ";
        int code = 1900;
        public int code(){return code;}
        public String tablename(){return tablename;}
        public String cname(){return cname;}
        public void setCname(String cname){this.cname = cname;}
    },IM{
		String cname = "皇冠体育";
		String tablename="FONTANA_BET_IM";
		int code = 2000;
		public int code(){return code;}
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	},SS{
		String cname = "皇冠三昇";
		String tablename="FONTANA_BET_SS";
		int code = 2100;
		public int code(){return code;}
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	},MW{
		String cname = "MW大满贯";
		String tablename="FONTANA_BET_MW";
		int code = 2200;
		public int code(){return code;}
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	},VCS{
		String cname = "VCS主播客服";
		String tablename="FONTANA_BET_VCS";
		int code = 2400;
		public int code(){return code;}
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	},JDB{
		String cname = "JDB电子";
		String tablename="FONTANA_BET_JDB";
		int code = 2500;
		public int code(){return code;}
		public String tablename(){return tablename;}
		public String cname(){return cname;}
		public void setCname(String cname){this.cname = cname;}
	};
	public static final char  taglimitchar[] = {'V','W','Z','B','D','H','J','K','M'};
	public static final String taglimitcount[] = {"10-1000","50-2000","50-5000","100-10000","500-20000","1000-50000","2000-100000","3000-150000","5000-200000"};
	public abstract String cname();
	public abstract int code();
	public abstract String tablename();
	public abstract void setCname(String cname);
	
	//是否有效类型
	public static boolean isValidType(String type)
	{
		for(GameType gt : GameType.values()){
			if(gt.name().equals(type.trim()))
			{
				return true;
			}
		}
		return false;
	}
	
	public static GameType getGameType(String type)
	{
		for(GameType gt : GameType.values()){
			if(gt.name().equals(type.trim()))
			{
				return gt;
			}
		}
		return null;
	}

	static List<Map<String,String>> result = new ArrayList<Map<String,String>>();
	static{
		for(GameType gt : GameType.values()){
			Map<String,String> map = new HashMap<String,String>();
			map.put("id",gt.name());
			map.put("text",gt.cname());
			result.add(map);
		}
	}
	public static List<Map<String,String>>  getGameTypeList(){
		return result;
	}
	
	public static void main(String args[]){
		boolean ax = true;
		MISC:
		{
			if(ax){
				ax = false;
				break MISC;
			}
			System.out.print("li mian");
		
			
		}
		System.out.print("wai mian");
	}
}
