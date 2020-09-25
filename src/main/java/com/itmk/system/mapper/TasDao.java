package com.itmk.system.mapper;

import com.itmk.system.entity.Tas;

public interface TasDao {
    int deleteByPrimaryKey(Integer taskId);

    int insert(Tas record);

    int insertSelective(Tas record);

    Tas selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(Tas record);

    int updateByPrimaryKey(Tas record);
}