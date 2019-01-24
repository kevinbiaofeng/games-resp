package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetEgame;

public interface FontanaBetEgameMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetEgame record);

    int insertSelective(FontanaBetEgame record);
    
    int insertReplaceRecordBatch(List<FontanaBetEgame> list);

    FontanaBetEgame selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetEgame record);

    int updateByPrimaryKey(FontanaBetEgame record);
}