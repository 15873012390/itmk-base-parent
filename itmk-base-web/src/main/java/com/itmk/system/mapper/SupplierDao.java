package com.itmk.system.mapper;

import com.itmk.system.entity.Supplier;

import java.util.List;

/**
 *功能描述 供应商持久层接口
 * @author 廖湘明
 * @date 2020/9/28
 * @param
 * @return
 */
public interface SupplierDao {
    //查询所有供应商
    public List<Supplier> queryAllSupplier();
}
