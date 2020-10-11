package com.itmk.system.service.Impl;

import com.itmk.system.entity.Orderdetail;
import com.itmk.system.entity.Orders;
import com.itmk.system.entity.Outstock;
import com.itmk.system.entity.Outstockdetails;
import com.itmk.system.mapper.OrdersDao;
import com.itmk.system.mapper.OutstockDao;
import com.itmk.system.service.OustStockService;
import com.itmk.system.vo.OutStockAdvancedSearch;
import com.itmk.system.vo.Pager;
import com.itmk.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private OrdersDao ordersDao;
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

    @Override
    public List<Orders> queryAllNoOutStock() {
        return this.ordersDao.queryAllNoOutStock();
    }

    @Override
    public Integer editAndUpdateOutStock(Outstock outstock) {
        if (outstock.getOutId() == 0) {
            if(outstock.getTitle()==null||outstock.getTitle()==""){
                Date date = new Date();
                //设置要获取到什么样的时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                //获取String类型的时间
                String createdate = sdf.format(date);
                outstock.setTitle(createdate+"出库需求");
            }
            outstock.setStatus("未出库");
            outstock.setOutNumber(UUIDUtils.getId());
            this.outstockDao.insertOutstock(outstock);
            if (outstock.getOrders() != null && outstock.getOrders().getOrdId() != 0) {
                Orders order = this.ordersDao.queryOrderdetailByOrdId(outstock.getOrders().getOrdId());
                Outstock outstock1 = this.outstockDao.queryOutstockByOutId(outstock.getOutId());
                outstock1.setCustomer(order.getCustomer());
                outstock1.setOrdNumber(order.getOrdNumber());
                Date date = new Date();
                //设置要获取到什么样的时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                //获取String类型的时间
                String createdate = sdf.format(date);
                outstock1.setRemarks(createdate+"加入订单");
                this.outstockDao.updateOutStock(outstock1);
                Outstockdetails od = new Outstockdetails();
                //循环遍历订单详情放入出库详情
                for (Orderdetail o : order.getOrderdetail()) {
                    od.setProductspecification(o.getProductspecification());
                    od.setOsdNumber(o.getDetNumber());
                    od.setStatus("未出库");
                    od.setOutstock(outstock);
                    this.outstockDao.insertOutStockDetails(od);
                }
                order.setOutStatus("进行出库");
                this.ordersDao.updateOrders(order);
            }
            return outstock.getOutId();
        } else {
            this.outstockDao.updateOutStock(outstock);
            return outstock.getOutId();
        }
    }

    /**
     * 根据出库ID查询出库
     *
     * @param outId
     * @return
     */
    @Override
    public Outstock queryOutstockByOutId(Integer outId) {
        return this.outstockDao.queryOutstockByOutId(outId);
    }

    @Override
    public List<Outstockdetails> queryAllOutdetailById(Integer outId) {
        return this.outstockDao.queryAllOutdetailById(outId);
    }

    /**
     * 根据出库ID删除出库及详情
     *
     * @param outId
     */
    @Override
    public void deleteOutStockAndDetail(Integer outId) {
        this.outstockDao.deleteOutstockByOutId(outId);
        this.outstockDao.deleteOutstockDetailByOutId(outId);
    }
}
