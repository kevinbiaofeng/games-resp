package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetCq9;

public interface FontanaBetCq9Mapper {
	
	int exists(String betnum,String username,String bcvalue);
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetCq9 record);

    int insertSelective(FontanaBetCq9 record);
    
    int insertReplaceRecordBatch(List<FontanaBetCq9> list);

    FontanaBetCq9 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetCq9 record);

    int updateByPrimaryKey(FontanaBetCq9 record);
}