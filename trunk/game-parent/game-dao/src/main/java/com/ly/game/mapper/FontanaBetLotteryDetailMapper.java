package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetLotteryDetail;

public interface FontanaBetLotteryDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetLotteryDetail record);

    int insertSelective(FontanaBetLotteryDetail record);
    
    int insertReplaceRecordBatch(List<FontanaBetLotteryDetail> list);

    FontanaBetLotteryDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetLotteryDetail record);

    int updateByPrimaryKey(FontanaBetLotteryDetail record);
}