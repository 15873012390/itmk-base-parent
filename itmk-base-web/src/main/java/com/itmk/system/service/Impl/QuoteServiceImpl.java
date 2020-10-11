package com.itmk.system.service.Impl;

import com.itmk.system.entity.Quote;
import com.itmk.system.entity.Quotedetails;
import com.itmk.system.mapper.QuoteDao;
import com.itmk.system.mapper.QuoteDetailsDao;
import com.itmk.system.mapper.SalesOpportDao;
import com.itmk.system.mapper.jpa.JpaQuoteDao;
import com.itmk.system.mapper.jpa.JpaQuoteDetailsDao;
import com.itmk.system.service.QuoteService;
import com.itmk.system.vo.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 廖湘明
 * @data 2020/10/11 0:02
 * @return
 */
@Slf4j
@Service
@Transactional
public class QuoteServiceImpl implements QuoteService {
    @Autowired
    private QuoteDao quoteDao;
    @Autowired
    private JpaQuoteDao jpaQuoteDao;
    @Autowired
    private SalesOpportDao salesOpportDao;
    @Autowired
    private QuoteDetailsDao quoteDetailsDao;
    @Autowired
    private JpaQuoteDetailsDao jpaQuoteDetailsDao;
    @Override
    public void addQuote(Quote quote) {
        if(this.quoteDao.queryByQuotId(quote.getQuoId())==null){
            quote.setAudit(null);
            quote.setAuditStatus(1);
            quote.setQuotationNo(UUID.getNewNo("Q"));

            if(quote.getSalesopport().getSoId()==0){
                quote.setSalesopport(null);
            }
            Quote q=this.jpaQuoteDao.save(quote);
            if(q.getSalesopport()!=null){
                this.salesOpportDao.updateSales(q.getSalesopport().getSoId(),"商务谈判");
            }

        }else{
            Quote q=this.quoteDao.queryByQuotId(quote.getQuoId());
            if(quote.getAudit().getAudId()==0){
                quote.setAudit(null);
            }
            if(q.getTotalMoney().compareTo(quote.getTotalMoney())!=0){
                List<Quotedetails> list=this.quoteDetailsDao.queryQuoteDetailsByQuoId(quote.getQuoId());
                BigDecimal sum=new BigDecimal(0);
                for(Quotedetails qs:list){
                    System.out.println(qs.toString());
                    sum=sum.add(qs.getMoney());
                }
                quote.setGrossProfit(list.size()==0?new BigDecimal(0):quote.getTotalMoney().subtract(sum));

            }
            this.jpaQuoteDao.save(quote);
        }
    }

    @Override
    public List<Quote> flashQuoteBysoid(Integer soId) {
        return this.quoteDao.flashQuoteBysoid(soId);
    }

    @Override
    public Quote queryByQuoId(Integer quoId) {
        return this.quoteDao.queryByQuotId(quoId);
    }

    @Override
    public void deleteByQuoId(Integer quoId) {
        List<Quotedetails> list=this.quoteDetailsDao.queryQuoteDetailsByQuoId(quoId);
        this.jpaQuoteDetailsDao.deleteAll(list);
        this.quoteDao.deleteQuoteByQuoId(quoId);
    }
}
