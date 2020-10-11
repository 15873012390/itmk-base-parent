package com.itmk.system.mapper;

import com.itmk.system.entity.Quotedetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *功能描述 报价单详情持久层接口
 * @author 廖湘明
 * @date 2020/10/11
 */
public interface QuoteDetailsDao {

    public List<Quotedetails> queryQuoteDetailsByQuoId(@Param("quoId") Integer quoId);

    public List<Quotedetails> queryAllByPage();

    //PL
    public List<Quotedetails> queryByQuoId(Integer quoid);
    //PL
    public List<Quotedetails> findAllByClaIdId();
    //PL
    public Quotedetails findByQuoteClaIdId(Integer qdid);

    //PL
    public Double PLMOney(Integer quoId);
    public List<Quotedetails> queryLikeQuotedetails(@Param("input") String input);

    //public List<Quotedetails> queryAdvanceQuotedetails(JrcQuoteDetailsAdvance jrcQuoteDetailsAdvance);

    public void deleteQuoteDetailsByquoId(@Param("quoId") Integer quoId);

}
