package com.itmk.system.mapper.jpa;


import com.itmk.system.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface LxmJpaProductDao extends CrudRepository<Product,Integer> {

}
