package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetBoinvideo;

public interface FontanaBetBoinvideoMapper {
	
	int exists(String betnum,String username,String bcvalue); 
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetBoinvideo record);

    int insertSelective(FontanaBetBoinvideo record);
    
    int insertReplaceRecordBatch(List<FontanaBetBoinvideo> list);

    FontanaBetBoinvideo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetBoinvideo record);

    int updateByPrimaryKey(FontanaBetBoinvideo record);
}