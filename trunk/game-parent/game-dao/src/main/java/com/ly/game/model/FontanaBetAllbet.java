package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class FontanaBetAllbet implements Serializable {
    /** 自增主键 */
    private Long id;

    /** 用户ID */
    private Long uid;

    /** 用户名 */
    @JSONField(name="client")
    private String username;

    /** 用户上级ID */
    private Long parentid;

    /** 公司ID */
    private Long cid;

    /** 投注单号，全局唯一 */
    @JSONField(name="gameround")
    private Long betnum;

    /** 游戏局编号 */
    private Long gameroundid;

    /** 游戏小类型，第三方定义 */
    @JSONField(name="gameType")
    private Integer gametype;

    /** 游戏大类型，平台定义其值，用于报表查询 */
    private Integer gamebigtype;

    /** 投注额 */
    private Double betamount;

    /** 有效投注额 */
    private Double validamount;

    /** 输赢金额 */
    @JSONField(name="winOrLoss")
    private Double result;

    /** 注单状态 */
    private Integer state;

    /** 投注类型 */
    private Integer bettype;

    /** 开牌结果 */
    private String gameresult;

    /** 投注时间 */
    @JSONField(name="betTime")
    private Date bettime;

    /** 创建时间 */
    private Date ctime;

    /** 用于合计表查询 */
    private Date groupfor;

    /** 游戏开始时间 */
    private Date gamestarttime;

    /** 游戏结束时间 */
    private Date gameendtime;

    /** 桌台名称 */
    private String tablename;

    /** 桌台类型 */
    private Integer commission;

    /** 币种 */
    private String currency;

    /** 汇率 */
    private Double exchangerate;

    private String gameplatformchild;

    private Double jackpotbetamount;

    private Double jackpotvalidamount;

    private Double jackpotwinorloss;

    private static final long serialVersionUID = 1L;

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

    public Long getBetnum() {
        return betnum;
    }

    public void setBetnum(Long betnum) {
        this.betnum = betnum;
    }

    public Long getGameroundid() {
        return gameroundid;
    }

    public void setGameroundid(Long gameroundid) {
        this.gameroundid = gameroundid;
    }

    public Integer getGametype() {
        return gametype;
    }

    public void setGametype(Integer gametype) {
        this.gametype = gametype;
    }

    public Integer getGamebigtype() {
        return gamebigtype;
    }

    public void setGamebigtype(Integer gamebigtype) {
        this.gamebigtype = gamebigtype;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getBettype() {
        return bettype;
    }

    public void setBettype(Integer bettype) {
        this.bettype = bettype;
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

    public Date getGamestarttime() {
        return gamestarttime;
    }

    public void setGamestarttime(Date gamestarttime) {
        this.gamestarttime = gamestarttime;
    }

    public Date getGameendtime() {
        return gameendtime;
    }

    public void setGameendtime(Date gameendtime) {
        this.gameendtime = gameendtime;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
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

    public Double getJackpotbetamount() {
        return jackpotbetamount;
    }

    public void setJackpotbetamount(Double jackpotbetamount) {
        this.jackpotbetamount = jackpotbetamount;
    }

    public Double getJackpotvalidamount() {
        return jackpotvalidamount;
    }

    public void setJackpotvalidamount(Double jackpotvalidamount) {
        this.jackpotvalidamount = jackpotvalidamount;
    }

    public Double getJackpotwinorloss() {
        return jackpotwinorloss;
    }

    public void setJackpotwinorloss(Double jackpotwinorloss) {
        this.jackpotwinorloss = jackpotwinorloss;
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
        FontanaBetAllbet other = (FontanaBetAllbet) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getBetnum() == null ? other.getBetnum() == null : this.getBetnum().equals(other.getBetnum()))
            && (this.getGameroundid() == null ? other.getGameroundid() == null : this.getGameroundid().equals(other.getGameroundid()))
            && (this.getGametype() == null ? other.getGametype() == null : this.getGametype().equals(other.getGametype()))
            && (this.getGamebigtype() == null ? other.getGamebigtype() == null : this.getGamebigtype().equals(other.getGamebigtype()))
            && (this.getBetamount() == null ? other.getBetamount() == null : this.getBetamount().equals(other.getBetamount()))
            && (this.getValidamount() == null ? other.getValidamount() == null : this.getValidamount().equals(other.getValidamount()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getBettype() == null ? other.getBettype() == null : this.getBettype().equals(other.getBettype()))
            && (this.getGameresult() == null ? other.getGameresult() == null : this.getGameresult().equals(other.getGameresult()))
            && (this.getBettime() == null ? other.getBettime() == null : this.getBettime().equals(other.getBettime()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getGamestarttime() == null ? other.getGamestarttime() == null : this.getGamestarttime().equals(other.getGamestarttime()))
            && (this.getGameendtime() == null ? other.getGameendtime() == null : this.getGameendtime().equals(other.getGameendtime()))
            && (this.getTablename() == null ? other.getTablename() == null : this.getTablename().equals(other.getTablename()))
            && (this.getCommission() == null ? other.getCommission() == null : this.getCommission().equals(other.getCommission()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getExchangerate() == null ? other.getExchangerate() == null : this.getExchangerate().equals(other.getExchangerate()))
            && (this.getGameplatformchild() == null ? other.getGameplatformchild() == null : this.getGameplatformchild().equals(other.getGameplatformchild()))
            && (this.getJackpotbetamount() == null ? other.getJackpotbetamount() == null : this.getJackpotbetamount().equals(other.getJackpotbetamount()))
            && (this.getJackpotvalidamount() == null ? other.getJackpotvalidamount() == null : this.getJackpotvalidamount().equals(other.getJackpotvalidamount()))
            && (this.getJackpotwinorloss() == null ? other.getJackpotwinorloss() == null : this.getJackpotwinorloss().equals(other.getJackpotwinorloss()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getBetnum() == null) ? 0 : getBetnum().hashCode());
        result = prime * result + ((getGameroundid() == null) ? 0 : getGameroundid().hashCode());
        result = prime * result + ((getGametype() == null) ? 0 : getGametype().hashCode());
        result = prime * result + ((getGamebigtype() == null) ? 0 : getGamebigtype().hashCode());
        result = prime * result + ((getBetamount() == null) ? 0 : getBetamount().hashCode());
        result = prime * result + ((getValidamount() == null) ? 0 : getValidamount().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getBettype() == null) ? 0 : getBettype().hashCode());
        result = prime * result + ((getGameresult() == null) ? 0 : getGameresult().hashCode());
        result = prime * result + ((getBettime() == null) ? 0 : getBettime().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getGamestarttime() == null) ? 0 : getGamestarttime().hashCode());
        result = prime * result + ((getGameendtime() == null) ? 0 : getGameendtime().hashCode());
        result = prime * result + ((getTablename() == null) ? 0 : getTablename().hashCode());
        result = prime * result + ((getCommission() == null) ? 0 : getCommission().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getExchangerate() == null) ? 0 : getExchangerate().hashCode());
        result = prime * result + ((getGameplatformchild() == null) ? 0 : getGameplatformchild().hashCode());
        result = prime * result + ((getJackpotbetamount() == null) ? 0 : getJackpotbetamount().hashCode());
        result = prime * result + ((getJackpotvalidamount() == null) ? 0 : getJackpotvalidamount().hashCode());
        result = prime * result + ((getJackpotwinorloss() == null) ? 0 : getJackpotwinorloss().hashCode());
        return result;
    }
}