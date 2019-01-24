package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetLylot;

public interface FontanaBetLylotService {
    int insert(FontanaBetLylot record);

    int insertReplaceRecordBatch(List<FontanaBetLylot> list);

    FontanaBetLylot selectByPrimaryKey(Long id);
}