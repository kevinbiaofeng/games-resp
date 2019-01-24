package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetLylot;

public interface FontanaBetLylotMapper {
	
	int exists(String betnum,String username,String status,String bcvalue);
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetLylot record);

    int insertSelective(FontanaBetLylot record);
    
    int insertReplaceRecordBatch(List<FontanaBetLylot> list);

    FontanaBetLylot selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetLylot record);

    int updateByPrimaryKey(FontanaBetLylot record);
}