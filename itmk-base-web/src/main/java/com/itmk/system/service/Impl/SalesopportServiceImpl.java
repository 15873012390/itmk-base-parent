package com.itmk.system.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.Salesopport;
import com.itmk.system.entity.Stagelog;
import com.itmk.system.entity.mybatis.Customer;
import com.itmk.system.mapper.CustomerDao;
import com.itmk.system.mapper.SalesOpportDao;
import com.itmk.system.mapper.StagelogDao;
import com.itmk.system.mapper.jpa.JpaSalesOpportDao;
import com.itmk.system.mapper.jpa.JpaStagelogDao;
import com.itmk.system.service.SalesopportService;
import com.itmk.system.vo.Pager;
import com.itmk.system.vo.SalesOpportAdvancedSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 销售机会业务实现类
 * @author 廖湘明
 * @data 2020/10/10 0:37
 * @return
 */
@Slf4j
@Service
@Transactional
public class SalesopportServiceImpl implements SalesopportService {
    @Autowired
    private SalesOpportDao salesOpportDao;
    @Autowired
    private JpaSalesOpportDao jpaSalesOpportDao;
    @Autowired
    private JpaStagelogDao jpaStagelogDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private StagelogDao stagelogDao;

    @Override
    public List<Salesopport> queryAll() {
        return this.salesOpportDao.queryAll();
    }

    @Override
    public Map queryAllSalesOppoerByPage(Integer currentPage, Integer pageSize) {
        List<Salesopport> sumList=this.salesOpportDao.queryAll();
        PageHelper.startPage(currentPage, pageSize);
        List<Salesopport> slist = this.salesOpportDao.queryAll();
        BigDecimal s=this.sum(sumList);
        PageInfo<Salesopport> pager = new PageInfo<>(slist);
        return this.backDate(pager,s);
    }

    @Override
    public Map querySalesOpportByLikeSearchPage(String value, String inputs, String select, Integer currentPage, Integer pageSize) {
        List<Salesopport> sumList=salesOpportDao.queryByLikeSearch(value,inputs.trim()!=""?"%"+inputs.trim()+"%":"", select);
        PageHelper.startPage(currentPage, pageSize);
        List<Salesopport> list = salesOpportDao.queryByLikeSearch(value,inputs.trim()!=""?"%"+inputs.trim()+"%":"", select);
        PageInfo<Salesopport> pager = new PageInfo<>(list);
        BigDecimal s=this.sum(sumList);
        return this.backDate(pager,s);
    }

    @Override
    public Map querySalesOpportByAdvancedSearch(SalesOpportAdvancedSearchVo s) {
        s.setOpportunitiesThem(s.getOpportunitiesThem().trim()!=""?"%"+s.getOpportunitiesThem().trim()+"%":"");
        List<Salesopport> sumList=salesOpportDao.queryByAdvancedSearch(s);
        PageHelper.startPage(s.getCurrentPage(), s.getPageSize());
        List<Salesopport> list = salesOpportDao.queryByAdvancedSearch(s);
        BigDecimal su=this.sum(sumList);
        PageInfo<Salesopport> pager = new PageInfo<>(list);
        return this.backDate(pager,su);
    }


    /**
     * 添加/编辑销售机会
     * 1.判断传进来的销售机会存不存在  存在则为修改   不存在则为添加
     * 2.修改时 判断有没有更改销售机会的阶段备注或者阶段
     * （a.修改了阶段备注/阶段 则新增一条阶段日志记录和修改销售机会表
     * （b.没有修改则仅仅修改销售机会表
     *
     * @param s
     */
    @Override
    public void addSalesOpport(Salesopport s) {
        Stagelog stagelog = new Stagelog();
        Salesopport s2 = this.salesOpportDao.queryBySoid(s.getSoId());
        if (s2!=null) {
            //编辑
            Salesopport sales=this.jpaSalesOpportDao.save(s);

            if (!((s2.getStage().equals(s.getStage())) &&
                    (s2.getConPhone().equals(s.getConPhone())))) {
                stagelog.setSlNote(s.getConPhone());
                stagelog.setRecordTime(new Timestamp(new Date().getTime()));
                stagelog.setStageName(s.getStage());
                //当前登录员工
                stagelog.setNickName(s.getUser().getNickName());
                stagelog.setSalesopport(sales);
                this.jpaStagelogDao.save(stagelog);
            }
            //新增
        } else {
            Customer c = this.customerDao.queryContactByCusid(s.getCustomer().getCusId());
            s.setUpdateDate(new Timestamp(new Date().getTime()));
            s.setCustomer(c);
            Salesopport saves=this.jpaSalesOpportDao.save(s);
            //Salesopport s2 = salesOpportMDao.queryAll().get(0);
            stagelog.setSlNote(s.getConPhone());
            stagelog.setRecordTime(new Timestamp(new Date().getTime()));
            stagelog.setStageName(s.getStage());

            //操作人 为 当前登录的员工
            stagelog.setNickName(s.getUser().getNickName());

            stagelog.setSalesopport(saves);
            this.jpaStagelogDao.save(stagelog);
        }

    }


    /**
     * 根据销售机会id查找销售机会和销售阶段日志
     *
     * @param soid
     * @return
     */
    @Override
    public Salesopport queryBySoid(Integer soid) {
        return this.salesOpportDao.queryBySoid(soid);
    }


    /**
     * 删除商机机会
     *
     * @param soid
     */
    @Override
    public void delSalesOpport(Integer soid) {
        Salesopport s = this.salesOpportDao.deleteQueryById(soid);
        if(s!=null){
            this.stagelogDao.deleteStageLogBySoid(soid);
            //clientdemandMDao.deleteClientdemandBySoid(soid);
            //solutionMDao.deleteSolutionBySoid(soid);
           /* List<Quote> quotes=quoteMDao.queryQuoteBySoid(soid);
            for(Quote q:quotes){
                quoteDetailsMDao.deleteQuoteDetailsByquoId(q.getQuoId());
            }
            quoteMDao.deleteQuoteBySoid(soid);*/
            this.salesOpportDao.deleteSalesBySoId(soid);
        }

    }

    /**
     *功能描述 批量删除商机
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @Override
    public void delBatchSalesopport(Integer[] soids) {
        for (Integer soid : soids) {
            this.delSalesOpport(soid);
        }
    }

    @Override
    public List<Salesopport> querySalesOpportByCustomer(Customer customer) {
        return this.salesOpportDao.querySalesOpportByCustomer(customer);
    }

    /**
     * 返回数据
     * @param pageInfo
     * @param sum
     * @return
     */
    public static Map backDate(PageInfo pageInfo,BigDecimal sum){
        Map map=new HashMap();
        map.put("sum",sum);
        map.put("list",new Pager<>(pageInfo.getTotal(), pageInfo.getList()));
        return map;
    }
    /**
     * 计算全部数据
     * @param list
     * @return
     */
    public static BigDecimal sum(List<Salesopport> list){
        BigDecimal s=new BigDecimal(0);
        for(Salesopport sa:list){
            s=(s.add(sa.getAmount()==null?new BigDecimal(0):sa.getAmount())).setScale(2);
        }
        return s;
    }
}
