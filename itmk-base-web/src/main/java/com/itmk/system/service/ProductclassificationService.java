package com.itmk.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itmk.system.entity.Productclassification;

import java.util.List;

/*
* 分类管理业务接口
* */
public interface ProductclassificationService extends IService<Productclassification> {
    //查询全部状态正常的类别
    public List<Productclassification> queryAllProductClassification();
    //根据分类id查询分类
   // public Productclassification findByClaId(Integer claid);
    //连接库存 不显示服务类 产品选择
    //public List<Productclassification> findAllByStock();
    //不连接库存 不显示服务类 产品选择
    //public List<Productclassification> findAll();
}
