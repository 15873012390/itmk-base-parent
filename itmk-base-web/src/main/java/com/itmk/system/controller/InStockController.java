package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.service.InstockService;
import com.itmk.system.vo.InstockAdvancedSearchVo;
import com.itmk.system.vo.StockAdvancedSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/api/Instock")
/**
 *功能描述 入库业务接口
 * @author 廖湘明
 * @date 2020/9/22
 */
public class InStockController {

    @Autowired//注入库存业务接口
    private InstockService instockService;

    /**
     *功能描述 查询所有产品
     * @author 廖湘明
     * @date 2020/9/22
     * @param
     * @return
     */
    @GetMapping("/queryAllProductByInstockDetail")
    public ResultVo queryAllProductByInstockDetail(){
        return ResultUtils.success("查询成功",this.instockService.queryAllProductByInstockDetail());
    }
    /**
     *功能描述 分页查询所有入库
     * @author 廖湘明
     * @date 2020/9/24
     * @param
     * @return
     */
    @GetMapping("/queryAllInstockByPage")
    public ResultVo queryAllInstockByPage(Integer currentPage,Integer pageSize){
        return ResultUtils.success("查询成功",this.instockService.queryAllInstockByPage(currentPage,pageSize));
    }
    /**
     *功能描述 通过下拉框数据查询入库
     * @author 廖湘明
     * @date 2020/9/24
     * @param
     * @return
     */
    @GetMapping("/queryInstockSelectAndInputByPage")
    public ResultVo queryInstockSelectAndInputByPage(String value, String input, String select, Integer currentPage, Integer pageSize){
        return ResultUtils.success("查询成功",this.instockService.querySelectAndInputByPage(value, input, select, currentPage, pageSize));
    }
    /**
     *功能描述 高级查询
     * @author 廖湘明
     * @date 2020/9/25
     * @param
     * @return
     */
    @PostMapping("/queryInstockByAdvancedSearch")
    public ResultVo queryInstockByAdvancedSearch(@RequestBody InstockAdvancedSearchVo ias){
        return ResultUtils.success("查询成功",this.instockService.queryInstockByAdvancedSearch(ias));
    }
}
