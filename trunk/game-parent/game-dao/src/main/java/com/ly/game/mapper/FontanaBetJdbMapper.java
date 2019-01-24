package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetJdb;

public interface FontanaBetJdbMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetJdb record);

    int insertSelective(FontanaBetJdb record);
    
    int insertReplaceRecordBatch(List<FontanaBetJdb> list);

    FontanaBetJdb selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetJdb record);

    int updateByPrimaryKey(FontanaBetJdb record);
}