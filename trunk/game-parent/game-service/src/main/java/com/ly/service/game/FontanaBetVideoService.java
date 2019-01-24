package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetVideo;

public interface FontanaBetVideoService {
    int insert(FontanaBetVideo record);

    int insertReplaceRecordBatch(List<FontanaBetVideo> list);

    FontanaBetVideo selectByPrimaryKey(Long id);
}