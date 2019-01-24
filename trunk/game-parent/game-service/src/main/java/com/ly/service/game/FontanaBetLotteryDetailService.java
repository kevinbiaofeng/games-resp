package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetLotteryDetail;

public interface FontanaBetLotteryDetailService {
    int insert(FontanaBetLotteryDetail record);

    int insertReplaceRecordBatch(List<FontanaBetLotteryDetail> list);

    FontanaBetLotteryDetail selectByPrimaryKey(Long id);
}