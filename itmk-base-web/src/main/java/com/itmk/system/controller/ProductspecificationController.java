package com.itmk.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Productspecification;
import com.itmk.system.service.ProductspecificationService;
import com.itmk.system.vo.ProductspecificationVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 规格管理控制器
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/Productspecification")
public class ProductspecificationController {
    @Autowired
    private ProductspecificationService productspecificationService;

    @RequestMapping(value = "getProductspecificationList",method = RequestMethod.POST)
    public ResultVo getProductspecificationList(@RequestBody ProductspecificationVo parm){
        //条件构造
        QueryWrapper<Productspecification> queryWrapper=new QueryWrapper<>();
        if(StringUtils.isNotBlank(parm.getProName())){
            queryWrapper.lambda().eq(Productspecification::getProName,parm.getProName());
        }
        //分页
        IPage<Productspecification> page=new Page<>();
        page.setCurrent(parm.getCurrentPage());
        page.setPages(parm.getPageSize());
        IPage<Productspecification> productspecificationIPage=productspecificationService.page(page,queryWrapper);
        return ResultUtils.success("查询规格成功",productspecificationIPage);

    }
}
