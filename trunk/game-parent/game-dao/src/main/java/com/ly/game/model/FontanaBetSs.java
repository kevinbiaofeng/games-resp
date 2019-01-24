package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetSs implements Serializable {
    /** 同步序号,refId */
    private Long id;

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

    /** 来源 */
    private String source;

    /** 参考ID,例子: 12342 */
    private String refid;

    /** 游戏编号 */
    private String playtype;

    /** 赛事编号 */
    private String matchindex;

    /** 赌注项目 */
    private Integer bettypecode;

    /** 方式 */
    private String teambetcode;

    /** 让球,例子: 1 , 0.75 , -0.25 ,-0.75 */
    private Double handicap;

    /** 赔率种类,例子: My(马来盘), euro(欧洲盘), hk1(香港盘) */
    private String oddstype;

    /** 下注赔率,例子: 1.98 or -0.88 or 2.30 */
    private Double wagerodds;

    /** 货币,例子: USD(美金) , RMB(人民币) , HKD(港币) */
    private String currencycode;

    /** 下注金额 (根据公司货币)例子: 320 */
    private Double wagerstake1;

    /** 输赢金额 (根据公司货币)例子: 3840,注: 成绩未揭晓将显示Null */
    private Double winamtl;

    /** 只限于走地,例子: 0:1 */
    private String score;

    /** 注单状态例子: 1: 有效,2: 取消,3: 待定,4: 拒绝,5: 退款 */
    private Integer bettingstatus;

    /** 结算时间 (若注单被取消,赛事取消,拒绝或待定，结算时间为空"null"),例子: 2013-07-10 00:35:23 */
    private Date lastupdate;

    /** 赛事时间,例子: 2015-08-26 00:00:00 */
    private Date matchdate;

    /** 有效注额,下注金额（公司货币）,例子: 160 */
    private Double finalstakel;

    /** 玩法编号 */
    private Integer playtypeindex;

    /** 联赛名称 */
    private String leaguename;

    /** 队伍A名称 */
    private String teamaname;

    /** 队伍B名称 */
    private String teambname;

    /** 玩法编号 */
    private String finalscore;

    /** 注单被取消的原因 */
    private String cancelreason;

    /** 子项数据JSON字符串 */
    private String detail;

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid == null ? null : refid.trim();
    }

    public String getPlaytype() {
        return playtype;
    }

    public void setPlaytype(String playtype) {
        this.playtype = playtype == null ? null : playtype.trim();
    }

    public String getMatchindex() {
        return matchindex;
    }

    public void setMatchindex(String matchindex) {
        this.matchindex = matchindex == null ? null : matchindex.trim();
    }

    public Integer getBettypecode() {
        return bettypecode;
    }

    public void setBettypecode(Integer bettypecode) {
        this.bettypecode = bettypecode;
    }

    public String getTeambetcode() {
        return teambetcode;
    }

    public void setTeambetcode(String teambetcode) {
        this.teambetcode = teambetcode == null ? null : teambetcode.trim();
    }

    public Double getHandicap() {
        return handicap;
    }

    public void setHandicap(Double handicap) {
        this.handicap = handicap;
    }

    public String getOddstype() {
        return oddstype;
    }

    public void setOddstype(String oddstype) {
        this.oddstype = oddstype == null ? null : oddstype.trim();
    }

    public Double getWagerodds() {
        return wagerodds;
    }

    public void setWagerodds(Double wagerodds) {
        this.wagerodds = wagerodds;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode == null ? null : currencycode.trim();
    }

    public Double getWagerstake1() {
        return wagerstake1;
    }

    public void setWagerstake1(Double wagerstake1) {
        this.wagerstake1 = wagerstake1;
    }

    public Double getWinamtl() {
        return winamtl;
    }

    public void setWinamtl(Double winamtl) {
        this.winamtl = winamtl;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public Integer getBettingstatus() {
        return bettingstatus;
    }

    public void setBettingstatus(Integer bettingstatus) {
        this.bettingstatus = bettingstatus;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public Date getMatchdate() {
        return matchdate;
    }

    public void setMatchdate(Date matchdate) {
        this.matchdate = matchdate;
    }

    public Double getFinalstakel() {
        return finalstakel;
    }

    public void setFinalstakel(Double finalstakel) {
        this.finalstakel = finalstakel;
    }

    public Integer getPlaytypeindex() {
        return playtypeindex;
    }

    public void setPlaytypeindex(Integer playtypeindex) {
        this.playtypeindex = playtypeindex;
    }

    public String getLeaguename() {
        return leaguename;
    }

    public void setLeaguename(String leaguename) {
        this.leaguename = leaguename == null ? null : leaguename.trim();
    }

    public String getTeamaname() {
        return teamaname;
    }

    public void setTeamaname(String teamaname) {
        this.teamaname = teamaname == null ? null : teamaname.trim();
    }

    public String getTeambname() {
        return teambname;
    }

    public void setTeambname(String teambname) {
        this.teambname = teambname == null ? null : teambname.trim();
    }

    public String getFinalscore() {
        return finalscore;
    }

    public void setFinalscore(String finalscore) {
        this.finalscore = finalscore == null ? null : finalscore.trim();
    }

    public String getCancelreason() {
        return cancelreason;
    }

    public void setCancelreason(String cancelreason) {
        this.cancelreason = cancelreason == null ? null : cancelreason.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
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
        FontanaBetSs other = (FontanaBetSs) that;
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
            && (this.getRefid() == null ? other.getRefid() == null : this.getRefid().equals(other.getRefid()))
            && (this.getPlaytype() == null ? other.getPlaytype() == null : this.getPlaytype().equals(other.getPlaytype()))
            && (this.getMatchindex() == null ? other.getMatchindex() == null : this.getMatchindex().equals(other.getMatchindex()))
            && (this.getBettypecode() == null ? other.getBettypecode() == null : this.getBettypecode().equals(other.getBettypecode()))
            && (this.getTeambetcode() == null ? other.getTeambetcode() == null : this.getTeambetcode().equals(other.getTeambetcode()))
            && (this.getHandicap() == null ? other.getHandicap() == null : this.getHandicap().equals(other.getHandicap()))
            && (this.getOddstype() == null ? other.getOddstype() == null : this.getOddstype().equals(other.getOddstype()))
            && (this.getWagerodds() == null ? other.getWagerodds() == null : this.getWagerodds().equals(other.getWagerodds()))
            && (this.getCurrencycode() == null ? other.getCurrencycode() == null : this.getCurrencycode().equals(other.getCurrencycode()))
            && (this.getWagerstake1() == null ? other.getWagerstake1() == null : this.getWagerstake1().equals(other.getWagerstake1()))
            && (this.getWinamtl() == null ? other.getWinamtl() == null : this.getWinamtl().equals(other.getWinamtl()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getBettingstatus() == null ? other.getBettingstatus() == null : this.getBettingstatus().equals(other.getBettingstatus()))
            && (this.getLastupdate() == null ? other.getLastupdate() == null : this.getLastupdate().equals(other.getLastupdate()))
            && (this.getMatchdate() == null ? other.getMatchdate() == null : this.getMatchdate().equals(other.getMatchdate()))
            && (this.getFinalstakel() == null ? other.getFinalstakel() == null : this.getFinalstakel().equals(other.getFinalstakel()))
            && (this.getPlaytypeindex() == null ? other.getPlaytypeindex() == null : this.getPlaytypeindex().equals(other.getPlaytypeindex()))
            && (this.getLeaguename() == null ? other.getLeaguename() == null : this.getLeaguename().equals(other.getLeaguename()))
            && (this.getTeamaname() == null ? other.getTeamaname() == null : this.getTeamaname().equals(other.getTeamaname()))
            && (this.getTeambname() == null ? other.getTeambname() == null : this.getTeambname().equals(other.getTeambname()))
            && (this.getFinalscore() == null ? other.getFinalscore() == null : this.getFinalscore().equals(other.getFinalscore()))
            && (this.getCancelreason() == null ? other.getCancelreason() == null : this.getCancelreason().equals(other.getCancelreason()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()));
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
        result = prime * result + ((getRefid() == null) ? 0 : getRefid().hashCode());
        result = prime * result + ((getPlaytype() == null) ? 0 : getPlaytype().hashCode());
        result = prime * result + ((getMatchindex() == null) ? 0 : getMatchindex().hashCode());
        result = prime * result + ((getBettypecode() == null) ? 0 : getBettypecode().hashCode());
        result = prime * result + ((getTeambetcode() == null) ? 0 : getTeambetcode().hashCode());
        result = prime * result + ((getHandicap() == null) ? 0 : getHandicap().hashCode());
        result = prime * result + ((getOddstype() == null) ? 0 : getOddstype().hashCode());
        result = prime * result + ((getWagerodds() == null) ? 0 : getWagerodds().hashCode());
        result = prime * result + ((getCurrencycode() == null) ? 0 : getCurrencycode().hashCode());
        result = prime * result + ((getWagerstake1() == null) ? 0 : getWagerstake1().hashCode());
        result = prime * result + ((getWinamtl() == null) ? 0 : getWinamtl().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getBettingstatus() == null) ? 0 : getBettingstatus().hashCode());
        result = prime * result + ((getLastupdate() == null) ? 0 : getLastupdate().hashCode());
        result = prime * result + ((getMatchdate() == null) ? 0 : getMatchdate().hashCode());
        result = prime * result + ((getFinalstakel() == null) ? 0 : getFinalstakel().hashCode());
        result = prime * result + ((getPlaytypeindex() == null) ? 0 : getPlaytypeindex().hashCode());
        result = prime * result + ((getLeaguename() == null) ? 0 : getLeaguename().hashCode());
        result = prime * result + ((getTeamaname() == null) ? 0 : getTeamaname().hashCode());
        result = prime * result + ((getTeambname() == null) ? 0 : getTeambname().hashCode());
        result = prime * result + ((getFinalscore() == null) ? 0 : getFinalscore().hashCode());
        result = prime * result + ((getCancelreason() == null) ? 0 : getCancelreason().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        return result;
    }
}