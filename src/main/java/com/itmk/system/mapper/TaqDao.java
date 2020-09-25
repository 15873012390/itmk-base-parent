package com.itmk.system.mapper;

import com.itmk.system.entity.Taq;

public interface TaqDao {
    int deleteByPrimaryKey(Integer taskId);

    int insert(Taq record);

    int insertSelective(Taq record);

    Taq selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(Taq record);

    int updateByPrimaryKey(Taq record);
}