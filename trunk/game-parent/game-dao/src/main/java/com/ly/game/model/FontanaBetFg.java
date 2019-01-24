package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class FontanaBetFg implements Serializable {

    /** 订单号 */
    @JSONField(name ="id")
    private String betnum;

    /** 用户id */
    private Long uid;

    /** 用户名 */
    @JSONField(name ="nickname")
    private String username;

    /** 公司id */
    private Long cid;

    /** 下注时间 */
    private Date bettime;

    /** 下注金额 */
    @JSONField(name ="bullet_chips")
    private Double betamount;

    /** 有效投注额 */
    private Double validamount;

    /** 输赢金额 */
    private Double result;

    /** groupfor */
    private Date groupfor;

    /** 大股东id */
    private Long pid;

    /** 股东id */
    private Long gid;

    /** 总代理id */
    private Long aid;

    /** 代理id */
    private Long sid;

    /** 游戏id */
    @JSONField(name ="game_id")
    private Integer gameid;

    /** 游戏name */
    private String gamename;

    /** 注单类型 */
    private Integer type;

    /** 总奖金 */
    @JSONField(name ="fish_dead_chips")
    private Double fishdeadchips;

    /** 场景id */
    @JSONField(name ="scene_id")
    private Integer sceneid;

    /** 幸运金 */
    @JSONField(name ="fish_price")
    private Integer fishprice;

    /** 子弹个数 */
    @JSONField(name ="bullet_count")
    private Integer bulletcount;

    /** 终端类型 */
    @JSONField(name ="game_terminal")
    private Integer gameterminal;

    /** 开始筹码 */
    @JSONField(name ="start_chips")
    private Double startchips;

    /** 结束筹码 */
    @JSONField(name ="end_chips")
    private Double endchips;

    /** 玩家赢得jackpot奖金 */
    @JSONField(name ="trans_chips")
    private Double tranships;

    /**
     * 开始时间
     */
    @JSONField(name ="start_time")
    private long sTime;
    
    /** 开始时间 */
    private Date starttime;
    /**
     * 结束时间
     */
    @JSONField(name ="end_time")
    private long eTime;
    /** 结束时间 */
    private Date endtime;

    /** 代理商id */
    @JSONField(name ="agent_uid")
    private Integer agentuid;

    /** 总社id */
    @JSONField(name ="top_agent_uid")
    private Integer topagentuid;

    /** 总代理id */
    @JSONField(name ="total_agent_uid")
    private Integer totalagentuid;

    /** 贡献保留4位小数 */
    @JSONField(name ="jp_add")
    private Double jpadd;

    /** 捕获鱼的编码 */
    @JSONField(name ="order_id")
    private int orderid;

    /** 买鱼时间 */
    @JSONField(name ="buy_time")
    private Long btime;
    
    private Date buytime;

    /** 房间id */
    @JSONField(name ="room_id")
    private int roomid;

    /** 房间倍率 */
    @JSONField(name ="room_type")
    private double roomtype;

    /** 来源 */
    private String source;

    private static final long serialVersionUID = 1L;

    public Long getBtime() {
		return btime;
	}

	public void setBtime(Long btime) {
		this.btime = btime;
	}

	public long getsTime() {
		return sTime;
	}

	public void setsTime(long sTime) {
		this.sTime = sTime;
	}

	public long geteTime() {
		return eTime;
	}

	public void seteTime(long eTime) {
		this.eTime = eTime;
	}

	public String getBetnum() {
        return betnum;
    }

    public void setBetnum(String betnum) {
        this.betnum = betnum == null ? null : betnum.trim();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Date getBettime() {
        return bettime;
    }

    public void setBettime(Date bettime) {
        this.bettime = bettime;
    }

    public Double getBetamount() {
        return betamount;
    }

    public void setBetamount(Double betamount) {
        this.betamount = betamount;
    }

    public Double getValidamount() {
        return validamount;
    }

    public void setValidamount(Double validamount) {
        this.validamount = validamount;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Date getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(Date groupfor) {
        this.groupfor = groupfor;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Integer getGameid() {
        return gameid;
    }

    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getFishdeadchips() {
        return fishdeadchips;
    }

    public void setFishdeadchips(Double fishdeadchips) {
        this.fishdeadchips = fishdeadchips;
    }

    public Integer getSceneid() {
        return sceneid;
    }

    public void setSceneid(Integer sceneid) {
        this.sceneid = sceneid;
    }

    public Integer getFishprice() {
        return fishprice;
    }

    public void setFishprice(Integer fishprice) {
        this.fishprice = fishprice;
    }

    public Integer getBulletcount() {
        return bulletcount;
    }

    public void setBulletcount(Integer bulletcount) {
        this.bulletcount = bulletcount;
    }

    public Integer getGameterminal() {
        return gameterminal;
    }

    public void setGameterminal(Integer gameterminal) {
        this.gameterminal = gameterminal;
    }

    public Double getStartchips() {
        return startchips;
    }

    public void setStartchips(Double startchips) {
        this.startchips = startchips;
    }

    public Double getEndchips() {
        return endchips;
    }

    public void setEndchips(Double endchips) {
        this.endchips = endchips;
    }

    public Double getTranships() {
        return tranships;
    }

    public void setTranships(Double tranships) {
        this.tranships = tranships;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getAgentuid() {
        return agentuid;
    }

    public void setAgentuid(Integer agentuid) {
        this.agentuid = agentuid;
    }

    public Integer getTopagentuid() {
        return topagentuid;
    }

    public void setTopagentuid(Integer topagentuid) {
        this.topagentuid = topagentuid;
    }

    public Integer getTotalagentuid() {
        return totalagentuid;
    }

    public void setTotalagentuid(Integer totalagentuid) {
        this.totalagentuid = totalagentuid;
    }

    public Double getJpadd() {
        return jpadd;
    }

    public void setJpadd(Double jpadd) {
        this.jpadd = jpadd;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Double getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Double roomtype) {
        this.roomtype = roomtype;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FontanaBetFg other = (FontanaBetFg) that;
        return (this.getBetnum() == null ? other.getBetnum() == null : this.getBetnum().equals(other.getBetnum()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getBettime() == null ? other.getBettime() == null : this.getBettime().equals(other.getBettime()))
            && (this.getBetamount() == null ? other.getBetamount() == null : this.getBetamount().equals(other.getBetamount()))
            && (this.getValidamount() == null ? other.getValidamount() == null : this.getValidamount().equals(other.getValidamount()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getGameid() == null ? other.getGameid() == null : this.getGameid().equals(other.getGameid()))
            && (this.getGamename() == null ? other.getGamename() == null : this.getGamename().equals(other.getGamename()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getFishdeadchips() == null ? other.getFishdeadchips() == null : this.getFishdeadchips().equals(other.getFishdeadchips()))
            && (this.getSceneid() == null ? other.getSceneid() == null : this.getSceneid().equals(other.getSceneid()))
            && (this.getFishprice() == null ? other.getFishprice() == null : this.getFishprice().equals(other.getFishprice()))
            && (this.getBulletcount() == null ? other.getBulletcount() == null : this.getBulletcount().equals(other.getBulletcount()))
            && (this.getGameterminal() == null ? other.getGameterminal() == null : this.getGameterminal().equals(other.getGameterminal()))
            && (this.getStartchips() == null ? other.getStartchips() == null : this.getStartchips().equals(other.getStartchips()))
            && (this.getEndchips() == null ? other.getEndchips() == null : this.getEndchips().equals(other.getEndchips()))
            && (this.getTranships() == null ? other.getTranships() == null : this.getTranships().equals(other.getTranships()))
            && (this.getStarttime() == null ? other.getStarttime() == null : this.getStarttime().equals(other.getStarttime()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getAgentuid() == null ? other.getAgentuid() == null : this.getAgentuid().equals(other.getAgentuid()))
            && (this.getTopagentuid() == null ? other.getTopagentuid() == null : this.getTopagentuid().equals(other.getTopagentuid()))
            && (this.getTotalagentuid() == null ? other.getTotalagentuid() == null : this.getTotalagentuid().equals(other.getTotalagentuid()))
            && (this.getJpadd() == null ? other.getJpadd() == null : this.getJpadd().equals(other.getJpadd()))
            && (this.getBuytime() == null ? other.getBuytime() == null : this.getBuytime().equals(other.getBuytime()))
            && (this.getRoomid() == null ? other.getRoomid() == null : this.getRoomid().equals(other.getRoomid()))
            && (this.getRoomtype() == null ? other.getRoomtype() == null : this.getRoomtype().equals(other.getRoomtype()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBetnum() == null) ? 0 : getBetnum().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getBettime() == null) ? 0 : getBettime().hashCode());
        result = prime * result + ((getBetamount() == null) ? 0 : getBetamount().hashCode());
        result = prime * result + ((getValidamount() == null) ? 0 : getValidamount().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getGameid() == null) ? 0 : getGameid().hashCode());
        result = prime * result + ((getGamename() == null) ? 0 : getGamename().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getFishdeadchips() == null) ? 0 : getFishdeadchips().hashCode());
        result = prime * result + ((getSceneid() == null) ? 0 : getSceneid().hashCode());
        result = prime * result + ((getFishprice() == null) ? 0 : getFishprice().hashCode());
        result = prime * result + ((getBulletcount() == null) ? 0 : getBulletcount().hashCode());
        result = prime * result + ((getGameterminal() == null) ? 0 : getGameterminal().hashCode());
        result = prime * result + ((getStartchips() == null) ? 0 : getStartchips().hashCode());
        result = prime * result + ((getEndchips() == null) ? 0 : getEndchips().hashCode());
        result = prime * result + ((getTranships() == null) ? 0 : getTranships().hashCode());
        result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getAgentuid() == null) ? 0 : getAgentuid().hashCode());
        result = prime * result + ((getTopagentuid() == null) ? 0 : getTopagentuid().hashCode());
        result = prime * result + ((getTotalagentuid() == null) ? 0 : getTotalagentuid().hashCode());
        result = prime * result + ((getJpadd() == null) ? 0 : getJpadd().hashCode());
        result = prime * result + ((getBuytime() == null) ? 0 : getBuytime().hashCode());
        result = prime * result + ((getRoomid() == null) ? 0 : getRoomid().hashCode());
        result = prime * result + ((getRoomtype() == null) ? 0 : getRoomtype().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        return result;
    }
}