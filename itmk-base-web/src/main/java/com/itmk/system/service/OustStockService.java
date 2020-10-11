package com.itmk.system.service;


import com.itmk.system.entity.Orders;
import com.itmk.system.entity.Outstock;
import com.itmk.system.entity.Outstockdetails;
import com.itmk.system.vo.OutStockAdvancedSearch;
import com.itmk.system.vo.Pager;

import java.util.List;


/**
 * 出库业务接口
 * @author 廖湘明
 * @data 2020/9/24 19:59
 * @return
 */
public interface OustStockService {
    //查询所有的出库
    public Pager<Outstock> queryAllOutStockByPage(Integer currentPage, Integer pageSize);
    //通过下拉框数据和值搜索出库
    public Pager<Outstock> queryOutStockSelectAndInputByPage(String value, String input, String select, Integer currentPage, Integer pageSize);
    //高级查询
    public Pager<Outstock> queryOutstockByAdvancedSearch(OutStockAdvancedSearch oas);
    //查询订单所有未出库的订单
    public List<Orders> queryAllNoOutStock();
    //编辑或添加出库单
    public Integer editAndUpdateOutStock(Outstock outstock);
    //根据出库ID查询出库
    public Outstock queryOutstockByOutId(Integer outId);
    //查询所有出库详情单
    public List<Outstockdetails> queryAllOutdetailById(Integer outId);
    //根据出库ID删除出库及详情
    public void deleteOutStockAndDetail(Integer outId);
}
