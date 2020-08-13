package com.itmk.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmk.system.entity.Product;
import com.itmk.system.mapper.ProductDao;
import com.itmk.system.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao,Product> implements ProductService {

}
