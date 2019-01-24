package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetMw;

public interface FontanaBetMwMapper {
	int exists(String betnum,String username,String bcvalue);
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetMw record);

    int insertSelective(FontanaBetMw record);
    
    int insertReplaceRecordBatch(List<FontanaBetMw> list);

    FontanaBetMw selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetMw record);

    int updateByPrimaryKey(FontanaBetMw record);
}