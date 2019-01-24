package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetVideo implements Serializable {
    private Long id;

    private Long parentid;

    /** 公司id */
    private Long cid;

    /** 注单唯一id */
    private Long vid;

    /** 桌台是否可以免佣 */
    private Integer sbanker;

    /** 厅类型 */
    private Integer lobbytype;

    /** 游戏ID */
    private Integer gameid;

    /** 游戏名称 */
    private String gamename;

    /** 结算时间 */
    private Date ctime;

    /** 下注时间 */
    private Date bettime;

    /** 调整后交易时间，操盘时间 */
    private Date groupfor;

    /** 桌台ID */
    private Long tableid;

    /** 桌台号 */
    private String tablename;

    /** 是否免佣 */
    private Integer jp;

    /** 会员名 */
    private String username;

    /** 靴ID */
    private Long shoeid;

    /** 靴号 */
    private Integer shoenum;

    /** 局ID */
    private Long inningid;

    /** 局号 */
    private Integer inningnum;

    private String betpoint;

    /** 投注额 */
    private Double betamount;

    /** 输赢 会员结果 */
    private Double result;

    /** 发牌结果 */
    private String cardresult;

    /** 胜出投注点 */
    private String winpoint;

    /** 注单状态 */
    private String status;

    /** 有效投注额 */
    private Double commamount;

    /** 进桌类型 */
    private Integer entertype;

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

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
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

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getBettime() {
        return bettime;
    }

    public void setBettime(Date bettime) {
        this.bettime = bettime;
    }

    public Date getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(Date groupfor) {
        this.groupfor = groupfor;
    }

    public Long getTableid() {
        return tableid;
    }

    public void setTableid(Long tableid) {
        this.tableid = tableid;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public Integer getJp() {
        return jp;
    }

    public void setJp(Integer jp) {
        this.jp = jp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public Long getInningid() {
        return inningid;
    }

    public void setInningid(Long inningid) {
        this.inningid = inningid;
    }

    public Integer getInningnum() {
        return inningnum;
    }

    public void setInningnum(Integer inningnum) {
        this.inningnum = inningnum;
    }

    public String getBetpoint() {
        return betpoint;
    }

    public void setBetpoint(String betpoint) {
        this.betpoint = betpoint == null ? null : betpoint.trim();
    }

    public Double getBetamount() {
        return betamount;
    }

    public void setBetamount(Double betamount) {
        this.betamount = betamount;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getCardresult() {
        return cardresult;
    }

    public void setCardresult(String cardresult) {
        this.cardresult = cardresult == null ? null : cardresult.trim();
    }

    public String getWinpoint() {
        return winpoint;
    }

    public void setWinpoint(String winpoint) {
        this.winpoint = winpoint == null ? null : winpoint.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Double getCommamount() {
        return commamount;
    }

    public void setCommamount(Double commamount) {
        this.commamount = commamount;
    }

    public Integer getEntertype() {
        return entertype;
    }

    public void setEntertype(Integer entertype) {
        this.entertype = entertype;
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
        FontanaBetVideo other = (FontanaBetVideo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getVid() == null ? other.getVid() == null : this.getVid().equals(other.getVid()))
            && (this.getSbanker() == null ? other.getSbanker() == null : this.getSbanker().equals(other.getSbanker()))
            && (this.getLobbytype() == null ? other.getLobbytype() == null : this.getLobbytype().equals(other.getLobbytype()))
            && (this.getGameid() == null ? other.getGameid() == null : this.getGameid().equals(other.getGameid()))
            && (this.getGamename() == null ? other.getGamename() == null : this.getGamename().equals(other.getGamename()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getBettime() == null ? other.getBettime() == null : this.getBettime().equals(other.getBettime()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getTableid() == null ? other.getTableid() == null : this.getTableid().equals(other.getTableid()))
            && (this.getTablename() == null ? other.getTablename() == null : this.getTablename().equals(other.getTablename()))
            && (this.getJp() == null ? other.getJp() == null : this.getJp().equals(other.getJp()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getShoeid() == null ? other.getShoeid() == null : this.getShoeid().equals(other.getShoeid()))
            && (this.getShoenum() == null ? other.getShoenum() == null : this.getShoenum().equals(other.getShoenum()))
            && (this.getInningid() == null ? other.getInningid() == null : this.getInningid().equals(other.getInningid()))
            && (this.getInningnum() == null ? other.getInningnum() == null : this.getInningnum().equals(other.getInningnum()))
            && (this.getBetpoint() == null ? other.getBetpoint() == null : this.getBetpoint().equals(other.getBetpoint()))
            && (this.getBetamount() == null ? other.getBetamount() == null : this.getBetamount().equals(other.getBetamount()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getCardresult() == null ? other.getCardresult() == null : this.getCardresult().equals(other.getCardresult()))
            && (this.getWinpoint() == null ? other.getWinpoint() == null : this.getWinpoint().equals(other.getWinpoint()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCommamount() == null ? other.getCommamount() == null : this.getCommamount().equals(other.getCommamount()))
            && (this.getEntertype() == null ? other.getEntertype() == null : this.getEntertype().equals(other.getEntertype()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getVid() == null) ? 0 : getVid().hashCode());
        result = prime * result + ((getSbanker() == null) ? 0 : getSbanker().hashCode());
        result = prime * result + ((getLobbytype() == null) ? 0 : getLobbytype().hashCode());
        result = prime * result + ((getGameid() == null) ? 0 : getGameid().hashCode());
        result = prime * result + ((getGamename() == null) ? 0 : getGamename().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getBettime() == null) ? 0 : getBettime().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getTableid() == null) ? 0 : getTableid().hashCode());
        result = prime * result + ((getTablename() == null) ? 0 : getTablename().hashCode());
        result = prime * result + ((getJp() == null) ? 0 : getJp().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getShoeid() == null) ? 0 : getShoeid().hashCode());
        result = prime * result + ((getShoenum() == null) ? 0 : getShoenum().hashCode());
        result = prime * result + ((getInningid() == null) ? 0 : getInningid().hashCode());
        result = prime * result + ((getInningnum() == null) ? 0 : getInningnum().hashCode());
        result = prime * result + ((getBetpoint() == null) ? 0 : getBetpoint().hashCode());
        result = prime * result + ((getBetamount() == null) ? 0 : getBetamount().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getCardresult() == null) ? 0 : getCardresult().hashCode());
        result = prime * result + ((getWinpoint() == null) ? 0 : getWinpoint().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCommamount() == null) ? 0 : getCommamount().hashCode());
        result = prime * result + ((getEntertype() == null) ? 0 : getEntertype().hashCode());
        return result;
    }
}