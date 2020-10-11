package com.itmk.system.service;

import com.itmk.system.entity.Department;
import com.itmk.system.entity.Product;
import com.itmk.system.entity.jpa.JpaSysUser;
import com.itmk.system.entity.mybatis.Customer;
import java.util.List;

/**
 * 客户和用户业务接口
 * @author 廖湘明
 * @data 2020/10/10 10:30
 * @return
 */
public interface CustomerAndUserService {
    //查看所有的客户
    public List<Customer> queryAllCustomer();
    //根据客户id查找联系人id
    public Customer queryContactByCusId(Integer cusid);
    //查找所有的员工
    public List<JpaSysUser> queryAllUser();
    //根据员工id查找员工
    public JpaSysUser queryByUid(Integer id);
    //根据客户名字和联系人名字查找数据
    public Customer queryByCusNameAndConName(String cusName,String conName);
    //根据员工名字查找数据
    public List<JpaSysUser> queryByUserName(String nickName);
    //查询所有部门底下的员工
    public List<Department> queryDeptAllUser();
    //查找所有产品名称
    public List<Product> queryAllProduct();
    //查找所有有权限的员工
    public List<JpaSysUser> getAllUserList();
}
