package com.ly.game.mapper;

import java.util.List;

import com.ly.game.model.FontanaUser;

public interface FontanaUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FontanaUser record);

    int insertSelective(FontanaUser record);

    FontanaUser selectByPrimaryKey(Long id);
    
    List<FontanaUser> selectListByLoginNames(List<String> list);

    int updateByPrimaryKeySelective(FontanaUser record);

    int updateByPrimaryKeyWithBLOBs(FontanaUser record);

    int updateByPrimaryKey(FontanaUser record);
}