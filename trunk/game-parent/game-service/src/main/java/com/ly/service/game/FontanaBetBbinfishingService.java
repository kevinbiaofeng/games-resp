package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetBbinfishing;

public interface FontanaBetBbinfishingService {
    int insert(FontanaBetBbinfishing record);

    int insertReplaceRecordBatch(List<FontanaBetBbinfishing> list);

    FontanaBetBbinfishing selectByPrimaryKey(Long id);
}