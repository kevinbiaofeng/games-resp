package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetLottery;

public interface FontanaBetLotteryService {
    int insert(FontanaBetLottery record);

    int insertReplaceRecordBatch(List<FontanaBetLottery> list);

    FontanaBetLottery selectByPrimaryKey(Long id);
}