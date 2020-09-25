package com.itmk.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itmk.system.entity.Warehouse;
import com.itmk.system.vo.WarehouseAdvancedSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 仓库列表，dao层接口
 */
public interface WarehouseDao extends BaseMapper<Warehouse> {

    //查询所有仓库
    public List<Warehouse> queryAllWarehouse();
    //通过下拉框数据查询仓库
    public List<Warehouse> querySelectOrInput(@Param("value") String value, @Param("input") String input, @Param("select") String select);
    //高级搜索仓库
    public List<Warehouse> queryByAdvanced(WarehouseAdvancedSearch wareHouseAdvancedSearch);
    //通过id搜索仓库
    public  Warehouse queryByWarehouseId(@Param("warehouseId") Integer warehouseId);
    //查询所有仓库
    public List<Warehouse> queryAllByPage();
}
