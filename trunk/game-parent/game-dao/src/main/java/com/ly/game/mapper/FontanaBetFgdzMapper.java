package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetFgdz;

public interface FontanaBetFgdzMapper {
	
	int exists(String betnum,String username,String bcvalue);
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetFgdz record);

    int insertSelective(FontanaBetFgdz record);
    
    int insertReplaceRecordBatch(List<FontanaBetFgdz> list);

    FontanaBetFgdz selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetFgdz record);

    int updateByPrimaryKey(FontanaBetFgdz record);
}