package com.itmk.system.service;

import com.itmk.system.entity.Customer;

import java.util.List;

public interface CustomerService {
    /**
     * @Author: fyr
     * @Description: 所有客户
     * @Date: 16:06 2020/8/13
     * @Param: []
     * @Return: java.util.List<com.itmk.system.entity.Customer>
     */
    List<Customer> queryAllCustomer();
}
