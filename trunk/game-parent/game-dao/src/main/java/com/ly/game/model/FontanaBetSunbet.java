package com.ly.game.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FontanaBetSunbet implements Serializable {
    /** 本表的注释需要弄清楚后加上 */
    private Long id;

    private String ugsbetid;

    private Integer parentid;

    private String txid;

    private String betid;

    private Date beton;

    private Date betclosedon;

    private Date betupdatedon;

    private Date timestamp;

    private String roundid;

    private String roundstatus;

    private Long userid;

    private String username;

    private BigDecimal riskamt;

    private BigDecimal winamt;

    private BigDecimal winloss;

    private BigDecimal beforebal;

    private BigDecimal postbal;

    private String cur;

    private String gameprovider;

    private String gamename;

    private String gameid;

    private String gameplatformtype;

    private String ipaddress;

    private String bettype;

    private String playtype;

    /** 创建时间 */
    private Date createtime;

    private String gameplatformid;

    private String gameplatformchild;

    private String groupfor;

    /** 有效投注额 */
    private Double validbet;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUgsbetid() {
        return ugsbetid;
    }

    public void setUgsbetid(String ugsbetid) {
        this.ugsbetid = ugsbetid == null ? null : ugsbetid.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid == null ? null : txid.trim();
    }

    public String getBetid() {
        return betid;
    }

    public void setBetid(String betid) {
        this.betid = betid == null ? null : betid.trim();
    }

    public Date getBeton() {
        return beton;
    }

    public void setBeton(Date beton) {
        this.beton = beton;
    }

    public Date getBetclosedon() {
        return betclosedon;
    }

    public void setBetclosedon(Date betclosedon) {
        this.betclosedon = betclosedon;
    }

    public Date getBetupdatedon() {
        return betupdatedon;
    }

    public void setBetupdatedon(Date betupdatedon) {
        this.betupdatedon = betupdatedon;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getRoundid() {
        return roundid;
    }

    public void setRoundid(String roundid) {
        this.roundid = roundid == null ? null : roundid.trim();
    }

    public String getRoundstatus() {
        return roundstatus;
    }

    public void setRoundstatus(String roundstatus) {
        this.roundstatus = roundstatus == null ? null : roundstatus.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public BigDecimal getRiskamt() {
        return riskamt;
    }

    public void setRiskamt(BigDecimal riskamt) {
        this.riskamt = riskamt;
    }

    public BigDecimal getWinamt() {
        return winamt;
    }

    public void setWinamt(BigDecimal winamt) {
        this.winamt = winamt;
    }

    public BigDecimal getWinloss() {
        return winloss;
    }

    public void setWinloss(BigDecimal winloss) {
        this.winloss = winloss;
    }

    public BigDecimal getBeforebal() {
        return beforebal;
    }

    public void setBeforebal(BigDecimal beforebal) {
        this.beforebal = beforebal;
    }

    public BigDecimal getPostbal() {
        return postbal;
    }

    public void setPostbal(BigDecimal postbal) {
        this.postbal = postbal;
    }

    public String getCur() {
        return cur;
    }

    public void setCur(String cur) {
        this.cur = cur == null ? null : cur.trim();
    }

    public String getGameprovider() {
        return gameprovider;
    }

    public void setGameprovider(String gameprovider) {
        this.gameprovider = gameprovider == null ? null : gameprovider.trim();
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid == null ? null : gameid.trim();
    }

    public String getGameplatformtype() {
        return gameplatformtype;
    }

    public void setGameplatformtype(String gameplatformtype) {
        this.gameplatformtype = gameplatformtype == null ? null : gameplatformtype.trim();
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }

    public String getBettype() {
        return bettype;
    }

    public void setBettype(String bettype) {
        this.bettype = bettype == null ? null : bettype.trim();
    }

    public String getPlaytype() {
        return playtype;
    }

    public void setPlaytype(String playtype) {
        this.playtype = playtype == null ? null : playtype.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getGameplatformid() {
        return gameplatformid;
    }

    public void setGameplatformid(String gameplatformid) {
        this.gameplatformid = gameplatformid == null ? null : gameplatformid.trim();
    }

    public String getGameplatformchild() {
        return gameplatformchild;
    }

    public void setGameplatformchild(String gameplatformchild) {
        this.gameplatformchild = gameplatformchild == null ? null : gameplatformchild.trim();
    }

    public String getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(String groupfor) {
        this.groupfor = groupfor;
    }

    public Double getValidbet() {
        return validbet;
    }

    public void setValidbet(Double validbet) {
        this.validbet = validbet;
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
        FontanaBetSunbet other = (FontanaBetSunbet) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUgsbetid() == null ? other.getUgsbetid() == null : this.getUgsbetid().equals(other.getUgsbetid()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getTxid() == null ? other.getTxid() == null : this.getTxid().equals(other.getTxid()))
            && (this.getBetid() == null ? other.getBetid() == null : this.getBetid().equals(other.getBetid()))
            && (this.getBeton() == null ? other.getBeton() == null : this.getBeton().equals(other.getBeton()))
            && (this.getBetclosedon() == null ? other.getBetclosedon() == null : this.getBetclosedon().equals(other.getBetclosedon()))
            && (this.getBetupdatedon() == null ? other.getBetupdatedon() == null : this.getBetupdatedon().equals(other.getBetupdatedon()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()))
            && (this.getRoundid() == null ? other.getRoundid() == null : this.getRoundid().equals(other.getRoundid()))
            && (this.getRoundstatus() == null ? other.getRoundstatus() == null : this.getRoundstatus().equals(other.getRoundstatus()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getRiskamt() == null ? other.getRiskamt() == null : this.getRiskamt().equals(other.getRiskamt()))
            && (this.getWinamt() == null ? other.getWinamt() == null : this.getWinamt().equals(other.getWinamt()))
            && (this.getWinloss() == null ? other.getWinloss() == null : this.getWinloss().equals(other.getWinloss()))
            && (this.getBeforebal() == null ? other.getBeforebal() == null : this.getBeforebal().equals(other.getBeforebal()))
            && (this.getPostbal() == null ? other.getPostbal() == null : this.getPostbal().equals(other.getPostbal()))
            && (this.getCur() == null ? other.getCur() == null : this.getCur().equals(other.getCur()))
            && (this.getGameprovider() == null ? other.getGameprovider() == null : this.getGameprovider().equals(other.getGameprovider()))
            && (this.getGamename() == null ? other.getGamename() == null : this.getGamename().equals(other.getGamename()))
            && (this.getGameid() == null ? other.getGameid() == null : this.getGameid().equals(other.getGameid()))
            && (this.getGameplatformtype() == null ? other.getGameplatformtype() == null : this.getGameplatformtype().equals(other.getGameplatformtype()))
            && (this.getIpaddress() == null ? other.getIpaddress() == null : this.getIpaddress().equals(other.getIpaddress()))
            && (this.getBettype() == null ? other.getBettype() == null : this.getBettype().equals(other.getBettype()))
            && (this.getPlaytype() == null ? other.getPlaytype() == null : this.getPlaytype().equals(other.getPlaytype()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getGameplatformid() == null ? other.getGameplatformid() == null : this.getGameplatformid().equals(other.getGameplatformid()))
            && (this.getGameplatformchild() == null ? other.getGameplatformchild() == null : this.getGameplatformchild().equals(other.getGameplatformchild()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getValidbet() == null ? other.getValidbet() == null : this.getValidbet().equals(other.getValidbet()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUgsbetid() == null) ? 0 : getUgsbetid().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getTxid() == null) ? 0 : getTxid().hashCode());
        result = prime * result + ((getBetid() == null) ? 0 : getBetid().hashCode());
        result = prime * result + ((getBeton() == null) ? 0 : getBeton().hashCode());
        result = prime * result + ((getBetclosedon() == null) ? 0 : getBetclosedon().hashCode());
        result = prime * result + ((getBetupdatedon() == null) ? 0 : getBetupdatedon().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        result = prime * result + ((getRoundid() == null) ? 0 : getRoundid().hashCode());
        result = prime * result + ((getRoundstatus() == null) ? 0 : getRoundstatus().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getRiskamt() == null) ? 0 : getRiskamt().hashCode());
        result = prime * result + ((getWinamt() == null) ? 0 : getWinamt().hashCode());
        result = prime * result + ((getWinloss() == null) ? 0 : getWinloss().hashCode());
        result = prime * result + ((getBeforebal() == null) ? 0 : getBeforebal().hashCode());
        result = prime * result + ((getPostbal() == null) ? 0 : getPostbal().hashCode());
        result = prime * result + ((getCur() == null) ? 0 : getCur().hashCode());
        result = prime * result + ((getGameprovider() == null) ? 0 : getGameprovider().hashCode());
        result = prime * result + ((getGamename() == null) ? 0 : getGamename().hashCode());
        result = prime * result + ((getGameid() == null) ? 0 : getGameid().hashCode());
        result = prime * result + ((getGameplatformtype() == null) ? 0 : getGameplatformtype().hashCode());
        result = prime * result + ((getIpaddress() == null) ? 0 : getIpaddress().hashCode());
        result = prime * result + ((getBettype() == null) ? 0 : getBettype().hashCode());
        result = prime * result + ((getPlaytype() == null) ? 0 : getPlaytype().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getGameplatformid() == null) ? 0 : getGameplatformid().hashCode());
        result = prime * result + ((getGameplatformchild() == null) ? 0 : getGameplatformchild().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getValidbet() == null) ? 0 : getValidbet().hashCode());
        return result;
    }
}