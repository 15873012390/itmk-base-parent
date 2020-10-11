package com.itmk.system.mapper.jpa;

import com.itmk.system.entity.Quotedetails;
import org.springframework.data.repository.CrudRepository;

/**
 * 报价详情JPA持久层接口
 * @author 廖湘明
 * @data 2020/10/11 9:46
 * @return
 */
public interface JpaQuoteDetailsDao extends CrudRepository<Quotedetails,Integer> {
}
