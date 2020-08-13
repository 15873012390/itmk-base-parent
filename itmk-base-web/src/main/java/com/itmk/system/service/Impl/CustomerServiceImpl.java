package com.itmk.system.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.itmk.system.entity.Customer;
import com.itmk.system.mapper.CustomerMapper;
import com.itmk.system.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
