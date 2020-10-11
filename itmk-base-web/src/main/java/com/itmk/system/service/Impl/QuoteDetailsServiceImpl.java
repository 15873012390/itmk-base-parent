package com.itmk.system.service.Impl;

import com.itmk.system.entity.Quote;
import com.itmk.system.entity.Quotedetails;
import com.itmk.system.mapper.QuoteDetailsDao;
import com.itmk.system.mapper.jpa.JpaQuoteDao;
import com.itmk.system.mapper.jpa.JpaQuoteDetailsDao;
import com.itmk.system.service.QuoteDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 廖湘明
 * @data 2020/10/11 1:05
 * @return
 */
@Slf4j
@Service
@Transactional
public class QuoteDetailsServiceImpl implements QuoteDetailsService {
    @Autowired
    private QuoteDetailsDao quoteDetailsDao;
    @Autowired
    private JpaQuoteDetailsDao jpaQuoteDetailsDao;
    @Autowired
    private JpaQuoteDao jpaQuoteDao;
    @Override
    public List<Quotedetails> queryQuoteDetailsByQuoId(Integer quoId) {
        return this.quoteDetailsDao.queryQuoteDetailsByQuoId(quoId);
    }

    @Override
    public void saveQuoteDetails(List<Quotedetails> list) {
        this.jpaQuoteDetailsDao.saveAll(list);
        BigDecimal sum=new BigDecimal(0);
        for(Quotedetails q:list){
            sum=sum.add(q.getMoney());
        }
        Quote quote=this.jpaQuoteDao.findById(list.get(0).getQuote().getQuoId()).get();
        quote.setGrossProfit(quote.getTotalMoney().subtract(sum));
        this.jpaQuoteDao.save(quote);
    }
}
