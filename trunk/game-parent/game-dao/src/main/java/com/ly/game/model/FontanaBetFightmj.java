package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetFightmj implements Serializable {
    private Long id;

    private Long parentid;

    /** 用户ID */
    private Long uid;

    /** 公司ID */
    private Long cid;

    /** 注单流水号 */
    private Integer gameid;

    /** 玩家姓名 */
    private String username;

    /** 游戏底分 */
    private Integer gamescore;

    /** 服务费 */
    private Double servicemoney;

    /** 输赢金额 */
    private Double money;

    /** 游戏持续时间 */
    private String timespend;

    /** 加倍次数 */
    private String doubletimes;

    private String enddoublecount;

    /** 游戏输赢 */
    private Integer gameresult;

    /** 番种 */
    private Integer an;

    /** 结算前金币 */
    private Double startfreecoins;

    /** 结算后金币 */
    private Double endfreecoins;

    /** 结束时间 */
    private Date gameendtime;

    /** 胡番 */
    private String hefan;

    /** 胡牌 */
    private String handpai;

    /** 房间号 */
    private String roomid;

    /** 座位号 */
    private String seatno;

    /** 渠道号 */
    private String channel;

    /** 结算比例 */
    private String commissrate;

    /** 是否同步 */
    private String istrans;

    /** 结算时间 */
    private Date createtime;

    /** 房间名称 */
    private String roomname;

    /** 调整后交易时间，操盘时间。例：9月10日 中午12点整 到 9月11日 中午11：59 billdate全部为 9月10日 */
    private Date groupfor;

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

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getGameid() {
        return gameid;
    }

    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getGamescore() {
        return gamescore;
    }

    public void setGamescore(Integer gamescore) {
        this.gamescore = gamescore;
    }

    public Double getServicemoney() {
        return servicemoney;
    }

    public void setServicemoney(Double servicemoney) {
        this.servicemoney = servicemoney;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getTimespend() {
        return timespend;
    }

    public void setTimespend(String timespend) {
        this.timespend = timespend == null ? null : timespend.trim();
    }

    public String getDoubletimes() {
        return doubletimes;
    }

    public void setDoubletimes(String doubletimes) {
        this.doubletimes = doubletimes == null ? null : doubletimes.trim();
    }

    public String getEnddoublecount() {
        return enddoublecount;
    }

    public void setEnddoublecount(String enddoublecount) {
        this.enddoublecount = enddoublecount == null ? null : enddoublecount.trim();
    }

    public Integer getGameresult() {
        return gameresult;
    }

    public void setGameresult(Integer gameresult) {
        this.gameresult = gameresult;
    }

    public Integer getAn() {
        return an;
    }

    public void setAn(Integer an) {
        this.an = an;
    }

    public Double getStartfreecoins() {
        return startfreecoins;
    }

    public void setStartfreecoins(Double startfreecoins) {
        this.startfreecoins = startfreecoins;
    }

    public Double getEndfreecoins() {
        return endfreecoins;
    }

    public void setEndfreecoins(Double endfreecoins) {
        this.endfreecoins = endfreecoins;
    }

    public Date getGameendtime() {
        return gameendtime;
    }

    public void setGameendtime(Date gameendtime) {
        this.gameendtime = gameendtime;
    }

    public String getHefan() {
        return hefan;
    }

    public void setHefan(String hefan) {
        this.hefan = hefan == null ? null : hefan.trim();
    }

    public String getHandpai() {
        return handpai;
    }

    public void setHandpai(String handpai) {
        this.handpai = handpai == null ? null : handpai.trim();
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid == null ? null : roomid.trim();
    }

    public String getSeatno() {
        return seatno;
    }

    public void setSeatno(String seatno) {
        this.seatno = seatno == null ? null : seatno.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getCommissrate() {
        return commissrate;
    }

    public void setCommissrate(String commissrate) {
        this.commissrate = commissrate == null ? null : commissrate.trim();
    }

    public String getIstrans() {
        return istrans;
    }

    public void setIstrans(String istrans) {
        this.istrans = istrans == null ? null : istrans.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname == null ? null : roomname.trim();
    }

    public Date getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(Date groupfor) {
        this.groupfor = groupfor;
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
        FontanaBetFightmj other = (FontanaBetFightmj) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getGameid() == null ? other.getGameid() == null : this.getGameid().equals(other.getGameid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getGamescore() == null ? other.getGamescore() == null : this.getGamescore().equals(other.getGamescore()))
            && (this.getServicemoney() == null ? other.getServicemoney() == null : this.getServicemoney().equals(other.getServicemoney()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getTimespend() == null ? other.getTimespend() == null : this.getTimespend().equals(other.getTimespend()))
            && (this.getDoubletimes() == null ? other.getDoubletimes() == null : this.getDoubletimes().equals(other.getDoubletimes()))
            && (this.getEnddoublecount() == null ? other.getEnddoublecount() == null : this.getEnddoublecount().equals(other.getEnddoublecount()))
            && (this.getGameresult() == null ? other.getGameresult() == null : this.getGameresult().equals(other.getGameresult()))
            && (this.getAn() == null ? other.getAn() == null : this.getAn().equals(other.getAn()))
            && (this.getStartfreecoins() == null ? other.getStartfreecoins() == null : this.getStartfreecoins().equals(other.getStartfreecoins()))
            && (this.getEndfreecoins() == null ? other.getEndfreecoins() == null : this.getEndfreecoins().equals(other.getEndfreecoins()))
            && (this.getGameendtime() == null ? other.getGameendtime() == null : this.getGameendtime().equals(other.getGameendtime()))
            && (this.getHefan() == null ? other.getHefan() == null : this.getHefan().equals(other.getHefan()))
            && (this.getHandpai() == null ? other.getHandpai() == null : this.getHandpai().equals(other.getHandpai()))
            && (this.getRoomid() == null ? other.getRoomid() == null : this.getRoomid().equals(other.getRoomid()))
            && (this.getSeatno() == null ? other.getSeatno() == null : this.getSeatno().equals(other.getSeatno()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getCommissrate() == null ? other.getCommissrate() == null : this.getCommissrate().equals(other.getCommissrate()))
            && (this.getIstrans() == null ? other.getIstrans() == null : this.getIstrans().equals(other.getIstrans()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getRoomname() == null ? other.getRoomname() == null : this.getRoomname().equals(other.getRoomname()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getGameid() == null) ? 0 : getGameid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getGamescore() == null) ? 0 : getGamescore().hashCode());
        result = prime * result + ((getServicemoney() == null) ? 0 : getServicemoney().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getTimespend() == null) ? 0 : getTimespend().hashCode());
        result = prime * result + ((getDoubletimes() == null) ? 0 : getDoubletimes().hashCode());
        result = prime * result + ((getEnddoublecount() == null) ? 0 : getEnddoublecount().hashCode());
        result = prime * result + ((getGameresult() == null) ? 0 : getGameresult().hashCode());
        result = prime * result + ((getAn() == null) ? 0 : getAn().hashCode());
        result = prime * result + ((getStartfreecoins() == null) ? 0 : getStartfreecoins().hashCode());
        result = prime * result + ((getEndfreecoins() == null) ? 0 : getEndfreecoins().hashCode());
        result = prime * result + ((getGameendtime() == null) ? 0 : getGameendtime().hashCode());
        result = prime * result + ((getHefan() == null) ? 0 : getHefan().hashCode());
        result = prime * result + ((getHandpai() == null) ? 0 : getHandpai().hashCode());
        result = prime * result + ((getRoomid() == null) ? 0 : getRoomid().hashCode());
        result = prime * result + ((getSeatno() == null) ? 0 : getSeatno().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getCommissrate() == null) ? 0 : getCommissrate().hashCode());
        result = prime * result + ((getIstrans() == null) ? 0 : getIstrans().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getRoomname() == null) ? 0 : getRoomname().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        return result;
    }
}