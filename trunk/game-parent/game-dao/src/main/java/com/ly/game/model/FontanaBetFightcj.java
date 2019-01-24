package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetFightcj implements Serializable {
    /** id */
    private Long id;

    /** 用户id */
    private Long uid;

    /** 玩家账号 */
    private String username;

    /** 房间名称 */
    private String roomname;

    /** 全球唯一识别号 */
    private String guid;

    /** 房间编号 */
    private Integer roomid;

    /** 注点类型 */
    private Short pointtype;

    /** 赔率 */
    private String losspercent;

    /** 投注额 */
    private Double betsize;

    /** 投注结果 */
    private Double betresult;

    /** 是否同步 */
    private Short istrans;

    /** 记录时间 */
    private Date createtime;

    /** 公司id */
    private Long cid;

    /** 大股东id */
    private Long pid;

    /** 股东id */
    private Long gid;

    /** 总代理id */
    private Long aid;

    /** 代理id */
    private Long sid;

    /** 美东时间的日期 */
    private Date groupfor;

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

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname == null ? null : roomname.trim();
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Short getPointtype() {
        return pointtype;
    }

    public void setPointtype(Short pointtype) {
        this.pointtype = pointtype;
    }

    public String getLosspercent() {
        return losspercent;
    }

    public void setLosspercent(String losspercent) {
        this.losspercent = losspercent == null ? null : losspercent.trim();
    }

    public Double getBetsize() {
        return betsize;
    }

    public void setBetsize(Double betsize) {
        this.betsize = betsize;
    }

    public Double getBetresult() {
        return betresult;
    }

    public void setBetresult(Double betresult) {
        this.betresult = betresult;
    }

    public Short getIstrans() {
        return istrans;
    }

    public void setIstrans(Short istrans) {
        this.istrans = istrans;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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
        FontanaBetFightcj other = (FontanaBetFightcj) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getRoomname() == null ? other.getRoomname() == null : this.getRoomname().equals(other.getRoomname()))
            && (this.getGuid() == null ? other.getGuid() == null : this.getGuid().equals(other.getGuid()))
            && (this.getRoomid() == null ? other.getRoomid() == null : this.getRoomid().equals(other.getRoomid()))
            && (this.getPointtype() == null ? other.getPointtype() == null : this.getPointtype().equals(other.getPointtype()))
            && (this.getLosspercent() == null ? other.getLosspercent() == null : this.getLosspercent().equals(other.getLosspercent()))
            && (this.getBetsize() == null ? other.getBetsize() == null : this.getBetsize().equals(other.getBetsize()))
            && (this.getBetresult() == null ? other.getBetresult() == null : this.getBetresult().equals(other.getBetresult()))
            && (this.getIstrans() == null ? other.getIstrans() == null : this.getIstrans().equals(other.getIstrans()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getRoomname() == null) ? 0 : getRoomname().hashCode());
        result = prime * result + ((getGuid() == null) ? 0 : getGuid().hashCode());
        result = prime * result + ((getRoomid() == null) ? 0 : getRoomid().hashCode());
        result = prime * result + ((getPointtype() == null) ? 0 : getPointtype().hashCode());
        result = prime * result + ((getLosspercent() == null) ? 0 : getLosspercent().hashCode());
        result = prime * result + ((getBetsize() == null) ? 0 : getBetsize().hashCode());
        result = prime * result + ((getBetresult() == null) ? 0 : getBetresult().hashCode());
        result = prime * result + ((getIstrans() == null) ? 0 : getIstrans().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        return result;
    }
}