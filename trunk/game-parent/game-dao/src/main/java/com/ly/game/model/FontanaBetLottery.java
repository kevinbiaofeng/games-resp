package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetLottery implements Serializable {
    private Long id;

    private String serialnumber;

    private Integer parentid;

    private Integer cid;

    private Integer playerid;

    private String playername;

    private Double merchantprize;

    private Double playerprize;

    private Double lossprize;

    private Integer state;

    private Integer substate;

    private String unit;

    private Double multiple;

    private Integer count;

    private Double cost;

    private String odds;

    private String number;

    private String position;

    private Integer channelid;

    private String channelname;

    private String bettypename;

    private String issuenumber;

    private String winningnumber;

    private Date bettime;

    private Date updatetime;

    private Date createtime;

    private Date groupfor;

    private String note;

    private String prizedetail;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber == null ? null : serialnumber.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPlayerid() {
        return playerid;
    }

    public void setPlayerid(Integer playerid) {
        this.playerid = playerid;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername == null ? null : playername.trim();
    }

    public Double getMerchantprize() {
        return merchantprize;
    }

    public void setMerchantprize(Double merchantprize) {
        this.merchantprize = merchantprize;
    }

    public Double getPlayerprize() {
        return playerprize;
    }

    public void setPlayerprize(Double playerprize) {
        this.playerprize = playerprize;
    }

    public Double getLossprize() {
        return lossprize;
    }

    public void setLossprize(Double lossprize) {
        this.lossprize = lossprize;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSubstate() {
        return substate;
    }

    public void setSubstate(Integer substate) {
        this.substate = substate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Double getMultiple() {
        return multiple;
    }

    public void setMultiple(Double multiple) {
        this.multiple = multiple;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds == null ? null : odds.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Integer getChannelid() {
        return channelid;
    }

    public void setChannelid(Integer channelid) {
        this.channelid = channelid;
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname == null ? null : channelname.trim();
    }

    public String getBettypename() {
        return bettypename;
    }

    public void setBettypename(String bettypename) {
        this.bettypename = bettypename == null ? null : bettypename.trim();
    }

    public String getIssuenumber() {
        return issuenumber;
    }

    public void setIssuenumber(String issuenumber) {
        this.issuenumber = issuenumber == null ? null : issuenumber.trim();
    }

    public String getWinningnumber() {
        return winningnumber;
    }

    public void setWinningnumber(String winningnumber) {
        this.winningnumber = winningnumber == null ? null : winningnumber.trim();
    }

    public Date getBettime() {
        return bettime;
    }

    public void setBettime(Date bettime) {
        this.bettime = bettime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(Date groupfor) {
        this.groupfor = groupfor;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getPrizedetail() {
        return prizedetail;
    }

    public void setPrizedetail(String prizedetail) {
        this.prizedetail = prizedetail == null ? null : prizedetail.trim();
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
        FontanaBetLottery other = (FontanaBetLottery) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSerialnumber() == null ? other.getSerialnumber() == null : this.getSerialnumber().equals(other.getSerialnumber()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getPlayerid() == null ? other.getPlayerid() == null : this.getPlayerid().equals(other.getPlayerid()))
            && (this.getPlayername() == null ? other.getPlayername() == null : this.getPlayername().equals(other.getPlayername()))
            && (this.getMerchantprize() == null ? other.getMerchantprize() == null : this.getMerchantprize().equals(other.getMerchantprize()))
            && (this.getPlayerprize() == null ? other.getPlayerprize() == null : this.getPlayerprize().equals(other.getPlayerprize()))
            && (this.getLossprize() == null ? other.getLossprize() == null : this.getLossprize().equals(other.getLossprize()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getSubstate() == null ? other.getSubstate() == null : this.getSubstate().equals(other.getSubstate()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getMultiple() == null ? other.getMultiple() == null : this.getMultiple().equals(other.getMultiple()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()))
            && (this.getOdds() == null ? other.getOdds() == null : this.getOdds().equals(other.getOdds()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getChannelid() == null ? other.getChannelid() == null : this.getChannelid().equals(other.getChannelid()))
            && (this.getChannelname() == null ? other.getChannelname() == null : this.getChannelname().equals(other.getChannelname()))
            && (this.getBettypename() == null ? other.getBettypename() == null : this.getBettypename().equals(other.getBettypename()))
            && (this.getIssuenumber() == null ? other.getIssuenumber() == null : this.getIssuenumber().equals(other.getIssuenumber()))
            && (this.getWinningnumber() == null ? other.getWinningnumber() == null : this.getWinningnumber().equals(other.getWinningnumber()))
            && (this.getBettime() == null ? other.getBettime() == null : this.getBettime().equals(other.getBettime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getPrizedetail() == null ? other.getPrizedetail() == null : this.getPrizedetail().equals(other.getPrizedetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSerialnumber() == null) ? 0 : getSerialnumber().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getPlayerid() == null) ? 0 : getPlayerid().hashCode());
        result = prime * result + ((getPlayername() == null) ? 0 : getPlayername().hashCode());
        result = prime * result + ((getMerchantprize() == null) ? 0 : getMerchantprize().hashCode());
        result = prime * result + ((getPlayerprize() == null) ? 0 : getPlayerprize().hashCode());
        result = prime * result + ((getLossprize() == null) ? 0 : getLossprize().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getSubstate() == null) ? 0 : getSubstate().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getMultiple() == null) ? 0 : getMultiple().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
        result = prime * result + ((getOdds() == null) ? 0 : getOdds().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getChannelid() == null) ? 0 : getChannelid().hashCode());
        result = prime * result + ((getChannelname() == null) ? 0 : getChannelname().hashCode());
        result = prime * result + ((getBettypename() == null) ? 0 : getBettypename().hashCode());
        result = prime * result + ((getIssuenumber() == null) ? 0 : getIssuenumber().hashCode());
        result = prime * result + ((getWinningnumber() == null) ? 0 : getWinningnumber().hashCode());
        result = prime * result + ((getBettime() == null) ? 0 : getBettime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getPrizedetail() == null) ? 0 : getPrizedetail().hashCode());
        return result;
    }
}