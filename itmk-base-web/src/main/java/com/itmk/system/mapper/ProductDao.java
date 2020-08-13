package com.itmk.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itmk.system.entity.Product;

/*
* 产品mapper接口
* */
public interface ProductDao extends BaseMapper<Product> {
    int deleteByPrimaryKey(Integer proId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer proId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}