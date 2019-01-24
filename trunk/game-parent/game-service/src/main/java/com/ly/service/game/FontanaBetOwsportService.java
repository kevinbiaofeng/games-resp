package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetOwsport;

public interface FontanaBetOwsportService {
    int insert(FontanaBetOwsport record);

    int insertReplaceRecordBatch(List<FontanaBetOwsport> list);

    FontanaBetOwsport selectByPrimaryKey(Long id);
}