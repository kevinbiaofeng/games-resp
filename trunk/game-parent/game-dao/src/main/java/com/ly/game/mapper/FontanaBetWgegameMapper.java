package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetWgegame;

public interface FontanaBetWgegameMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetWgegame record);

    int insertSelective(FontanaBetWgegame record);
    
    int insertReplaceRecordBatch(List<FontanaBetWgegame> list);

    FontanaBetWgegame selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetWgegame record);

    int updateByPrimaryKey(FontanaBetWgegame record);
}