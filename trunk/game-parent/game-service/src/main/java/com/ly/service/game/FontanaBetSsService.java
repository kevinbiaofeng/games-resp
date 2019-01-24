package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetSs;

public interface FontanaBetSsService {
    int insert(FontanaBetSs record);

    int insertReplaceRecordBatch(List<FontanaBetSs> list);

    FontanaBetSs selectByPrimaryKey(Long id);
}