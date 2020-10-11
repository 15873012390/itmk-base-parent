package com.itmk.system.service;

import com.itmk.system.entity.Quotedetails;

import java.util.List;

/**
 * 报价单详情业务接口
 * @author 廖湘明
 * @data 2020/10/11 1:04
 * @return
 */
public interface QuoteDetailsService {
    //通过报价单id查询报价单详情
    public List<Quotedetails> queryQuoteDetailsByQuoId(Integer quoId);
    //保存明细数据
    public void saveQuoteDetails(List<Quotedetails> list);
}
