package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class FontanaBetLylot implements Serializable {
    private Long id;

    /** 注单号 */
    @JSONField(name ="OrderNumber")
    private String betnum;

    /** 用户id */
    private Long uid;

    /** 用户名 */
    @JSONField(name ="AccountName")
    private String username;

    /** 公司id */
    private Long cid;

    /** 下注时间 */
    @JSONField(name ="CreateTime",format = "yyyy/MM/dd HH:mm:ss")
    private Date bettime;

    /** 下注金额 */
    @JSONField(name ="TotalAmount")
    private Double betamount;

    /** 有效投注额=输赢金额的绝对值 */
    private Double validamount;

    /** 输赢金额=中奖金额+退水金额-投注金额 */
    private Double result;

    /** 对账日期 */
    private Date groupfor;

    /** 大股东id */
    private Long pid;

    /** 股东id */
    private Long gid;

    /** 总代理id */
    private Long aid;

    /** 代理id */
    private Long sid;

    /** 结算时间 */
    @JSONField(name ="SettleTime",format = "yyyy/MM/dd HH:mm:ss")
    private Date settletime;

    /** 注单状态(0:未结算，1:已结算，2:取消，3:删除) */
    @JSONField(name ="Status")
    private Short status;

    /** 中奖金额 */
    @JSONField(name ="BettingBalance")
    private Double bettingbalance;

    /** 退水金额 */
    @JSONField(name ="TotalKickback")
    private Double totalkickback;

    /** 期数 */
    @JSONField(name ="NumberOfPeriod")
    private String numberofperiod;

    /** 游戏名称 */
    @JSONField(name ="GameName")
    private String gamename;

    /** ip地址 */
    @JSONField(name ="IpAddress")
    private String ipaddress;

    /** 倍数 */
    @JSONField(name ="Times")
    private String times;

    /** 注数 */
    @JSONField(name ="BetNumber")
    private String betnumber;

    /** 赔率 */
    @JSONField(name ="ODDS")
    private String odds;

    /** 下注内容(已移至FONTANA_BET_LYLOT_CONTENT表) */
    @JSONField(name ="Content")
    private String content;

    /** 玩法名称 */
    @JSONField(name ="GamePlayName")
    private String gameplayname;

    /** 下注平台 */
    @JSONField(name ="Platform")
    private String platform;

    /** 开奖结果 */
    @JSONField(name ="Result")
    private String gameresult;

    /** 开奖时间 */
    @JSONField(name ="LotteryCreateTime" ,format = "yyyy/MM/dd HH:mm:ss" )
    private Date lotterycreatetime;

    /** 中奖状态(0:输，1：平，2：赢) */
    @JSONField(name ="WinningStatus")
    private Short winningstatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getSettletime() {
        return settletime;
    }

    public void setSettletime(Date settletime) {
        this.settletime = settletime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Double getBettingbalance() {
        return bettingbalance;
    }

    public void setBettingbalance(Double bettingbalance) {
        this.bettingbalance = bettingbalance;
    }

    public Double getTotalkickback() {
        return totalkickback;
    }

    public void setTotalkickback(Double totalkickback) {
        this.totalkickback = totalkickback;
    }

    public String getNumberofperiod() {
        return numberofperiod;
    }

    public void setNumberofperiod(String numberofperiod) {
        this.numberofperiod = numberofperiod == null ? null : numberofperiod.trim();
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times == null ? null : times.trim();
    }

    public String getBetnumber() {
        return betnumber;
    }

    public void setBetnumber(String betnumber) {
        this.betnumber = betnumber == null ? null : betnumber.trim();
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds == null ? null : odds.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getGameplayname() {
        return gameplayname;
    }

    public void setGameplayname(String gameplayname) {
        this.gameplayname = gameplayname == null ? null : gameplayname.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getGameresult() {
        return gameresult;
    }

    public void setGameresult(String gameresult) {
        this.gameresult = gameresult == null ? null : gameresult.trim();
    }

    public Date getLotterycreatetime() {
        return lotterycreatetime;
    }

    public void setLotterycreatetime(Date lotterycreatetime) {
        this.lotterycreatetime = lotterycreatetime;
    }

    public Short getWinningstatus() {
        return winningstatus;
    }

    public void setWinningstatus(Short winningstatus) {
        this.winningstatus = winningstatus;
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
        FontanaBetLylot other = (FontanaBetLylot) that;
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
            && (this.getSettletime() == null ? other.getSettletime() == null : this.getSettletime().equals(other.getSettletime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBettingbalance() == null ? other.getBettingbalance() == null : this.getBettingbalance().equals(other.getBettingbalance()))
            && (this.getTotalkickback() == null ? other.getTotalkickback() == null : this.getTotalkickback().equals(other.getTotalkickback()))
            && (this.getNumberofperiod() == null ? other.getNumberofperiod() == null : this.getNumberofperiod().equals(other.getNumberofperiod()))
            && (this.getGamename() == null ? other.getGamename() == null : this.getGamename().equals(other.getGamename()))
            && (this.getIpaddress() == null ? other.getIpaddress() == null : this.getIpaddress().equals(other.getIpaddress()))
            && (this.getTimes() == null ? other.getTimes() == null : this.getTimes().equals(other.getTimes()))
            && (this.getBetnumber() == null ? other.getBetnumber() == null : this.getBetnumber().equals(other.getBetnumber()))
            && (this.getOdds() == null ? other.getOdds() == null : this.getOdds().equals(other.getOdds()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getGameplayname() == null ? other.getGameplayname() == null : this.getGameplayname().equals(other.getGameplayname()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getGameresult() == null ? other.getGameresult() == null : this.getGameresult().equals(other.getGameresult()))
            && (this.getLotterycreatetime() == null ? other.getLotterycreatetime() == null : this.getLotterycreatetime().equals(other.getLotterycreatetime()))
            && (this.getWinningstatus() == null ? other.getWinningstatus() == null : this.getWinningstatus().equals(other.getWinningstatus()));
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
        result = prime * result + ((getSettletime() == null) ? 0 : getSettletime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBettingbalance() == null) ? 0 : getBettingbalance().hashCode());
        result = prime * result + ((getTotalkickback() == null) ? 0 : getTotalkickback().hashCode());
        result = prime * result + ((getNumberofperiod() == null) ? 0 : getNumberofperiod().hashCode());
        result = prime * result + ((getGamename() == null) ? 0 : getGamename().hashCode());
        result = prime * result + ((getIpaddress() == null) ? 0 : getIpaddress().hashCode());
        result = prime * result + ((getTimes() == null) ? 0 : getTimes().hashCode());
        result = prime * result + ((getBetnumber() == null) ? 0 : getBetnumber().hashCode());
        result = prime * result + ((getOdds() == null) ? 0 : getOdds().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getGameplayname() == null) ? 0 : getGameplayname().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getGameresult() == null) ? 0 : getGameresult().hashCode());
        result = prime * result + ((getLotterycreatetime() == null) ? 0 : getLotterycreatetime().hashCode());
        result = prime * result + ((getWinningstatus() == null) ? 0 : getWinningstatus().hashCode());
        return result;
    }
}