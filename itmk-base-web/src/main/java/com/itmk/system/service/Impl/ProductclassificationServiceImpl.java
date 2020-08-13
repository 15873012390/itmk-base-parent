package com.itmk.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmk.system.entity.Productclassification;
import com.itmk.system.mapper.ProductclassificationMapper;
import com.itmk.system.service.ProductclassificationService;
import org.springframework.stereotype.Service;

@Service
public class ProductclassificationServiceImpl extends ServiceImpl<ProductclassificationMapper,Productclassification> implements ProductclassificationService {

}
