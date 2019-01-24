package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetVggame;

public interface FontanaBetVggameMapper {
	
	int exists(String betnum,String bcvalue);
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetVggame record);

    int insertSelective(FontanaBetVggame record);
    
    int insertReplaceRecordBatch(List<FontanaBetVggame> list);

    FontanaBetVggame selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetVggame record);

    int updateByPrimaryKey(FontanaBetVggame record);
}