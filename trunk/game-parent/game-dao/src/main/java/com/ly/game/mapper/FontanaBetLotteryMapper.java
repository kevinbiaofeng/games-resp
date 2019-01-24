package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetLottery;

public interface FontanaBetLotteryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetLottery record);

    int insertSelective(FontanaBetLottery record);
    
    int insertReplaceRecordBatch(List<FontanaBetLottery> list);

    FontanaBetLottery selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetLottery record);

    int updateByPrimaryKeyWithBLOBs(FontanaBetLottery record);

    int updateByPrimaryKey(FontanaBetLottery record);
}