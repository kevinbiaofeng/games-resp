package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetFightnn;

public interface FontanaBetFightnnMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetFightnn record);

    int insertSelective(FontanaBetFightnn record);
    
    int insertReplaceRecordBatch(List<FontanaBetFightnn> list);

    FontanaBetFightnn selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetFightnn record);

    int updateByPrimaryKey(FontanaBetFightnn record);
}