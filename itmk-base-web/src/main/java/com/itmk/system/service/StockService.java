package com.itmk.system.service;

import com.itmk.system.entity.Stock;
import com.itmk.system.vo.Pager;

import java.util.List;

public interface StockService {
    //查询所有库存
    public Pager<Stock> queryAllStock(Integer currentPage,Integer pageSize);
}
