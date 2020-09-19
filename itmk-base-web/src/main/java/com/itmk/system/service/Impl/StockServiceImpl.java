package com.itmk.system.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.Stock;
import com.itmk.system.mapper.StockDao;
import com.itmk.system.service.StockService;
import com.itmk.system.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService {
    @Autowired
    private StockDao stockDao;
    @Override
    public Pager<Stock> queryAllStock(Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Stock> list = stockDao.queryAllStock();
        PageInfo<Stock> pager = new PageInfo<>(list);
        return new Pager<Stock>(pager.getTotal(),pager.getList());
    }
}
