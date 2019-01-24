package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaBetAgbm;

public interface FontanaBetAgbmMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaBetAgbm record);

    int insertSelective(FontanaBetAgbm record);
    /**
            * 批量插入数据     Replace insert
     * @param list
     * @return
     */
    int insertReplaceRecordBatch(List<FontanaBetAgbm> list);

    FontanaBetAgbm selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FontanaBetAgbm record);

    int updateByPrimaryKey(FontanaBetAgbm record);
}