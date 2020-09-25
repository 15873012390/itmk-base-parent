package com.itmk.system.service;


import com.itmk.system.entity.Outstock;
import com.itmk.system.vo.OutStockAdvancedSearch;
import com.itmk.system.vo.Pager;


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
}
