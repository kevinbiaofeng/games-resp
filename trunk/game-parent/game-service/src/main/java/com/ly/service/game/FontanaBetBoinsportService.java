package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetBoinsport;

public interface FontanaBetBoinsportService {
    int insert(FontanaBetBoinsport record);
    
    int insertReplaceRecordBatch(List<FontanaBetBoinsport> list);

    FontanaBetBoinsport selectByPrimaryKey(Long id);
}