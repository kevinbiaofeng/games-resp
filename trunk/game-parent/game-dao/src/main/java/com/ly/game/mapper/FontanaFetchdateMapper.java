package com.ly.game.mapper;

import com.ly.game.model.FontanaFetchdate;

public interface FontanaFetchdateMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(FontanaFetchdate record);

    int insertSelective(FontanaFetchdate record);

    FontanaFetchdate selectByPrimaryKey(Integer id);
    
    FontanaFetchdate selectByPrimaryGametype(String gametype);

    int updateByPrimaryKeySelective(FontanaFetchdate record);

    int updateByPrimaryKey(FontanaFetchdate record);
}