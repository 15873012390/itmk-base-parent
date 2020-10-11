package com.itmk.system.mapper.jpa;

import com.itmk.system.entity.Stagelog;
import org.springframework.data.repository.CrudRepository;

/**
 * 阶段日志jpa持久层接口
 * @author 廖湘明
 * @data 2020/10/10 15:01
 * @return
 */
public interface JpaStagelogDao extends CrudRepository<Stagelog,Integer> {
}
