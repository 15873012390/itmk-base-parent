package com.itmk.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Warehouse;
import com.itmk.system.service.WarehouseService;
import com.itmk.system.vo.WarehouseAdvancedSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    /**
     * 查询所有仓库
     * @return
     */
    @GetMapping("/query_all_warehouse")
    public ResultVo queryAllWarehouseByPage(){
        return ResultUtils.success("查询成功",this.warehouseService.queryAllWarehouse());
    }

    /**
     * 查询所有仓库（分页）
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/query_all_warehouse_by_page")
    public ResultVo queryAllWarehouseByPage(Integer currentPage, Integer pageSize){
        return ResultUtils.success("查询成功",this.warehouseService.queryAllWarehouseByPage(currentPage,pageSize));
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
    @GetMapping("/querySelectOrInputWarehouse")
    public ResultVo querySelectOrInputWarehouse(Integer currentPage, Integer pageSize, String value, String input, String select){
        return ResultUtils.success("查询成功",warehouseService.querySelectOrInputWarehouse(value,input,select,currentPage,pageSize));
    }

    /**
     * 高级搜索仓库
     * @param wds
     * @return
     */
    @PostMapping("/queryWarehouseAdvanced")
    public ResultVo queryWarehouseAdvanced(@RequestBody WarehouseAdvancedSearch wds){
        return ResultUtils.success("查询成功",this.warehouseService.queryByAdvanced(wds));
    }

    /**
     * 添加或修改仓库
     * @param warehouse
     * @return
     */
    @PostMapping("/addOrEditWarehouse")
    public ResultVo addOrEditWarehouse(@RequestBody Warehouse warehouse){
        this.warehouseService.addOreditWarehouse(warehouse);
        return ResultUtils.success("操作成功");
    }

    /**
     * 通过id查詢仓库
     * @param warehouseId
     * @return
     */
    @GetMapping("/queryByWarehouseId")
    public Warehouse queryByWarehouseId(Integer warehouseId){
        return this.warehouseService.queryByWarehouseId(warehouseId);
    }

    /**
     * 通过id删除仓库
     * @param warehouseId
     * @return
     */
    @DeleteMapping("/deleteByWarehouseId")
    public ResultVo deleteByWarehouseId(Integer warehouseId){
        return ResultUtils.success("操作成功",this.warehouseService.deleteByWarehouseId(warehouseId));
    }

    /**
     * 通过ids[]批量删除仓库
     * @param ids
     * @return
     */
    @PostMapping("/deleteByWarehouseIds")
    public ResultVo deleteByWarehouseIds(@RequestBody Integer[] ids){
        return ResultUtils.success("操作成功",this.warehouseService.deleteByWarehouseIds(ids));
    }
}
