package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetFightbrnn;

public interface FontanaBetFightbrnnMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetFightbrnn record);

    int insertSelective(FontanaBetFightbrnn record);
    
    int insertReplaceRecordBatch(List<FontanaBetFightbrnn> list);

    FontanaBetFightbrnn selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetFightbrnn record);

    int updateByPrimaryKey(FontanaBetFightbrnn record);
}