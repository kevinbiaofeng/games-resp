package com.ly.game.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FontanaBetIm implements Serializable {
    /** 同步序号 */
    private String id;

    /** 订单号 订单编码 */
    private String betnum;

    /** 用户id 玩家编号 */
    private Long uid;

    /** 用户名 玩家编号 */
    private String username;

    /** 公司id */
    private Long cid;

    /** 下注时间 */
    private Date bettime;

    /** 下注金额 */
    private BigDecimal betamount;

    /** 有效投注额 */
    private BigDecimal validamount;

    /** 输赢金额 */
    private BigDecimal result;

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

    /** 来源 */
    private String source;

    /** 产品供应商代码 */
    private String provider;

    /** IMOne 系统内的 GameID */
    private String gameid;

    /** 玩家账号 */
    private String playerid;

    /** 货币代码 */
    private String currency;

    /** 下注金额 */
    private BigDecimal memberexposure;

    /** 可赢金额 */
    private BigDecimal payoutamount;

    /** 赔率类别: HK 香港盘 / EURO 欧洲盘 / MALAY 马来盘 / INDO 印尼盘 */
    private String oddstype;

    /** 注单类别: Single 单一 / ParlayAll 混合过关 */
    private String wagertype;

    /** 平台类别: Web 电脑 / Mobile 手机 */
    private String platform;

    /** 0 = Not Settled 未结算, 1 = Settled 已结算 */
    private Long issettled;

    /** 0 = Pending 待定, 1 = Confirmed 确认, 2 = Cancelled 取消 */
    private Long isconfirmed;

    /** 0 = Not cancel 未取消, 1 = Cancel 已取消 */
    private Long iscancelled;

    /** BetTrade 状态: Cancel 取消 / Sold 兑现成功  如果没有此单据则回传 Null。 */
    private String bettradestatus;

    /** BetTrade 返水金额. 如果没有此单据则回传 Null. */
    private BigDecimal bettradecommission;

    /** BetTrade 金额 (buy back amount)。 如果没有此单据则回传 Null. */
    private BigDecimal bettradebuybackamount;

    /** 注单最后更新时间 格式: YYYY-MM-DD HH:mm:ss +08:00 */
    private Date lastupdateddate;

    /** 混合过关类别 */
    private String combotype;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid == null ? null : gameid.trim();
    }

    public String getPlayerid() {
        return playerid;
    }

    public void setPlayerid(String playerid) {
        this.playerid = playerid == null ? null : playerid.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getMemberexposure() {
        return memberexposure;
    }

    public void setMemberexposure(BigDecimal memberexposure) {
        this.memberexposure = memberexposure;
    }

    public BigDecimal getPayoutamount() {
        return payoutamount;
    }

    public void setPayoutamount(BigDecimal payoutamount) {
        this.payoutamount = payoutamount;
    }

    public String getOddstype() {
        return oddstype;
    }

    public void setOddstype(String oddstype) {
        this.oddstype = oddstype == null ? null : oddstype.trim();
    }

    public String getWagertype() {
        return wagertype;
    }

    public void setWagertype(String wagertype) {
        this.wagertype = wagertype == null ? null : wagertype.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public Long getIssettled() {
        return issettled;
    }

    public void setIssettled(Long issettled) {
        this.issettled = issettled;
    }

    public Long getIsconfirmed() {
        return isconfirmed;
    }

    public void setIsconfirmed(Long isconfirmed) {
        this.isconfirmed = isconfirmed;
    }

    public Long getIscancelled() {
        return iscancelled;
    }

    public void setIscancelled(Long iscancelled) {
        this.iscancelled = iscancelled;
    }

    public String getBettradestatus() {
        return bettradestatus;
    }

    public void setBettradestatus(String bettradestatus) {
        this.bettradestatus = bettradestatus == null ? null : bettradestatus.trim();
    }

    public BigDecimal getBettradecommission() {
        return bettradecommission;
    }

    public void setBettradecommission(BigDecimal bettradecommission) {
        this.bettradecommission = bettradecommission;
    }

    public BigDecimal getBettradebuybackamount() {
        return bettradebuybackamount;
    }

    public void setBettradebuybackamount(BigDecimal bettradebuybackamount) {
        this.bettradebuybackamount = bettradebuybackamount;
    }

    public Date getLastupdateddate() {
        return lastupdateddate;
    }

    public void setLastupdateddate(Date lastupdateddate) {
        this.lastupdateddate = lastupdateddate;
    }

    public String getCombotype() {
        return combotype;
    }

    public void setCombotype(String combotype) {
        this.combotype = combotype == null ? null : combotype.trim();
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
        FontanaBetIm other = (FontanaBetIm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBetnum() == null ? other.getBetnum() == null : this.getBetnum().equals(other.getBetnum()))
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
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getProvider() == null ? other.getProvider() == null : this.getProvider().equals(other.getProvider()))
            && (this.getGameid() == null ? other.getGameid() == null : this.getGameid().equals(other.getGameid()))
            && (this.getPlayerid() == null ? other.getPlayerid() == null : this.getPlayerid().equals(other.getPlayerid()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getMemberexposure() == null ? other.getMemberexposure() == null : this.getMemberexposure().equals(other.getMemberexposure()))
            && (this.getPayoutamount() == null ? other.getPayoutamount() == null : this.getPayoutamount().equals(other.getPayoutamount()))
            && (this.getOddstype() == null ? other.getOddstype() == null : this.getOddstype().equals(other.getOddstype()))
            && (this.getWagertype() == null ? other.getWagertype() == null : this.getWagertype().equals(other.getWagertype()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getIssettled() == null ? other.getIssettled() == null : this.getIssettled().equals(other.getIssettled()))
            && (this.getIsconfirmed() == null ? other.getIsconfirmed() == null : this.getIsconfirmed().equals(other.getIsconfirmed()))
            && (this.getIscancelled() == null ? other.getIscancelled() == null : this.getIscancelled().equals(other.getIscancelled()))
            && (this.getBettradestatus() == null ? other.getBettradestatus() == null : this.getBettradestatus().equals(other.getBettradestatus()))
            && (this.getBettradecommission() == null ? other.getBettradecommission() == null : this.getBettradecommission().equals(other.getBettradecommission()))
            && (this.getBettradebuybackamount() == null ? other.getBettradebuybackamount() == null : this.getBettradebuybackamount().equals(other.getBettradebuybackamount()))
            && (this.getLastupdateddate() == null ? other.getLastupdateddate() == null : this.getLastupdateddate().equals(other.getLastupdateddate()))
            && (this.getCombotype() == null ? other.getCombotype() == null : this.getCombotype().equals(other.getCombotype()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
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
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getProvider() == null) ? 0 : getProvider().hashCode());
        result = prime * result + ((getGameid() == null) ? 0 : getGameid().hashCode());
        result = prime * result + ((getPlayerid() == null) ? 0 : getPlayerid().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getMemberexposure() == null) ? 0 : getMemberexposure().hashCode());
        result = prime * result + ((getPayoutamount() == null) ? 0 : getPayoutamount().hashCode());
        result = prime * result + ((getOddstype() == null) ? 0 : getOddstype().hashCode());
        result = prime * result + ((getWagertype() == null) ? 0 : getWagertype().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getIssettled() == null) ? 0 : getIssettled().hashCode());
        result = prime * result + ((getIsconfirmed() == null) ? 0 : getIsconfirmed().hashCode());
        result = prime * result + ((getIscancelled() == null) ? 0 : getIscancelled().hashCode());
        result = prime * result + ((getBettradestatus() == null) ? 0 : getBettradestatus().hashCode());
        result = prime * result + ((getBettradecommission() == null) ? 0 : getBettradecommission().hashCode());
        result = prime * result + ((getBettradebuybackamount() == null) ? 0 : getBettradebuybackamount().hashCode());
        result = prime * result + ((getLastupdateddate() == null) ? 0 : getLastupdateddate().hashCode());
        result = prime * result + ((getCombotype() == null) ? 0 : getCombotype().hashCode());
        return result;
    }
}