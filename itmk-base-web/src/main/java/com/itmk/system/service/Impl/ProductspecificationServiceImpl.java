package com.itmk.system.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.Product;
import com.itmk.system.entity.Productspecification;
import com.itmk.system.mapper.ProductDao;
import com.itmk.system.mapper.ProductspecificationDao;
import com.itmk.system.service.ProductspecificationService;
import com.itmk.system.vo.Pager;
import com.itmk.system.vo.ProductSpecificationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductspecificationServiceImpl extends ServiceImpl<ProductspecificationDao, Productspecification> implements ProductspecificationService {

    @Autowired
    private ProductspecificationDao productspecificationDao;
    @Autowired
    private ProductDao productDao;
    @Override
    public Pager<Productspecification> queryProductspecificationByProId(Integer proid,Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Productspecification> productspecificationList=this.productspecificationDao.queryProductspecificationByProId(proid);
        PageInfo<Productspecification> page=new PageInfo<>(productspecificationList);
        return new Pager<Productspecification>(page.getTotal(),page.getList());
    }

    @Override
    public void addEditSpecification(ProductSpecificationVo productSpecificationVo) {
        Product p=new Product();
        //查找存不存在产品id
        p=this.productDao.findProductById(productSpecificationVo.getProId());
        if(p!=null){
            //先把传进来的vo对象中的speid值赋值给一个变量
            int speone= productSpecificationVo.getSpeId();
            System.out.println(speone);
            Productspecification spe=new Productspecification();
            System.out.println("传进来的speid"+speone);
            //把变量去查找一遍
            if(speone==0 ){
                //如果不存在就新增
                this.productspecificationDao.insertSpe(productSpecificationVo);
            }else {
                //存在就编辑
                this.productspecificationDao.updateSpe(productSpecificationVo.getSpeSpecification(),productSpecificationVo.getSpeUnit(),productSpecificationVo.getSpeUnitConversion(),productSpecificationVo.getSpeId());
            }

        }else {
            System.out.println("产品id不存在！");
        }
    }

    @Override
    public Productspecification queryBySepId(Integer speid) {
        return this.productspecificationDao.queryBySepId(speid);
    }

    @Override
    public void delBySpeId(Integer speId) {
        this.productspecificationDao.delBySpeId(speId);
    }
}
