package com.itmk.system.mapper;

import com.itmk.system.entity.Customer;
import com.itmk.system.vo.AdvancedQueryCustomerDataVo;
import com.itmk.system.vo.Pager;
import org.apache.ibatis.annotations.Param;

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
    //通过客户id查询联系人
    public  com.itmk.system.entity.mybatis.Customer queryContactByCusid(@Param("cusid") Integer cusid);
    //查询所有客户
    public List<com.itmk.system.entity.mybatis.Customer> queryAll();
    /*查询更新时间在一周内的客户*/
    public List<Customer> queryCustomerByWeek();
    //查询更新时间一个月内的客户
    public List<Customer> queryCustomerByMonth();
    /*查询更新时间一年内的客户*/
    public List<Customer> queryCustomerByYear();
    //通过客户来源查询客户
    public List<Customer> queryCustomerBySource(String value);
    //通过信用等级查询客户
    public List<Customer> queryCustomerByCredit(String value);
    //通过生命周期查询客户
    public List<Customer> queryCustomerByLifecycle(String value);
    //通过客户状态查询客户
    public List<Customer> queryCustomerByState(String value);
    //通过定级查询客户
    public List<Customer> queryCustomerByGrading(String value);
    //高级查询客户
    public List<Customer> queryCustomerSenior(AdvancedQueryCustomerDataVo advancedQueryCustomerDataVo);
    //通过id查询客户
    public com.itmk.system.entity.mybatis.Customer getCustomerById(Integer cusId);
    //搜索id查询客户
    public List<Customer> searchCustomerById(Integer cusId);
    //搜索名字查询客户
    public List<Customer> queryCustomerByName(String cusName, Integer currentPage, Integer pageSize);
    //根据cusId查询客户详情(左)
    public com.itmk.system.entity.mybatis.Customer queryCustomerDetailsById(Integer cusId);
}