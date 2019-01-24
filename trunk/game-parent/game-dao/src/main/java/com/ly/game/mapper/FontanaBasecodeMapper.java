package com.ly.game.mapper;

import com.ly.game.model.FontanaBasecode;

public interface FontanaBasecodeMapper {
	
	FontanaBasecode selectByPrimarybc(String bctype,String bckey);
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBasecode record);

    int insertSelective(FontanaBasecode record);

    FontanaBasecode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBasecode record);

    int updateByPrimaryKey(FontanaBasecode record);
}