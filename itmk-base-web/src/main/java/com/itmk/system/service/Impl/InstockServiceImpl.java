package com.itmk.system.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.Customer;
import com.itmk.system.entity.Instock;
import com.itmk.system.entity.Product;
import com.itmk.system.mapper.InstockDao;
import com.itmk.system.mapper.ProductDao;
import com.itmk.system.service.InstockService;
import com.itmk.system.vo.InstockAdvancedSearchVo;
import com.itmk.system.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 廖湘明
 * @data 2020/9/22 15:49
 * @return
 */
@Service
@Transactional
public class InstockServiceImpl implements InstockService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private InstockDao instockDao;
    /**
     * 查询全部产品
     * @return
     */
    public List<Product> queryAllProductByInstockDetail(){
        return this.productDao.queryAllProduct();
    }

    @Override
    /**
     * 分页查询所有的入库
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Pager<Instock> queryAllInstockByPage(Integer currentPage, Integer pageSize){
        List<Instock> list1 = this.instockDao.selectAllInstock();
        List list2 = new ArrayList();
        for(int i = 0; i < pageSize; i ++){
            int index = (currentPage - 1) * pageSize + i;
            if(index<list1.size()) {
                if(list1.get(index)!=null) {
                    list2.add(list1.get(index));
                }
            }
        }
        return new Pager<Instock>(list1.size(),list2);
    }

    @Override
    public Pager<Instock> querySelectAndInputByPage(String value, String input, String select, Integer currentPage, Integer pageSize) {
        List<Instock> clist2 = this.instockDao.querySelectAndInputByPage(value,"%"+input.trim()+"%",select);
        List list2 = new ArrayList();
        for (int i = 0; i < pageSize; i++) {
            //得到要显示的数据的下标
            int index = (currentPage - 1) *pageSize + i;
            if (index < clist2.size()) {
                if (clist2.get(index) != null) {
                    list2.add(clist2.get(index));
                }
            }
        }
        return new Pager<Instock>(clist2.size(), list2);
    }

    @Override
    public Pager<Instock> queryInstockByAdvancedSearch(InstockAdvancedSearchVo ias) {
        if(ias.getFillTime()!=null && ias.getFillTime().length!=0){
            ias.setS1(ias.getFillTime()[0]);
            ias.setS2(ias.getFillTime()[1]);
        }
        if(ias.getExecutionTime()!=null && ias.getExecutionTime().length!=0){
            ias.setS3(ias.getExecutionTime()[0]);
            ias.setS4(ias.getExecutionTime()[1]);
        }
        List<Instock> list = this.instockDao.queryInstockByAdvancedSearch(ias);
        List list2 = new ArrayList();
        for (int i = 0; i < ias.getPageSize(); i++) {
            //得到要显示的数据的下标
            int index = (ias.getCurrentPage() - 1) * ias.getPageSize() + i;
            if (index < list.size()) {
                if (list.get(index) != null) {
                    list2.add(list.get(index));
                }
            }
        }
        return new Pager<Instock>(list.size(), list2);
    }
}
