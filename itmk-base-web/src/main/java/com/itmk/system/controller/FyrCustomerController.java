package com.itmk.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Customer;
import com.itmk.system.service.CustomerService;
import com.itmk.system.vo.Pager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: fyr
 * @Description: 客户信息
 * @Date: 16:03 2020/8/13
 * @Param:
 * @Return: 
 */
@Slf4j
@RestController
@RequestMapping("/api/customer")
public class FyrCustomerController {

    @Autowired
    private CustomerService customerService;
    @GetMapping("/queryAllCustomers")
    public ResultVo queryAllCustomers(@RequestBody @RequestParam(value="curpage",
            defaultValue = "1") int curpage,@RequestBody @RequestParam(value="pagesize",
            required = false,defaultValue = "10") int pagesize){
        PageHelper.startPage(curpage,pagesize);
        List<Customer> list= customerService.queryAllCustomer();
        PageInfo<Customer> pageInfo=new PageInfo<>(list);
        return ResultUtils.success("查询成功",new Pager<Customer>(pageInfo.getTotal(),pageInfo.getList()));
    }
}
