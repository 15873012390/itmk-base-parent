package com.itmk.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.Warehouse;
import com.itmk.system.vo.Pager;
import com.itmk.system.vo.WarehouseAdvancedSearch;

import java.util.List;

/**
 * 仓库列表接口
 */
public interface WarehouseService extends IService<Warehouse> {
    //查询所有仓库
    public List<Warehouse> queryAllWarehouse();
    //查询所有仓库（分页）
    public Pager<Warehouse> queryAllWarehouseByPage(Integer currentPage, Integer pageSize);
    //通过下拉框数据查询仓库列表
    public Pager<Warehouse> querySelectOrInputWarehouse(String value,String input,String select,Integer curpage,Integer pagesize);
    //高级搜索仓库
    public Pager<Warehouse> queryByAdvanced(WarehouseAdvancedSearch wareHouseAdvancedSearch);
    //保存或编辑仓库
    public void addOreditWarehouse(Warehouse warehouse);
    //通过仓库id查询仓库
    public Warehouse queryByWarehouseId(Integer warehouseId);
    //通过ids[]批量删除仓库
    public String deleteByWarehouseIds(Integer[] ids);
    //通过id批量删除仓库
    public String deleteByWarehouseId(Integer id);
}
