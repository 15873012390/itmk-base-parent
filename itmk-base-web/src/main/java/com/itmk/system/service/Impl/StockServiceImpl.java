package com.itmk.system.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.Stock;
import com.itmk.system.entity.Warehouse;
import com.itmk.system.entity.Warehouseallocationdetail;
import com.itmk.system.mapper.StockDao;
import com.itmk.system.mapper.WarehouseDao;
import com.itmk.system.service.StockService;
import com.itmk.system.vo.Pager;
import com.itmk.system.vo.StockAdvancedSearchVo;
import com.itmk.system.vo.StockNumberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StockServiceImpl implements StockService {
    @Autowired
    private StockDao stockDao;
    @Autowired
    private WarehouseDao warehouseDao;
    @Override
    public Pager<Stock> queryAllStock(Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PageInfo<Stock> pager = new PageInfo<>(stockDao.queryAllStock());
        return new Pager<Stock>(pager.getTotal(),pager.getList());
    }

    @Override
    public Stock queryStockByStockId(Integer stockId) {
        return this.stockDao.queryStockByStockId(stockId);
    }

    @Override
    public Pager<Stock> queryStockBySearch(String value, String input, String select, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PageInfo<Stock> pager = new PageInfo<>(this.stockDao.queryStockBySearch(value,"%"+input.trim()+"%",select));
        return new Pager<Stock>(pager.getTotal(),pager.getList());
    }

    @Override
    public Pager<Stock> queryStockByAdvanced(StockAdvancedSearchVo sds) {
        PageHelper.startPage(sds.getCurrentPage(),sds.getPageSize());
        PageInfo<Stock> pager = new PageInfo<>(this.stockDao.queryStockByAdvanced(sds));
        return new Pager<Stock>(pager.getTotal(),pager.getList());
    }

    @Override
    public int removeStockisZero() {
        return this.stockDao.removeStockisZero();
    }

    @Override
    /**
     * 根据规格和仓库查库存
     * @param warehouseallocationdetails
     * @return
     */
    public Map<String,Object> queryByAllWarehouse(List<Warehouseallocationdetail> warehouseallocationdetails){
        List list = new ArrayList();
        Map<String,Object> map=new HashMap<>();
        List<Warehouse> warehouses = this.warehouseDao.queryAllByPage();
        map.put("warehouses",warehouses);
        if(warehouses!=null){
            for(Warehouseallocationdetail i : warehouseallocationdetails){
                StockNumberVo stockNumberVo = new StockNumberVo();
                stockNumberVo.setProName(i.getProductspecification().getProName());
                stockNumberVo.setDnumber(i.getWadQuantity());
                List list2= new ArrayList();
                for(Warehouse w:warehouses){
                    Stock stock = this.stockDao.queryStockByWarehouseAndSpeId(i.getProductspecification().getSpeId(),w.getWarehouseId());
                    if(stock!=null){
                        list2.add(stock.getStockQuantity());
                    }else{
                        list2.add(0);
                    }
                }
                stockNumberVo.setPnumber(list2);
                list.add(stockNumberVo);
            }
            map.put("list",list);
        }
        return map;
    }

    @Override
    public Stock queryQuantityBySpeId(Integer speId) {
        return this.stockDao.queryQuantityBySpeId(speId);
    }

}
