package com.itmk.system.service;

import com.itmk.system.entity.Warehouseallocation;
import com.itmk.system.vo.Pager;
import com.itmk.system.vo.WarehouseallocationAdvancedSearchVo;
import com.itmk.system.vo.WarehouseallocationdetailVo;

import java.util.List;

/**
 * 仓库调拨业务接口
 * @author 廖湘明
 * @data 2020/9/21 15:09
 * @return
 */
public interface WarehouseallocationService {
    //查询所有调拨记录
    public Pager<Warehouseallocation> selectWaByPage(Integer currentPage,Integer pageSize);
    //通过下拉框搜索值查询所有记录列表
    public Pager<Warehouseallocation> queryBySelectAndInput(String value,String input,String select,Integer currentPage,Integer pageSize);
    //高级查询调拨记录
    public Pager<Warehouseallocation> queryByAdvanced(WarehouseallocationAdvancedSearchVo waad);
    //插入调拨记录
    public void addAndEditWahouseallocation(Warehouseallocation warehouseallocation);
    //根据仓库调拨ID查询仓库调拨单
    public Warehouseallocation queryWaByWaId(Integer waId);
    //根据仓库调拨ID来删除
    public void deleteWaByWaId(Integer waId);
    //仓库调拨单增加产品详情
    public void addAndEditWad(WarehouseallocationdetailVo warehouseallocationdetailVo);
}
