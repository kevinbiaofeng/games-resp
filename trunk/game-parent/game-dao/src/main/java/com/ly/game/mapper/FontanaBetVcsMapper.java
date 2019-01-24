package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetVcs;

public interface FontanaBetVcsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetVcs record);

    int insertSelective(FontanaBetVcs record);
    
    int insertReplaceRecordBatch(List<FontanaBetVcs> list);

    FontanaBetVcs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetVcs record);

    int updateByPrimaryKey(FontanaBetVcs record);
}