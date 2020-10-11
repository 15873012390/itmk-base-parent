package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Warehouseallocation;
import com.itmk.system.service.InstockService;
import com.itmk.system.service.WarehouseallocationService;
import com.itmk.system.vo.WarehouseallocationAdvancedSearchVo;
import com.itmk.system.vo.WarehouseallocationdetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 仓库调拨控制层
 * @author 廖湘明
 * @data 2020/9/21 15:18
 * @return
 */
@Slf4j
@RestController
@RequestMapping("/api/Warehouseallocation")
public class WarehouseallocationController {
    @Autowired
    private WarehouseallocationService warehouseallocationService;
    @Autowired
    private InstockService instockService;
    /**
     *功能描述 查询所有调拨
     * @author 廖湘明
     * @date 2020/9/21
     * @param
     * @return
     */
    @GetMapping("/selectWaByPage")
    public ResultVo selectWaByPage(Integer currentPage,Integer pageSize){
        return ResultUtils.success("查询成功",this.warehouseallocationService.selectWaByPage(currentPage,pageSize));
    }
    /**
     *功能描述 通过下拉框搜索值查询所有记录列表
     * @author 廖湘明
     * @date 2020/9/21
     * @param
     * @return
     */
    @GetMapping("/queryWarehouseallocationBySelectAndInput")
    public ResultVo queryWarehouseallocationBySelectAndInput(String value,String input,String select,Integer currentPage,Integer pageSize){
        return  ResultUtils.success("查询成功",this.warehouseallocationService.queryBySelectAndInput(value, input, select, currentPage, pageSize));
    }

    /**
     *功能描述 高级查询调拨记录
     * @author 廖湘明
     * @date 2020/9/22
     * @param
     * @return
     */
    @PostMapping("/queryWasehouseAllocationConditionByPage")
    public ResultVo queryWasehouseAllocationConditionByPage(@RequestBody WarehouseallocationAdvancedSearchVo wws){
        return  ResultUtils.success("查询成功",this.warehouseallocationService.queryByAdvanced(wws));
    }
    /**
     *功能描述 编辑和添加
     * @author 廖湘明
     * @date 2020/9/22
     * @param
     * @return
     */
    @PostMapping("/addAndEditWahouseallocation")
    public ResultVo addAndEditWahouseallocation(@RequestBody Warehouseallocation warehouseallocation){
        this.warehouseallocationService.addAndEditWahouseallocation(warehouseallocation);
        return ResultUtils.success("操作成功");
    }

    /**
     *功能描述 通过仓库id查询调拨记录
     * @author 廖湘明
     * @date 2020/9/22
     * @param
     * @return
     */
    @GetMapping("/queryWaByWaId")
    public ResultVo queryWaByWaId(Integer waId){
        return ResultUtils.success("查询成功",this.warehouseallocationService.queryWaByWaId(waId));
    }
    /**
     *功能描述 通过id删除调拨记录
     * @author 廖湘明
     * @date 2020/9/22
     * @param
     * @return
     */
    @DeleteMapping("/deleteWaByWaId")
    public ResultVo deleteWaByWaId(Integer waId){
        this.warehouseallocationService.deleteWaByWaId(waId);
        return ResultUtils.success("操作成功");
    }
    /**
     *功能描述 添加或修改
     * @author 廖湘明
     * @date 2020/9/24
     * @param
     * @return
     */
    @PostMapping("/addAndEditWad")
    public ResultVo addAndEditWad(@RequestBody WarehouseallocationdetailVo warehouseallocationdetailVo){
        this.warehouseallocationService.addAndEditWad(warehouseallocationdetailVo);
        return ResultUtils.success("操作成功");
    }
    /**
     *功能描述 执行库管确认操作
     * @author 廖湘明
     * @date 2020/9/26
     * @param
     * @return
     */
    @GetMapping("/toConfirm")
    public ResultVo toConfirm(Integer waId,Integer type,Integer uId){
        log.info("ssss"+waId+"sss"+uId);
        this.warehouseallocationService.toConfirm(waId,type,uId);
        return ResultUtils.success("操作成功");
    }

    /**
     *功能描述 执行库存调拨操作
     * @author 廖湘明
     * @date 2020/9/26
     * @param
     * @return
     */
    @GetMapping("/toOutAndInStock")
    public String toOutAndInStock(Integer waId,String uName){
        return warehouseallocationService.toOutAndInStock(waId,uName);
    }

    /**
     *功能描述 撤销库存调拨操作
     * @author 廖湘明
     * @date 2020/9/26
     * @param
     * @return
     */
    @GetMapping("/removeWaStatus")
    public String removeWaStatus(Integer waId){
        return warehouseallocationService.removeWaStatus(waId);
    }
}
