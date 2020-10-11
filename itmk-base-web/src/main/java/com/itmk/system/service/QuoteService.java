package com.itmk.system.service;

import com.itmk.system.entity.Quote;

import java.util.List;

/**
 * 报价单业务接口
 * @author 廖湘明
 * @data 2020/10/11 0:02
 * @return
 */
public interface QuoteService {
    //添加报价记录
    public void addQuote(Quote quote);
    //刷新销售机会详情页数据
    public List<Quote> flashQuoteBysoid(Integer soId);
    //根据id查询
    public Quote queryByQuoId(Integer quoId);
    //根据id删除
    public void deleteByQuoId(Integer quoId);
}
