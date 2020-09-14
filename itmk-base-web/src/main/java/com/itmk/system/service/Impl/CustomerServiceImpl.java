package com.itmk.system.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.Customer;
import com.itmk.system.entity.jpa.JpaCustomer;
import com.itmk.system.entity.mybatis.Customertransfer;
import com.itmk.system.mapper.CustomerDao;
import com.itmk.system.mapper.CustomerMapper;
import com.itmk.system.mapper.jpa.LxmJpaCustomerDao;
import com.itmk.system.mapper.jpa.LxmJpaCustomerDao2;
import com.itmk.system.mapper.jpa.LxmJpaCustomerTransferDao;
import com.itmk.system.service.CustomerService;
import com.itmk.system.vo.AdvancedQueryCustomerDataVo;
import com.itmk.system.vo.Pager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Autowired
    private LxmJpaCustomerDao lxmJpaCustomerDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LxmJpaCustomerDao2 lxmJpaCustomerDao2;

    @Autowired
    private LxmJpaCustomerTransferDao lxmJpaCustomerTransferDao;

    @Override
    public com.itmk.system.entity.mybatis.Customer getCustomerById(Integer cusId) {
        return this.customerDao.getCustomerById(cusId);
    }

    /**
     * 添加/修改客户
     * @param customer
     */
    public void saveCustomer(JpaCustomer customer){
        this.lxmJpaCustomerDao.save(customer).toString();
    }

    @Override
    /**
     * 根据数据查询客户
     * @param value
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Pager<Customer> queryCustomerByShuJu(String value,Integer currentPage,Integer pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<Customer> list=null;
        if (value.equals("一周内")){
            list= this.customerDao.queryCustomerByWeek();
        }else if (value.equals("一个月内")){
            list= this.customerDao.queryCustomerByMonth();
        }else if (value.equals("一年内")){
            list= this.customerDao.queryCustomerByYear();
        }else if(value.equals("客户介绍")||value.equals("电话来访")||value.equals("媒体宣传")||value.equals("网站填表")||value.equals("其他")){
            list= this.customerDao.queryCustomerBySource(value);
        }else if(value.equals("较高")||value.equals("高")||value.equals("中")||value.equals("低")||value.equals("较低")){
            list= this.customerDao.queryCustomerByCredit(value);
        }else if(value.equals("一次性")||value.equals("重复购买")||value.equals("长期合作")){
            list= this.customerDao.queryCustomerByLifecycle(value);
        }else if(value.equals("正常")||value.equals("预警")||value.equals("流失")){
            list= this.customerDao.queryCustomerByState(value);
        }else if(value.equals("1")||value.equals("2")||value.equals("3")||value.equals("4")){
            list= this.customerDao.queryCustomerByGrading(value);
        }
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public com.itmk.system.entity.mybatis.Customer queryCustomerDetailsById(Integer cusId) {
        return this.customerDao.queryCustomerDetailsById(cusId);
    }

    /**
     * 高级查询客户
     * @param advancedQueryCustomerDataVo
     * @return
     */
    public Pager<Customer> queryCustomerSenior(AdvancedQueryCustomerDataVo advancedQueryCustomerDataVo){
        PageHelper.startPage(advancedQueryCustomerDataVo.getcurrentPage(),advancedQueryCustomerDataVo.getpageSize());
        List<Customer> list= this.customerDao.queryCustomerSenior(advancedQueryCustomerDataVo);
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public List<Customer> queryAllCustomers2() {
        return this.customerDao.queryAllCustomer();
    }

    @Override
    public Pager<Customer> queryAllCustomers(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Customer> list= this.customerDao.queryAllCustomer();
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public Pager<Customer> searchCustomerById(Integer cusId, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Customer> list= this.customerDao.searchCustomerById(cusId);
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public Pager<Customer> queryCustomerByName(String cusName, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Customer> list= this.customerDao.queryCustomerByName(cusName,currentPage,pageSize);
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加客户转移日志
     * @param customertransfer
     */
    public void saveCustomerTransfer(Customertransfer customertransfer){
        com.itmk.system.entity.mybatis.Customer customer=getCustomerById(customertransfer.getCustomer().getCusId());
        customer.setJpaSysUser(customertransfer.getUser2());
        customer.setCusUpdateTime(customertransfer.getCtTime());
        this.saveCustomer(customer);
        this.lxmJpaCustomerTransferDao.save(customertransfer);
    }
    /**
     * 添加/修改客户
     * @param customer
     */
    public void saveCustomer(com.itmk.system.entity.mybatis.Customer customer){
        lxmJpaCustomerDao2.save(customer);
    }
}
