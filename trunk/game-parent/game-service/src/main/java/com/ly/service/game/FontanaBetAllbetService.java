package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetAllbet;

public interface FontanaBetAllbetService {
    int insert(FontanaBetAllbet record);

    int insertReplaceRecordBatch(List<FontanaBetAllbet> list);

    FontanaBetAllbet selectByPrimaryKey(Long id);
}