package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetFightnn;

public interface FontanaBetFightnnService {
    int insert(FontanaBetFightnn record);

    int insertReplaceRecordBatch(List<FontanaBetFightnn> list);

    FontanaBetFightnn selectByPrimaryKey(Long id);
}