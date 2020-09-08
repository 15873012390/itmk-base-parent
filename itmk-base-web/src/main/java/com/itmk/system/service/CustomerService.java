package com.itmk.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.itmk.system.entity.jpa.JpaCustomer;
import com.itmk.system.entity.Customer;
import com.itmk.system.entity.mybatis.Customertransfer;
import com.itmk.system.vo.AdvancedQueryCustomerDataVo;
import com.itmk.system.vo.Pager;

import java.util.List;


/*
* 客户管理service接口
* */
public interface CustomerService extends IService<Customer> {

    //通过id查询客户
    public com.itmk.system.entity.mybatis.Customer getCustomerById(Integer cusId);
    /*编辑和添加*/
    public void saveCustomer(JpaCustomer customer);
    //根据数据查询客户
    public Pager<Customer> queryCustomerByShuJu(String value, Integer currentPage, Integer pageSize);

    //高级查询客户
    public Pager<Customer> queryCustomerSenior(AdvancedQueryCustomerDataVo advancedQueryCustomerDataVo) ;

    //查询所有客户不带分页
    public List<Customer> queryAllCustomers2();
    //查询所有客户分页
    public Pager<Customer> queryAllCustomers(Integer currentPage,Integer pageSize);
    //搜索id查询客户
    public Pager<Customer> searchCustomerById(Integer cusId,Integer currentPage,Integer pageSize);
    //搜索名字查询客户
    public Pager<Customer> queryCustomerByName(String cusName,Integer currentPage,Integer pageSize);
    //添加客户转移日志
    public void saveCustomerTransfer(Customertransfer customertransfer);
}
