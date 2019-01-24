package com.ly.game.model;

public class Handicap {

    /**
     * 编号
     */
    private int id;
    
    /**
     * 名称
     */
    private String name;
    
    /**
     * 最低限红
     */
    private double upperLimit;
    
    /**
     * 最大限红
     */
    private double lowerLimit;
    
    /**
     * 盘口类型，0：普通盘口，1：VIP 盘口 
     */
    private int handicapType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(double upperLimit) {
        this.upperLimit = upperLimit;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public int getHandicapType() {
        return handicapType;
    }

    public void setHandicapType(int handicapType) {
        this.handicapType = handicapType;
    }
    
}
