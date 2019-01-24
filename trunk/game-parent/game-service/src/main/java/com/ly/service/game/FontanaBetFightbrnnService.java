package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetFightbrnn;

public interface FontanaBetFightbrnnService {
    int insert(FontanaBetFightbrnn record);

    int insertReplaceRecordBatch(List<FontanaBetFightbrnn> list);

    FontanaBetFightbrnn selectByPrimaryKey(Long id);
}