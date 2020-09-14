package com.itmk.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itmk.system.entity.Productspecification;
import com.itmk.system.vo.Pager;
import org.apache.ibatis.annotations.Param;

/*
 * 规格业务接口
 * */
public interface ProductspecificationService extends IService<Productspecification> {
    //根据产品id查询全部规格
    public Pager<Productspecification> queryProductspecificationByProId(Integer proid,Integer currentPage, Integer pageSize);
    //添加/修改规格
    public void addEditSpecification(ProductSpecificationVo productSpecificationVo);
    //根据规格id查找规格对象
    public Productspecification queryBySepId(@Param("speid") Integer speid);
    //删除规格
    public void delBySpeId(Integer speId);
}

