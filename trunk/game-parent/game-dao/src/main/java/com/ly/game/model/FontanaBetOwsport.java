package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetOwsport implements Serializable {
    private Long id;

    /** 注单号 */
    private Long betnum;

    /** 玩家id */
    private Long uid;

    /** 玩家名字 */
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

    /** 订单状态 */
    private String ticketstatus;

    /** 订单对账日期 */
    private Date groupfor;

    /** 体育类型 */
    private String sporttype;

    /** 抓票对应的versionKey */
    private Integer versionkey;

    /** 大股东id */
    private Long pid;

    /** 股东id */
    private Long gid;

    /** 总代理id */
    private Long aid;

    /** 代理id */
    private Long sid;

    /** 用户来源 */
    private String source;

    /** 游戏比赛id */
    private String matchid;

    /** 联赛id */
    private String leagueid;

    /** 联赛名字 */
    private String leaguename;

    /** 客场团队id */
    private String awayid;

    /** 客队名字 */
    private String awayidname;

    /** 主场id */
    private String homeid;

    /** 主场球队名字 */
    private String homeidname;

    /** 比赛开始时间 */
    private String matchdatetime;

    /** 打赌类型 */
    private String bettype;

    private String parlayrefno;

    /** 投注站代号 */
    private String betteam;

    /** 让分盘 */
    private Double hdp;

    /** 客队的让分盘 */
    private Double awayhdp;

    /** 主队打的让分盘 */
    private Double homehdp;

    /** 赔率 */
    private Double odds;

    /** 盘id */
    private Short oddstype;

    /** 客队得分 */
    private String awayscore;

    /** 主队得分 */
    private String homescore;

    /** Live 状态 */
    private String islive;

    private String islucky;

    /** X 和 Y 值 Bet Type */
    private String betTag;

    private String lastballno;

    /** 下注后的金额 */
    private Double afteramount;

    /** 币种 */
    private String currency;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBetnum() {
        return betnum;
    }

    public void setBetnum(Long betnum) {
        this.betnum = betnum;
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

    public String getTicketstatus() {
        return ticketstatus;
    }

    public void setTicketstatus(String ticketstatus) {
        this.ticketstatus = ticketstatus == null ? null : ticketstatus.trim();
    }

    public Date getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(Date groupfor) {
        this.groupfor = groupfor;
    }

    public String getSporttype() {
        return sporttype;
    }

    public void setSporttype(String sporttype) {
        this.sporttype = sporttype == null ? null : sporttype.trim();
    }

    public Integer getVersionkey() {
        return versionkey;
    }

    public void setVersionkey(Integer versionkey) {
        this.versionkey = versionkey;
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

    public String getMatchid() {
        return matchid;
    }

    public void setMatchid(String matchid) {
        this.matchid = matchid == null ? null : matchid.trim();
    }

    public String getLeagueid() {
        return leagueid;
    }

    public void setLeagueid(String leagueid) {
        this.leagueid = leagueid == null ? null : leagueid.trim();
    }

    public String getLeaguename() {
        return leaguename;
    }

    public void setLeaguename(String leaguename) {
        this.leaguename = leaguename == null ? null : leaguename.trim();
    }

    public String getAwayid() {
        return awayid;
    }

    public void setAwayid(String awayid) {
        this.awayid = awayid == null ? null : awayid.trim();
    }

    public String getAwayidname() {
        return awayidname;
    }

    public void setAwayidname(String awayidname) {
        this.awayidname = awayidname == null ? null : awayidname.trim();
    }

    public String getHomeid() {
        return homeid;
    }

    public void setHomeid(String homeid) {
        this.homeid = homeid == null ? null : homeid.trim();
    }

    public String getHomeidname() {
        return homeidname;
    }

    public void setHomeidname(String homeidname) {
        this.homeidname = homeidname == null ? null : homeidname.trim();
    }

    public String getMatchdatetime() {
        return matchdatetime;
    }

    public void setMatchdatetime(String matchdatetime) {
        this.matchdatetime = matchdatetime == null ? null : matchdatetime.trim();
    }

    public String getBettype() {
        return bettype;
    }

    public void setBettype(String bettype) {
        this.bettype = bettype == null ? null : bettype.trim();
    }

    public String getParlayrefno() {
        return parlayrefno;
    }

    public void setParlayrefno(String parlayrefno) {
        this.parlayrefno = parlayrefno == null ? null : parlayrefno.trim();
    }

    public String getBetteam() {
        return betteam;
    }

    public void setBetteam(String betteam) {
        this.betteam = betteam == null ? null : betteam.trim();
    }

    public Double getHdp() {
        return hdp;
    }

    public void setHdp(Double hdp) {
        this.hdp = hdp;
    }

    public Double getAwayhdp() {
        return awayhdp;
    }

    public void setAwayhdp(Double awayhdp) {
        this.awayhdp = awayhdp;
    }

    public Double getHomehdp() {
        return homehdp;
    }

    public void setHomehdp(Double homehdp) {
        this.homehdp = homehdp;
    }

    public Double getOdds() {
        return odds;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }

    public Short getOddstype() {
        return oddstype;
    }

    public void setOddstype(Short oddstype) {
        this.oddstype = oddstype;
    }

    public String getAwayscore() {
        return awayscore;
    }

    public void setAwayscore(String awayscore) {
        this.awayscore = awayscore == null ? null : awayscore.trim();
    }

    public String getHomescore() {
        return homescore;
    }

    public void setHomescore(String homescore) {
        this.homescore = homescore == null ? null : homescore.trim();
    }

    public String getIslive() {
        return islive;
    }

    public void setIslive(String islive) {
        this.islive = islive == null ? null : islive.trim();
    }

    public String getIslucky() {
        return islucky;
    }

    public void setIslucky(String islucky) {
        this.islucky = islucky == null ? null : islucky.trim();
    }

    public String getBetTag() {
        return betTag;
    }

    public void setBetTag(String betTag) {
        this.betTag = betTag == null ? null : betTag.trim();
    }

    public String getLastballno() {
        return lastballno;
    }

    public void setLastballno(String lastballno) {
        this.lastballno = lastballno == null ? null : lastballno.trim();
    }

    public Double getAfteramount() {
        return afteramount;
    }

    public void setAfteramount(Double afteramount) {
        this.afteramount = afteramount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
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
        FontanaBetOwsport other = (FontanaBetOwsport) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBetnum() == null ? other.getBetnum() == null : this.getBetnum().equals(other.getBetnum()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getBettime() == null ? other.getBettime() == null : this.getBettime().equals(other.getBettime()))
            && (this.getBetamount() == null ? other.getBetamount() == null : this.getBetamount().equals(other.getBetamount()))
            && (this.getValidamount() == null ? other.getValidamount() == null : this.getValidamount().equals(other.getValidamount()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getTicketstatus() == null ? other.getTicketstatus() == null : this.getTicketstatus().equals(other.getTicketstatus()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getSporttype() == null ? other.getSporttype() == null : this.getSporttype().equals(other.getSporttype()))
            && (this.getVersionkey() == null ? other.getVersionkey() == null : this.getVersionkey().equals(other.getVersionkey()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getMatchid() == null ? other.getMatchid() == null : this.getMatchid().equals(other.getMatchid()))
            && (this.getLeagueid() == null ? other.getLeagueid() == null : this.getLeagueid().equals(other.getLeagueid()))
            && (this.getLeaguename() == null ? other.getLeaguename() == null : this.getLeaguename().equals(other.getLeaguename()))
            && (this.getAwayid() == null ? other.getAwayid() == null : this.getAwayid().equals(other.getAwayid()))
            && (this.getAwayidname() == null ? other.getAwayidname() == null : this.getAwayidname().equals(other.getAwayidname()))
            && (this.getHomeid() == null ? other.getHomeid() == null : this.getHomeid().equals(other.getHomeid()))
            && (this.getHomeidname() == null ? other.getHomeidname() == null : this.getHomeidname().equals(other.getHomeidname()))
            && (this.getMatchdatetime() == null ? other.getMatchdatetime() == null : this.getMatchdatetime().equals(other.getMatchdatetime()))
            && (this.getBettype() == null ? other.getBettype() == null : this.getBettype().equals(other.getBettype()))
            && (this.getParlayrefno() == null ? other.getParlayrefno() == null : this.getParlayrefno().equals(other.getParlayrefno()))
            && (this.getBetteam() == null ? other.getBetteam() == null : this.getBetteam().equals(other.getBetteam()))
            && (this.getHdp() == null ? other.getHdp() == null : this.getHdp().equals(other.getHdp()))
            && (this.getAwayhdp() == null ? other.getAwayhdp() == null : this.getAwayhdp().equals(other.getAwayhdp()))
            && (this.getHomehdp() == null ? other.getHomehdp() == null : this.getHomehdp().equals(other.getHomehdp()))
            && (this.getOdds() == null ? other.getOdds() == null : this.getOdds().equals(other.getOdds()))
            && (this.getOddstype() == null ? other.getOddstype() == null : this.getOddstype().equals(other.getOddstype()))
            && (this.getAwayscore() == null ? other.getAwayscore() == null : this.getAwayscore().equals(other.getAwayscore()))
            && (this.getHomescore() == null ? other.getHomescore() == null : this.getHomescore().equals(other.getHomescore()))
            && (this.getIslive() == null ? other.getIslive() == null : this.getIslive().equals(other.getIslive()))
            && (this.getIslucky() == null ? other.getIslucky() == null : this.getIslucky().equals(other.getIslucky()))
            && (this.getBetTag() == null ? other.getBetTag() == null : this.getBetTag().equals(other.getBetTag()))
            && (this.getLastballno() == null ? other.getLastballno() == null : this.getLastballno().equals(other.getLastballno()))
            && (this.getAfteramount() == null ? other.getAfteramount() == null : this.getAfteramount().equals(other.getAfteramount()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()));
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
        result = prime * result + ((getTicketstatus() == null) ? 0 : getTicketstatus().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getSporttype() == null) ? 0 : getSporttype().hashCode());
        result = prime * result + ((getVersionkey() == null) ? 0 : getVersionkey().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getMatchid() == null) ? 0 : getMatchid().hashCode());
        result = prime * result + ((getLeagueid() == null) ? 0 : getLeagueid().hashCode());
        result = prime * result + ((getLeaguename() == null) ? 0 : getLeaguename().hashCode());
        result = prime * result + ((getAwayid() == null) ? 0 : getAwayid().hashCode());
        result = prime * result + ((getAwayidname() == null) ? 0 : getAwayidname().hashCode());
        result = prime * result + ((getHomeid() == null) ? 0 : getHomeid().hashCode());
        result = prime * result + ((getHomeidname() == null) ? 0 : getHomeidname().hashCode());
        result = prime * result + ((getMatchdatetime() == null) ? 0 : getMatchdatetime().hashCode());
        result = prime * result + ((getBettype() == null) ? 0 : getBettype().hashCode());
        result = prime * result + ((getParlayrefno() == null) ? 0 : getParlayrefno().hashCode());
        result = prime * result + ((getBetteam() == null) ? 0 : getBetteam().hashCode());
        result = prime * result + ((getHdp() == null) ? 0 : getHdp().hashCode());
        result = prime * result + ((getAwayhdp() == null) ? 0 : getAwayhdp().hashCode());
        result = prime * result + ((getHomehdp() == null) ? 0 : getHomehdp().hashCode());
        result = prime * result + ((getOdds() == null) ? 0 : getOdds().hashCode());
        result = prime * result + ((getOddstype() == null) ? 0 : getOddstype().hashCode());
        result = prime * result + ((getAwayscore() == null) ? 0 : getAwayscore().hashCode());
        result = prime * result + ((getHomescore() == null) ? 0 : getHomescore().hashCode());
        result = prime * result + ((getIslive() == null) ? 0 : getIslive().hashCode());
        result = prime * result + ((getIslucky() == null) ? 0 : getIslucky().hashCode());
        result = prime * result + ((getBetTag() == null) ? 0 : getBetTag().hashCode());
        result = prime * result + ((getLastballno() == null) ? 0 : getLastballno().hashCode());
        result = prime * result + ((getAfteramount() == null) ? 0 : getAfteramount().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        return result;
    }
}