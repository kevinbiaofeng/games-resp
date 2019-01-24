package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetImItem;

public interface FontanaBetImItemService {
    int insert(FontanaBetImItem record);

    int insertReplaceRecordBatch(List<FontanaBetImItem> list);

    FontanaBetImItem selectByPrimaryKey(Long id);
}