package com.ly.game.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FontanaBetImItem implements Serializable {
    /** 同步序号 */
    private Long id;

    /** FONTANA_BET_IM表的ID */
    private String gameid;

    /** 盘口类别: Early 早盘, Today 今日, Live 滚球 如果 betType = OR (冠军赛事)，则回传 Null。 */
    private String market;

    /** 赛事名称 */
    private String eventname;

    /** 格式: YYYY-MM-DD HH:mm:ss +08:00 */
    private Date eventdatetime;

    /** 竞技名称 */
    private String competitionname;

    /** 主队名称  */
    private String hometeamname;

    /** 客队名称 */
    private String awayteamname;

    /** “H” –最看好球队为主队。 “A” – 最看好球队为客队。如果 BetType 是 “Outright” or “Parlay” 则回传 Null。 */
    private String avteam;

    /** 玩法类别:CS, FGLG, TG 等 */
    private String bettype;

    /** 玩法类别备注: Correct Score, First Goal / Last Goal...等 */
    private String bettypedesc;

    /** 1H 上半场, 2H 下半场, FT 全场 如果 betType = OR (冠军赛事)，则回传 Null。 */
    private String period;

    /** 参考附录D */
    private String selection;

    /** 赔率 */
    private BigDecimal odds;

    /** 主队上半场比分 (仅在结算时提供。) */
    private String hometeamhtscore;

    /** 客队上半场比分 (仅在结算时提供。) */
    private String awayteamhtscore;

    /** 主队全场比分 (仅在结算时提供。) */
    private String hometeamftscore;

    /** 客队全场比分 (仅在结算时提供。) */
    private String awayteamftscore;

    /** 注单确定时的主队比分 */
    private Long wagerhometeamscore;

    /** 注单确定时的客队比分 */
    private Long wagerawayteamscore;

    /** 让球,如果 betType = OR (冠军赛事)，则回传 Null。 "-" => 客队让球 "+" => 主队让球 */
    private BigDecimal handicap;

    /** 0=Not cancel 未取消, 1=Cancel 已取消 */
    private Long iswageritemcancelled;

    /** 体育名称: Soccer, Basketball 等。 */
    private String sportsname;

    /** 赛事编号 */
    private Long eventid;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid == null ? null : gameid.trim();
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market == null ? null : market.trim();
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname == null ? null : eventname.trim();
    }

    public Date getEventdatetime() {
        return eventdatetime;
    }

    public void setEventdatetime(Date eventdatetime) {
        this.eventdatetime = eventdatetime;
    }

    public String getCompetitionname() {
        return competitionname;
    }

    public void setCompetitionname(String competitionname) {
        this.competitionname = competitionname == null ? null : competitionname.trim();
    }

    public String getHometeamname() {
        return hometeamname;
    }

    public void setHometeamname(String hometeamname) {
        this.hometeamname = hometeamname == null ? null : hometeamname.trim();
    }

    public String getAwayteamname() {
        return awayteamname;
    }

    public void setAwayteamname(String awayteamname) {
        this.awayteamname = awayteamname == null ? null : awayteamname.trim();
    }

    public String getAvteam() {
        return avteam;
    }

    public void setAvteam(String avteam) {
        this.avteam = avteam == null ? null : avteam.trim();
    }

    public String getBettype() {
        return bettype;
    }

    public void setBettype(String bettype) {
        this.bettype = bettype == null ? null : bettype.trim();
    }

    public String getBettypedesc() {
        return bettypedesc;
    }

    public void setBettypedesc(String bettypedesc) {
        this.bettypedesc = bettypedesc == null ? null : bettypedesc.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection == null ? null : selection.trim();
    }

    public BigDecimal getOdds() {
        return odds;
    }

    public void setOdds(BigDecimal odds) {
        this.odds = odds;
    }

    public String getHometeamhtscore() {
        return hometeamhtscore;
    }

    public void setHometeamhtscore(String hometeamhtscore) {
        this.hometeamhtscore = hometeamhtscore == null ? null : hometeamhtscore.trim();
    }

    public String getAwayteamhtscore() {
        return awayteamhtscore;
    }

    public void setAwayteamhtscore(String awayteamhtscore) {
        this.awayteamhtscore = awayteamhtscore == null ? null : awayteamhtscore.trim();
    }

    public String getHometeamftscore() {
        return hometeamftscore;
    }

    public void setHometeamftscore(String hometeamftscore) {
        this.hometeamftscore = hometeamftscore == null ? null : hometeamftscore.trim();
    }

    public String getAwayteamftscore() {
        return awayteamftscore;
    }

    public void setAwayteamftscore(String awayteamftscore) {
        this.awayteamftscore = awayteamftscore == null ? null : awayteamftscore.trim();
    }

    public Long getWagerhometeamscore() {
        return wagerhometeamscore;
    }

    public void setWagerhometeamscore(Long wagerhometeamscore) {
        this.wagerhometeamscore = wagerhometeamscore;
    }

    public Long getWagerawayteamscore() {
        return wagerawayteamscore;
    }

    public void setWagerawayteamscore(Long wagerawayteamscore) {
        this.wagerawayteamscore = wagerawayteamscore;
    }

    public BigDecimal getHandicap() {
        return handicap;
    }

    public void setHandicap(BigDecimal handicap) {
        this.handicap = handicap;
    }

    public Long getIswageritemcancelled() {
        return iswageritemcancelled;
    }

    public void setIswageritemcancelled(Long iswageritemcancelled) {
        this.iswageritemcancelled = iswageritemcancelled;
    }

    public String getSportsname() {
        return sportsname;
    }

    public void setSportsname(String sportsname) {
        this.sportsname = sportsname == null ? null : sportsname.trim();
    }

    public Long getEventid() {
        return eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
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
        FontanaBetImItem other = (FontanaBetImItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGameid() == null ? other.getGameid() == null : this.getGameid().equals(other.getGameid()))
            && (this.getMarket() == null ? other.getMarket() == null : this.getMarket().equals(other.getMarket()))
            && (this.getEventname() == null ? other.getEventname() == null : this.getEventname().equals(other.getEventname()))
            && (this.getEventdatetime() == null ? other.getEventdatetime() == null : this.getEventdatetime().equals(other.getEventdatetime()))
            && (this.getCompetitionname() == null ? other.getCompetitionname() == null : this.getCompetitionname().equals(other.getCompetitionname()))
            && (this.getHometeamname() == null ? other.getHometeamname() == null : this.getHometeamname().equals(other.getHometeamname()))
            && (this.getAwayteamname() == null ? other.getAwayteamname() == null : this.getAwayteamname().equals(other.getAwayteamname()))
            && (this.getAvteam() == null ? other.getAvteam() == null : this.getAvteam().equals(other.getAvteam()))
            && (this.getBettype() == null ? other.getBettype() == null : this.getBettype().equals(other.getBettype()))
            && (this.getBettypedesc() == null ? other.getBettypedesc() == null : this.getBettypedesc().equals(other.getBettypedesc()))
            && (this.getPeriod() == null ? other.getPeriod() == null : this.getPeriod().equals(other.getPeriod()))
            && (this.getSelection() == null ? other.getSelection() == null : this.getSelection().equals(other.getSelection()))
            && (this.getOdds() == null ? other.getOdds() == null : this.getOdds().equals(other.getOdds()))
            && (this.getHometeamhtscore() == null ? other.getHometeamhtscore() == null : this.getHometeamhtscore().equals(other.getHometeamhtscore()))
            && (this.getAwayteamhtscore() == null ? other.getAwayteamhtscore() == null : this.getAwayteamhtscore().equals(other.getAwayteamhtscore()))
            && (this.getHometeamftscore() == null ? other.getHometeamftscore() == null : this.getHometeamftscore().equals(other.getHometeamftscore()))
            && (this.getAwayteamftscore() == null ? other.getAwayteamftscore() == null : this.getAwayteamftscore().equals(other.getAwayteamftscore()))
            && (this.getWagerhometeamscore() == null ? other.getWagerhometeamscore() == null : this.getWagerhometeamscore().equals(other.getWagerhometeamscore()))
            && (this.getWagerawayteamscore() == null ? other.getWagerawayteamscore() == null : this.getWagerawayteamscore().equals(other.getWagerawayteamscore()))
            && (this.getHandicap() == null ? other.getHandicap() == null : this.getHandicap().equals(other.getHandicap()))
            && (this.getIswageritemcancelled() == null ? other.getIswageritemcancelled() == null : this.getIswageritemcancelled().equals(other.getIswageritemcancelled()))
            && (this.getSportsname() == null ? other.getSportsname() == null : this.getSportsname().equals(other.getSportsname()))
            && (this.getEventid() == null ? other.getEventid() == null : this.getEventid().equals(other.getEventid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGameid() == null) ? 0 : getGameid().hashCode());
        result = prime * result + ((getMarket() == null) ? 0 : getMarket().hashCode());
        result = prime * result + ((getEventname() == null) ? 0 : getEventname().hashCode());
        result = prime * result + ((getEventdatetime() == null) ? 0 : getEventdatetime().hashCode());
        result = prime * result + ((getCompetitionname() == null) ? 0 : getCompetitionname().hashCode());
        result = prime * result + ((getHometeamname() == null) ? 0 : getHometeamname().hashCode());
        result = prime * result + ((getAwayteamname() == null) ? 0 : getAwayteamname().hashCode());
        result = prime * result + ((getAvteam() == null) ? 0 : getAvteam().hashCode());
        result = prime * result + ((getBettype() == null) ? 0 : getBettype().hashCode());
        result = prime * result + ((getBettypedesc() == null) ? 0 : getBettypedesc().hashCode());
        result = prime * result + ((getPeriod() == null) ? 0 : getPeriod().hashCode());
        result = prime * result + ((getSelection() == null) ? 0 : getSelection().hashCode());
        result = prime * result + ((getOdds() == null) ? 0 : getOdds().hashCode());
        result = prime * result + ((getHometeamhtscore() == null) ? 0 : getHometeamhtscore().hashCode());
        result = prime * result + ((getAwayteamhtscore() == null) ? 0 : getAwayteamhtscore().hashCode());
        result = prime * result + ((getHometeamftscore() == null) ? 0 : getHometeamftscore().hashCode());
        result = prime * result + ((getAwayteamftscore() == null) ? 0 : getAwayteamftscore().hashCode());
        result = prime * result + ((getWagerhometeamscore() == null) ? 0 : getWagerhometeamscore().hashCode());
        result = prime * result + ((getWagerawayteamscore() == null) ? 0 : getWagerawayteamscore().hashCode());
        result = prime * result + ((getHandicap() == null) ? 0 : getHandicap().hashCode());
        result = prime * result + ((getIswageritemcancelled() == null) ? 0 : getIswageritemcancelled().hashCode());
        result = prime * result + ((getSportsname() == null) ? 0 : getSportsname().hashCode());
        result = prime * result + ((getEventid() == null) ? 0 : getEventid().hashCode());
        return result;
    }
}