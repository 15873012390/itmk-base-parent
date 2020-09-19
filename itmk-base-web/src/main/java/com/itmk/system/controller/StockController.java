package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/query_all_stock_by_page")
    public ResultVo queryAllStockByPage(Integer currentPage,Integer pageSize){
        return ResultUtils.success("查询成功",this.stockService.queryAllStock(currentPage,pageSize));
    }
}
