package com.ly.game.model;

import java.io.Serializable;
import java.util.Date;

public class FontanaBetFight implements Serializable {
    private Long id;

    private Long parentid;

    private Integer fid;

    private String username;

    private Date createtime;

    private String gameid;

    private String userhandcard;

    private String seat0handcard;

    private String seat1handcard;

    private String bottomcard;

    private Integer islord;

    private Integer gamescore;

    private Integer multiplebomb;

    private Integer multiplespring;

    private Integer multipletask;

    private Integer multiplemultiple;

    private Integer opencardmultiple;

    private Double result;

    /** 服务费 */
    private Double servicemoney;

    private String commratio;

    private Integer roomid;

    private String cnname;

    private Integer roomsrcore;

    private String currency;

    private Double rate;

    private Long userid;

    private Double useresult;

    private Double userDisacount;

    private Double userTake;

    private Double userAmount;

    private Long subagentid;

    private String subagentname;

    private Double subagentPer;

    private Double subagentPart;

    private Double subagentDisacount;

    private Double subagentTake;

    private Double subagentGive;

    private Double subagentAmount;

    private Long agentid;

    private String agentname;

    private Double agentPer;

    private Double agentPart;

    private Double agentDisacount;

    private Double agentTake;

    private Double agentGive;

    private Double agentAmount;

    private Long gengeralid;

    private String gengeralname;

    private Double gengeralPer;

    private Double gengeralPart;

    private Double gengeralDisacount;

    private Double gengeralTake;

    private Double gengeralGive;

    private Double gengeralAmount;

    private Long partnerid;

    private String partnername;

    private Double partnerPer;

    private Double partnerPart;

    private Double partnerDisacount;

    private Double partnerTake;

    private Double partnerGive;

    private Double partnerAmount;

    private Long companyid;

    private String companyname;

    private Double companyPer;

    private Double companyPart;

    private Double companyDisacount;

    private Double companyTake;

    private Double companyGive;

    private Double companyAmount;

    private Double platformPer;

    private Double platformPart;

    private Double platformGive;

    private Double platformAmount;

    private Date bettime;

    private Date groupfor;

    private Integer status;

    /** 行牌记录 */
    private String takeoutlog;

    /** 局号 */
    private String bureauno;

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

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid == null ? null : gameid.trim();
    }

    public String getUserhandcard() {
        return userhandcard;
    }

    public void setUserhandcard(String userhandcard) {
        this.userhandcard = userhandcard == null ? null : userhandcard.trim();
    }

    public String getSeat0handcard() {
        return seat0handcard;
    }

    public void setSeat0handcard(String seat0handcard) {
        this.seat0handcard = seat0handcard == null ? null : seat0handcard.trim();
    }

    public String getSeat1handcard() {
        return seat1handcard;
    }

    public void setSeat1handcard(String seat1handcard) {
        this.seat1handcard = seat1handcard == null ? null : seat1handcard.trim();
    }

    public String getBottomcard() {
        return bottomcard;
    }

    public void setBottomcard(String bottomcard) {
        this.bottomcard = bottomcard == null ? null : bottomcard.trim();
    }

    public Integer getIslord() {
        return islord;
    }

    public void setIslord(Integer islord) {
        this.islord = islord;
    }

    public Integer getGamescore() {
        return gamescore;
    }

    public void setGamescore(Integer gamescore) {
        this.gamescore = gamescore;
    }

    public Integer getMultiplebomb() {
        return multiplebomb;
    }

    public void setMultiplebomb(Integer multiplebomb) {
        this.multiplebomb = multiplebomb;
    }

    public Integer getMultiplespring() {
        return multiplespring;
    }

    public void setMultiplespring(Integer multiplespring) {
        this.multiplespring = multiplespring;
    }

    public Integer getMultipletask() {
        return multipletask;
    }

    public void setMultipletask(Integer multipletask) {
        this.multipletask = multipletask;
    }

    public Integer getMultiplemultiple() {
        return multiplemultiple;
    }

    public void setMultiplemultiple(Integer multiplemultiple) {
        this.multiplemultiple = multiplemultiple;
    }

    public Integer getOpencardmultiple() {
        return opencardmultiple;
    }

    public void setOpencardmultiple(Integer opencardmultiple) {
        this.opencardmultiple = opencardmultiple;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Double getServicemoney() {
        return servicemoney;
    }

    public void setServicemoney(Double servicemoney) {
        this.servicemoney = servicemoney;
    }

    public String getCommratio() {
        return commratio;
    }

    public void setCommratio(String commratio) {
        this.commratio = commratio == null ? null : commratio.trim();
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname == null ? null : cnname.trim();
    }

    public Integer getRoomsrcore() {
        return roomsrcore;
    }

    public void setRoomsrcore(Integer roomsrcore) {
        this.roomsrcore = roomsrcore;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Double getUseresult() {
        return useresult;
    }

    public void setUseresult(Double useresult) {
        this.useresult = useresult;
    }

    public Double getUserDisacount() {
        return userDisacount;
    }

    public void setUserDisacount(Double userDisacount) {
        this.userDisacount = userDisacount;
    }

    public Double getUserTake() {
        return userTake;
    }

    public void setUserTake(Double userTake) {
        this.userTake = userTake;
    }

    public Double getUserAmount() {
        return userAmount;
    }

    public void setUserAmount(Double userAmount) {
        this.userAmount = userAmount;
    }

    public Long getSubagentid() {
        return subagentid;
    }

    public void setSubagentid(Long subagentid) {
        this.subagentid = subagentid;
    }

    public String getSubagentname() {
        return subagentname;
    }

    public void setSubagentname(String subagentname) {
        this.subagentname = subagentname == null ? null : subagentname.trim();
    }

    public Double getSubagentPer() {
        return subagentPer;
    }

    public void setSubagentPer(Double subagentPer) {
        this.subagentPer = subagentPer;
    }

    public Double getSubagentPart() {
        return subagentPart;
    }

    public void setSubagentPart(Double subagentPart) {
        this.subagentPart = subagentPart;
    }

    public Double getSubagentDisacount() {
        return subagentDisacount;
    }

    public void setSubagentDisacount(Double subagentDisacount) {
        this.subagentDisacount = subagentDisacount;
    }

    public Double getSubagentTake() {
        return subagentTake;
    }

    public void setSubagentTake(Double subagentTake) {
        this.subagentTake = subagentTake;
    }

    public Double getSubagentGive() {
        return subagentGive;
    }

    public void setSubagentGive(Double subagentGive) {
        this.subagentGive = subagentGive;
    }

    public Double getSubagentAmount() {
        return subagentAmount;
    }

    public void setSubagentAmount(Double subagentAmount) {
        this.subagentAmount = subagentAmount;
    }

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname == null ? null : agentname.trim();
    }

    public Double getAgentPer() {
        return agentPer;
    }

    public void setAgentPer(Double agentPer) {
        this.agentPer = agentPer;
    }

    public Double getAgentPart() {
        return agentPart;
    }

    public void setAgentPart(Double agentPart) {
        this.agentPart = agentPart;
    }

    public Double getAgentDisacount() {
        return agentDisacount;
    }

    public void setAgentDisacount(Double agentDisacount) {
        this.agentDisacount = agentDisacount;
    }

    public Double getAgentTake() {
        return agentTake;
    }

    public void setAgentTake(Double agentTake) {
        this.agentTake = agentTake;
    }

    public Double getAgentGive() {
        return agentGive;
    }

    public void setAgentGive(Double agentGive) {
        this.agentGive = agentGive;
    }

    public Double getAgentAmount() {
        return agentAmount;
    }

    public void setAgentAmount(Double agentAmount) {
        this.agentAmount = agentAmount;
    }

    public Long getGengeralid() {
        return gengeralid;
    }

    public void setGengeralid(Long gengeralid) {
        this.gengeralid = gengeralid;
    }

    public String getGengeralname() {
        return gengeralname;
    }

    public void setGengeralname(String gengeralname) {
        this.gengeralname = gengeralname == null ? null : gengeralname.trim();
    }

    public Double getGengeralPer() {
        return gengeralPer;
    }

    public void setGengeralPer(Double gengeralPer) {
        this.gengeralPer = gengeralPer;
    }

    public Double getGengeralPart() {
        return gengeralPart;
    }

    public void setGengeralPart(Double gengeralPart) {
        this.gengeralPart = gengeralPart;
    }

    public Double getGengeralDisacount() {
        return gengeralDisacount;
    }

    public void setGengeralDisacount(Double gengeralDisacount) {
        this.gengeralDisacount = gengeralDisacount;
    }

    public Double getGengeralTake() {
        return gengeralTake;
    }

    public void setGengeralTake(Double gengeralTake) {
        this.gengeralTake = gengeralTake;
    }

    public Double getGengeralGive() {
        return gengeralGive;
    }

    public void setGengeralGive(Double gengeralGive) {
        this.gengeralGive = gengeralGive;
    }

    public Double getGengeralAmount() {
        return gengeralAmount;
    }

    public void setGengeralAmount(Double gengeralAmount) {
        this.gengeralAmount = gengeralAmount;
    }

    public Long getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(Long partnerid) {
        this.partnerid = partnerid;
    }

    public String getPartnername() {
        return partnername;
    }

    public void setPartnername(String partnername) {
        this.partnername = partnername == null ? null : partnername.trim();
    }

    public Double getPartnerPer() {
        return partnerPer;
    }

    public void setPartnerPer(Double partnerPer) {
        this.partnerPer = partnerPer;
    }

    public Double getPartnerPart() {
        return partnerPart;
    }

    public void setPartnerPart(Double partnerPart) {
        this.partnerPart = partnerPart;
    }

    public Double getPartnerDisacount() {
        return partnerDisacount;
    }

    public void setPartnerDisacount(Double partnerDisacount) {
        this.partnerDisacount = partnerDisacount;
    }

    public Double getPartnerTake() {
        return partnerTake;
    }

    public void setPartnerTake(Double partnerTake) {
        this.partnerTake = partnerTake;
    }

    public Double getPartnerGive() {
        return partnerGive;
    }

    public void setPartnerGive(Double partnerGive) {
        this.partnerGive = partnerGive;
    }

    public Double getPartnerAmount() {
        return partnerAmount;
    }

    public void setPartnerAmount(Double partnerAmount) {
        this.partnerAmount = partnerAmount;
    }

    public Long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public Double getCompanyPer() {
        return companyPer;
    }

    public void setCompanyPer(Double companyPer) {
        this.companyPer = companyPer;
    }

    public Double getCompanyPart() {
        return companyPart;
    }

    public void setCompanyPart(Double companyPart) {
        this.companyPart = companyPart;
    }

    public Double getCompanyDisacount() {
        return companyDisacount;
    }

    public void setCompanyDisacount(Double companyDisacount) {
        this.companyDisacount = companyDisacount;
    }

    public Double getCompanyTake() {
        return companyTake;
    }

    public void setCompanyTake(Double companyTake) {
        this.companyTake = companyTake;
    }

    public Double getCompanyGive() {
        return companyGive;
    }

    public void setCompanyGive(Double companyGive) {
        this.companyGive = companyGive;
    }

    public Double getCompanyAmount() {
        return companyAmount;
    }

    public void setCompanyAmount(Double companyAmount) {
        this.companyAmount = companyAmount;
    }

    public Double getPlatformPer() {
        return platformPer;
    }

    public void setPlatformPer(Double platformPer) {
        this.platformPer = platformPer;
    }

    public Double getPlatformPart() {
        return platformPart;
    }

    public void setPlatformPart(Double platformPart) {
        this.platformPart = platformPart;
    }

    public Double getPlatformGive() {
        return platformGive;
    }

    public void setPlatformGive(Double platformGive) {
        this.platformGive = platformGive;
    }

    public Double getPlatformAmount() {
        return platformAmount;
    }

    public void setPlatformAmount(Double platformAmount) {
        this.platformAmount = platformAmount;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTakeoutlog() {
        return takeoutlog;
    }

    public void setTakeoutlog(String takeoutlog) {
        this.takeoutlog = takeoutlog == null ? null : takeoutlog.trim();
    }

    public String getBureauno() {
        return bureauno;
    }

    public void setBureauno(String bureauno) {
        this.bureauno = bureauno == null ? null : bureauno.trim();
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
        FontanaBetFight other = (FontanaBetFight) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getGameid() == null ? other.getGameid() == null : this.getGameid().equals(other.getGameid()))
            && (this.getUserhandcard() == null ? other.getUserhandcard() == null : this.getUserhandcard().equals(other.getUserhandcard()))
            && (this.getSeat0handcard() == null ? other.getSeat0handcard() == null : this.getSeat0handcard().equals(other.getSeat0handcard()))
            && (this.getSeat1handcard() == null ? other.getSeat1handcard() == null : this.getSeat1handcard().equals(other.getSeat1handcard()))
            && (this.getBottomcard() == null ? other.getBottomcard() == null : this.getBottomcard().equals(other.getBottomcard()))
            && (this.getIslord() == null ? other.getIslord() == null : this.getIslord().equals(other.getIslord()))
            && (this.getGamescore() == null ? other.getGamescore() == null : this.getGamescore().equals(other.getGamescore()))
            && (this.getMultiplebomb() == null ? other.getMultiplebomb() == null : this.getMultiplebomb().equals(other.getMultiplebomb()))
            && (this.getMultiplespring() == null ? other.getMultiplespring() == null : this.getMultiplespring().equals(other.getMultiplespring()))
            && (this.getMultipletask() == null ? other.getMultipletask() == null : this.getMultipletask().equals(other.getMultipletask()))
            && (this.getMultiplemultiple() == null ? other.getMultiplemultiple() == null : this.getMultiplemultiple().equals(other.getMultiplemultiple()))
            && (this.getOpencardmultiple() == null ? other.getOpencardmultiple() == null : this.getOpencardmultiple().equals(other.getOpencardmultiple()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getServicemoney() == null ? other.getServicemoney() == null : this.getServicemoney().equals(other.getServicemoney()))
            && (this.getCommratio() == null ? other.getCommratio() == null : this.getCommratio().equals(other.getCommratio()))
            && (this.getRoomid() == null ? other.getRoomid() == null : this.getRoomid().equals(other.getRoomid()))
            && (this.getCnname() == null ? other.getCnname() == null : this.getCnname().equals(other.getCnname()))
            && (this.getRoomsrcore() == null ? other.getRoomsrcore() == null : this.getRoomsrcore().equals(other.getRoomsrcore()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUseresult() == null ? other.getUseresult() == null : this.getUseresult().equals(other.getUseresult()))
            && (this.getUserDisacount() == null ? other.getUserDisacount() == null : this.getUserDisacount().equals(other.getUserDisacount()))
            && (this.getUserTake() == null ? other.getUserTake() == null : this.getUserTake().equals(other.getUserTake()))
            && (this.getUserAmount() == null ? other.getUserAmount() == null : this.getUserAmount().equals(other.getUserAmount()))
            && (this.getSubagentid() == null ? other.getSubagentid() == null : this.getSubagentid().equals(other.getSubagentid()))
            && (this.getSubagentname() == null ? other.getSubagentname() == null : this.getSubagentname().equals(other.getSubagentname()))
            && (this.getSubagentPer() == null ? other.getSubagentPer() == null : this.getSubagentPer().equals(other.getSubagentPer()))
            && (this.getSubagentPart() == null ? other.getSubagentPart() == null : this.getSubagentPart().equals(other.getSubagentPart()))
            && (this.getSubagentDisacount() == null ? other.getSubagentDisacount() == null : this.getSubagentDisacount().equals(other.getSubagentDisacount()))
            && (this.getSubagentTake() == null ? other.getSubagentTake() == null : this.getSubagentTake().equals(other.getSubagentTake()))
            && (this.getSubagentGive() == null ? other.getSubagentGive() == null : this.getSubagentGive().equals(other.getSubagentGive()))
            && (this.getSubagentAmount() == null ? other.getSubagentAmount() == null : this.getSubagentAmount().equals(other.getSubagentAmount()))
            && (this.getAgentid() == null ? other.getAgentid() == null : this.getAgentid().equals(other.getAgentid()))
            && (this.getAgentname() == null ? other.getAgentname() == null : this.getAgentname().equals(other.getAgentname()))
            && (this.getAgentPer() == null ? other.getAgentPer() == null : this.getAgentPer().equals(other.getAgentPer()))
            && (this.getAgentPart() == null ? other.getAgentPart() == null : this.getAgentPart().equals(other.getAgentPart()))
            && (this.getAgentDisacount() == null ? other.getAgentDisacount() == null : this.getAgentDisacount().equals(other.getAgentDisacount()))
            && (this.getAgentTake() == null ? other.getAgentTake() == null : this.getAgentTake().equals(other.getAgentTake()))
            && (this.getAgentGive() == null ? other.getAgentGive() == null : this.getAgentGive().equals(other.getAgentGive()))
            && (this.getAgentAmount() == null ? other.getAgentAmount() == null : this.getAgentAmount().equals(other.getAgentAmount()))
            && (this.getGengeralid() == null ? other.getGengeralid() == null : this.getGengeralid().equals(other.getGengeralid()))
            && (this.getGengeralname() == null ? other.getGengeralname() == null : this.getGengeralname().equals(other.getGengeralname()))
            && (this.getGengeralPer() == null ? other.getGengeralPer() == null : this.getGengeralPer().equals(other.getGengeralPer()))
            && (this.getGengeralPart() == null ? other.getGengeralPart() == null : this.getGengeralPart().equals(other.getGengeralPart()))
            && (this.getGengeralDisacount() == null ? other.getGengeralDisacount() == null : this.getGengeralDisacount().equals(other.getGengeralDisacount()))
            && (this.getGengeralTake() == null ? other.getGengeralTake() == null : this.getGengeralTake().equals(other.getGengeralTake()))
            && (this.getGengeralGive() == null ? other.getGengeralGive() == null : this.getGengeralGive().equals(other.getGengeralGive()))
            && (this.getGengeralAmount() == null ? other.getGengeralAmount() == null : this.getGengeralAmount().equals(other.getGengeralAmount()))
            && (this.getPartnerid() == null ? other.getPartnerid() == null : this.getPartnerid().equals(other.getPartnerid()))
            && (this.getPartnername() == null ? other.getPartnername() == null : this.getPartnername().equals(other.getPartnername()))
            && (this.getPartnerPer() == null ? other.getPartnerPer() == null : this.getPartnerPer().equals(other.getPartnerPer()))
            && (this.getPartnerPart() == null ? other.getPartnerPart() == null : this.getPartnerPart().equals(other.getPartnerPart()))
            && (this.getPartnerDisacount() == null ? other.getPartnerDisacount() == null : this.getPartnerDisacount().equals(other.getPartnerDisacount()))
            && (this.getPartnerTake() == null ? other.getPartnerTake() == null : this.getPartnerTake().equals(other.getPartnerTake()))
            && (this.getPartnerGive() == null ? other.getPartnerGive() == null : this.getPartnerGive().equals(other.getPartnerGive()))
            && (this.getPartnerAmount() == null ? other.getPartnerAmount() == null : this.getPartnerAmount().equals(other.getPartnerAmount()))
            && (this.getCompanyid() == null ? other.getCompanyid() == null : this.getCompanyid().equals(other.getCompanyid()))
            && (this.getCompanyname() == null ? other.getCompanyname() == null : this.getCompanyname().equals(other.getCompanyname()))
            && (this.getCompanyPer() == null ? other.getCompanyPer() == null : this.getCompanyPer().equals(other.getCompanyPer()))
            && (this.getCompanyPart() == null ? other.getCompanyPart() == null : this.getCompanyPart().equals(other.getCompanyPart()))
            && (this.getCompanyDisacount() == null ? other.getCompanyDisacount() == null : this.getCompanyDisacount().equals(other.getCompanyDisacount()))
            && (this.getCompanyTake() == null ? other.getCompanyTake() == null : this.getCompanyTake().equals(other.getCompanyTake()))
            && (this.getCompanyGive() == null ? other.getCompanyGive() == null : this.getCompanyGive().equals(other.getCompanyGive()))
            && (this.getCompanyAmount() == null ? other.getCompanyAmount() == null : this.getCompanyAmount().equals(other.getCompanyAmount()))
            && (this.getPlatformPer() == null ? other.getPlatformPer() == null : this.getPlatformPer().equals(other.getPlatformPer()))
            && (this.getPlatformPart() == null ? other.getPlatformPart() == null : this.getPlatformPart().equals(other.getPlatformPart()))
            && (this.getPlatformGive() == null ? other.getPlatformGive() == null : this.getPlatformGive().equals(other.getPlatformGive()))
            && (this.getPlatformAmount() == null ? other.getPlatformAmount() == null : this.getPlatformAmount().equals(other.getPlatformAmount()))
            && (this.getBettime() == null ? other.getBettime() == null : this.getBettime().equals(other.getBettime()))
            && (this.getGroupfor() == null ? other.getGroupfor() == null : this.getGroupfor().equals(other.getGroupfor()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTakeoutlog() == null ? other.getTakeoutlog() == null : this.getTakeoutlog().equals(other.getTakeoutlog()))
            && (this.getBureauno() == null ? other.getBureauno() == null : this.getBureauno().equals(other.getBureauno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getGameid() == null) ? 0 : getGameid().hashCode());
        result = prime * result + ((getUserhandcard() == null) ? 0 : getUserhandcard().hashCode());
        result = prime * result + ((getSeat0handcard() == null) ? 0 : getSeat0handcard().hashCode());
        result = prime * result + ((getSeat1handcard() == null) ? 0 : getSeat1handcard().hashCode());
        result = prime * result + ((getBottomcard() == null) ? 0 : getBottomcard().hashCode());
        result = prime * result + ((getIslord() == null) ? 0 : getIslord().hashCode());
        result = prime * result + ((getGamescore() == null) ? 0 : getGamescore().hashCode());
        result = prime * result + ((getMultiplebomb() == null) ? 0 : getMultiplebomb().hashCode());
        result = prime * result + ((getMultiplespring() == null) ? 0 : getMultiplespring().hashCode());
        result = prime * result + ((getMultipletask() == null) ? 0 : getMultipletask().hashCode());
        result = prime * result + ((getMultiplemultiple() == null) ? 0 : getMultiplemultiple().hashCode());
        result = prime * result + ((getOpencardmultiple() == null) ? 0 : getOpencardmultiple().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getServicemoney() == null) ? 0 : getServicemoney().hashCode());
        result = prime * result + ((getCommratio() == null) ? 0 : getCommratio().hashCode());
        result = prime * result + ((getRoomid() == null) ? 0 : getRoomid().hashCode());
        result = prime * result + ((getCnname() == null) ? 0 : getCnname().hashCode());
        result = prime * result + ((getRoomsrcore() == null) ? 0 : getRoomsrcore().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUseresult() == null) ? 0 : getUseresult().hashCode());
        result = prime * result + ((getUserDisacount() == null) ? 0 : getUserDisacount().hashCode());
        result = prime * result + ((getUserTake() == null) ? 0 : getUserTake().hashCode());
        result = prime * result + ((getUserAmount() == null) ? 0 : getUserAmount().hashCode());
        result = prime * result + ((getSubagentid() == null) ? 0 : getSubagentid().hashCode());
        result = prime * result + ((getSubagentname() == null) ? 0 : getSubagentname().hashCode());
        result = prime * result + ((getSubagentPer() == null) ? 0 : getSubagentPer().hashCode());
        result = prime * result + ((getSubagentPart() == null) ? 0 : getSubagentPart().hashCode());
        result = prime * result + ((getSubagentDisacount() == null) ? 0 : getSubagentDisacount().hashCode());
        result = prime * result + ((getSubagentTake() == null) ? 0 : getSubagentTake().hashCode());
        result = prime * result + ((getSubagentGive() == null) ? 0 : getSubagentGive().hashCode());
        result = prime * result + ((getSubagentAmount() == null) ? 0 : getSubagentAmount().hashCode());
        result = prime * result + ((getAgentid() == null) ? 0 : getAgentid().hashCode());
        result = prime * result + ((getAgentname() == null) ? 0 : getAgentname().hashCode());
        result = prime * result + ((getAgentPer() == null) ? 0 : getAgentPer().hashCode());
        result = prime * result + ((getAgentPart() == null) ? 0 : getAgentPart().hashCode());
        result = prime * result + ((getAgentDisacount() == null) ? 0 : getAgentDisacount().hashCode());
        result = prime * result + ((getAgentTake() == null) ? 0 : getAgentTake().hashCode());
        result = prime * result + ((getAgentGive() == null) ? 0 : getAgentGive().hashCode());
        result = prime * result + ((getAgentAmount() == null) ? 0 : getAgentAmount().hashCode());
        result = prime * result + ((getGengeralid() == null) ? 0 : getGengeralid().hashCode());
        result = prime * result + ((getGengeralname() == null) ? 0 : getGengeralname().hashCode());
        result = prime * result + ((getGengeralPer() == null) ? 0 : getGengeralPer().hashCode());
        result = prime * result + ((getGengeralPart() == null) ? 0 : getGengeralPart().hashCode());
        result = prime * result + ((getGengeralDisacount() == null) ? 0 : getGengeralDisacount().hashCode());
        result = prime * result + ((getGengeralTake() == null) ? 0 : getGengeralTake().hashCode());
        result = prime * result + ((getGengeralGive() == null) ? 0 : getGengeralGive().hashCode());
        result = prime * result + ((getGengeralAmount() == null) ? 0 : getGengeralAmount().hashCode());
        result = prime * result + ((getPartnerid() == null) ? 0 : getPartnerid().hashCode());
        result = prime * result + ((getPartnername() == null) ? 0 : getPartnername().hashCode());
        result = prime * result + ((getPartnerPer() == null) ? 0 : getPartnerPer().hashCode());
        result = prime * result + ((getPartnerPart() == null) ? 0 : getPartnerPart().hashCode());
        result = prime * result + ((getPartnerDisacount() == null) ? 0 : getPartnerDisacount().hashCode());
        result = prime * result + ((getPartnerTake() == null) ? 0 : getPartnerTake().hashCode());
        result = prime * result + ((getPartnerGive() == null) ? 0 : getPartnerGive().hashCode());
        result = prime * result + ((getPartnerAmount() == null) ? 0 : getPartnerAmount().hashCode());
        result = prime * result + ((getCompanyid() == null) ? 0 : getCompanyid().hashCode());
        result = prime * result + ((getCompanyname() == null) ? 0 : getCompanyname().hashCode());
        result = prime * result + ((getCompanyPer() == null) ? 0 : getCompanyPer().hashCode());
        result = prime * result + ((getCompanyPart() == null) ? 0 : getCompanyPart().hashCode());
        result = prime * result + ((getCompanyDisacount() == null) ? 0 : getCompanyDisacount().hashCode());
        result = prime * result + ((getCompanyTake() == null) ? 0 : getCompanyTake().hashCode());
        result = prime * result + ((getCompanyGive() == null) ? 0 : getCompanyGive().hashCode());
        result = prime * result + ((getCompanyAmount() == null) ? 0 : getCompanyAmount().hashCode());
        result = prime * result + ((getPlatformPer() == null) ? 0 : getPlatformPer().hashCode());
        result = prime * result + ((getPlatformPart() == null) ? 0 : getPlatformPart().hashCode());
        result = prime * result + ((getPlatformGive() == null) ? 0 : getPlatformGive().hashCode());
        result = prime * result + ((getPlatformAmount() == null) ? 0 : getPlatformAmount().hashCode());
        result = prime * result + ((getBettime() == null) ? 0 : getBettime().hashCode());
        result = prime * result + ((getGroupfor() == null) ? 0 : getGroupfor().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTakeoutlog() == null) ? 0 : getTakeoutlog().hashCode());
        result = prime * result + ((getBureauno() == null) ? 0 : getBureauno().hashCode());
        return result;
    }
}