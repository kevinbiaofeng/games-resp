package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetSunbet;

public interface FontanaBetSunbetMapper {
	
	int exists(String betnum,String bcvalue);
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetSunbet record);

    int insertSelective(FontanaBetSunbet record);
    
    int insertReplaceRecordBatch(List<FontanaBetSunbet> list);

    FontanaBetSunbet selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetSunbet record);

    int updateByPrimaryKey(FontanaBetSunbet record);
}