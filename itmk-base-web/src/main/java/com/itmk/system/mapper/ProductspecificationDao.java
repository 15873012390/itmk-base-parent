package com.itmk.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itmk.system.entity.Productspecification;

public interface ProductspecificationDao extends BaseMapper<Productspecification> {
    int deleteByPrimaryKey(Integer speId);

    int insert(Productspecification record);

    int insertSelective(Productspecification record);

    Productspecification selectByPrimaryKey(Integer speId);

    int updateByPrimaryKeySelective(Productspecification record);

    int updateByPrimaryKey(Productspecification record);
}