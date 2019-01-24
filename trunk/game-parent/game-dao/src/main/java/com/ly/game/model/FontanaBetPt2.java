package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetPt2 implements Serializable {
    /** id */
    private Long id;

    /** 订单号 */
    private String betnum;

    /** 用户id */
    private Long uid;

    /** 用户名 */
    private String username;

    /** 公司id */
    private Long cid;

    /** 下注时间 */
    private Date bettime;

    /** 下注金额 */
    private Double betamount;

    /** 有效投注额 */
    private Double validamount;

    /** 输赢金额 */
    private Double result;

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

    /** 游戏id */
    private Integer gameid;

    /** 游戏类型 1:as 2:h5 */
    private Integer gametype;

    /** 1:普通旋转 2:免费旋转 3:奖励游戏 4:赌博 */
    private Integer rotarytype;

    /** long类型的下注时间 */
    private Long gamedate;

    /** 开始筹码 */
    private Double startchips;

    /** 结束筹码 */
    private Double endchips;

    /** 总奖金 */
    private Double allwins;

    /** 代理商自增局id */
    private Integer collectid;

    /** 美元球投注 */
    private Double dollarballbets;

    /** 美元球奖金 */
    private Double dollarballbonus;

    /** jackpot 奖金 */
    private Double jackpotbonus;

    /** JP贡献 */
    private Double jpcontri;

    /** 美元球JP */
    private Double dbjp;

    /** 美元球JP贡献 */
    private Double dbjpcontri;

    /** 平台费用 */
    private Double pfee;

    /** 游戏名字 */
    private String gamename;

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

    public Integer getGameid() {
        return gameid;
    }

    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }

    public Integer getGametype() {
        return gametype;
    }

    public void setGametype(Integer gametype) {
        this.gametype = gametype;
    }

    public Integer getRotarytype() {
        return rotarytype;
    }

    public void setRotarytype(Integer rotarytype) {
        this.rotarytype = rotarytype;
    }

    public Long getGamedate() {
        return gamedate;
    }

    public void setGamedate(Long gamedate) {
        this.gamedate = gamedate;
    }

    public Double getStartchips() {
        return startchips;
    }

    public void setStartchips(Double startchips) {
        this.startchips = startchips;
    }

    public Double getEndchips() {
        return endchips;
    }

    public void setEndchips(Double endchips) {
        this.endchips = endchips;
    }

    public Double getAllwins() {
        return allwins;
    }

    public void setAllwins(Double allwins) {
        this.allwins = allwins;
    }

    public Integer getCollectid() {
        return collectid;
    }

    public void setCollectid(Integer collectid) {
        this.collectid = collectid;
    }

    public Double getDollarballbets() {
        return dollarballbets;
    }

    public void setDollarballbets(Double dollarballbets) {
        this.dollarballbets = dollarballbets;
    }

    public Double getDollarballbonus() {
        return dollarballbonus;
    }

    public void setDollarballbonus(Double dollarballbonus) {
        this.dollarballbonus = dollarballbonus;
    }

    public Double getJackpotbonus() {
        return jackpotbonus;
    }

    public void setJackpotbonus(Double jackpotbonus) {
        this.jackpotbonus = jackpotbonus;
    }

    public Double getJpcontri() {
        return jpcontri;
    }

    public void setJpcontri(Double jpcontri) {
        this.jpcontri = jpcontri;
    }

    public Double getDbjp() {
        return dbjp;
    }

    public void setDbjp(Double dbjp) {
        this.dbjp = dbjp;
    }

    public Double getDbjpcontri() {
        return dbjpcontri;
    }

    public void setDbjpcontri(Double dbjpcontri) {
        this.dbjpcontri = dbjpcontri;
    }

    public Double getPfee() {
        return pfee;
    }

    public void setPfee(Double pfee) {
        this.pfee = pfee;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
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
        FontanaBetPt2 other = (FontanaBetPt2) that;
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
            && (this.getGameid() == null ? other.getGameid() == null : this.getGameid().equals(other.getGameid()))
            && (this.getGametype() == null ? other.getGametype() == null : this.getGametype().equals(other.getGametype()))
            && (this.getRotarytype() == null ? other.getRotarytype() == null : this.getRotarytype().equals(other.getRotarytype()))
            && (this.getGamedate() == null ? other.getGamedate() == null : this.getGamedate().equals(other.getGamedate()))
            && (this.getStartchips() == null ? other.getStartchips() == null : this.getStartchips().equals(other.getStartchips()))
            && (this.getEndchips() == null ? other.getEndchips() == null : this.getEndchips().equals(other.getEndchips()))
            && (this.getAllwins() == null ? other.getAllwins() == null : this.getAllwins().equals(other.getAllwins()))
            && (this.getCollectid() == null ? other.getCollectid() == null : this.getCollectid().equals(other.getCollectid()))
            && (this.getDollarballbets() == null ? other.getDollarballbets() == null : this.getDollarballbets().equals(other.getDollarballbets()))
            && (this.getDollarballbonus() == null ? other.getDollarballbonus() == null : this.getDollarballbonus().equals(other.getDollarballbonus()))
            && (this.getJackpotbonus() == null ? other.getJackpotbonus() == null : this.getJackpotbonus().equals(other.getJackpotbonus()))
            && (this.getJpcontri() == null ? other.getJpcontri() == null : this.getJpcontri().equals(other.getJpcontri()))
            && (this.getDbjp() == null ? other.getDbjp() == null : this.getDbjp().equals(other.getDbjp()))
            && (this.getDbjpcontri() == null ? other.getDbjpcontri() == null : this.getDbjpcontri().equals(other.getDbjpcontri()))
            && (this.getPfee() == null ? other.getPfee() == null : this.getPfee().equals(other.getPfee()))
            && (this.getGamename() == null ? other.getGamename() == null : this.getGamename().equals(other.getGamename()));
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
        result = prime * result + ((getGameid() == null) ? 0 : getGameid().hashCode());
        result = prime * result + ((getGametype() == null) ? 0 : getGametype().hashCode());
        result = prime * result + ((getRotarytype() == null) ? 0 : getRotarytype().hashCode());
        result = prime * result + ((getGamedate() == null) ? 0 : getGamedate().hashCode());
        result = prime * result + ((getStartchips() == null) ? 0 : getStartchips().hashCode());
        result = prime * result + ((getEndchips() == null) ? 0 : getEndchips().hashCode());
        result = prime * result + ((getAllwins() == null) ? 0 : getAllwins().hashCode());
        result = prime * result + ((getCollectid() == null) ? 0 : getCollectid().hashCode());
        result = prime * result + ((getDollarballbets() == null) ? 0 : getDollarballbets().hashCode());
        result = prime * result + ((getDollarballbonus() == null) ? 0 : getDollarballbonus().hashCode());
        result = prime * result + ((getJackpotbonus() == null) ? 0 : getJackpotbonus().hashCode());
        result = prime * result + ((getJpcontri() == null) ? 0 : getJpcontri().hashCode());
        result = prime * result + ((getDbjp() == null) ? 0 : getDbjp().hashCode());
        result = prime * result + ((getDbjpcontri() == null) ? 0 : getDbjpcontri().hashCode());
        result = prime * result + ((getPfee() == null) ? 0 : getPfee().hashCode());
        result = prime * result + ((getGamename() == null) ? 0 : getGamename().hashCode());
        return result;
    }
}