package com.itmk.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Customer;
import com.itmk.system.entity.jpa.JpaCustomer;
import com.itmk.system.entity.mybatis.Customertransfer;
import com.itmk.system.service.CustomerService;
import com.itmk.system.vo.AdvancedQueryCustomerDataVo;
import com.itmk.system.vo.CustomerVo;
import com.itmk.system.vo.Pager;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/customer")
public class LxmCustomerController {

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
     * 编辑和添加客户
     * */
    @RequestMapping(value = "add_and_update_customer",method = RequestMethod.POST)
    public ResultVo add_and_update_customer(@RequestBody JpaCustomer customer){
       //条件构造器
        QueryWrapper<Customer> query=new QueryWrapper<>();
        query.lambda().eq(Customer::getCusName,customer.getCusName());
        query.lambda().ne(Customer::getCusId,customer.getCusId());
        Customer one=customerService.getOne(query);
         if(one!=null){
            return ResultUtils.error("该客户已存在");
        }
        /*boolean b=customerService.updateById(customer);
        if(b){
            return ResultUtils.success(" 编辑客户成功");
        }else{
            return ResultUtils.error("编辑客户失败");
        }*/
        try{
            this.customerService.saveCustomer(customer);
            return ResultUtils.success(" 操作成功");
        }catch (Exception e){
            return ResultUtils.success(" 操作失败");
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

    /**
     * 根据id数组批量删除客户
     * @param cusIds
     * @return
     */
    @RequestMapping(value = "deleteCustomerByIds",method = RequestMethod.POST)
    public ResultVo deleteCustomerIds(@RequestBody Integer[] cusIds){
        boolean b=customerService.removeByIds(Arrays.asList(cusIds));
        if(b){
            return ResultUtils.success("删除客户成功");
        }else{
            return ResultUtils.error("删除客户失败");
        }
    }

    /**
     * 通过客户id查找客户
     * @param cusId
     * @return
     */
    @GetMapping("query_customer_by_id")
    public ResultVo getCustomerById(Integer cusId){

        com.itmk.system.entity.mybatis.Customer customer=customerService.getCustomerById(cusId);
        return ResultUtils.success("查询成功",customer);
    }

    /**
     * 搜索客户id查找客户
     * @param cusId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("search_customer_by_id")
    public ResultVo searchCustomerById(Integer cusId,Integer currentPage,Integer pageSize){

        return ResultUtils.success("查询成功",this.customerService.searchCustomerById(cusId,currentPage,pageSize));
    }

    /**
     *
     * @param cusName
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("query_customer_by_name")
    public ResultVo queryCustomerByName(String cusName,Integer currentPage,Integer pageSize){

        return ResultUtils.success("查询成功",this.customerService.queryCustomerByName(cusName,currentPage,pageSize));
    }


    /**
     * 根据数据查询客户
     * @param value
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/query_customer_by_shuju")
    public ResultVo queryCustomerByShuJu(String value,Integer currentPage, Integer pageSize){

        return ResultUtils.success(value,this.customerService.queryCustomerByShuJu(value,currentPage,pageSize));
    }

    /**
     * 高级查询客户
     * @param advancedQueryCustomerData
     * @return
     */
    @ResponseBody
    @RequestMapping("/query_customer_senior")
    public ResultVo queryCustomerSenior(@RequestBody AdvancedQueryCustomerDataVo advancedQueryCustomerData){

        return ResultUtils.success("高级查询客户",this.customerService.queryCustomerSenior(advancedQueryCustomerData));
    }

    /**
     * 根据名称加载客户
     * @param cusName
     * @return
     */
    @GetMapping("/find_customer_by_name")
    public Customer findCustomerByName(String cusName){
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(Customer::getCusName,cusName);
        return this.customerService.getOne(queryWrapper);
    }

    /**
     * 查询所有客户2(不带分页)
     * @return
     */
    @GetMapping("/query_all_customer2")
    public ResultVo queryAllCustomer2(){
        return  ResultUtils.success("查询成功",this.customerService.queryAllCustomers2());
    }
    /**
     * 分页查询所有客户
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_all_customer")
    public ResultVo queryAllCustomer(Integer currentPage, Integer pageSize){

        return ResultUtils.success("查询成功",this.customerService.queryAllCustomers(currentPage,pageSize));
    }

    /**
     * 添加客户转移日志
     * @param customertransfer
     * @return
     */
    @PostMapping("/add_customertransfer")
    public ResultVo addCustomerTransfer(@RequestBody Customertransfer customertransfer){
        this.customerService.saveCustomerTransfer(customertransfer);
        return ResultUtils.success("操作成功");
    }
}
