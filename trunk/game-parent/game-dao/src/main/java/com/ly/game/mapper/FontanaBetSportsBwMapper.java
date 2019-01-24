package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetSportsBw;

public interface FontanaBetSportsBwMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetSportsBw record);

    int insertSelective(FontanaBetSportsBw record);
    
    int insertReplaceRecordBatch(List<FontanaBetSportsBw> list);

    FontanaBetSportsBw selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetSportsBw record);

    int updateByPrimaryKey(FontanaBetSportsBw record);
}