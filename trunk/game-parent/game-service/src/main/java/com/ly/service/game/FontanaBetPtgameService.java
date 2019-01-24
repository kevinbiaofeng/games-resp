package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetPtgame;

public interface FontanaBetPtgameService {
    int insert(FontanaBetPtgame record);

    int insertReplaceRecordBatch(List<FontanaBetPtgame> list);

    FontanaBetPtgame selectByPrimaryKey(Long id);
}