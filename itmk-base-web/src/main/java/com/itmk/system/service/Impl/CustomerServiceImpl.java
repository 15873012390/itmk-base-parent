package com.itmk.system.service.Impl;

import com.itmk.system.entity.Customer;
import com.itmk.system.mapper.CustomerDao;
import com.itmk.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Override
    public List<Customer> queryAllCustomer() {
        return customerDao.queryAllCustomer();
    }
}
