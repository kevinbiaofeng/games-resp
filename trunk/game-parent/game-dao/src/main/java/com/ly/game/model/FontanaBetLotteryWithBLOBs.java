package com.ly.game.model;

import java.io.Serializable;

public class FontanaBetLotteryWithBLOBs extends FontanaBetLottery implements Serializable {
    private String note;

    private String prizedetail;

    private static final long serialVersionUID = 1L;

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
        FontanaBetLotteryWithBLOBs other = (FontanaBetLotteryWithBLOBs) that;
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