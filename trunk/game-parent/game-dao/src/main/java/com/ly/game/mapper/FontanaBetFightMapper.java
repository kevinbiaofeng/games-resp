package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetFight;

public interface FontanaBetFightMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetFight record);

    int insertSelective(FontanaBetFight record);
    
    int insertReplaceRecordBatch(List<FontanaBetFight> list);

    FontanaBetFight selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetFight record);

    int updateByPrimaryKey(FontanaBetFight record);
}