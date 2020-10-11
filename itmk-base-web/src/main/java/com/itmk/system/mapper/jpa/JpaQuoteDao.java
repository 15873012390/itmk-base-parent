package com.itmk.system.mapper.jpa;

import com.itmk.system.entity.Quote;
import org.springframework.data.repository.CrudRepository;

/**
 * 报价JPA持久层
 * @author 廖湘明
 * @data 2020/10/11 0:06
 * @return
 */
public interface JpaQuoteDao extends CrudRepository<Quote,Integer> {
}
