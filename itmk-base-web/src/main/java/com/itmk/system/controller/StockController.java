package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Warehouseallocationdetail;
import com.itmk.system.service.StockService;
import com.itmk.system.vo.StockAdvancedSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 库存控制层
 */

@Slf4j
@RestController
@RequestMapping(value = "/api/stock")
public class StockController {

    @Autowired//注入库存业务接口
    private StockService stockService;

    /**
     * 查詢所有库存(分页)
     * @param currentPage
     * @param pageSize
     * @return
     */

    @GetMapping("/query_all_stock_by_page")
    public ResultVo queryAllStockByPage(Integer currentPage,Integer pageSize){
        return ResultUtils.success("查询成功",this.stockService.queryAllStock(currentPage,pageSize));
    }

    /**
     * 通过库存id查詢库存
     * @param stockId
     * @return
     */
    @GetMapping("/queryStockByStockId")
    public ResultVo queryStockByStockId(Integer stockId){
        return ResultUtils.success("查詢成功",this.stockService.queryStockByStockId(stockId));
    }

    /**
     * 通过下拉框数据查询仓库
     * @param currentPage
     * @param pageSize
     * @param value
     * @param input
     * @param select
     * @return
     */
    @GetMapping("/query_stock_by_search")
    public ResultVo queryStockBySearch(Integer currentPage, Integer pageSize, String value, String input, String select){
        return ResultUtils.success("查询成功",this.stockService.queryStockBySearch(value,input,select,currentPage,pageSize));
    }

    /**
     * 高级查询库存列表
     * 9/19
     * @param sas
     * @return
     */
    @PostMapping("/queryStockByAdvanced")
    public ResultVo queryStockByAdvanced(@RequestBody StockAdvancedSearchVo sas){
        return ResultUtils.success("查詢成功",this.stockService.queryStockByAdvanced(sas));
    }

    /**
     * 清除数据为0的库存
     * @return
     */

    @DeleteMapping("/removeStockisZero")
    public ResultVo removeStockisZero(){
        return ResultUtils.success("操作成功",this.stockService.removeStockisZero());
    }

    /**
     *功能描述 通过仓库id和规格id查询库存
     * @author 廖湘明
     * @date 2020/9/23
     * @param
     * @return
     */
    @PostMapping("/queryStockByAllWarehouse")
    public ResultVo queryStockByAllWarehouse(@RequestBody List<Warehouseallocationdetail> warehouseallocationdetails){
        return ResultUtils.success("查询成功",this.stockService.queryByAllWarehouse(warehouseallocationdetails));
    }
    /**
     *功能描述 通过规格id查询库存
     * @author 廖湘明
     * @date 2020/9/24
     * @param
     * @return
     */
    @GetMapping("/queryQuantityBySpeId")
    public ResultVo queryQuantityBySpeId(Integer speId){
        return ResultUtils.success("查询成功",this.stockService.queryQuantityBySpeId(speId));
    }
}
