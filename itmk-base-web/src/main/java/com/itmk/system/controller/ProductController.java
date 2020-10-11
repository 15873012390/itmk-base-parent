package com.itmk.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Product;
import com.itmk.system.service.ProductService;
import com.itmk.system.vo.ProductAdvancedSearch;
import com.itmk.system.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产品管理控制器
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 查询全部产品
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/query_all_product")
    public ResultVo queryAllProduct(Integer currentPage, Integer pageSize){
        return ResultUtils.success("查询产品成功",this.productService.queryAllProduct(currentPage, pageSize));
    }

    /**
     * 通过下拉框数据搜索产品
     * @param value
     * @param input
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/search_product_by_shuJu")
    public ResultVo seachProductByShuJu(String value,String input,Integer currentPage, Integer pageSize){
        return ResultUtils.success("查询产品成功",this.productService.seachProductByShuJu(value,input,currentPage, pageSize));
    }

    /**
     * 高级搜索产品
     * @param productAdvancedSearch
     * @return
     */
    @PostMapping("/product_advancedSearch")
    public ResultVo productAdvancedSearch(@RequestBody ProductAdvancedSearch productAdvancedSearch){
        return ResultUtils.success("查询产品成功",this.productService.productAdvancedSearch(productAdvancedSearch));
    }

    /**
     * 删除产品通过id(逻辑删除，修改状态)
     * @param proid
     * @return
     */
    @DeleteMapping("/delete_product_by_id")
    public ResultVo deleteProductById(Integer proid){
        this.productService.deleteProudctById(proid);
        return ResultUtils.success("删除成功");
    }

    /**
     * 通过id查找产品
     * @param proid
     * @return
     */
    @GetMapping("/find_product_by_id")
    public ResultVo findProductById(Integer proid){
        return ResultUtils.success("查询成功",this.productService.findProductById(proid));
    }

    /**
     * 新增/编辑产品
     * @param product
     * @return
     */
    @PostMapping("/add_update_product")
    public ResultVo addUpdateProduct(@RequestBody Product product){
        return ResultUtils.success("操作成功",this.productService.addAndUpdateProduct(product));
    }

    /**
     * 产品详情页上 统计每个仓库还有多少库存
     * @return
     */
    @GetMapping("/query_by_stock")
    public ResultVo queryByStock(){
        return ResultUtils.success("查询成功",this.productService.queryByStock());
    }

    /**
     *功能描述 通过规格id查询产品
     * @author 廖湘明
     * @date 2020/9/24
     * @param
     * @return
     */
    @GetMapping("/findBySpeid")
    public ResultVo findBySpeid(Integer speid){
        return ResultUtils.success("查询成功",this.productService.findBySpeid(speid));
    }
    /**
     *功能描述 选择产品页面
     * @author 廖湘明
     * @date 2020/9/28
     * @param
     * @return
     */
    @GetMapping("/findAllCla")
    public ResultVo findAllCla(){
        return ResultUtils.success("查询类别和产品成功",this.productService.findAllCla());
    }
}
