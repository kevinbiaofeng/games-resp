package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetEgame;

public interface FontanaBetEgameService {
    int insert(FontanaBetEgame record);

    int insertReplaceRecordBatch(List<FontanaBetEgame> list);

    FontanaBetEgame selectByPrimaryKey(Long id);
}