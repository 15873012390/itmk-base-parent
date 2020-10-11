package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.service.CustomerAndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *功能描述 用户和客户业务层
 * @author 廖湘明
 * @date 2020/10/10
 */
@RestController
@RequestMapping(value = "/api/CustomerAndUser")
public class CustomerAndUserController {
    @Autowired
    private CustomerAndUserService customerAndUserService;

    /**
     * 查看所有客户
     * @return
     */
    @GetMapping("/query_all_customer")
    public ResultVo queryAllCustomer(){
       return ResultUtils.success("查看所有客户成功",this.customerAndUserService.queryAllCustomer());
    }

    /**
     * 根据客户id查找对应的联系人
     * @param cusid
     * @return
     */
    @GetMapping("/query_contact_by_cusId")
    public ResultVo queryContactByCusId(Integer cusid){
        return ResultUtils.success("根据客户id查找对应的联系人",this.customerAndUserService.queryContactByCusId(cusid));
    }


    /**
     * 查找所有的用户
     * @return
     */
    @GetMapping("/query_all_user")
    public ResultVo queryAllUser(){
        return ResultUtils.success("查找所有的用户",this.customerAndUserService.queryAllUser());
    }

    /**
     * 查看所有部门底下的员工
     * @return
     */
    @GetMapping("/query_dept_all_user")
    public ResultVo queryDeptAllUser(){
        return ResultUtils.success("查看所有部门底下的员工",this.customerAndUserService.queryDeptAllUser());
    }


    /**
     * 查找所有产品名称
     *
     * @return
     */
    @GetMapping("/query_all_product")
    public ResultVo queryAllProduct(){
        return ResultUtils.success("查找所有产品名称",this.customerAndUserService.queryAllProduct());
    }

    /**
     * 查询有审批权限的员工
     * @return
     */
    @GetMapping("/get_all_user")
    public ResultVo getAllUser(){
        return ResultUtils.success("查询有审批权限的员工",this.customerAndUserService.getAllUserList());
    }


}
