package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetVideoresult implements Serializable {
    private Long id;

    private Long parentid;

    /** 局id */
    private Long inningid;

    /** 桌台ID */
    private Long tableid;

    /** 是否可以免佣 */
    private Integer sbanker;

    /** 厅类型 */
    private Integer lobbytype;

    /** 桌台名称 */
    private String tablename;

    /** 游戏ID */
    private Integer gameid;

    /** 游戏名称 */
    private String gamename;

    /** 靴ID */
    private Long shoeid;

    /** 靴号 */
    private Integer shoenum;

    /** 局号 */
    private Integer gamblingnum;

    /** 调整后交易时间，操盘时间 */
    private Date groupfor;

    /** 局开始时间 */
    private Date starttime;

    /** 开始加注时间 */
    private Date addbettime;

    /** 庄闲和结果或者同发牌结果，不同游戏不一样 */
    private String result;

    /** 发牌结果 */
    private String cards;

    /** 状态 */
    private String state;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Long getInningid() {
        return inningid;
    }

    public void setInningid(Long inningid) {
        this.inningid = inningid;
    }

    public Long getTableid() {
        return tableid;
    }

    public void setTableid(Long tableid) {
        this.tableid = tableid;
    }

    public Integer getSbanker() {
        return sbanker;
    }

    public void setSbanker(Integer sbanker) {
        this.sbanker = sbanker;
    }

    public Integer getLobbytype() {
        return lobbytype;
    }

    public void setLobbytype(Integer lobbytype) {
        this.lobbytype = lobbytype;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public Integer getGameid() {
        return gameid;
    }

    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }

    public Long getShoeid() {
        return shoeid;
    }

    public void setShoeid(Long shoeid) {
        this.shoeid = shoeid;
    }

    public Integer getShoenum() {
        return shoenum;
    }

    public void setShoenum(Integer shoenum) {
        this.shoenum = shoenum;
    }

    public Integer getGamblingnum() {
        return gamblingnum;
    }

    public void setGamblingnum(Integer gamblingnum) {
        this.gamblingnum = gamblingnum;
    }

    public Date getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(Date groupfor) {
        this.groupfor = groupfor;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getAddbettime() {
        return addbettime;
    }

    public void setAddbettime(Date addbettime) {
        this.addbettime = addbettime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards == null ? null : cards.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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
        FontanaBetVideoresult other = (FontanaBetVideoresult) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getInningid() == null ? other.getInningid() == null : this.getInningid().equals(other.getInningid()))
            && (this.getTableid() == null ? other.getTableid() == null : this.getTableid().equals(other.getTableid()))
            && (this.getSbanker() == null ? other.getSbanker() == null : this.getSbanker().equals(other.getSbanker()))
            && (this.getLobbytype() == null ? other.getLobbytype() == null : this.getLobbytype().equals(other.getLobbytype()))
            && (this.getTablename() == null ? other.getTablename() == null : this.getTablename().equals(other.getTablename()))
            && (this.getGameid() == null ? other.getGameid() == null : this.getGameid().equals(other.getGameid()))
            && (this.getGamename() == null ? other.getGamename() == null : this.getGamename().equals(other.getGamename()))
            && (this.getShoeid() == null ? other.getShoeid() == null : this.getShoeid().equals(other.getShoeid()))
            && (this.getShoenum() == null ? other.getShoenum() == null : this.getShoenum().equals(other.getShoenum()))
            && (this.getGamblingnum() == null ? other.getGamblingnum() == null : this.getGamblingnum().equals(other.getGamblingnum()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getStarttime() == null ? other.getStarttime() == null : this.getStarttime().equals(other.getStarttime()))
            && (this.getAddbettime() == null ? other.getAddbettime() == null : this.getAddbettime().equals(other.getAddbettime()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getCards() == null ? other.getCards() == null : this.getCards().equals(other.getCards()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getInningid() == null) ? 0 : getInningid().hashCode());
        result = prime * result + ((getTableid() == null) ? 0 : getTableid().hashCode());
        result = prime * result + ((getSbanker() == null) ? 0 : getSbanker().hashCode());
        result = prime * result + ((getLobbytype() == null) ? 0 : getLobbytype().hashCode());
        result = prime * result + ((getTablename() == null) ? 0 : getTablename().hashCode());
        result = prime * result + ((getGameid() == null) ? 0 : getGameid().hashCode());
        result = prime * result + ((getGamename() == null) ? 0 : getGamename().hashCode());
        result = prime * result + ((getShoeid() == null) ? 0 : getShoeid().hashCode());
        result = prime * result + ((getShoenum() == null) ? 0 : getShoenum().hashCode());
        result = prime * result + ((getGamblingnum() == null) ? 0 : getGamblingnum().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
        result = prime * result + ((getAddbettime() == null) ? 0 : getAddbettime().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getCards() == null) ? 0 : getCards().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }
}