package com.itmk.system.service.Impl;

import com.itmk.system.entity.*;
import com.itmk.system.entity.mybatis.Customer;
import com.itmk.system.mapper.*;
import com.itmk.system.service.BackLogTaskService;
import com.itmk.system.service.SalesOpportDetailsService;
import com.itmk.system.vo.Pager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 廖湘明
 * @data 2020/10/10 17:43
 * @return
 */
@Slf4j
@Service
@Transactional
public class SalesOpportDetailsServiceImpl implements SalesOpportDetailsService {
    @Autowired
    private SalesOpportDao salesOpportDao;
    @Autowired
    private ClientdemandDao clientdemandDao;
    @Autowired
    private QuoteDao quoteDao;
    @Autowired
    private SolutionDao solutionDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private BackLogTaskService backLogTaskService;
    @Override
    public Map querySalesOpportAndCustomeDetails(Integer soId) {
        Map map=new HashMap();
        Salesopport salesopport=this.salesOpportDao.queryBySoid(soId);
        List<Clientdemand> clientdemands=this.clientdemandDao.queryClientdemandBySoid(soId);
        List<Quote> quotes=this.quoteDao.queryQuoteBySoid(soId);
        List<Solution> solutions=this.solutionDao.querySolutionBySoid(soId);
        Customer customer=this.customerDao.queryContactByCusid(salesopport.getCustomer().getCusId());
        Pager<Backlogtask> pager=this.backLogTaskService.queryAllBackLogTaskByCusId(salesopport.getCustomer().getCusId(),1,5);
        map.put("salesopport",salesopport);

        map.put("clientdemands",clientdemands);
        map.put("quotes",quotes);
        map.put("solutions",solutions);
        map.put("backlogtasks",pager);
        map.put("customer",customer);
        return map;
    }
    /**
     * 刷新销售机会数据
     * @param soId
     * @return
     */
    public Salesopport pushSalesOpport(Integer soId){
        return this.salesOpportDao.queryBySoid(soId);
    }
}
