package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaFetchdate implements Serializable {
    private Long id;

    /** 游戏类型，对应GameType.java */
    private String gametype;

    /** 最后一次抓票的时间记录 */
    private Date etchstarttime;

    private String versionkey;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
    }

    public Date getEtchstarttime() {
        return etchstarttime;
    }

    public void setEtchstarttime(Date etchstarttime) {
        this.etchstarttime = etchstarttime;
    }

    public String getVersionkey() {
        return versionkey;
    }

    public void setVersionkey(String versionkey) {
        this.versionkey = versionkey == null ? null : versionkey.trim();
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
        FontanaFetchdate other = (FontanaFetchdate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGametype() == null ? other.getGametype() == null : this.getGametype().equals(other.getGametype()))
            && (this.getEtchstarttime() == null ? other.getEtchstarttime() == null : this.getEtchstarttime().equals(other.getEtchstarttime()))
            && (this.getVersionkey() == null ? other.getVersionkey() == null : this.getVersionkey().equals(other.getVersionkey()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGametype() == null) ? 0 : getGametype().hashCode());
        result = prime * result + ((getEtchstarttime() == null) ? 0 : getEtchstarttime().hashCode());
        result = prime * result + ((getVersionkey() == null) ? 0 : getVersionkey().hashCode());
        return result;
    }
}