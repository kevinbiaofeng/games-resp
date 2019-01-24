package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetVggame;

public interface FontanaBetVggameService {
    int insert(FontanaBetVggame record);

    int insertReplaceRecordBatch(List<FontanaBetVggame> list);

    FontanaBetVggame selectByPrimaryKey(Long id);
}