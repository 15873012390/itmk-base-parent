package com.itmk.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Customer;
import com.itmk.system.service.CustomerService;
import com.itmk.system.vo.CustomerVo;
import com.itmk.system.vo.Pager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
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
    /*
     * 查询客户(模糊查询，分页）
     * */
    @RequestMapping(value = "getCustomerList",method = RequestMethod.POST)
    public ResultVo getCustomerList(@RequestBody CustomerVo parm){
        //条件构造器
        QueryWrapper<Customer> query=new QueryWrapper<>();
        if(StringUtils.isNotBlank(parm.getCusName())){
            query.lambda().like(Customer::getCusName,parm.getCusName());
        }
        if(StringUtils.isNotBlank(parm.getCusTel())){
            query.lambda().like(Customer::getCusTel,parm.getCusTel());
        }
        IPage<Customer> page = new Page<>();
        page.setCurrent(parm.getCurrentPage());
        page.setSize(parm.getPageSize());
        IPage<Customer> customerIPage=customerService.page(page,query);
        return ResultUtils.success("查询成功",customerIPage);
    }
    /*
     * 新增客户
     * */
    @RequestMapping(value = "addCustomer",method = RequestMethod.POST)
    public ResultVo addCustomer(@RequestBody Customer customer){
        //条件构造器
        QueryWrapper<Customer> query=new QueryWrapper<>();
        query.lambda().eq(Customer::getCusName,customer.getCusName());
        Customer one=customerService.getOne(query);
        if(one!=null){
            return ResultUtils.error("该客户已存在");
        }
        boolean b=customerService.save(customer);
        if(b){
            return ResultUtils.success("新增客户成功");
        }else{
            return ResultUtils.error("新增客户失败");
        }
    }

    /*
     * 编辑客户
     * */
    @RequestMapping(value = "updateCustomer",method = RequestMethod.POST)
    public ResultVo updateCustomer(@RequestBody Customer customer){
        //条件构造器
        QueryWrapper<Customer> query=new QueryWrapper<>();
        query.lambda().eq(Customer::getCusName,customer.getCusName());
        query.lambda().ne(Customer::getCusId,customer.getCusId());
        Customer one=customerService.getOne(query);
        if(one!=null){
            return ResultUtils.error("该客户已存在");
        }
        boolean b=customerService.updateById(customer);
        if(b){
            return ResultUtils.success(" 编辑客户成功");
        }else{
            return ResultUtils.error("编辑客户失败");
        }
    }

    /*
     * 根据id删除客户
     * */
    @RequestMapping(value = "deleteCustomerById",method = RequestMethod.POST)
    public ResultVo deleteCustomerById(@RequestBody Customer customer){

        boolean b=customerService.removeById(customer.getCusId());
        if(b){
            return ResultUtils.success("删除客户成功");
        }else{
            return ResultUtils.error("删除客户失败");
        }
    }
}
