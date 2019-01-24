package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetBj implements Serializable {
    /** 同步序号 */
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

    /** source */
    private String source;

    /** 数据类型 */
    private Long rsynctype;

    /** 彩种编码 */
    private Long gamecode;

    /** 外部期号 */
    private String outissue;

    /** 投注倍数 */
    private Long betmulti;

    /** 投注玩法 */
    private String wanfacode;

    /** 中奖金额 */
    private Double winbonus;

    /** 大奖标记 */
    private Long bigwintag;

    /** 开奖号码 */
    private String prizecode;

    /** 中奖时间 */
    private Date awardtime;

    /** 注销时间 */
    private Date unregtime;

    /** 玩法名称 */
    private String wanfaname;

    /** 游戏名称 */
    private String gamename;

    /** 投注内容 */
    private String tradeinfo;

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

    public Long getRsynctype() {
        return rsynctype;
    }

    public void setRsynctype(Long rsynctype) {
        this.rsynctype = rsynctype;
    }

    public Long getGamecode() {
        return gamecode;
    }

    public void setGamecode(Long gamecode) {
        this.gamecode = gamecode;
    }

    public String getOutissue() {
        return outissue;
    }

    public void setOutissue(String outissue) {
        this.outissue = outissue == null ? null : outissue.trim();
    }

    public Long getBetmulti() {
        return betmulti;
    }

    public void setBetmulti(Long betmulti) {
        this.betmulti = betmulti;
    }

    public String getWanfacode() {
        return wanfacode;
    }

    public void setWanfacode(String wanfacode) {
        this.wanfacode = wanfacode == null ? null : wanfacode.trim();
    }

    public Double getWinbonus() {
        return winbonus;
    }

    public void setWinbonus(Double winbonus) {
        this.winbonus = winbonus;
    }

    public Long getBigwintag() {
        return bigwintag;
    }

    public void setBigwintag(Long bigwintag) {
        this.bigwintag = bigwintag;
    }

    public String getPrizecode() {
        return prizecode;
    }

    public void setPrizecode(String prizecode) {
        this.prizecode = prizecode == null ? null : prizecode.trim();
    }

    public Date getAwardtime() {
        return awardtime;
    }

    public void setAwardtime(Date awardtime) {
        this.awardtime = awardtime;
    }

    public Date getUnregtime() {
        return unregtime;
    }

    public void setUnregtime(Date unregtime) {
        this.unregtime = unregtime;
    }

    public String getWanfaname() {
        return wanfaname;
    }

    public void setWanfaname(String wanfaname) {
        this.wanfaname = wanfaname == null ? null : wanfaname.trim();
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }

    public String getTradeinfo() {
        return tradeinfo;
    }

    public void setTradeinfo(String tradeinfo) {
        this.tradeinfo = tradeinfo == null ? null : tradeinfo.trim();
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
        FontanaBetBj other = (FontanaBetBj) that;
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
            && (this.getRsynctype() == null ? other.getRsynctype() == null : this.getRsynctype().equals(other.getRsynctype()))
            && (this.getGamecode() == null ? other.getGamecode() == null : this.getGamecode().equals(other.getGamecode()))
            && (this.getOutissue() == null ? other.getOutissue() == null : this.getOutissue().equals(other.getOutissue()))
            && (this.getBetmulti() == null ? other.getBetmulti() == null : this.getBetmulti().equals(other.getBetmulti()))
            && (this.getWanfacode() == null ? other.getWanfacode() == null : this.getWanfacode().equals(other.getWanfacode()))
            && (this.getWinbonus() == null ? other.getWinbonus() == null : this.getWinbonus().equals(other.getWinbonus()))
            && (this.getBigwintag() == null ? other.getBigwintag() == null : this.getBigwintag().equals(other.getBigwintag()))
            && (this.getPrizecode() == null ? other.getPrizecode() == null : this.getPrizecode().equals(other.getPrizecode()))
            && (this.getAwardtime() == null ? other.getAwardtime() == null : this.getAwardtime().equals(other.getAwardtime()))
            && (this.getUnregtime() == null ? other.getUnregtime() == null : this.getUnregtime().equals(other.getUnregtime()))
            && (this.getWanfaname() == null ? other.getWanfaname() == null : this.getWanfaname().equals(other.getWanfaname()))
            && (this.getGamename() == null ? other.getGamename() == null : this.getGamename().equals(other.getGamename()))
            && (this.getTradeinfo() == null ? other.getTradeinfo() == null : this.getTradeinfo().equals(other.getTradeinfo()));
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
        result = prime * result + ((getRsynctype() == null) ? 0 : getRsynctype().hashCode());
        result = prime * result + ((getGamecode() == null) ? 0 : getGamecode().hashCode());
        result = prime * result + ((getOutissue() == null) ? 0 : getOutissue().hashCode());
        result = prime * result + ((getBetmulti() == null) ? 0 : getBetmulti().hashCode());
        result = prime * result + ((getWanfacode() == null) ? 0 : getWanfacode().hashCode());
        result = prime * result + ((getWinbonus() == null) ? 0 : getWinbonus().hashCode());
        result = prime * result + ((getBigwintag() == null) ? 0 : getBigwintag().hashCode());
        result = prime * result + ((getPrizecode() == null) ? 0 : getPrizecode().hashCode());
        result = prime * result + ((getAwardtime() == null) ? 0 : getAwardtime().hashCode());
        result = prime * result + ((getUnregtime() == null) ? 0 : getUnregtime().hashCode());
        result = prime * result + ((getWanfaname() == null) ? 0 : getWanfaname().hashCode());
        result = prime * result + ((getGamename() == null) ? 0 : getGamename().hashCode());
        result = prime * result + ((getTradeinfo() == null) ? 0 : getTradeinfo().hashCode());
        return result;
    }
}