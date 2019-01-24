package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetSportsBw;

public interface FontanaBetSportsBwService {
    int insert(FontanaBetSportsBw record);

    int insertReplaceRecordBatch(List<FontanaBetSportsBw> list);

    FontanaBetSportsBw selectByPrimaryKey(Long id);
}