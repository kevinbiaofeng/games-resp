package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetMw;

public interface FontanaBetMwService {
    int insert(FontanaBetMw record);

    int insertReplaceRecordBatch(List<FontanaBetMw> list);

    FontanaBetMw selectByPrimaryKey(Long id);
}