package com.itmk.system.mapper.jpa;

import com.itmk.system.entity.jpa.JpaCustomer;
import org.springframework.data.repository.CrudRepository;

public interface LxmJpaCustomerDao extends CrudRepository<JpaCustomer, Integer> {
}
