package com.itmk.system.service;

import com.itmk.system.entity.Supplier;

import java.util.List;

/**
 * 供应商业务接口
 * @author 廖湘明
 * @data 2020/9/28 20:13
 * @return
 */
public interface SupplierService {
    //查询所有供应商
    public List<Supplier> queryAllSupplier();
}
