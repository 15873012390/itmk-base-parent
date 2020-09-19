package com.itmk.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itmk.system.entity.Productclassification;

import java.util.List;


/*
* 分类管理mapper接口
* */
public interface ProductclassificationDao extends BaseMapper<Productclassification> {
    //查询全部类别
    public List<Productclassification> getAllProductClassification();
    //查询状态正常的全部分类
    public List<Productclassification> queryAllProductClassification();

}