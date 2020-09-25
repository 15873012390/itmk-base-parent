package com.itmk.system.controller;


import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.service.OustStockService;
import com.itmk.system.vo.OutStockAdvancedSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *功能描述 入库控制层
 * @author 廖湘明
 * @date 2020/9/22
 */
@Slf4j
@RestController
@RequestMapping("/api/Outstock")
public class OutStockController {

    @Autowired
    private OustStockService oustStockService;

    /**
     *功能描述 查询所有出库分页
     * @author 廖湘明
     * @date 2020/9/24
     * @param
     * @return
     */
    @GetMapping("/queryAllOutStockByPage")
    public ResultVo queryAllOutStockByPage(Integer currentPage, Integer pageSize){
        return ResultUtils.success("查询成功",this.oustStockService.queryAllOutStockByPage(currentPage,pageSize));
    }
    /**
     *功能描述 通过下拉框数据和值搜索出库
     * @author 廖湘明
     * @date 2020/9/24
     * @param
     * @return
     */
    @GetMapping("/queryOutStockSelectAndInputByPage")
    public ResultVo queryOutStockSelectAndInputByPage(String value, String input, String select, Integer currentPage, Integer pageSize){
        return ResultUtils.success("查询成功",this.oustStockService.queryOutStockSelectAndInputByPage(value, input, select, currentPage, pageSize));
    }

    /**
     *功能描述 高级查询
     * @author 廖湘明
     * @date 2020/9/24
     * @param
     * @return
     */
    @PostMapping("/queryOutstockByAdvancedSearch")
    public ResultVo queryOutstockByAdvancedSearch(@RequestBody OutStockAdvancedSearch oas){
        return ResultUtils.success("查询成功",this.oustStockService.queryOutstockByAdvancedSearch(oas));
    }
}
