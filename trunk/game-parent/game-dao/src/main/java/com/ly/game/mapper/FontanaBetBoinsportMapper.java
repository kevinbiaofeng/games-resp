package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetBoinsport;

public interface FontanaBetBoinsportMapper {
	
	int exists(String betnum,String username,String bcvalue); 
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetBoinsport record);

    int insertSelective(FontanaBetBoinsport record);
    
    int insertReplaceRecordBatch(List<FontanaBetBoinsport> list);

    FontanaBetBoinsport selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetBoinsport record);

    int updateByPrimaryKey(FontanaBetBoinsport record);
}