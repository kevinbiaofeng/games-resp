package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetBoinvideo;

public interface FontanaBetBoinvideoService {
    int insert(FontanaBetBoinvideo record);

    int insertReplaceRecordBatch(List<FontanaBetBoinvideo> list);

    FontanaBetBoinvideo selectByPrimaryKey(Long id);
}