package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetPtgame;

public interface FontanaBetPtgameMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetPtgame record);

    int insertSelective(FontanaBetPtgame record);
    
    int insertReplaceRecordBatch(List<FontanaBetPtgame> list);

    FontanaBetPtgame selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetPtgame record);

    int updateByPrimaryKey(FontanaBetPtgame record);
}