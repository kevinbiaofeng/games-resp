package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetKaga;

public interface FontanaBetKagaMapper {
	int exists(String betNum, String round, String username,String bcvalue);
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetKaga record);

    int insertSelective(FontanaBetKaga record);
    
    int insertReplaceRecordBatch(List<FontanaBetKaga> list);

    FontanaBetKaga selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetKaga record);

    int updateByPrimaryKey(FontanaBetKaga record);
}