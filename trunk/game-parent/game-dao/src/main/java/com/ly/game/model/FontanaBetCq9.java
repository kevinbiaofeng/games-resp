package com.ly.game.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;

public class FontanaBetCq9 implements Serializable {
    /** id */
    private Long id;

    /** 用户id */
    private Long uid;

    /** 用户名字 */
    @JSONField(name = "account")
    private String username;

    /** 公司id */
    private Long cid;

    /** 下注订单号 */
    @JSONField(name = "round")
    private String betnum;

    /** 报表日期 */
    private String groupfor;

    /** 下注时间 */
    private String bettime;
    
    /** 下注金额 */
    @JSONField(name = "bet")
    private BigDecimal betamount;

    /** 有效投注额 */
    private BigDecimal validamount;

    /** 输赢金额 */
    private BigDecimal result;

    /** 大股东id */
    private Long pid;

    /** 股东id */
    private Long gid;

    /** 总代理id */
    private Long aid;

    /** 代理id */
    private Long sid;

    /** 游戏名字 */
    private String gamename;

    /** 游戏代码 */
    private String gamecode;

    /** 游戏商名称 */
    private String gamehall;

    /** 游戏代码 */
    private String gametype;

    /** 游戏种类 */
    private String gameplat;

    /** 游戏后余额 */
    private BigDecimal balance;

    /** 订单状态 complete:完成 */
    private String status;

    /** 游戏方的创建订单时间 */
    private String createtime;

    /** 遊戲結束時間 */
    private String endroundtime;

    /** 免费次数 */
    private Integer freegame=0;

    /** ？ */
    private Integer luckydraw=0;

    /** ？ */
    private Integer bonus=0;
    
    private BigDecimal win;

    private List<Map<String, Integer>> detail;
    
    private static final long serialVersionUID = 1L;

	public List<Map<String, Integer>> getDetail() {
		return detail;
	}

	public BigDecimal getWin() {
		return win;
	}
	public void setWin(BigDecimal win) {
		this.win = win;
	}
	public void setDetail(List<Map<String, Integer>> detail) {
		this.detail = detail;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getBetnum() {
        return betnum;
    }

    public void setBetnum(String betnum) {
        this.betnum = betnum == null ? null : betnum.trim();
    }

    public String getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(String groupfor) {
        this.groupfor = groupfor;
    }

    public String getBettime() {
        return bettime;
    }

    public void setBettime(String bettime) {
        this.bettime = bettime;
    }

    public BigDecimal getBetamount() {
        return betamount;
    }

    public void setBetamount(BigDecimal betamount) {
        this.betamount = betamount;
    }

    public BigDecimal getValidamount() {
        return validamount;
    }

    public void setValidamount(BigDecimal validamount) {
        this.validamount = validamount;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
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

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }

    public String getGamecode() {
        return gamecode;
    }

    public void setGamecode(String gamecode) {
        this.gamecode = gamecode == null ? null : gamecode.trim();
    }

    public String getGamehall() {
        return gamehall;
    }

    public void setGamehall(String gamehall) {
        this.gamehall = gamehall == null ? null : gamehall.trim();
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
    }

    public String getGameplat() {
        return gameplat;
    }

    public void setGameplat(String gameplat) {
        this.gameplat = gameplat == null ? null : gameplat.trim();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getEndroundtime() {
        return endroundtime;
    }

    public void setEndroundtime(String endroundtime) {
        this.endroundtime = endroundtime;
    }

    public Integer getFreegame() {
        return freegame;
    }

    public void setFreegame(Integer freegame) {
        this.freegame = freegame;
    }

    public Integer getLuckydraw() {
        return luckydraw;
    }

    public void setLuckydraw(Integer luckydraw) {
        this.luckydraw = luckydraw;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
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
        FontanaBetCq9 other = (FontanaBetCq9) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getBetnum() == null ? other.getBetnum() == null : this.getBetnum().equals(other.getBetnum()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getBettime() == null ? other.getBettime() == null : this.getBettime().equals(other.getBettime()))
            && (this.getBetamount() == null ? other.getBetamount() == null : this.getBetamount().equals(other.getBetamount()))
            && (this.getValidamount() == null ? other.getValidamount() == null : this.getValidamount().equals(other.getValidamount()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getGamename() == null ? other.getGamename() == null : this.getGamename().equals(other.getGamename()))
            && (this.getGamecode() == null ? other.getGamecode() == null : this.getGamecode().equals(other.getGamecode()))
            && (this.getGamehall() == null ? other.getGamehall() == null : this.getGamehall().equals(other.getGamehall()))
            && (this.getGametype() == null ? other.getGametype() == null : this.getGametype().equals(other.getGametype()))
            && (this.getGameplat() == null ? other.getGameplat() == null : this.getGameplat().equals(other.getGameplat()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getEndroundtime() == null ? other.getEndroundtime() == null : this.getEndroundtime().equals(other.getEndroundtime()))
            && (this.getFreegame() == null ? other.getFreegame() == null : this.getFreegame().equals(other.getFreegame()))
            && (this.getLuckydraw() == null ? other.getLuckydraw() == null : this.getLuckydraw().equals(other.getLuckydraw()))
            && (this.getBonus() == null ? other.getBonus() == null : this.getBonus().equals(other.getBonus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getBetnum() == null) ? 0 : getBetnum().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getBettime() == null) ? 0 : getBettime().hashCode());
        result = prime * result + ((getBetamount() == null) ? 0 : getBetamount().hashCode());
        result = prime * result + ((getValidamount() == null) ? 0 : getValidamount().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getGamename() == null) ? 0 : getGamename().hashCode());
        result = prime * result + ((getGamecode() == null) ? 0 : getGamecode().hashCode());
        result = prime * result + ((getGamehall() == null) ? 0 : getGamehall().hashCode());
        result = prime * result + ((getGametype() == null) ? 0 : getGametype().hashCode());
        result = prime * result + ((getGameplat() == null) ? 0 : getGameplat().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getEndroundtime() == null) ? 0 : getEndroundtime().hashCode());
        result = prime * result + ((getFreegame() == null) ? 0 : getFreegame().hashCode());
        result = prime * result + ((getLuckydraw() == null) ? 0 : getLuckydraw().hashCode());
        result = prime * result + ((getBonus() == null) ? 0 : getBonus().hashCode());
        return result;
    }
}