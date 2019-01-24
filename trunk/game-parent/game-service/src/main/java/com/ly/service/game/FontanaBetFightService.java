package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetFight;

public interface FontanaBetFightService {
    int insert(FontanaBetFight record);

    int insertReplaceRecordBatch(List<FontanaBetFight> list);

    FontanaBetFight selectByPrimaryKey(Long id);
}