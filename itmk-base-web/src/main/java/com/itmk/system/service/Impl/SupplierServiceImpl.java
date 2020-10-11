package com.itmk.system.service.Impl;

import com.itmk.system.entity.Supplier;
import com.itmk.system.mapper.SupplierDao;
import com.itmk.system.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author 廖湘明
 * @data 2020/9/28 20:16
 * @return
 */
@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;
    @Override
    public List<Supplier> queryAllSupplier() {
        return this.supplierDao.queryAllSupplier();
    }
}
