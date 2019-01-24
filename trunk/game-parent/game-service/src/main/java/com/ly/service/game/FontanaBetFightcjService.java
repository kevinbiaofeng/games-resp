package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetFightcj;

public interface FontanaBetFightcjService {
    int insert(FontanaBetFightcj record);

    int insertReplaceRecordBatch(List<FontanaBetFightcj> list);

    FontanaBetFightcj selectByPrimaryKey(Long id);
}