package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.service.ProductspecificationService;
import com.itmk.system.vo.ProductSpecificationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 规格管理控制器
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/Productspecification")
public class ProductspecificationController {
    @Autowired
    private ProductspecificationService productspecificationService;

    /**
     * //根据产品id查询全部规格
     * @param proid
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/query_all_by_proid_page")
    public ResultVo queryAllByProidPage(Integer proid,Integer currentPage, Integer pageSize){
        return ResultUtils.success("操作成功",this.productspecificationService.queryProductspecificationByProId(proid,currentPage,pageSize));
    }

    /**
     * 添加/编辑子规格
     * @param productSpecificationVo
     * @return
     */
    @PostMapping("/add_edit_specification")
    public ResultVo addEditSpecification(@RequestBody ProductSpecificationVo productSpecificationVo){
        this.productspecificationService.addEditSpecification(productSpecificationVo);
        return ResultUtils.success("操作成功");
    }

    /**
     * 通过id查找规格
     * @param speid
     * @return
     */
    @GetMapping("/find_by_speid")
    public ResultVo findBySpeid(Integer speid){
        return ResultUtils.success("查询成功",this.productspecificationService.queryBySepId(speid));
    }

    @DeleteMapping("del_by_speid")
    public ResultVo delBySpeid(Integer speid){
        this.productspecificationService.delBySpeId(speid);
        return ResultUtils.success("操作成功");
    }
}
