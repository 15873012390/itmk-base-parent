package com.itmk.system.service.Impl;

import com.itmk.system.entity.Department;
import com.itmk.system.entity.Product;
import com.itmk.system.entity.jpa.JpaSysUser;
import com.itmk.system.entity.mybatis.Customer;
import com.itmk.system.mapper.CustomerDao;
import com.itmk.system.mapper.UserDao;
import com.itmk.system.service.CustomerAndUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 廖湘明
 * @data 2020/10/10 10:39
 * @return
 */
@Slf4j
@Service
@Transactional
public class CustomerAndUserServiceImpl implements CustomerAndUserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CustomerDao customerDao;
    @Override
    public List<Customer> queryAllCustomer() {
        return this.customerDao.queryAll();
    }

    @Override
    public Customer queryContactByCusId(Integer cusid) {
        return null;
    }

    @Override
    public List<JpaSysUser> queryAllUser() {
        return this.userDao.queryAll();
    }

    @Override
    public JpaSysUser queryByUid(Integer id) {
        return this.userDao.queryByUid(id);
    }

    @Override
    public Customer queryByCusNameAndConName(String cusName, String conName) {
        return null;
    }

    @Override
    public List<JpaSysUser> queryByUserName(String nickName) {
        return this.userDao.queryByUserName(nickName);
    }

    @Override
    public List<Department> queryDeptAllUser() {
        return null;
    }

    @Override
    public List<Product> queryAllProduct() {
        return null;
    }

    @Override
    public List<JpaSysUser> getAllUserList() {
        return this.userDao.getAllUsrList();
    }
}
