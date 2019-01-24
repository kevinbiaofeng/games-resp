package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class FontanaBetFgdz implements Serializable {

    /** 订单号 */
	@JSONField(name ="id")
    private String betnum;

    /** 用户id */
    private Long uid;

    /** 用户名 */
    @JSONField(name ="player_name")
    private String username;

    /** 公司id */
    private Long cid;

    /** 下注时间 */
    private Date bettime;

    /** 下注金额 */
    @JSONField(name ="all_bets")
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

    /** 总代理商id */
    @JSONField(name ="total_agent_uid")
    private Integer totalagentid;

    /** 代理商id */
    @JSONField(name ="agent_uid")
    private Integer agentuid;

    /** 游戏id */
    @JSONField(name ="game_id")
    private Integer gameid;

    /** 游戏name */
    private String gamename;

    /** 游戏类型 */
    private String gt;

    /** 设备类型 */
    private Integer device;

    /** 注单时间 */
    private long dtime;
    
    private Date time;

    /** 结束筹码 */
    @JSONField(name ="end_chips")
    private double endchips;

    /** 总奖金 */
    @JSONField(name ="all_wins")
    private double allwins;

    /**  jackpot 奖金 */
    @JSONField(name ="jackpot_bonus")
    private double jackpotbonus;

    /** 后台的收支 */
    private Double gresult;

    private static final long serialVersionUID = 1L;

    public Date getTime() {
		return time;
	}

	public long getDtime() {
		return dtime;
	}

	public void setDtime(long dtime) {
		this.dtime = dtime;
	}

	public void setTime(Date time) {
		this.time = time;
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

    public Integer getTotalagentid() {
        return totalagentid;
    }

    public void setTotalagentid(Integer totalagentid) {
        this.totalagentid = totalagentid;
    }

    public Integer getAgentuid() {
        return agentuid;
    }

    public void setAgentuid(Integer agentuid) {
        this.agentuid = agentuid;
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

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt == null ? null : gt.trim();
    }

    public Integer getDevice() {
        return device;
    }

    public void setDevice(Integer device) {
        this.device = device;
    }

    public Double getEndchips() {
        return endchips;
    }

    public void setEndchips(Double endchips) {
        this.endchips = endchips;
    }

    public Double getAllwins() {
        return allwins;
    }

    public void setAllwins(Double allwins) {
        this.allwins = allwins;
    }

    public Double getJackpotbonus() {
        return jackpotbonus;
    }

    public void setJackpotbonus(Double jackpotbonus) {
        this.jackpotbonus = jackpotbonus;
    }

    public Double getGresult() {
        return gresult;
    }

    public void setGresult(Double gresult) {
        this.gresult = gresult;
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
        FontanaBetFgdz other = (FontanaBetFgdz) that;
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
            && (this.getTotalagentid() == null ? other.getTotalagentid() == null : this.getTotalagentid().equals(other.getTotalagentid()))
            && (this.getAgentuid() == null ? other.getAgentuid() == null : this.getAgentuid().equals(other.getAgentuid()))
            && (this.getGameid() == null ? other.getGameid() == null : this.getGameid().equals(other.getGameid()))
            && (this.getGamename() == null ? other.getGamename() == null : this.getGamename().equals(other.getGamename()))
            && (this.getGt() == null ? other.getGt() == null : this.getGt().equals(other.getGt()))
            && (this.getDevice() == null ? other.getDevice() == null : this.getDevice().equals(other.getDevice()))
            && (this.getEndchips() == null ? other.getEndchips() == null : this.getEndchips().equals(other.getEndchips()))
            && (this.getAllwins() == null ? other.getAllwins() == null : this.getAllwins().equals(other.getAllwins()))
            && (this.getJackpotbonus() == null ? other.getJackpotbonus() == null : this.getJackpotbonus().equals(other.getJackpotbonus()))
            && (this.getGresult() == null ? other.getGresult() == null : this.getGresult().equals(other.getGresult()));
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
        result = prime * result + ((getTotalagentid() == null) ? 0 : getTotalagentid().hashCode());
        result = prime * result + ((getAgentuid() == null) ? 0 : getAgentuid().hashCode());
        result = prime * result + ((getGameid() == null) ? 0 : getGameid().hashCode());
        result = prime * result + ((getGamename() == null) ? 0 : getGamename().hashCode());
        result = prime * result + ((getGt() == null) ? 0 : getGt().hashCode());
        result = prime * result + ((getDevice() == null) ? 0 : getDevice().hashCode());
        result = prime * result + ((getEndchips() == null) ? 0 : getEndchips().hashCode());
        result = prime * result + ((getAllwins() == null) ? 0 : getAllwins().hashCode());
        result = prime * result + ((getJackpotbonus() == null) ? 0 : getJackpotbonus().hashCode());
        result = prime * result + ((getGresult() == null) ? 0 : getGresult().hashCode());
        return result;
    }
}