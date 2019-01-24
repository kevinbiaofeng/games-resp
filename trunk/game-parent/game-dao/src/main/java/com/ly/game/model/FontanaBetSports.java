package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetSports implements Serializable {
    private Long id;

    /** 用户名 */
    private String username;

    /** 会员货币代码 */
    private String currencycode;

    /** 投注时间 */
    private Date createtime;

    /** 结算时间 */
    private Date settletime;

    /** 注单状态 */
    private Integer wagerstatus;

    /** 赔率 */
    private Double odds;

    /** 注单ID */
    private String xid;

    /** 下注金额 */
    private Double amount;

    /** 输赢金额 */
    private Double result;

    /** 下注IP */
    private String ipaddress;

    /** 下注类型的名称 */
    private String bettype;

    /** 注单的选择 */
    private String selection;

    /** 未知，保留 */
    private String handicap;

    /** 未知，保留 */
    private String period;

    /** 未知，保留 */
    private String group;

    /** 无效原因 */
    private String remark;

    /** 未知，保留 */
    private String tag;

    /** 赛事名称，xx vs xx */
    private String name;

    /** 赛事结果 */
    private String results;

    /** 赛事开始时间 */
    private Date starttime;

    /** 赛事结束时间 */
    private Date endtime;

    /** 插库时间 */
    private Date inserttime;

    /** 用户ID */
    private Integer userid;

    /** 公司ID */
    private Integer cid;

    private Date groupfor;

    /** 有效投注额 */
    private Double validbet;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode == null ? null : currencycode.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getSettletime() {
        return settletime;
    }

    public void setSettletime(Date settletime) {
        this.settletime = settletime;
    }

    public Integer getWagerstatus() {
        return wagerstatus;
    }

    public void setWagerstatus(Integer wagerstatus) {
        this.wagerstatus = wagerstatus;
    }

    public Double getOdds() {
        return odds;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid == null ? null : xid.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }

    public String getBettype() {
        return bettype;
    }

    public void setBettype(String bettype) {
        this.bettype = bettype == null ? null : bettype.trim();
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection == null ? null : selection.trim();
    }

    public String getHandicap() {
        return handicap;
    }

    public void setHandicap(String handicap) {
        this.handicap = handicap == null ? null : handicap.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group == null ? null : group.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results == null ? null : results.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(Date groupfor) {
        this.groupfor = groupfor;
    }

    public Double getValidbet() {
        return validbet;
    }

    public void setValidbet(Double validbet) {
        this.validbet = validbet;
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
        FontanaBetSports other = (FontanaBetSports) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getCurrencycode() == null ? other.getCurrencycode() == null : this.getCurrencycode().equals(other.getCurrencycode()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getSettletime() == null ? other.getSettletime() == null : this.getSettletime().equals(other.getSettletime()))
            && (this.getWagerstatus() == null ? other.getWagerstatus() == null : this.getWagerstatus().equals(other.getWagerstatus()))
            && (this.getOdds() == null ? other.getOdds() == null : this.getOdds().equals(other.getOdds()))
            && (this.getXid() == null ? other.getXid() == null : this.getXid().equals(other.getXid()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getIpaddress() == null ? other.getIpaddress() == null : this.getIpaddress().equals(other.getIpaddress()))
            && (this.getBettype() == null ? other.getBettype() == null : this.getBettype().equals(other.getBettype()))
            && (this.getSelection() == null ? other.getSelection() == null : this.getSelection().equals(other.getSelection()))
            && (this.getHandicap() == null ? other.getHandicap() == null : this.getHandicap().equals(other.getHandicap()))
            && (this.getPeriod() == null ? other.getPeriod() == null : this.getPeriod().equals(other.getPeriod()))
            && (this.getGroup() == null ? other.getGroup() == null : this.getGroup().equals(other.getGroup()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getTag() == null ? other.getTag() == null : this.getTag().equals(other.getTag()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getResults() == null ? other.getResults() == null : this.getResults().equals(other.getResults()))
            && (this.getStarttime() == null ? other.getStarttime() == null : this.getStarttime().equals(other.getStarttime()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getInserttime() == null ? other.getInserttime() == null : this.getInserttime().equals(other.getInserttime()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getValidbet() == null ? other.getValidbet() == null : this.getValidbet().equals(other.getValidbet()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getCurrencycode() == null) ? 0 : getCurrencycode().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getSettletime() == null) ? 0 : getSettletime().hashCode());
        result = prime * result + ((getWagerstatus() == null) ? 0 : getWagerstatus().hashCode());
        result = prime * result + ((getOdds() == null) ? 0 : getOdds().hashCode());
        result = prime * result + ((getXid() == null) ? 0 : getXid().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getIpaddress() == null) ? 0 : getIpaddress().hashCode());
        result = prime * result + ((getBettype() == null) ? 0 : getBettype().hashCode());
        result = prime * result + ((getSelection() == null) ? 0 : getSelection().hashCode());
        result = prime * result + ((getHandicap() == null) ? 0 : getHandicap().hashCode());
        result = prime * result + ((getPeriod() == null) ? 0 : getPeriod().hashCode());
        result = prime * result + ((getGroup() == null) ? 0 : getGroup().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getTag() == null) ? 0 : getTag().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getResults() == null) ? 0 : getResults().hashCode());
        result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getInserttime() == null) ? 0 : getInserttime().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getValidbet() == null) ? 0 : getValidbet().hashCode());
        return result;
    }
}