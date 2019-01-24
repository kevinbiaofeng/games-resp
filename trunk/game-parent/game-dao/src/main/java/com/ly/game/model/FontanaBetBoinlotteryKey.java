package com.ly.game.model;

import java.io.Serializable;

public class FontanaBetBoinlotteryKey implements Serializable {
    /** 自增主键 */
    private Long id;

    /** 投注单号，全局唯一 */
    private Long betnum;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBetnum() {
        return betnum;
    }

    public void setBetnum(Long betnum) {
        this.betnum = betnum;
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
        FontanaBetBoinlotteryKey other = (FontanaBetBoinlotteryKey) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBetnum() == null ? other.getBetnum() == null : this.getBetnum().equals(other.getBetnum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBetnum() == null) ? 0 : getBetnum().hashCode());
        return result;
    }
}