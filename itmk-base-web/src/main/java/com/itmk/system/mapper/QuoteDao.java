package com.itmk.system.mapper;

import com.itmk.system.entity.Quote;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *功能描述 报价持久层接口
 * @author 廖湘明
 * @date 2020/10/10
 */
public interface QuoteDao {

    public List<Quote> queryQuoteBySoid(@Param("soId") Integer soId);

    public List<Quote> queryAllByPage();

    public List<Quote> queryAllByLikePage(@Param("select") String select, @Param("input") String input);

    public Quote queryByQuotId(@Param("quoId") Integer quoId);

    //public List<Quote> queryQuoteByAdvancedSearch(JrcQuoteAdvancedQuery quoteAdvancedQuery);

    public List<Quote> PLqueryAllQuote();

    public Quote queryQuoteByAudId(@Param("audId") Integer audId);

    //把报价状态修改成3
    public void PLupdateByQutId(Integer quoId);

    public List<Quote> copyQuote(@Param("quotationNo") String quotationNo);

    //删除销售机会关联删除数据
    public void deleteQuoteBySoid(@Param("soId") Integer soId);

    public void deleteQuoteByQuoId(@Param("quoId") Integer quoId);

    /*刷新报价数据*/
    public List<Quote> flashQuoteBysoid(@Param("soId") Integer soId);

}
