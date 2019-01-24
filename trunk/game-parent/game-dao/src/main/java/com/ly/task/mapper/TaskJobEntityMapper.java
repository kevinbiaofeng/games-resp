package com.ly.task.mapper;

import java.util.List;
import java.util.Map;

import com.ly.task.model.TaskJobEntity;

public interface TaskJobEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TaskJobEntity record);

    int insertSelective(TaskJobEntity record);

    TaskJobEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskJobEntity record);

    int updateByPrimaryKey(TaskJobEntity record);
    
    List<TaskJobEntity> selectAllByCondition(Map<String, Object> map);
}