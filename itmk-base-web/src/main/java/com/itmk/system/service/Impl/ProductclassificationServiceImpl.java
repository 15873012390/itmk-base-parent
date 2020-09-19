package com.itmk.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.Productclassification;
import com.itmk.system.entity.Productspecification;
import com.itmk.system.mapper.ProductclassificationDao;
import com.itmk.system.service.ProductclassificationService;
import com.itmk.system.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductclassificationServiceImpl extends ServiceImpl<ProductclassificationDao,Productclassification> implements ProductclassificationService {

    @Autowired
    private ProductclassificationDao productclassificationDao;

    @Override
    public Pager<Productclassification> getAllProductClassification(Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Productclassification> productclassificationList=this.productclassificationDao.getAllProductClassification();
        PageInfo<Productclassification> page=new PageInfo<>(productclassificationList);
        return  new Pager<Productclassification>(page.getTotal(),page.getList());
    }

    @Override
    public List<Productclassification> queryAllProductClassification() {
        return this.productclassificationDao.queryAllProductClassification();
    }
}
