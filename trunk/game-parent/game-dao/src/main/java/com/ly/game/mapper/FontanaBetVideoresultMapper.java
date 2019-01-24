package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetVideoresult;

public interface FontanaBetVideoresultMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetVideoresult record);

    int insertSelective(FontanaBetVideoresult record);
    
    int insertReplaceRecordBatch(List<FontanaBetVideoresult> list);

    FontanaBetVideoresult selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetVideoresult record);

    int updateByPrimaryKey(FontanaBetVideoresult record);
}