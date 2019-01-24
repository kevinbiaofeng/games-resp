package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetFightnn implements Serializable {
    private Long id;

    /** 盘编号 */
    private Long panId;

    /** 开始时间 */
    private Date timeBegin;

    /** 结束时间 */
    private Date timeEnd;

    /** 用户名 */
    private String username;

    /** 房间编号 */
    private String roomid;

    /** 桌号 */
    private String tableid;

    /** 座位号 */
    private String seatid;

    private String betValue;

    /** 输赢金额 */
    private String value;

    private String mutiBet;

    /** 翻倍 */
    private String multi;

    /** 牌型 */
    private String cardtype;

    /** 牌 */
    private String cards;

    /** 金币 */
    private String gamecoin;

    /** 房间名称 */
    private String roomName;

    private Integer userid;

    /** 创建时间 */
    private Date createtime;

    private Integer cid;

    private Date groupfor;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPanId() {
        return panId;
    }

    public void setPanId(Long panId) {
        this.panId = panId;
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

    public String getSeatid() {
        return seatid;
    }

    public void setSeatid(String seatid) {
        this.seatid = seatid == null ? null : seatid.trim();
    }

    public String getBetValue() {
        return betValue;
    }

    public void setBetValue(String betValue) {
        this.betValue = betValue == null ? null : betValue.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getMutiBet() {
        return mutiBet;
    }

    public void setMutiBet(String mutiBet) {
        this.mutiBet = mutiBet == null ? null : mutiBet.trim();
    }

    public String getMulti() {
        return multi;
    }

    public void setMulti(String multi) {
        this.multi = multi == null ? null : multi.trim();
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards == null ? null : cards.trim();
    }

    public String getGamecoin() {
        return gamecoin;
    }

    public void setGamecoin(String gamecoin) {
        this.gamecoin = gamecoin == null ? null : gamecoin.trim();
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(Date groupfor) {
        this.groupfor = groupfor;
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
        FontanaBetFightnn other = (FontanaBetFightnn) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPanId() == null ? other.getPanId() == null : this.getPanId().equals(other.getPanId()))
            && (this.getTimeBegin() == null ? other.getTimeBegin() == null : this.getTimeBegin().equals(other.getTimeBegin()))
            && (this.getTimeEnd() == null ? other.getTimeEnd() == null : this.getTimeEnd().equals(other.getTimeEnd()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getRoomid() == null ? other.getRoomid() == null : this.getRoomid().equals(other.getRoomid()))
            && (this.getTableid() == null ? other.getTableid() == null : this.getTableid().equals(other.getTableid()))
            && (this.getSeatid() == null ? other.getSeatid() == null : this.getSeatid().equals(other.getSeatid()))
            && (this.getBetValue() == null ? other.getBetValue() == null : this.getBetValue().equals(other.getBetValue()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getMutiBet() == null ? other.getMutiBet() == null : this.getMutiBet().equals(other.getMutiBet()))
            && (this.getMulti() == null ? other.getMulti() == null : this.getMulti().equals(other.getMulti()))
            && (this.getCardtype() == null ? other.getCardtype() == null : this.getCardtype().equals(other.getCardtype()))
            && (this.getCards() == null ? other.getCards() == null : this.getCards().equals(other.getCards()))
            && (this.getGamecoin() == null ? other.getGamecoin() == null : this.getGamecoin().equals(other.getGamecoin()))
            && (this.getRoomName() == null ? other.getRoomName() == null : this.getRoomName().equals(other.getRoomName()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()));
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
        result = prime * result + ((getSeatid() == null) ? 0 : getSeatid().hashCode());
        result = prime * result + ((getBetValue() == null) ? 0 : getBetValue().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getMutiBet() == null) ? 0 : getMutiBet().hashCode());
        result = prime * result + ((getMulti() == null) ? 0 : getMulti().hashCode());
        result = prime * result + ((getCardtype() == null) ? 0 : getCardtype().hashCode());
        result = prime * result + ((getCards() == null) ? 0 : getCards().hashCode());
        result = prime * result + ((getGamecoin() == null) ? 0 : getGamecoin().hashCode());
        result = prime * result + ((getRoomName() == null) ? 0 : getRoomName().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        return result;
    }
}