package com.itmk.system.service;

import com.itmk.system.entity.Stock;
import com.itmk.system.entity.Warehouseallocationdetail;
import com.itmk.system.vo.Pager;
import com.itmk.system.vo.StockAdvancedSearchVo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存业务层接口
 */
public interface StockService {
    //查询所有库存
    public Pager<Stock> queryAllStock(Integer currentPage,Integer pageSize);
    //通过库存id查詢库存
    public Stock queryStockByStockId(Integer stockId);
    //通过下拉框数据查询仓库
    public Pager<Stock> queryStockBySearch(String value,String input,String select,Integer currentPage,Integer pageSize);
    //高级查询库存列表
    public Pager<Stock> queryStockByAdvanced(StockAdvancedSearchVo sds);
    //清除数据为0的库存
    public int removeStockisZero();
    //根据规格和仓库查库存
    public Map<String,Object> queryByAllWarehouse(List<Warehouseallocationdetail> warehouseallocationdetails);
    //通过规格id查询库存
    public Stock queryQuantityBySpeId(Integer speId);
}
