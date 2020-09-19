package com.itmk.system.entity.jpa;

import com.itmk.system.entity.Warehouse;
import org.springframework.data.repository.CrudRepository;

public interface JpaWarehouseDao extends CrudRepository<Warehouse,Integer> {
}
