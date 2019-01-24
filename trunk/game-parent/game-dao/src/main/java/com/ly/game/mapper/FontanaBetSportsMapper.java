package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetSports;

public interface FontanaBetSportsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetSports record);

    int insertSelective(FontanaBetSports record);
    
    int insertReplaceRecordBatch(List<FontanaBetSports> list);

    FontanaBetSports selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetSports record);

    int updateByPrimaryKey(FontanaBetSports record);
}