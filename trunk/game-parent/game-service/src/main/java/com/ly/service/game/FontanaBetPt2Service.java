package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetPt2;

public interface FontanaBetPt2Service {
    int insert(FontanaBetPt2 record);

    int insertReplaceRecordBatch(List<FontanaBetPt2> list);

    FontanaBetPt2 selectByPrimaryKey(Long id);
}