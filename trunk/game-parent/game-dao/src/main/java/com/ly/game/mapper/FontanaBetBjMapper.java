package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetBj;

public interface FontanaBetBjMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetBj record);

    int insertSelective(FontanaBetBj record);
    
    int insertReplaceRecordBatch(List<FontanaBetBj> list);

    FontanaBetBj selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetBj record);

    int updateByPrimaryKeyWithBLOBs(FontanaBetBj record);

    int updateByPrimaryKey(FontanaBetBj record);
}