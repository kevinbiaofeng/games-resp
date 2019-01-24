package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetPtgame implements Serializable {
    /** 自增主键 */
    private Long id;

    /** 用户ID */
    private Long uid;

    /** 用户名 */
    private String username;

    /** 用户上级ID */
    private Long parentid;

    /** 公司ID */
    private Long cid;

    /** 投注单号，全局唯一 */
    private Long betnum;

    /** 游戏种类 */
    private String gametype;

    /** 游戏名称 */
    private String gamename;

    /** 投注额 */
    private Double betamount;

    /** 有效投注额 */
    private Double validamount;

    /** 当前投注额 */
    private Double currentbetamount;

    /** 输赢金额 */
    private Double result;

    /** 打开视窗数目 */
    private Integer windowcount;

    /** 游戏次数 */
    private Integer playcount;

    /** 游戏编码 */
    private Long gamecode;

    /** 链接编码 */
    private String linkcode;

    /** 注单结果 */
    private String gameresult;

    /** 投注时间 */
    private Date bettime;

    /** 创建时间 */
    private Date ctime;

    /** 用于合计表查询 */
    private Date groupfor;

    /** 余额 */
    private Double balance;

    /** 累积投注 */
    private Double totalbetamount;

    /** 累积赢额 */
    private Double totalresult;

    /** 现场游戏 */
    private String livegame;

    /** 响应次数 */
    private Integer responsecount;

    /** 币种 */
    private String currency;

    /** 汇率 */
    private Double exchangerate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getBetnum() {
        return betnum;
    }

    public void setBetnum(Long betnum) {
        this.betnum = betnum;
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
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

    public Double getCurrentbetamount() {
        return currentbetamount;
    }

    public void setCurrentbetamount(Double currentbetamount) {
        this.currentbetamount = currentbetamount;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Integer getWindowcount() {
        return windowcount;
    }

    public void setWindowcount(Integer windowcount) {
        this.windowcount = windowcount;
    }

    public Integer getPlaycount() {
        return playcount;
    }

    public void setPlaycount(Integer playcount) {
        this.playcount = playcount;
    }

    public Long getGamecode() {
        return gamecode;
    }

    public void setGamecode(Long gamecode) {
        this.gamecode = gamecode;
    }

    public String getLinkcode() {
        return linkcode;
    }

    public void setLinkcode(String linkcode) {
        this.linkcode = linkcode == null ? null : linkcode.trim();
    }

    public String getGameresult() {
        return gameresult;
    }

    public void setGameresult(String gameresult) {
        this.gameresult = gameresult == null ? null : gameresult.trim();
    }

    public Date getBettime() {
        return bettime;
    }

    public void setBettime(Date bettime) {
        this.bettime = bettime;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(Date groupfor) {
        this.groupfor = groupfor;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getTotalbetamount() {
        return totalbetamount;
    }

    public void setTotalbetamount(Double totalbetamount) {
        this.totalbetamount = totalbetamount;
    }

    public Double getTotalresult() {
        return totalresult;
    }

    public void setTotalresult(Double totalresult) {
        this.totalresult = totalresult;
    }

    public String getLivegame() {
        return livegame;
    }

    public void setLivegame(String livegame) {
        this.livegame = livegame == null ? null : livegame.trim();
    }

    public Integer getResponsecount() {
        return responsecount;
    }

    public void setResponsecount(Integer responsecount) {
        this.responsecount = responsecount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Double getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(Double exchangerate) {
        this.exchangerate = exchangerate;
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
        FontanaBetPtgame other = (FontanaBetPtgame) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getBetnum() == null ? other.getBetnum() == null : this.getBetnum().equals(other.getBetnum()))
            && (this.getGametype() == null ? other.getGametype() == null : this.getGametype().equals(other.getGametype()))
            && (this.getGamename() == null ? other.getGamename() == null : this.getGamename().equals(other.getGamename()))
            && (this.getBetamount() == null ? other.getBetamount() == null : this.getBetamount().equals(other.getBetamount()))
            && (this.getValidamount() == null ? other.getValidamount() == null : this.getValidamount().equals(other.getValidamount()))
            && (this.getCurrentbetamount() == null ? other.getCurrentbetamount() == null : this.getCurrentbetamount().equals(other.getCurrentbetamount()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getWindowcount() == null ? other.getWindowcount() == null : this.getWindowcount().equals(other.getWindowcount()))
            && (this.getPlaycount() == null ? other.getPlaycount() == null : this.getPlaycount().equals(other.getPlaycount()))
            && (this.getGamecode() == null ? other.getGamecode() == null : this.getGamecode().equals(other.getGamecode()))
            && (this.getLinkcode() == null ? other.getLinkcode() == null : this.getLinkcode().equals(other.getLinkcode()))
            && (this.getGameresult() == null ? other.getGameresult() == null : this.getGameresult().equals(other.getGameresult()))
            && (this.getBettime() == null ? other.getBettime() == null : this.getBettime().equals(other.getBettime()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getTotalbetamount() == null ? other.getTotalbetamount() == null : this.getTotalbetamount().equals(other.getTotalbetamount()))
            && (this.getTotalresult() == null ? other.getTotalresult() == null : this.getTotalresult().equals(other.getTotalresult()))
            && (this.getLivegame() == null ? other.getLivegame() == null : this.getLivegame().equals(other.getLivegame()))
            && (this.getResponsecount() == null ? other.getResponsecount() == null : this.getResponsecount().equals(other.getResponsecount()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getExchangerate() == null ? other.getExchangerate() == null : this.getExchangerate().equals(other.getExchangerate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getBetnum() == null) ? 0 : getBetnum().hashCode());
        result = prime * result + ((getGametype() == null) ? 0 : getGametype().hashCode());
        result = prime * result + ((getGamename() == null) ? 0 : getGamename().hashCode());
        result = prime * result + ((getBetamount() == null) ? 0 : getBetamount().hashCode());
        result = prime * result + ((getValidamount() == null) ? 0 : getValidamount().hashCode());
        result = prime * result + ((getCurrentbetamount() == null) ? 0 : getCurrentbetamount().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getWindowcount() == null) ? 0 : getWindowcount().hashCode());
        result = prime * result + ((getPlaycount() == null) ? 0 : getPlaycount().hashCode());
        result = prime * result + ((getGamecode() == null) ? 0 : getGamecode().hashCode());
        result = prime * result + ((getLinkcode() == null) ? 0 : getLinkcode().hashCode());
        result = prime * result + ((getGameresult() == null) ? 0 : getGameresult().hashCode());
        result = prime * result + ((getBettime() == null) ? 0 : getBettime().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getTotalbetamount() == null) ? 0 : getTotalbetamount().hashCode());
        result = prime * result + ((getTotalresult() == null) ? 0 : getTotalresult().hashCode());
        result = prime * result + ((getLivegame() == null) ? 0 : getLivegame().hashCode());
        result = prime * result + ((getResponsecount() == null) ? 0 : getResponsecount().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getExchangerate() == null) ? 0 : getExchangerate().hashCode());
        return result;
    }
}