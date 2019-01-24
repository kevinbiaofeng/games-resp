package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetVideo;

public interface FontanaBetVideoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetVideo record);

    int insertSelective(FontanaBetVideo record);
    
    int insertReplaceRecordBatch(List<FontanaBetVideo> list);

    FontanaBetVideo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetVideo record);

    int updateByPrimaryKey(FontanaBetVideo record);
}