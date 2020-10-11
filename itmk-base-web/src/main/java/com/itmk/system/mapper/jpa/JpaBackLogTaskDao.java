package com.itmk.system.mapper.jpa;

import com.itmk.system.entity.Backlogtask;
import org.springframework.data.repository.CrudRepository;

/**
 *功能描述 待办任务JPA持久层接口
 * @author 廖湘明
 * @date 2020/10/10
 */
public interface JpaBackLogTaskDao extends CrudRepository<Backlogtask,Integer> {

}
