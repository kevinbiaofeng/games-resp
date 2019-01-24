package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetKaga;

public interface FontanaBetKagaService {
    int insert(FontanaBetKaga record);

    int insertReplaceRecordBatch(List<FontanaBetKaga> list);

    FontanaBetKaga selectByPrimaryKey(Long id);
}