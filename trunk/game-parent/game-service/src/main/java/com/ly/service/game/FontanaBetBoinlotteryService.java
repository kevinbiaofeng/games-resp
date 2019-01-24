package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetBoinlottery;

public interface FontanaBetBoinlotteryService {
    int insert(FontanaBetBoinlottery record);

    int insertReplaceRecordBatch(List<FontanaBetBoinlottery> list);

    FontanaBetBoinlottery selectByPrimaryKey(Long id);
}