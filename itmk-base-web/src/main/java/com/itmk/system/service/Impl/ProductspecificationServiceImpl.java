package com.itmk.system.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmk.system.entity.Productspecification;
import com.itmk.system.mapper.ProductspecificationDao;
import com.itmk.system.service.ProductspecificationService;
import org.springframework.stereotype.Service;

@Service
public class ProductspecificationServiceImpl extends ServiceImpl<ProductspecificationDao, Productspecification> implements ProductspecificationService {

}
