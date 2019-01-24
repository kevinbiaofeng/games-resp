package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetFightcj;

public interface FontanaBetFightcjMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetFightcj record);

    int insertSelective(FontanaBetFightcj record);
    
    int insertReplaceRecordBatch(List<FontanaBetFightcj> list);

    FontanaBetFightcj selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetFightcj record);

    int updateByPrimaryKey(FontanaBetFightcj record);
}