package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class FontanaBetKaga implements Serializable {
    private Long id;

    /** 用户ID */
    private Long uid;

    /** 用户账号 */
    @JSONField(name = "playerId")
    private String username;

    /** 公司ID */
    private Long cid;

    /** 游戏每局标识 */
    @JSONField(name = "transactionId")
    private String betnum;

    /** 下注时间 */
    @JSONField(format = "yyyy/MM/dd HH:mm:ss" ,name = "spinDate" )
    private Date bettime;

    /** 下注金额 */
    private Double betamount;

    /** 有效投注 */
    private Double validamount;

    /** 输赢金额 */
    private Double result;

    /** 统计日期，格式 YYYY-MM-DD，例如 2013-07-02 */
    private Date groupfor;

    /** 游戏名字 */
    @JSONField(name = "gameName")
    private String gamename;

    /** 币种 */
    private String currency;

    /** 大股东id */
    private Long pid;

    /** 股东id */
    private Long gid;

    /** 总代理id */
    private Long aid;

    /** 代理id */
    private Long sid;

    /** 玩家的回报率 */
    private Double rtp;

    /** 面额 */
    private Double denomination;

    /** 线 */
    private Short selections;

    /** 代币/线 */
    private Long creditperselection;

    /** 下注金额 */
    private Long cashplayed;

    /** 赢的金额 */
    private Long cashwon;

    /** 下注代币 */
    private Long creditsplayed;

    /** 赢的代币 */
    private Long creditswon;

    /** 是否freegame */
    private String freespin;

    /** 第几次freegame */
    private Short round;

    /** 剩余的freegame */
    private Short roundsremaining;

    /** 小游戏派彩金额 */
    private Double smallgamepayout;

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

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
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

    public Double getRtp() {
        return rtp;
    }

    public void setRtp(Double rtp) {
        this.rtp = rtp;
    }

    public Double getDenomination() {
        return denomination;
    }

    public void setDenomination(Double denomination) {
        this.denomination = denomination;
    }

    public Short getSelections() {
        return selections;
    }

    public void setSelections(Short selections) {
        this.selections = selections;
    }

    public Long getCreditperselection() {
        return creditperselection;
    }

    public void setCreditperselection(Long creditperselection) {
        this.creditperselection = creditperselection;
    }

    public Long getCashplayed() {
        return cashplayed;
    }

    public void setCashplayed(Long cashplayed) {
        this.cashplayed = cashplayed;
    }

    public Long getCashwon() {
        return cashwon;
    }

    public void setCashwon(Long cashwon) {
        this.cashwon = cashwon;
    }

    public Long getCreditsplayed() {
        return creditsplayed;
    }

    public void setCreditsplayed(Long creditsplayed) {
        this.creditsplayed = creditsplayed;
    }

    public Long getCreditswon() {
        return creditswon;
    }

    public void setCreditswon(Long creditswon) {
        this.creditswon = creditswon;
    }

    public String getFreespin() {
        return freespin;
    }

    public void setFreespin(String freespin) {
        this.freespin = freespin == null ? null : freespin.trim();
    }

    public Short getRound() {
        return round;
    }

    public void setRound(Short round) {
        this.round = round;
    }

    public Short getRoundsremaining() {
        return roundsremaining;
    }

    public void setRoundsremaining(Short roundsremaining) {
        this.roundsremaining = roundsremaining;
    }

    public Double getSmallgamepayout() {
        return smallgamepayout;
    }

    public void setSmallgamepayout(Double smallgamepayout) {
        this.smallgamepayout = smallgamepayout;
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
        FontanaBetKaga other = (FontanaBetKaga) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getBetnum() == null ? other.getBetnum() == null : this.getBetnum().equals(other.getBetnum()))
            && (this.getBettime() == null ? other.getBettime() == null : this.getBettime().equals(other.getBettime()))
            && (this.getBetamount() == null ? other.getBetamount() == null : this.getBetamount().equals(other.getBetamount()))
            && (this.getValidamount() == null ? other.getValidamount() == null : this.getValidamount().equals(other.getValidamount()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getGamename() == null ? other.getGamename() == null : this.getGamename().equals(other.getGamename()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getRtp() == null ? other.getRtp() == null : this.getRtp().equals(other.getRtp()))
            && (this.getDenomination() == null ? other.getDenomination() == null : this.getDenomination().equals(other.getDenomination()))
            && (this.getSelections() == null ? other.getSelections() == null : this.getSelections().equals(other.getSelections()))
            && (this.getCreditperselection() == null ? other.getCreditperselection() == null : this.getCreditperselection().equals(other.getCreditperselection()))
            && (this.getCashplayed() == null ? other.getCashplayed() == null : this.getCashplayed().equals(other.getCashplayed()))
            && (this.getCashwon() == null ? other.getCashwon() == null : this.getCashwon().equals(other.getCashwon()))
            && (this.getCreditsplayed() == null ? other.getCreditsplayed() == null : this.getCreditsplayed().equals(other.getCreditsplayed()))
            && (this.getCreditswon() == null ? other.getCreditswon() == null : this.getCreditswon().equals(other.getCreditswon()))
            && (this.getFreespin() == null ? other.getFreespin() == null : this.getFreespin().equals(other.getFreespin()))
            && (this.getRound() == null ? other.getRound() == null : this.getRound().equals(other.getRound()))
            && (this.getRoundsremaining() == null ? other.getRoundsremaining() == null : this.getRoundsremaining().equals(other.getRoundsremaining()))
            && (this.getSmallgamepayout() == null ? other.getSmallgamepayout() == null : this.getSmallgamepayout().equals(other.getSmallgamepayout()));
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
        result = prime * result + ((getBettime() == null) ? 0 : getBettime().hashCode());
        result = prime * result + ((getBetamount() == null) ? 0 : getBetamount().hashCode());
        result = prime * result + ((getValidamount() == null) ? 0 : getValidamount().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getGamename() == null) ? 0 : getGamename().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getRtp() == null) ? 0 : getRtp().hashCode());
        result = prime * result + ((getDenomination() == null) ? 0 : getDenomination().hashCode());
        result = prime * result + ((getSelections() == null) ? 0 : getSelections().hashCode());
        result = prime * result + ((getCreditperselection() == null) ? 0 : getCreditperselection().hashCode());
        result = prime * result + ((getCashplayed() == null) ? 0 : getCashplayed().hashCode());
        result = prime * result + ((getCashwon() == null) ? 0 : getCashwon().hashCode());
        result = prime * result + ((getCreditsplayed() == null) ? 0 : getCreditsplayed().hashCode());
        result = prime * result + ((getCreditswon() == null) ? 0 : getCreditswon().hashCode());
        result = prime * result + ((getFreespin() == null) ? 0 : getFreespin().hashCode());
        result = prime * result + ((getRound() == null) ? 0 : getRound().hashCode());
        result = prime * result + ((getRoundsremaining() == null) ? 0 : getRoundsremaining().hashCode());
        result = prime * result + ((getSmallgamepayout() == null) ? 0 : getSmallgamepayout().hashCode());
        return result;
    }
}