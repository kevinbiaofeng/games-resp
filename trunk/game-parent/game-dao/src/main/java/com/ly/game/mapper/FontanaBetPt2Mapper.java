package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetPt2;

public interface FontanaBetPt2Mapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetPt2 record);

    int insertSelective(FontanaBetPt2 record);
    
    int insertReplaceRecordBatch(List<FontanaBetPt2> list);

    FontanaBetPt2 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetPt2 record);

    int updateByPrimaryKey(FontanaBetPt2 record);
}