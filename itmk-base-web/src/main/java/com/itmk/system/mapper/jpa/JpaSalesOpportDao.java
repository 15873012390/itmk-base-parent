package com.itmk.system.mapper.jpa;

import com.itmk.system.entity.Salesopport;
import org.springframework.data.repository.CrudRepository;

/**
 * 商机jpa持久层接口
 * @author 廖湘明
 * @data 2020/10/10 14:59
 * @return
 */
public interface JpaSalesOpportDao extends CrudRepository<Salesopport,Integer> {
}
