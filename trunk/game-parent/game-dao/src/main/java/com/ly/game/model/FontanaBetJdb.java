package com.ly.game.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FontanaBetJdb implements Serializable {
    /** 同步序号 */
    private Long id;

    /** 订单号 */
    private String betnum;

    /** 用户id */
    private Long uid;

    /** 用户名=uid */
    private String username;

    /** 公司id */
    private Long cid;

    /** 下注时间=gameDate */
    private Date bettime;

    /** 下注金额=bet */
    private BigDecimal betamount;

    /** 有效投注额=bet */
    private BigDecimal validamount;

    /** 输赢金额=(total) */
    private BigDecimal result;

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

    /** 博取游戏押注金额 */
    private BigDecimal gamblebet;

    /** 游戏赢分 */
    private BigDecimal win;

    /** 赢得彩金金额 */
    private BigDecimal jackpot;

    /** 彩金贡献值 */
    private BigDecimal jackpotcontribute;

    /** 投注面值 */
    private BigDecimal denom;

    /** 游戏类型 0=老虎机,7=捕鱼机,9=街机,12=电子彩票,18=棋牌 */
    private String gtype;

    /** 机台类型 */
    private Integer mtype;

    /** 货币代码 */
    private String currency;

    /** 最后修改时间 */
    private Date lastmodifytime;

    /** 玩家IP */
    private String playerip;

    /** 玩家从网页或行动装置登入 */
    private String clienttype;

    /** 免费游戏,0: 否,1: 是 */
    private Integer hasfreegame;

    /** 博取游戏,0: 否,1: 是 */
    private Integer hasgamble;

    /** 标记该笔为游戏中断线,由系统结算,0: 否,1: 是 */
    private Integer systemtakewin;

    /** 游戏区域,0:欢乐区,1:富豪区,2:财神区 */
    private Integer roomtype;

    /** 进场金额 */
    private BigDecimal beforebalance;

    /** 离场金额 */
    private BigDecimal afterbalance;

    /** 奖金游戏,0: 否,1: 是 */
    private Integer hasbonusgame;

    /** 游戏局号 */
    private String roundseqno;

    /** 税 */
    private BigDecimal tax;

    /** 错误信息 */
    private String errtext;

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

    public BigDecimal getGamblebet() {
        return gamblebet;
    }

    public void setGamblebet(BigDecimal gamblebet) {
        this.gamblebet = gamblebet;
    }

    public BigDecimal getWin() {
        return win;
    }

    public void setWin(BigDecimal win) {
        this.win = win;
    }

    public BigDecimal getJackpot() {
        return jackpot;
    }

    public void setJackpot(BigDecimal jackpot) {
        this.jackpot = jackpot;
    }

    public BigDecimal getJackpotcontribute() {
        return jackpotcontribute;
    }

    public void setJackpotcontribute(BigDecimal jackpotcontribute) {
        this.jackpotcontribute = jackpotcontribute;
    }

    public BigDecimal getDenom() {
        return denom;
    }

    public void setDenom(BigDecimal denom) {
        this.denom = denom;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype == null ? null : gtype.trim();
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public String getPlayerip() {
        return playerip;
    }

    public void setPlayerip(String playerip) {
        this.playerip = playerip == null ? null : playerip.trim();
    }

    public String getClienttype() {
        return clienttype;
    }

    public void setClienttype(String clienttype) {
        this.clienttype = clienttype == null ? null : clienttype.trim();
    }

    public Integer getHasfreegame() {
        return hasfreegame;
    }

    public void setHasfreegame(Integer hasfreegame) {
        this.hasfreegame = hasfreegame;
    }

    public Integer getHasgamble() {
        return hasgamble;
    }

    public void setHasgamble(Integer hasgamble) {
        this.hasgamble = hasgamble;
    }

    public Integer getSystemtakewin() {
        return systemtakewin;
    }

    public void setSystemtakewin(Integer systemtakewin) {
        this.systemtakewin = systemtakewin;
    }

    public Integer getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Integer roomtype) {
        this.roomtype = roomtype;
    }

    public BigDecimal getBeforebalance() {
        return beforebalance;
    }

    public void setBeforebalance(BigDecimal beforebalance) {
        this.beforebalance = beforebalance;
    }

    public BigDecimal getAfterbalance() {
        return afterbalance;
    }

    public void setAfterbalance(BigDecimal afterbalance) {
        this.afterbalance = afterbalance;
    }

    public Integer getHasbonusgame() {
        return hasbonusgame;
    }

    public void setHasbonusgame(Integer hasbonusgame) {
        this.hasbonusgame = hasbonusgame;
    }

    public String getRoundseqno() {
        return roundseqno;
    }

    public void setRoundseqno(String roundseqno) {
        this.roundseqno = roundseqno == null ? null : roundseqno.trim();
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getErrtext() {
        return errtext;
    }

    public void setErrtext(String errtext) {
        this.errtext = errtext == null ? null : errtext.trim();
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
        FontanaBetJdb other = (FontanaBetJdb) that;
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
            && (this.getGamblebet() == null ? other.getGamblebet() == null : this.getGamblebet().equals(other.getGamblebet()))
            && (this.getWin() == null ? other.getWin() == null : this.getWin().equals(other.getWin()))
            && (this.getJackpot() == null ? other.getJackpot() == null : this.getJackpot().equals(other.getJackpot()))
            && (this.getJackpotcontribute() == null ? other.getJackpotcontribute() == null : this.getJackpotcontribute().equals(other.getJackpotcontribute()))
            && (this.getDenom() == null ? other.getDenom() == null : this.getDenom().equals(other.getDenom()))
            && (this.getGtype() == null ? other.getGtype() == null : this.getGtype().equals(other.getGtype()))
            && (this.getMtype() == null ? other.getMtype() == null : this.getMtype().equals(other.getMtype()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getLastmodifytime() == null ? other.getLastmodifytime() == null : this.getLastmodifytime().equals(other.getLastmodifytime()))
            && (this.getPlayerip() == null ? other.getPlayerip() == null : this.getPlayerip().equals(other.getPlayerip()))
            && (this.getClienttype() == null ? other.getClienttype() == null : this.getClienttype().equals(other.getClienttype()))
            && (this.getHasfreegame() == null ? other.getHasfreegame() == null : this.getHasfreegame().equals(other.getHasfreegame()))
            && (this.getHasgamble() == null ? other.getHasgamble() == null : this.getHasgamble().equals(other.getHasgamble()))
            && (this.getSystemtakewin() == null ? other.getSystemtakewin() == null : this.getSystemtakewin().equals(other.getSystemtakewin()))
            && (this.getRoomtype() == null ? other.getRoomtype() == null : this.getRoomtype().equals(other.getRoomtype()))
            && (this.getBeforebalance() == null ? other.getBeforebalance() == null : this.getBeforebalance().equals(other.getBeforebalance()))
            && (this.getAfterbalance() == null ? other.getAfterbalance() == null : this.getAfterbalance().equals(other.getAfterbalance()))
            && (this.getHasbonusgame() == null ? other.getHasbonusgame() == null : this.getHasbonusgame().equals(other.getHasbonusgame()))
            && (this.getRoundseqno() == null ? other.getRoundseqno() == null : this.getRoundseqno().equals(other.getRoundseqno()))
            && (this.getTax() == null ? other.getTax() == null : this.getTax().equals(other.getTax()))
            && (this.getErrtext() == null ? other.getErrtext() == null : this.getErrtext().equals(other.getErrtext()));
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
        result = prime * result + ((getGamblebet() == null) ? 0 : getGamblebet().hashCode());
        result = prime * result + ((getWin() == null) ? 0 : getWin().hashCode());
        result = prime * result + ((getJackpot() == null) ? 0 : getJackpot().hashCode());
        result = prime * result + ((getJackpotcontribute() == null) ? 0 : getJackpotcontribute().hashCode());
        result = prime * result + ((getDenom() == null) ? 0 : getDenom().hashCode());
        result = prime * result + ((getGtype() == null) ? 0 : getGtype().hashCode());
        result = prime * result + ((getMtype() == null) ? 0 : getMtype().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getLastmodifytime() == null) ? 0 : getLastmodifytime().hashCode());
        result = prime * result + ((getPlayerip() == null) ? 0 : getPlayerip().hashCode());
        result = prime * result + ((getClienttype() == null) ? 0 : getClienttype().hashCode());
        result = prime * result + ((getHasfreegame() == null) ? 0 : getHasfreegame().hashCode());
        result = prime * result + ((getHasgamble() == null) ? 0 : getHasgamble().hashCode());
        result = prime * result + ((getSystemtakewin() == null) ? 0 : getSystemtakewin().hashCode());
        result = prime * result + ((getRoomtype() == null) ? 0 : getRoomtype().hashCode());
        result = prime * result + ((getBeforebalance() == null) ? 0 : getBeforebalance().hashCode());
        result = prime * result + ((getAfterbalance() == null) ? 0 : getAfterbalance().hashCode());
        result = prime * result + ((getHasbonusgame() == null) ? 0 : getHasbonusgame().hashCode());
        result = prime * result + ((getRoundseqno() == null) ? 0 : getRoundseqno().hashCode());
        result = prime * result + ((getTax() == null) ? 0 : getTax().hashCode());
        result = prime * result + ((getErrtext() == null) ? 0 : getErrtext().hashCode());
        return result;
    }
}