package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class FontanaBetBoinsport implements Serializable {
    /** 自增主键 */
    private Long id;

    /** 用户ID */
    private Long uid;

    /** 用户名 */
    @JSONField(name = "UserName")
    private String username;

    /** 公司ID */
    private Long cid;

    /** 投注单号，全局唯一 */
    @JSONField(name = "WagersID")
    private Long betnum;

    /** 游戏小类型，第三方定义 */
    @JSONField(name = "GameType")
    private String gametype;

    /** 投注额 */
    @JSONField(name = "BetAmount")
    private Double betamount;

    /** 有效投注额 */
    @JSONField(name = "Commissionable")
    private Double validamount;

    /** 输赢金额 */
    @JSONField(name = "Payoff")
    private Double result;

    /** 注单结果 */
    /**
     * 注单结果
     * 体育：N：没有结果 C：注销, W：赢,L：输 ,LW：赢一半, LL：输一半, 0：平手, D：未接受, F：非法下注注销 ,X：未结算, S：等待中
     * 视讯：注单结果ResultType，-1：注销
     * 机率：-1：注销、1：赢、200：输
     * 彩票：W：赢，L：输，N：平手，0：没有结果，N2：注销
     * 3D厅：-1：注销、1：赢、200：输
     */
    @JSONField(name = "Result")
    private String gameresult;

    /** 投注时间 */
    @JSONField(name = "WagersDate")
    private Date bettime;

    /** 用于合计表查询 */
    private Date groupfor;

    /** 币种 */
    @JSONField(name = "Currency")
    private String currency;

    /** 汇率 */
    @JSONField(name = "ExchangeRate")
    private Double exchangerate;

    /** 游戏类型 */
    private String gameplatformchild;

    /** 注单变更时间 */
    @JSONField(name = "UPTIME")
    private Date uptime;
    
    /**
     * 注单变更时间，除体育游戏之外其他游戏用的是这个字段
     */
    @JSONField(name = "OrderDate")
    private String GROUPFOR;

    /** 大股东id */
    private Long pid;

    /** 股东id */
    private Long gid;

    /** 总代id */
    private Long aid;

    /** 代理id */
    private Long sid;

    private static final long serialVersionUID = 1L;

    
    public String getGROUPFOR() {
		return GROUPFOR;
	}

	public void setGROUPFOR(String gROUPFOR) {
		GROUPFOR = gROUPFOR;
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

    public Long getBetnum() {
        return betnum;
    }

    public void setBetnum(Long betnum) {
        this.betnum = betnum;
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
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

    public String getGameresult() {
        return gameresult;
    }

    public void setGameresult(String gameresult) {
        this.gameresult = gameresult == null ? null : gameresult.trim();
    }

    public Date getBettime() {
        return bettime;
    }

    public void setBettime(Date bettime) {
        this.bettime = bettime;
    }

    public Date getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(Date groupfor) {
        this.groupfor = groupfor;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Double getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(Double exchangerate) {
        this.exchangerate = exchangerate;
    }

    public String getGameplatformchild() {
        return gameplatformchild;
    }

    public void setGameplatformchild(String gameplatformchild) {
        this.gameplatformchild = gameplatformchild == null ? null : gameplatformchild.trim();
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
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
        FontanaBetBoinsport other = (FontanaBetBoinsport) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getBetnum() == null ? other.getBetnum() == null : this.getBetnum().equals(other.getBetnum()))
            && (this.getGametype() == null ? other.getGametype() == null : this.getGametype().equals(other.getGametype()))
            && (this.getBetamount() == null ? other.getBetamount() == null : this.getBetamount().equals(other.getBetamount()))
            && (this.getValidamount() == null ? other.getValidamount() == null : this.getValidamount().equals(other.getValidamount()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getGameresult() == null ? other.getGameresult() == null : this.getGameresult().equals(other.getGameresult()))
            && (this.getBettime() == null ? other.getBettime() == null : this.getBettime().equals(other.getBettime()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getExchangerate() == null ? other.getExchangerate() == null : this.getExchangerate().equals(other.getExchangerate()))
            && (this.getGameplatformchild() == null ? other.getGameplatformchild() == null : this.getGameplatformchild().equals(other.getGameplatformchild()))
            && (this.getUptime() == null ? other.getUptime() == null : this.getUptime().equals(other.getUptime()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()));
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
        result = prime * result + ((getGametype() == null) ? 0 : getGametype().hashCode());
        result = prime * result + ((getBetamount() == null) ? 0 : getBetamount().hashCode());
        result = prime * result + ((getValidamount() == null) ? 0 : getValidamount().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getGameresult() == null) ? 0 : getGameresult().hashCode());
        result = prime * result + ((getBettime() == null) ? 0 : getBettime().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getExchangerate() == null) ? 0 : getExchangerate().hashCode());
        result = prime * result + ((getGameplatformchild() == null) ? 0 : getGameplatformchild().hashCode());
        result = prime * result + ((getUptime() == null) ? 0 : getUptime().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        return result;
    }
}