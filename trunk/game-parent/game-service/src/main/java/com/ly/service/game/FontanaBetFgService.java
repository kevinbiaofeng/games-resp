package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetFg;

public interface FontanaBetFgService {
    int insert(FontanaBetFg record);

    int insertReplaceRecordBatch(List<FontanaBetFg> list);

    FontanaBetFg selectByPrimaryKey(Long id);
}