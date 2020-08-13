package com.itmk.system.mapper;

import com.itmk.system.entity.Customer;

import java.util.List;

public interface CustomerDao {
    int deleteByPrimaryKey(Integer cusId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer cusId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    //查询所有客户
    List<Customer> queryAllCustomer();
}