package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetAgbm implements Serializable {
    private Long id;

    private Long parentid;

    /** 用户ID */
    private Long uid;

    /** 公司ID */
    private Long cid;

    /** 数据类型,EBR:电子游戏下注记录;LBR:彩票下注记录;LGR:彩票结果 */
    private String datatype;

    /** 注单流水号 */
    private String billno;

    /** 玩家账号 */
    private String playername;

    /** 代理商编号 */
    private String agentcode;

    /** 游戏局号,彩票期号 */
    private String gamecode;

    /** 玩家输赢额度 */
    private Double netamount;

    /** 投注时间 */
    private Date bettime;

    /** 游戏类型 */
    private String gametype;

    /** 投注金额 */
    private Double betamount;

    /** 有效投注金额 */
    private Double validbetamount;

    /** 结算状态 */
    private String lag;

    /** 游戏玩法 */
    private String playtype;

    /** 货币类型 */
    private String currency;

    /** 桌子编号 */
    private String tablecode;

    /** 玩家IP */
    private String loginip;

    /** 注单重新派彩时间 */
    private Date recalcutime;

    /** 平台类型 */
    private String platformtype;

    /** 额外信息 */
    private String remark;

    /** 平台内的大厅类型 */
    private String round;

    /** 老虎机类型 */
    private String slottype;

    /** 结果 */
    private String result;

    /** 主订单号 */
    private String mainbillno;

    /** 玩家下注前的剩余额度 */
    private Double beforecredit;

    /** 设备类型 */
    private String devicetype;

    /** 游戏下注额度 */
    private Double betamountbase;

    /** Jackpot下注额度 */
    private Double betamountbonus;

    /** 游戏派彩 */
    private Double netamountbase;

    /** Jackpot派彩 */
    private Double netamountbonus;

    /** 倍数 */
    private Double multiple;

    /** 彩票期开始的时间 */
    private Date begintime;

    /** 彩票期结束的时间 */
    private Date closetime;

    /** 调整后交易时间，操盘时间。例：9月10日 中午12点整 到 9月11日 中午11：59 billdate全部为 9月10日 */
    private Date groupfor;

    /** 创建时间 */
    private Date createtime;

    private String dealer;

    private String shoecode;

    private String bankerpoint;

    private String playerpoint;

    private Integer cardnum;

    private Integer pair;

    private String dragonpoint;

    private String tigerpoint;

    private String cardlist;

    private String vid;

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

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype == null ? null : datatype.trim();
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername == null ? null : playername.trim();
    }

    public String getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(String agentcode) {
        this.agentcode = agentcode == null ? null : agentcode.trim();
    }

    public String getGamecode() {
        return gamecode;
    }

    public void setGamecode(String gamecode) {
        this.gamecode = gamecode == null ? null : gamecode.trim();
    }

    public Double getNetamount() {
        return netamount;
    }

    public void setNetamount(Double netamount) {
        this.netamount = netamount;
    }

    public Date getBettime() {
        return bettime;
    }

    public void setBettime(Date bettime) {
        this.bettime = bettime;
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
    }

    public Double getBetamount() {
        return betamount;
    }

    public void setBetamount(Double betamount) {
        this.betamount = betamount;
    }

    public Double getValidbetamount() {
        return validbetamount;
    }

    public void setValidbetamount(Double validbetamount) {
        this.validbetamount = validbetamount;
    }

    public String getLag() {
        return lag;
    }

    public void setLag(String lag) {
        this.lag = lag == null ? null : lag.trim();
    }

    public String getPlaytype() {
        return playtype;
    }

    public void setPlaytype(String playtype) {
        this.playtype = playtype == null ? null : playtype.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getTablecode() {
        return tablecode;
    }

    public void setTablecode(String tablecode) {
        this.tablecode = tablecode == null ? null : tablecode.trim();
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip == null ? null : loginip.trim();
    }

    public Date getRecalcutime() {
        return recalcutime;
    }

    public void setRecalcutime(Date recalcutime) {
        this.recalcutime = recalcutime;
    }

    public String getPlatformtype() {
        return platformtype;
    }

    public void setPlatformtype(String platformtype) {
        this.platformtype = platformtype == null ? null : platformtype.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round == null ? null : round.trim();
    }

    public String getSlottype() {
        return slottype;
    }

    public void setSlottype(String slottype) {
        this.slottype = slottype == null ? null : slottype.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getMainbillno() {
        return mainbillno;
    }

    public void setMainbillno(String mainbillno) {
        this.mainbillno = mainbillno == null ? null : mainbillno.trim();
    }

    public Double getBeforecredit() {
        return beforecredit;
    }

    public void setBeforecredit(Double beforecredit) {
        this.beforecredit = beforecredit;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype == null ? null : devicetype.trim();
    }

    public Double getBetamountbase() {
        return betamountbase;
    }

    public void setBetamountbase(Double betamountbase) {
        this.betamountbase = betamountbase;
    }

    public Double getBetamountbonus() {
        return betamountbonus;
    }

    public void setBetamountbonus(Double betamountbonus) {
        this.betamountbonus = betamountbonus;
    }

    public Double getNetamountbase() {
        return netamountbase;
    }

    public void setNetamountbase(Double netamountbase) {
        this.netamountbase = netamountbase;
    }

    public Double getNetamountbonus() {
        return netamountbonus;
    }

    public void setNetamountbonus(Double netamountbonus) {
        this.netamountbonus = netamountbonus;
    }

    public Double getMultiple() {
        return multiple;
    }

    public void setMultiple(Double multiple) {
        this.multiple = multiple;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getClosetime() {
        return closetime;
    }

    public void setClosetime(Date closetime) {
        this.closetime = closetime;
    }

    public Date getGroupfor() {
        return groupfor;
    }

    public void setGroupfor(Date groupfor) {
        this.groupfor = groupfor;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer == null ? null : dealer.trim();
    }

    public String getShoecode() {
        return shoecode;
    }

    public void setShoecode(String shoecode) {
        this.shoecode = shoecode == null ? null : shoecode.trim();
    }

    public String getBankerpoint() {
        return bankerpoint;
    }

    public void setBankerpoint(String bankerpoint) {
        this.bankerpoint = bankerpoint == null ? null : bankerpoint.trim();
    }

    public String getPlayerpoint() {
        return playerpoint;
    }

    public void setPlayerpoint(String playerpoint) {
        this.playerpoint = playerpoint == null ? null : playerpoint.trim();
    }

    public Integer getCardnum() {
        return cardnum;
    }

    public void setCardnum(Integer cardnum) {
        this.cardnum = cardnum;
    }

    public Integer getPair() {
        return pair;
    }

    public void setPair(Integer pair) {
        this.pair = pair;
    }

    public String getDragonpoint() {
        return dragonpoint;
    }

    public void setDragonpoint(String dragonpoint) {
        this.dragonpoint = dragonpoint == null ? null : dragonpoint.trim();
    }

    public String getTigerpoint() {
        return tigerpoint;
    }

    public void setTigerpoint(String tigerpoint) {
        this.tigerpoint = tigerpoint == null ? null : tigerpoint.trim();
    }

    public String getCardlist() {
        return cardlist;
    }

    public void setCardlist(String cardlist) {
        this.cardlist = cardlist == null ? null : cardlist.trim();
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid == null ? null : vid.trim();
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
        FontanaBetAgbm other = (FontanaBetAgbm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getDatatype() == null ? other.getDatatype() == null : this.getDatatype().equals(other.getDatatype()))
            && (this.getBillno() == null ? other.getBillno() == null : this.getBillno().equals(other.getBillno()))
            && (this.getPlayername() == null ? other.getPlayername() == null : this.getPlayername().equals(other.getPlayername()))
            && (this.getAgentcode() == null ? other.getAgentcode() == null : this.getAgentcode().equals(other.getAgentcode()))
            && (this.getGamecode() == null ? other.getGamecode() == null : this.getGamecode().equals(other.getGamecode()))
            && (this.getNetamount() == null ? other.getNetamount() == null : this.getNetamount().equals(other.getNetamount()))
            && (this.getBettime() == null ? other.getBettime() == null : this.getBettime().equals(other.getBettime()))
            && (this.getGametype() == null ? other.getGametype() == null : this.getGametype().equals(other.getGametype()))
            && (this.getBetamount() == null ? other.getBetamount() == null : this.getBetamount().equals(other.getBetamount()))
            && (this.getValidbetamount() == null ? other.getValidbetamount() == null : this.getValidbetamount().equals(other.getValidbetamount()))
            && (this.getLag() == null ? other.getLag() == null : this.getLag().equals(other.getLag()))
            && (this.getPlaytype() == null ? other.getPlaytype() == null : this.getPlaytype().equals(other.getPlaytype()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getTablecode() == null ? other.getTablecode() == null : this.getTablecode().equals(other.getTablecode()))
            && (this.getLoginip() == null ? other.getLoginip() == null : this.getLoginip().equals(other.getLoginip()))
            && (this.getRecalcutime() == null ? other.getRecalcutime() == null : this.getRecalcutime().equals(other.getRecalcutime()))
            && (this.getPlatformtype() == null ? other.getPlatformtype() == null : this.getPlatformtype().equals(other.getPlatformtype()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getRound() == null ? other.getRound() == null : this.getRound().equals(other.getRound()))
            && (this.getSlottype() == null ? other.getSlottype() == null : this.getSlottype().equals(other.getSlottype()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getMainbillno() == null ? other.getMainbillno() == null : this.getMainbillno().equals(other.getMainbillno()))
            && (this.getBeforecredit() == null ? other.getBeforecredit() == null : this.getBeforecredit().equals(other.getBeforecredit()))
            && (this.getDevicetype() == null ? other.getDevicetype() == null : this.getDevicetype().equals(other.getDevicetype()))
            && (this.getBetamountbase() == null ? other.getBetamountbase() == null : this.getBetamountbase().equals(other.getBetamountbase()))
            && (this.getBetamountbonus() == null ? other.getBetamountbonus() == null : this.getBetamountbonus().equals(other.getBetamountbonus()))
            && (this.getNetamountbase() == null ? other.getNetamountbase() == null : this.getNetamountbase().equals(other.getNetamountbase()))
            && (this.getNetamountbonus() == null ? other.getNetamountbonus() == null : this.getNetamountbonus().equals(other.getNetamountbonus()))
            && (this.getMultiple() == null ? other.getMultiple() == null : this.getMultiple().equals(other.getMultiple()))
            && (this.getBegintime() == null ? other.getBegintime() == null : this.getBegintime().equals(other.getBegintime()))
            && (this.getClosetime() == null ? other.getClosetime() == null : this.getClosetime().equals(other.getClosetime()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getDealer() == null ? other.getDealer() == null : this.getDealer().equals(other.getDealer()))
            && (this.getShoecode() == null ? other.getShoecode() == null : this.getShoecode().equals(other.getShoecode()))
            && (this.getBankerpoint() == null ? other.getBankerpoint() == null : this.getBankerpoint().equals(other.getBankerpoint()))
            && (this.getPlayerpoint() == null ? other.getPlayerpoint() == null : this.getPlayerpoint().equals(other.getPlayerpoint()))
            && (this.getCardnum() == null ? other.getCardnum() == null : this.getCardnum().equals(other.getCardnum()))
            && (this.getPair() == null ? other.getPair() == null : this.getPair().equals(other.getPair()))
            && (this.getDragonpoint() == null ? other.getDragonpoint() == null : this.getDragonpoint().equals(other.getDragonpoint()))
            && (this.getTigerpoint() == null ? other.getTigerpoint() == null : this.getTigerpoint().equals(other.getTigerpoint()))
            && (this.getCardlist() == null ? other.getCardlist() == null : this.getCardlist().equals(other.getCardlist()))
            && (this.getVid() == null ? other.getVid() == null : this.getVid().equals(other.getVid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getDatatype() == null) ? 0 : getDatatype().hashCode());
        result = prime * result + ((getBillno() == null) ? 0 : getBillno().hashCode());
        result = prime * result + ((getPlayername() == null) ? 0 : getPlayername().hashCode());
        result = prime * result + ((getAgentcode() == null) ? 0 : getAgentcode().hashCode());
        result = prime * result + ((getGamecode() == null) ? 0 : getGamecode().hashCode());
        result = prime * result + ((getNetamount() == null) ? 0 : getNetamount().hashCode());
        result = prime * result + ((getBettime() == null) ? 0 : getBettime().hashCode());
        result = prime * result + ((getGametype() == null) ? 0 : getGametype().hashCode());
        result = prime * result + ((getBetamount() == null) ? 0 : getBetamount().hashCode());
        result = prime * result + ((getValidbetamount() == null) ? 0 : getValidbetamount().hashCode());
        result = prime * result + ((getLag() == null) ? 0 : getLag().hashCode());
        result = prime * result + ((getPlaytype() == null) ? 0 : getPlaytype().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getTablecode() == null) ? 0 : getTablecode().hashCode());
        result = prime * result + ((getLoginip() == null) ? 0 : getLoginip().hashCode());
        result = prime * result + ((getRecalcutime() == null) ? 0 : getRecalcutime().hashCode());
        result = prime * result + ((getPlatformtype() == null) ? 0 : getPlatformtype().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getRound() == null) ? 0 : getRound().hashCode());
        result = prime * result + ((getSlottype() == null) ? 0 : getSlottype().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getMainbillno() == null) ? 0 : getMainbillno().hashCode());
        result = prime * result + ((getBeforecredit() == null) ? 0 : getBeforecredit().hashCode());
        result = prime * result + ((getDevicetype() == null) ? 0 : getDevicetype().hashCode());
        result = prime * result + ((getBetamountbase() == null) ? 0 : getBetamountbase().hashCode());
        result = prime * result + ((getBetamountbonus() == null) ? 0 : getBetamountbonus().hashCode());
        result = prime * result + ((getNetamountbase() == null) ? 0 : getNetamountbase().hashCode());
        result = prime * result + ((getNetamountbonus() == null) ? 0 : getNetamountbonus().hashCode());
        result = prime * result + ((getMultiple() == null) ? 0 : getMultiple().hashCode());
        result = prime * result + ((getBegintime() == null) ? 0 : getBegintime().hashCode());
        result = prime * result + ((getClosetime() == null) ? 0 : getClosetime().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getDealer() == null) ? 0 : getDealer().hashCode());
        result = prime * result + ((getShoecode() == null) ? 0 : getShoecode().hashCode());
        result = prime * result + ((getBankerpoint() == null) ? 0 : getBankerpoint().hashCode());
        result = prime * result + ((getPlayerpoint() == null) ? 0 : getPlayerpoint().hashCode());
        result = prime * result + ((getCardnum() == null) ? 0 : getCardnum().hashCode());
        result = prime * result + ((getPair() == null) ? 0 : getPair().hashCode());
        result = prime * result + ((getDragonpoint() == null) ? 0 : getDragonpoint().hashCode());
        result = prime * result + ((getTigerpoint() == null) ? 0 : getTigerpoint().hashCode());
        result = prime * result + ((getCardlist() == null) ? 0 : getCardlist().hashCode());
        result = prime * result + ((getVid() == null) ? 0 : getVid().hashCode());
        return result;
    }
}