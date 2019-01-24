package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetFightmj;

public interface FontanaBetFightmjService {
    int insert(FontanaBetFightmj record);

    int insertReplaceRecordBatch(List<FontanaBetFightmj> list);

    FontanaBetFightmj selectByPrimaryKey(Long id);
}