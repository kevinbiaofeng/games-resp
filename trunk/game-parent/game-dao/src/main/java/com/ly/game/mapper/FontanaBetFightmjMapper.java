package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetFightmj;

public interface FontanaBetFightmjMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetFightmj record);

    int insertSelective(FontanaBetFightmj record);
    
    int insertReplaceRecordBatch(List<FontanaBetFightmj> list);

    FontanaBetFightmj selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetFightmj record);

    int updateByPrimaryKey(FontanaBetFightmj record);
}