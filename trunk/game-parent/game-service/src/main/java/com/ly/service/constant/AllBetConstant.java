package com.ly.service.constant;

import java.util.HashMap;
import java.util.Map;

public class AllBetConstant {

    /**
     * key：小游戏类型，value：大游戏类型（1:百家乐，2:骰宝，3:龙虎，4:轮盘，5:21点 ，6:电子游戏）
     */
    private static Map<Integer, Integer> gameBigTypeMap = new HashMap<Integer, Integer>();
    static{
        gameBigTypeMap.put(101, 1);
        gameBigTypeMap.put(102, 1);
        gameBigTypeMap.put(103, 1);
        gameBigTypeMap.put(104, 1);
        gameBigTypeMap.put(501, 1);
        gameBigTypeMap.put(201, 2);
        gameBigTypeMap.put(301, 3);
        gameBigTypeMap.put(401, 4);
        gameBigTypeMap.put(601, 4);
        gameBigTypeMap.put(701, 5);
        gameBigTypeMap.put(1100, 6);
    }
    
    /**
     * 根据第三方接口返回的游戏小类型，转成定义好的游戏大类型
     * @param gameType 游戏小类型
     * @return
     */
    public static Integer getGameBigType(int gameType){
        return gameBigTypeMap.get(gameType);
    }
}
