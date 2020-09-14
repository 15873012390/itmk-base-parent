package com.itmk.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmk.system.entity.Productclassification;
import com.itmk.system.mapper.ProductclassificationDao;
import com.itmk.system.service.ProductclassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductclassificationServiceImpl extends ServiceImpl<ProductclassificationDao,Productclassification> implements ProductclassificationService {

    @Autowired
    private ProductclassificationDao productclassificationDao;
    @Override
    public List<Productclassification> queryAllProductClassification() {
        return this.productclassificationDao.queryAllProductClassification();
    }
}
