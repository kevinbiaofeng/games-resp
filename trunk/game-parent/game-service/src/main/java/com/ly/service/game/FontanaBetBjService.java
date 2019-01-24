package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetBj;

public interface FontanaBetBjService {
    int insert(FontanaBetBj record);

    int insertReplaceRecordBatch(List<FontanaBetBj> list);

    FontanaBetBj selectByPrimaryKey(Long id);
}