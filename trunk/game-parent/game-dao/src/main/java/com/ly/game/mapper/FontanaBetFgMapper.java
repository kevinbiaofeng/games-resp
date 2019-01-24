package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetFg;

public interface FontanaBetFgMapper {
	
	int exists(String betnum,String username,String bcvalue);
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetFg record);

    int insertSelective(FontanaBetFg record);
    
    int insertReplaceRecordBatch(List<FontanaBetFg> list);

    FontanaBetFg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetFg record);

    int updateByPrimaryKey(FontanaBetFg record);
}