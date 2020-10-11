package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商控制器
 * @author 廖湘明
 * @data 2020/9/28 20:17
 * @return
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/supplier")
public class SupplierServiceController {
    @Autowired
    private SupplierService supplierService;

    /**
     *功能描述 查询所有供应商
     * @author 廖湘明
     * @date 2020/9/28
     * @param
     * @return
     */
    @GetMapping("/queryAllSupplier")
    public ResultVo queryAllSupplier(){
        return ResultUtils.success("查询成功",this.supplierService.queryAllSupplier());
    }
}
