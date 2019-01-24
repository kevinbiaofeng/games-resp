package com.ly.game.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FontanaBetBoinlottery implements Serializable {
    /** 自增主键 */
    private Long id;

    /** 投注单号，全局唯一 */
    @JSONField(name = "WagersID")
    private Long betnum;

    /** 用户ID */
    private Long uid;

    /** 用户名 */
    @JSONField(name = "UserName")
    private String username;

    /** 用户上级ID */
    private Long parentid;

    /** 公司ID */
    private Long cid;

    /** 游戏小类型，第三方定义 */
    @JSONField(name = "GameType")
    private String gametype;

    /** 游戏大类型，平台定义其值，用于报表查询 */
    private Integer gamebigtype;

    /** 投注额 */
    @JSONField(name = "BetAmount")
    private BigDecimal betamount;

    /** 有效投注额 */
    @JSONField(name = "Commissionable")
    private BigDecimal validamount;

    /** 输赢金额 */
    @JSONField(name = "Commissionable")
    private BigDecimal result;

    /** 注单结果 */
    @JSONField(name = "Result")
    private String gameresult;

    /** 投注时间 */
    @JSONField(name = "WagersDate")
    private Date bettime;

    /** 创建时间 */
    private Date ctime;

    /** 用于合计表查询 */
    private Date groupfor;

    /** 退水 */
    private BigDecimal commission;

    /** Y：已派彩、N：未派彩 */
    private String ispaid;

    /** 帐务时间 */
    private Date orderdate;

    /** 币种 */
    @JSONField(name = "Currency")
    private String currency;

    /** 汇率 */
    @JSONField(name = "ExchangeRate")
    private BigDecimal exchangerate;

    private String gameplatformchild;
    
    /**
     * 注单变更时间，体育游戏用的是这个字段
     */
    @JsonProperty("UPTIME")
    private String upTime;
    
    /**
     * 注单变更时间，除体育游戏之外其他游戏用的是这个字段
     */
    @JsonProperty("ModifiedDate")
    private String modifiedDate;

    private Date settledtime;
    

    public String getUpTime() {
		return upTime;
	}

	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBetnum() {
        return betnum;
    }

    public void setBetnum(Long betnum) {
        this.betnum = betnum;
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

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
    }

    public Integer getGamebigtype() {
        return gamebigtype;
    }

    public void setGamebigtype(Integer gamebigtype) {
        this.gamebigtype = gamebigtype;
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

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(Date groupfor) {
        this.groupfor = groupfor;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public String getIspaid() {
        return ispaid;
    }

    public void setIspaid(String ispaid) {
        this.ispaid = ispaid == null ? null : ispaid.trim();
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(BigDecimal exchangerate) {
        this.exchangerate = exchangerate;
    }

    public String getGameplatformchild() {
        return gameplatformchild;
    }

    public void setGameplatformchild(String gameplatformchild) {
        this.gameplatformchild = gameplatformchild == null ? null : gameplatformchild.trim();
    }

    public Date getSettledtime() {
        return settledtime;
    }

    public void setSettledtime(Date settledtime) {
        this.settledtime = settledtime;
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
        FontanaBetBoinlottery other = (FontanaBetBoinlottery) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBetnum() == null ? other.getBetnum() == null : this.getBetnum().equals(other.getBetnum()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getGametype() == null ? other.getGametype() == null : this.getGametype().equals(other.getGametype()))
            && (this.getGamebigtype() == null ? other.getGamebigtype() == null : this.getGamebigtype().equals(other.getGamebigtype()))
            && (this.getBetamount() == null ? other.getBetamount() == null : this.getBetamount().equals(other.getBetamount()))
            && (this.getValidamount() == null ? other.getValidamount() == null : this.getValidamount().equals(other.getValidamount()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getGameresult() == null ? other.getGameresult() == null : this.getGameresult().equals(other.getGameresult()))
            && (this.getBettime() == null ? other.getBettime() == null : this.getBettime().equals(other.getBettime()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getCommission() == null ? other.getCommission() == null : this.getCommission().equals(other.getCommission()))
            && (this.getIspaid() == null ? other.getIspaid() == null : this.getIspaid().equals(other.getIspaid()))
            && (this.getOrderdate() == null ? other.getOrderdate() == null : this.getOrderdate().equals(other.getOrderdate()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getExchangerate() == null ? other.getExchangerate() == null : this.getExchangerate().equals(other.getExchangerate()))
            && (this.getGameplatformchild() == null ? other.getGameplatformchild() == null : this.getGameplatformchild().equals(other.getGameplatformchild()))
            && (this.getSettledtime() == null ? other.getSettledtime() == null : this.getSettledtime().equals(other.getSettledtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBetnum() == null) ? 0 : getBetnum().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getGametype() == null) ? 0 : getGametype().hashCode());
        result = prime * result + ((getGamebigtype() == null) ? 0 : getGamebigtype().hashCode());
        result = prime * result + ((getBetamount() == null) ? 0 : getBetamount().hashCode());
        result = prime * result + ((getValidamount() == null) ? 0 : getValidamount().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getGameresult() == null) ? 0 : getGameresult().hashCode());
        result = prime * result + ((getBettime() == null) ? 0 : getBettime().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getCommission() == null) ? 0 : getCommission().hashCode());
        result = prime * result + ((getIspaid() == null) ? 0 : getIspaid().hashCode());
        result = prime * result + ((getOrderdate() == null) ? 0 : getOrderdate().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getExchangerate() == null) ? 0 : getExchangerate().hashCode());
        result = prime * result + ((getGameplatformchild() == null) ? 0 : getGameplatformchild().hashCode());
        result = prime * result + ((getSettledtime() == null) ? 0 : getSettledtime().hashCode());
        return result;
    }
}