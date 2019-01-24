package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetSs;

public interface FontanaBetSsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetSs record);

    int insertSelective(FontanaBetSs record);
    
    int insertReplaceRecordBatch(List<FontanaBetSs> list);

    FontanaBetSs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetSs record);

    int updateByPrimaryKeyWithBLOBs(FontanaBetSs record);

    int updateByPrimaryKey(FontanaBetSs record);
}