package com.itmk.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Product;
import com.itmk.system.service.ProductService;
import com.itmk.system.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品管理控制器
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    /*
     * 查询产品(模糊查询，分页）
     * */
    @RequestMapping(value = "getProductList",method = RequestMethod.POST)
    public ResultVo getProductList(@RequestBody ProductVo parm){
        //条件构造器
        QueryWrapper<Product> queryWrapper=new QueryWrapper<>();
        if(StringUtils.isNotBlank(parm.getProName())){
            queryWrapper.lambda().like(Product::getProName,parm.getProName());
        }
        //分页
        IPage<Product> page=new Page<>();
        page.setCurrent(parm.getCurrentPage());
        page.setPages(parm.getPageSize());
        IPage<Product> productIPage=productService.page(page,queryWrapper);
        return ResultUtils.success("查询产品成功",productIPage);
    }

    /*
    * 添加产品
    * */
    @RequestMapping(value = "addProduct",method = RequestMethod.POST)
    public ResultVo addProduct(@RequestBody Product product){
        //条件构造器
        QueryWrapper<Product> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(Product::getProName,product.getProName());
        Product p=productService.getOne(queryWrapper);
        if(p!=null){
            return ResultUtils.error("该产品名称已存在");
        }
        Boolean b=productService.save(product);
        if(b){
            return ResultUtils.success("添加产品成功");
        }else {
            return  ResultUtils.error("添加产品失败");
        }
    }

    /*
     * 编辑产品
     * */
    @RequestMapping(value = "updateProduct",method = RequestMethod.POST)
    public ResultVo updateProduct(@RequestBody Product product){
        //条件构造器
        QueryWrapper<Product> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(Product::getProName,product.getProName());
        queryWrapper.lambda().ne(Product::getProId,product.getProId());
        Product p=productService.getOne(queryWrapper);
        if(p!=null){
            return ResultUtils.error("该产品名称已存在");
        }
        Boolean b=productService.updateById(product);
        if(b){
            return ResultUtils.success("修改产品成功");
        }else {
            return  ResultUtils.error("修改产品失败");
        }
    }

    /*
    * 删除产品
    * */
    @RequestMapping(value = "deleteProductById",method = RequestMethod.POST)
    public ResultVo deleteProductById(@RequestBody Product product){
        Boolean b=productService.removeById(product);
        if(b){
            return ResultUtils.success("删除产品成功");
        }else{
            return ResultUtils.error("删除产品失败");
        }
    }
}
