package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetWgegame;

public interface FontanaBetWgegameService {
    int insert(FontanaBetWgegame record);

    int insertReplaceRecordBatch(List<FontanaBetWgegame> list);

    FontanaBetWgegame selectByPrimaryKey(Long id);
}