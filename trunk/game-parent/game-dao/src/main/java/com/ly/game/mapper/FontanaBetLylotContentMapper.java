package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetLylotContent;

public interface FontanaBetLylotContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetLylotContent record);

    int insertSelective(FontanaBetLylotContent record);
    
    int insertReplaceRecordBatch(List<FontanaBetLylotContent> list);

    FontanaBetLylotContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetLylotContent record);

    int updateByPrimaryKeyWithBLOBs(FontanaBetLylotContent record);

    int updateByPrimaryKey(FontanaBetLylotContent record);
}