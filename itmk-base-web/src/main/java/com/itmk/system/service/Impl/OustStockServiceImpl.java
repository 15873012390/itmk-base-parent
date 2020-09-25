package com.itmk.system.service.Impl;

import com.itmk.system.entity.Outstock;
import com.itmk.system.mapper.OutstockDao;
import com.itmk.system.service.OustStockService;
import com.itmk.system.vo.OutStockAdvancedSearch;
import com.itmk.system.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *功能描述 出库业务接口实现类
 * @author 廖湘明
 * @date 2020/9/24
 */
@Service
@Transactional
public class OustStockServiceImpl implements OustStockService {
    @Autowired
    private OutstockDao outstockDao;

    @Override
    public Pager<Outstock> queryAllOutStockByPage(Integer currentPage, Integer pageSize) {
        List<Outstock> list1 = this.outstockDao.queryAllOutstock();
        List list2 = new ArrayList();
        for (int i = 0; i < pageSize; i++) {
            //得到要显示的数据的下标
            int index = (currentPage - 1) * pageSize + i;
            if (index < list1.size()) {
                if (list1.get(index) != null) {
                    list2.add(list1.get(index));
                }
            }
        }
        return new Pager<Outstock>(list1.size(), list2);
    }

    @Override
    public Pager<Outstock> queryOutStockSelectAndInputByPage(String value, String input, String select, Integer currentPage, Integer pageSize) {
        List<Outstock> clist2 = this.outstockDao.queryOutStockSelectAndInputByPage(value, input, select);
        List list2 = new ArrayList();
        for (int i = 0; i < pageSize; i++) {
            //得到要显示的数据的下标
            int index = (currentPage - 1) * pageSize + i;
            if (index < clist2.size()) {
                if (clist2.get(index) != null) {
                    list2.add(clist2.get(index));
                }
            }
        }
        return new Pager<Outstock>(clist2.size(), list2);
    }

    @Override
    public Pager<Outstock> queryOutstockByAdvancedSearch(OutStockAdvancedSearch oas) {
        return null;
    }
}
