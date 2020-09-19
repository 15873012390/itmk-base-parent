package com.itmk.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Productclassification;
import com.itmk.system.mapper.ProductclassificationDao;
import com.itmk.system.service.ProductclassificationService;
import com.itmk.system.vo.Pager;
import com.itmk.system.vo.ProductclassificationVo;
import com.itmk.system.vo.TreeUtilsVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类管理控制器
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/productclassification")
public class ProductclassificationController {

    @Autowired
    private ProductclassificationService productclassificationService;

    /*
    * 查询分类(模糊查询，分页）
    * */
    @RequestMapping(value="getProductclassificationList",method = RequestMethod.POST)
    public ResultVo getProductclassificationList(@RequestBody ProductclassificationVo parm){
        //条件构造器
        QueryWrapper<Productclassification> queryWrapper=new QueryWrapper<>();
        if(StringUtils.isNotBlank(parm.getClaName())){
            queryWrapper.lambda().like(Productclassification::getClaName,parm.getClaName());
        }
        //分页
        IPage<Productclassification> page=new Page();
        page.setCurrent(parm.getCurrentPage());
        page.setSize(parm.getPageSize());
        IPage<Productclassification> productclassificationIPage=productclassificationService.page(page,queryWrapper);
        return ResultUtils.success("查询分类成功",productclassificationIPage);
    }

    /*
    * 新增类别
    * */
    @RequestMapping(value = "addProductclassification",method = RequestMethod.POST)
    public ResultVo addProductclassification(@RequestBody Productclassification productclassification){
        //条件构造器
        QueryWrapper<Productclassification> query=new QueryWrapper<>();
        query.lambda().eq(Productclassification::getClaName,productclassification.getClaName());
        Productclassification p=productclassificationService.getOne(query);
        if(p!=null){
            return ResultUtils.error("该类别名称已存在");
        }
        Boolean b=productclassificationService.save(productclassification);
        if(b){
            return ResultUtils.success("新增类别成功");
        }else{
            return ResultUtils.error("新增类别失败");
        }
    }

    /*
    * 修改类别
    * */
    @RequestMapping(value = "updateProductclassification",method = RequestMethod.POST)
    public ResultVo updateProductclassification(@RequestBody Productclassification productclassification){
        QueryWrapper<Productclassification> query =new QueryWrapper<>();
        query.lambda().eq(Productclassification::getClaName,productclassification.getClaName());
        query.lambda().ne(Productclassification::getClaId,productclassification.getClaId());
        Productclassification p=productclassificationService.getOne(query);
        if(p!=null){
            return ResultUtils.error("该类别名称已存在");
        }
        Boolean b=productclassificationService.updateById(productclassification);
        if(b){
            return ResultUtils.success("修改类别成功");
        }else{
            return ResultUtils.error("修改类别失败");
        }
    }
    /*
    * 删除类别
    * */
    @RequestMapping(value = "deleteProductclassificationById",method = RequestMethod.POST)
    public ResultVo deleteProductclassificationById(@RequestBody Productclassification productclassification){
        Boolean b=productclassificationService.removeById(productclassification.getClaId());
        if(b){
            return ResultUtils.success("删除类别成功");
        }else{
            return ResultUtils.error("删除类别失败");
        }
    }

    /**
     * 查询全部状态正常的类别
     * @return
     */
    @GetMapping("/query_all_productClassification")
    public ResultVo queryAllProductClassification(){
        return ResultUtils.success("查询成功",this.productclassificationService.queryAllProductClassification());
    }

    /**
     * 查询全部类别（分页）
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Autowired
    private ProductclassificationDao productclassificationDao;
    @GetMapping("/get_all_productClassification")
    public ResultVo getAllProductClassification( Integer currentPage, Integer pageSize) throws Exception {
        Pager<Productclassification> list=this.productclassificationService.getAllProductClassification(currentPage,pageSize);
        List<TreeUtilsVo> treeList=TreeUtilsVo.getTreeList(this.productclassificationDao.getAllProductClassification(),"claId","claIdId","claName","claState","claDatetime");
        return ResultUtils.success("查询成功",treeList);
    }
}
