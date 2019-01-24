package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetSports;

public interface FontanaBetSportsService {
    int insert(FontanaBetSports record);

    int insertReplaceRecordBatch(List<FontanaBetSports> list);

    FontanaBetSports selectByPrimaryKey(Long id);
}