package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetIm;

public interface FontanaBetImService {
    int insert(FontanaBetIm record);

    int insertReplaceRecordBatch(List<FontanaBetIm> list);

    FontanaBetIm selectByPrimaryKey(String id);
}