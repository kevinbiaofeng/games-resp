package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetBbinfishing;

public interface FontanaBetBbinfishingMapper {
	
	int exists(String betnum,String username,String gameType,String bcvalue);
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetBbinfishing record);

    int insertSelective(FontanaBetBbinfishing record);
    
    int insertReplaceRecordBatch(List<FontanaBetBbinfishing> list);

    FontanaBetBbinfishing selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetBbinfishing record);

    int updateByPrimaryKey(FontanaBetBbinfishing record);
}