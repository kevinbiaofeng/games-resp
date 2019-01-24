package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetFightbrnn implements Serializable {
    /** id */
    private Long id;

    /** 盘编号 */
    private String panId;

    /** 开始时间 */
    private Date timeBegin;

    /** 结束时间 */
    private Date timeEnd;

    /** 玩家账号 */
    private String username;

    /** 房间编号 */
    private Integer roomid;

    /** 桌号 */
    private Integer tableid;

    /** 座位号 */
    private String seated;

    /** 压注单 */
    private String betValue;

    /** 输赢 */
    private Integer win;

    /** 输赢金额 */
    private Double value;

    /** 庄家 */
    private String zhuangj;

    /** 牌型 */
    private String scards;

    /** 金币 */
    private Integer gamecoin;

    /** 抽水 */
    private Double fee;

    /** 玩家IP */
    private String ipUser;

    /** 是否机器人 */
    private Integer robot;

    /** 房间名称 */
    private String roomName;

    /** 局号 */
    private String roundGuid;

    /** 注单插入时间 */
    private Date createTime;

    /** groupfor时间 */
    private Date groupfor;

    /** 用户id */
    private Long uid;

    /** 公司id */
    private Long cid;

    /** 大股东id */
    private Long pid;

    /** 股东id */
    private Long gid;

    /** 总代理id */
    private Long aid;

    /** 代理id */
    private Long sid;

    /** 总有效投注额 */
    private Double betValues;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPanId() {
        return panId;
    }

    public void setPanId(String panId) {
        this.panId = panId == null ? null : panId.trim();
    }

    public Date getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Date timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public String getSeated() {
        return seated;
    }

    public void setSeated(String seated) {
        this.seated = seated == null ? null : seated.trim();
    }

    public String getBetValue() {
        return betValue;
    }

    public void setBetValue(String betValue) {
        this.betValue = betValue == null ? null : betValue.trim();
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getZhuangj() {
        return zhuangj;
    }

    public void setZhuangj(String zhuangj) {
        this.zhuangj = zhuangj == null ? null : zhuangj.trim();
    }

    public String getScards() {
        return scards;
    }

    public void setScards(String scards) {
        this.scards = scards == null ? null : scards.trim();
    }

    public Integer getGamecoin() {
        return gamecoin;
    }

    public void setGamecoin(Integer gamecoin) {
        this.gamecoin = gamecoin;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getIpUser() {
        return ipUser;
    }

    public void setIpUser(String ipUser) {
        this.ipUser = ipUser == null ? null : ipUser.trim();
    }

    public Integer getRobot() {
        return robot;
    }

    public void setRobot(Integer robot) {
        this.robot = robot;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public String getRoundGuid() {
        return roundGuid;
    }

    public void setRoundGuid(String roundGuid) {
        this.roundGuid = roundGuid == null ? null : roundGuid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(Date groupfor) {
        this.groupfor = groupfor;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

    public Double getBetValues() {
        return betValues;
    }

    public void setBetValues(Double betValues) {
        this.betValues = betValues;
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
        FontanaBetFightbrnn other = (FontanaBetFightbrnn) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPanId() == null ? other.getPanId() == null : this.getPanId().equals(other.getPanId()))
            && (this.getTimeBegin() == null ? other.getTimeBegin() == null : this.getTimeBegin().equals(other.getTimeBegin()))
            && (this.getTimeEnd() == null ? other.getTimeEnd() == null : this.getTimeEnd().equals(other.getTimeEnd()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getRoomid() == null ? other.getRoomid() == null : this.getRoomid().equals(other.getRoomid()))
            && (this.getTableid() == null ? other.getTableid() == null : this.getTableid().equals(other.getTableid()))
            && (this.getSeated() == null ? other.getSeated() == null : this.getSeated().equals(other.getSeated()))
            && (this.getBetValue() == null ? other.getBetValue() == null : this.getBetValue().equals(other.getBetValue()))
            && (this.getWin() == null ? other.getWin() == null : this.getWin().equals(other.getWin()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getZhuangj() == null ? other.getZhuangj() == null : this.getZhuangj().equals(other.getZhuangj()))
            && (this.getScards() == null ? other.getScards() == null : this.getScards().equals(other.getScards()))
            && (this.getGamecoin() == null ? other.getGamecoin() == null : this.getGamecoin().equals(other.getGamecoin()))
            && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()))
            && (this.getIpUser() == null ? other.getIpUser() == null : this.getIpUser().equals(other.getIpUser()))
            && (this.getRobot() == null ? other.getRobot() == null : this.getRobot().equals(other.getRobot()))
            && (this.getRoomName() == null ? other.getRoomName() == null : this.getRoomName().equals(other.getRoomName()))
            && (this.getRoundGuid() == null ? other.getRoundGuid() == null : this.getRoundGuid().equals(other.getRoundGuid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getBetValues() == null ? other.getBetValues() == null : this.getBetValues().equals(other.getBetValues()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPanId() == null) ? 0 : getPanId().hashCode());
        result = prime * result + ((getTimeBegin() == null) ? 0 : getTimeBegin().hashCode());
        result = prime * result + ((getTimeEnd() == null) ? 0 : getTimeEnd().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getRoomid() == null) ? 0 : getRoomid().hashCode());
        result = prime * result + ((getTableid() == null) ? 0 : getTableid().hashCode());
        result = prime * result + ((getSeated() == null) ? 0 : getSeated().hashCode());
        result = prime * result + ((getBetValue() == null) ? 0 : getBetValue().hashCode());
        result = prime * result + ((getWin() == null) ? 0 : getWin().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getZhuangj() == null) ? 0 : getZhuangj().hashCode());
        result = prime * result + ((getScards() == null) ? 0 : getScards().hashCode());
        result = prime * result + ((getGamecoin() == null) ? 0 : getGamecoin().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        result = prime * result + ((getIpUser() == null) ? 0 : getIpUser().hashCode());
        result = prime * result + ((getRobot() == null) ? 0 : getRobot().hashCode());
        result = prime * result + ((getRoomName() == null) ? 0 : getRoomName().hashCode());
        result = prime * result + ((getRoundGuid() == null) ? 0 : getRoundGuid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getBetValues() == null) ? 0 : getBetValues().hashCode());
        return result;
    }
}