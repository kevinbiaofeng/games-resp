package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetBoinlottery;

public interface FontanaBetBoinlotteryMapper {
	
	int exists(String betnum,String username,String bcvalue);
	
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetBoinlottery record);

    int insertSelective(FontanaBetBoinlottery record);
    
    int insertReplaceRecordBatch(List<FontanaBetBoinlottery> list);

    FontanaBetBoinlottery selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetBoinlottery record);

    int updateByPrimaryKey(FontanaBetBoinlottery record);
}