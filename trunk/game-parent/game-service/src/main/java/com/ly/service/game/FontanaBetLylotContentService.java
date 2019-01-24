package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetLylotContent;

public interface FontanaBetLylotContentService {
    int insert(FontanaBetLylotContent record);

    int insertReplaceRecordBatch(List<FontanaBetLylotContent> list);

    FontanaBetLylotContent selectByPrimaryKey(Long id);
}