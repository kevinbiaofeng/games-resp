package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetJdb;

public interface FontanaBetJdbService {
    int insert(FontanaBetJdb record);

    int insertReplaceRecordBatch(List<FontanaBetJdb> list);

    FontanaBetJdb selectByPrimaryKey(Long id);
}