package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetIm;

public interface FontanaBetImMapper {
    int deleteByPrimaryKey(String id);

    int insert(FontanaBetIm record);

    int insertSelective(FontanaBetIm record);
    
    int insertReplaceRecordBatch(List<FontanaBetIm> list);

    FontanaBetIm selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FontanaBetIm record);

    int updateByPrimaryKey(FontanaBetIm record);
}