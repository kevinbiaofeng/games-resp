package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetVcs;

public interface FontanaBetVcsService {
    int insert(FontanaBetVcs record);

    int insertReplaceRecordBatch(List<FontanaBetVcs> list);

    FontanaBetVcs selectByPrimaryKey(Long id);
}