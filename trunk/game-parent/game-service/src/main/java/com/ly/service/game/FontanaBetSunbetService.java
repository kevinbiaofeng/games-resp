package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetSunbet;

public interface FontanaBetSunbetService {
    int insert(FontanaBetSunbet record);

    int insertReplaceRecordBatch(List<FontanaBetSunbet> list);

    FontanaBetSunbet selectByPrimaryKey(Long id);
}