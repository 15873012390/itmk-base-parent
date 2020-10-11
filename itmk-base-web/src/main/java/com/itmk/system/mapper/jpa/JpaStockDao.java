package com.itmk.system.mapper.jpa;


import com.itmk.system.entity.Stock;
import org.springframework.data.repository.CrudRepository;

public interface JpaStockDao extends CrudRepository<Stock,Integer> {
}
