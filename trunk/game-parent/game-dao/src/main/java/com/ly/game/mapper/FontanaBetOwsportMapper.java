package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetOwsport;

public interface FontanaBetOwsportMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetOwsport record);

    int insertSelective(FontanaBetOwsport record);
    
    int insertReplaceRecordBatch(List<FontanaBetOwsport> list);

    FontanaBetOwsport selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetOwsport record);

    int updateByPrimaryKey(FontanaBetOwsport record);
}