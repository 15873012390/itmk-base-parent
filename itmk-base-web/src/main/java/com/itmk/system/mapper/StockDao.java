package com.itmk.system.mapper;

import com.itmk.system.entity.Stock;

import com.itmk.system.entity.Warehouse;
import com.itmk.system.vo.CountPieVo;
import com.itmk.system.vo.StockAdvancedSearchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 库存持久层接口
 */
public interface StockDao {
    //查询所有库存
    public List<Stock> queryAllStock();
    //产品详情页上 统计每个仓库还有多少库存
    public List<CountPieVo> queryByStock();
    //通过库存id查詢库存
    public Stock queryStockByStockId(Integer stockId);
    //通过下拉框数据查询仓库
    public List<Stock> queryStockBySearch(@Param("value") String value, @Param("input") String input, @Param("select") String select);
    //高级查询库存列表
    public List<Stock> queryStockByAdvanced(StockAdvancedSearchVo sds);
    //清除数据为0的库存
    public int removeStockisZero();
    //通过仓库id和规格id查询库存
    public Stock queryStockByWarehouseAndSpeId(Integer speId,Integer warehouseId);
    //通过规格id查询库存
    public Stock queryQuantityBySpeId(Integer speId);
}
