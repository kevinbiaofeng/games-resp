package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetAllbet;

public interface FontanaBetAllbetMapper {
	int exists(String betnum,String username,String bcvalue); 
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetAllbet record);

    int insertSelective(FontanaBetAllbet record);
    
    int insertReplaceRecordBatch(List<FontanaBetAllbet> list);

    FontanaBetAllbet selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetAllbet record);

    int updateByPrimaryKey(FontanaBetAllbet record);
}