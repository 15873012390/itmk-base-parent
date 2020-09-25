package com.itmk.system.mapper;

import com.itmk.system.entity.Task;

public interface TaskDao {
    int deleteByPrimaryKey(Integer taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}