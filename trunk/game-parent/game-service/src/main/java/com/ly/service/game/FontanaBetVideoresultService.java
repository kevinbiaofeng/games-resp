package com.ly.service.game;

import java.util.List;

import com.ly.game.model.FontanaBetVideoresult;

public interface FontanaBetVideoresultService {
    int insert(FontanaBetVideoresult record);

    int insertReplaceRecordBatch(List<FontanaBetVideoresult> list);

    FontanaBetVideoresult selectByPrimaryKey(Long id);
}