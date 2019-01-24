package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetImItem;

public interface FontanaBetImItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetImItem record);

    int insertSelective(FontanaBetImItem record);
    
    int insertReplaceRecordBatch(List<FontanaBetImItem> list);

    FontanaBetImItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetImItem record);

    int updateByPrimaryKey(FontanaBetImItem record);
}