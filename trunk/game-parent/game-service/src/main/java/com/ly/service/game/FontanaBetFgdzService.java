package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetFgdz;

public interface FontanaBetFgdzService {
    int insert(FontanaBetFgdz record);

    int insertReplaceRecordBatch(List<FontanaBetFgdz> list);

    FontanaBetFgdz selectByPrimaryKey(Long id);
}