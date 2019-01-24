package com.ly.game.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class FontanaBetVggame implements Serializable {
    /** 唯一id，更新状态时传递这个字段的值 */
    @JSONField(name = "id")
    private String betnum;

    /** 用户id */
    private Long uid;

    /** 用户名称 */
    private String username;

    /** 公司id */
    private Long cid;
    /** 下注时间、开始时间 */
    @JSONField(format = "yyyy/MM/dd HH:mm:ss" ,name ="begintime")
    private Date bettime;

    /** 总投注 */
    @JSONField(name ="betamount")
    private BigDecimal betamount;

    /** 有效投注额 */
    @JSONField(name ="validbetamount")
    private BigDecimal validamount;

    /** 输赢金额 */
    @JSONField(name ="money")
    private BigDecimal result;

    /** 对账时间，美东时间 */
    private Date groupfor;

    /** 大股东id */
    private Long pid;

    /** 股东id */
    private Long gid;

    /** 总代理id */
    private Long aid;

    /** 代理id */
    private Long sid;

    /** 用户来源，暂时没用 */
    private String source;

    /** 渠道号 */
    private String channel;

    /** 创建时间 */
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    private Date createtime;

    /** 游戏类型，1=斗地主，2=二人麻将，3=抢庄牛牛，4=百人牛牛 */
    private Short gametype;

    /** 房间编号 */
    private String roomid;

    /** 桌号 */
    private String tableid;

    /** 局id */
    private String roundid;

    /** 下注点 */
    private String betpoint;

    /** 赔率（翻倍数） */
    private String odds;

    /** 服务费（抽水） */
    private BigDecimal servicemoney;

    /** 游戏结束时间 */
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    private Date endtime;

    /** 庄闲 1表示庄 0表示闲 */
    private Integer isbanker;

    /** 发牌情况 */
    private String gameinfo;

    /** 游戏结果，0=输，1=赢，2=和 */
    private Short gameresult;

    /** 开局时用户余额 */
    private BigDecimal beforbalance;

    /** 额外字段1，默认为空，值根据根据游戏而定 */
    private String info1;

    /** 额外字2，默认为空，值根据根据游戏而定 */
    private String info2;

    /** 额外字段3，默认为空，值根据根据游戏而定 */
    private String info3;

    private static final long serialVersionUID = 1L;

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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Short getGametype() {
        return gametype;
    }

    public void setGametype(Short gametype) {
        this.gametype = gametype;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid == null ? null : roomid.trim();
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid == null ? null : tableid.trim();
    }

    public String getRoundid() {
        return roundid;
    }

    public void setRoundid(String roundid) {
        this.roundid = roundid == null ? null : roundid.trim();
    }

    public String getBetpoint() {
        return betpoint;
    }

    public void setBetpoint(String betpoint) {
        this.betpoint = betpoint == null ? null : betpoint.trim();
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds == null ? null : odds.trim();
    }

    public BigDecimal getServicemoney() {
        return servicemoney;
    }

    public void setServicemoney(BigDecimal servicemoney) {
        this.servicemoney = servicemoney;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getIsbanker() {
        return isbanker;
    }

    public void setIsbanker(Integer isbanker) {
        this.isbanker = isbanker;
    }

    public String getGameinfo() {
        return gameinfo;
    }

    public void setGameinfo(String gameinfo) {
        this.gameinfo = gameinfo == null ? null : gameinfo.trim();
    }

    public Short getGameresult() {
        return gameresult;
    }

    public void setGameresult(Short gameresult) {
        this.gameresult = gameresult;
    }

    public BigDecimal getBeforbalance() {
        return beforbalance;
    }

    public void setBeforbalance(BigDecimal beforbalance) {
        this.beforbalance = beforbalance;
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1 == null ? null : info1.trim();
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2 == null ? null : info2.trim();
    }

    public String getInfo3() {
        return info3;
    }

    public void setInfo3(String info3) {
        this.info3 = info3 == null ? null : info3.trim();
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
        FontanaBetVggame other = (FontanaBetVggame) that;
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
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getGametype() == null ? other.getGametype() == null : this.getGametype().equals(other.getGametype()))
            && (this.getRoomid() == null ? other.getRoomid() == null : this.getRoomid().equals(other.getRoomid()))
            && (this.getTableid() == null ? other.getTableid() == null : this.getTableid().equals(other.getTableid()))
            && (this.getRoundid() == null ? other.getRoundid() == null : this.getRoundid().equals(other.getRoundid()))
            && (this.getBetpoint() == null ? other.getBetpoint() == null : this.getBetpoint().equals(other.getBetpoint()))
            && (this.getOdds() == null ? other.getOdds() == null : this.getOdds().equals(other.getOdds()))
            && (this.getServicemoney() == null ? other.getServicemoney() == null : this.getServicemoney().equals(other.getServicemoney()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getIsbanker() == null ? other.getIsbanker() == null : this.getIsbanker().equals(other.getIsbanker()))
            && (this.getGameinfo() == null ? other.getGameinfo() == null : this.getGameinfo().equals(other.getGameinfo()))
            && (this.getGameresult() == null ? other.getGameresult() == null : this.getGameresult().equals(other.getGameresult()))
            && (this.getBeforbalance() == null ? other.getBeforbalance() == null : this.getBeforbalance().equals(other.getBeforbalance()))
            && (this.getInfo1() == null ? other.getInfo1() == null : this.getInfo1().equals(other.getInfo1()))
            && (this.getInfo2() == null ? other.getInfo2() == null : this.getInfo2().equals(other.getInfo2()))
            && (this.getInfo3() == null ? other.getInfo3() == null : this.getInfo3().equals(other.getInfo3()));
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
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getGametype() == null) ? 0 : getGametype().hashCode());
        result = prime * result + ((getRoomid() == null) ? 0 : getRoomid().hashCode());
        result = prime * result + ((getTableid() == null) ? 0 : getTableid().hashCode());
        result = prime * result + ((getRoundid() == null) ? 0 : getRoundid().hashCode());
        result = prime * result + ((getBetpoint() == null) ? 0 : getBetpoint().hashCode());
        result = prime * result + ((getOdds() == null) ? 0 : getOdds().hashCode());
        result = prime * result + ((getServicemoney() == null) ? 0 : getServicemoney().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getIsbanker() == null) ? 0 : getIsbanker().hashCode());
        result = prime * result + ((getGameinfo() == null) ? 0 : getGameinfo().hashCode());
        result = prime * result + ((getGameresult() == null) ? 0 : getGameresult().hashCode());
        result = prime * result + ((getBeforbalance() == null) ? 0 : getBeforbalance().hashCode());
        result = prime * result + ((getInfo1() == null) ? 0 : getInfo1().hashCode());
        result = prime * result + ((getInfo2() == null) ? 0 : getInfo2().hashCode());
        result = prime * result + ((getInfo3() == null) ? 0 : getInfo3().hashCode());
        return result;
    }
}