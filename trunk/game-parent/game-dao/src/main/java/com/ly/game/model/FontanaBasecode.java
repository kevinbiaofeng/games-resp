package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class FontanaBasecode implements Serializable {
    private Long id;

    private Long parentid;

    /** 类型 */
    @JSONField(name = "bctype")
    private String bctype;

    /** 关键字key */
    private String bckey;

    /** 值value */
    private String bcvalue;

    /** 排序 */
    private Integer sort;

    /** 备注 */
    private String remark;

    /** 修改时间 */
    private Date updatetime;

    /** 创建时间 */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

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

    public String getBctype() {
        return bctype;
    }

    public void setBctype(String bctype) {
        this.bctype = bctype == null ? null : bctype.trim();
    }

    public String getBckey() {
        return bckey;
    }

    public void setBckey(String bckey) {
        this.bckey = bckey == null ? null : bckey.trim();
    }

    public String getBcvalue() {
        return bcvalue;
    }

    public void setBcvalue(String bcvalue) {
        this.bcvalue = bcvalue == null ? null : bcvalue.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
        FontanaBasecode other = (FontanaBasecode) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getBctype() == null ? other.getBctype() == null : this.getBctype().equals(other.getBctype()))
            && (this.getBckey() == null ? other.getBckey() == null : this.getBckey().equals(other.getBckey()))
            && (this.getBcvalue() == null ? other.getBcvalue() == null : this.getBcvalue().equals(other.getBcvalue()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getBctype() == null) ? 0 : getBctype().hashCode());
        result = prime * result + ((getBckey() == null) ? 0 : getBckey().hashCode());
        result = prime * result + ((getBcvalue() == null) ? 0 : getBcvalue().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        return result;
    }
}