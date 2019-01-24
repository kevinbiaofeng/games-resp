package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetCq9;

public interface FontanaBetCq9Service {
    int insert(FontanaBetCq9 record);

    int insertReplaceRecordBatch(List<FontanaBetCq9> list);

    FontanaBetCq9 selectByPrimaryKey(Long id);
}