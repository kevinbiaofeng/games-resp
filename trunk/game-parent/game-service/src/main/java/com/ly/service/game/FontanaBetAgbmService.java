package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetAgbm;

public interface FontanaBetAgbmService {
    int insert(FontanaBetAgbm record);

    int insertReplaceRecordBatch(List<FontanaBetAgbm> list);
    
    FontanaBetAgbm selectByPrimaryKey(Long id);
}