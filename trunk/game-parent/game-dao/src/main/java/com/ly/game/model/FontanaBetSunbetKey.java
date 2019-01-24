package com.ly.game.model;

import java.io.Serializable;

public class FontanaBetSunbetKey implements Serializable {
    /** 本表的注释需要弄清楚后加上 */
    private Long id;

    private String ugsbetid;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUgsbetid() {
        return ugsbetid;
    }

    public void setUgsbetid(String ugsbetid) {
        this.ugsbetid = ugsbetid == null ? null : ugsbetid.trim();
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
        FontanaBetSunbetKey other = (FontanaBetSunbetKey) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUgsbetid() == null ? other.getUgsbetid() == null : this.getUgsbetid().equals(other.getUgsbetid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUgsbetid() == null) ? 0 : getUgsbetid().hashCode());
        return result;
    }
}