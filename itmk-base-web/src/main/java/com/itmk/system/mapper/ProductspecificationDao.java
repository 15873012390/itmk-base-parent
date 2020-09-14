package com.itmk.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itmk.system.entity.Productspecification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductspecificationDao extends BaseMapper<Productspecification> {
    //根据产品id查询全部规格
    public List<Productspecification> queryProductspecificationByProId(Integer proid);
    //新增规格
    //新增
    public void insertSpeProduct(Productspecification productspecification);
    //新增
    public void insertSpe(ProductSpecificationVo productSpecificationVo);
    //修改
    public void updateSpe(@Param("speSpecification") String speSpecification, @Param("speUnit") String speUnit, @Param("speUnitConversion") Integer speUnitConversion, @Param("speid") Integer speid);
    //根据规格id查找规格对象
    public Productspecification queryBySepId(@Param("speid") Integer speid);
    //删除规格
    public void delBySpeId(Integer speId);
}