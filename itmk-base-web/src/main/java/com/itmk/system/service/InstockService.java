package com.itmk.system.service;


import com.itmk.system.entity.Instock;
import com.itmk.system.entity.Instockdetail;
import com.itmk.system.entity.Outstock;
import com.itmk.system.entity.Product;
import com.itmk.system.vo.InstockAdvancedSearchVo;
import com.itmk.system.vo.OutStockAdvancedSearch;
import com.itmk.system.vo.Pager;

import java.util.ArrayList;
import java.util.List;

/**
 *功能描述 入库业务接口SSssSSS
 * @author 廖湘明
 * @date 2020/9/22
 * @param
 * @return
 */
public interface InstockService {
    //查询全部产品
    public List<Product> queryAllProductByInstockDetail();
    //分页查询所有的入库
    public Pager<Instock> queryAllInstockByPage(Integer currentPage, Integer pageSize);
    //通过下拉框数据查询入库
    public Pager<Instock> querySelectAndInputByPage(String value, String input, String select,Integer currentPage,Integer pageSize);
    //高级查询
    public Pager<Instock> queryInstockByAdvancedSearch(InstockAdvancedSearchVo iad);
}
