package com.itmk.system.mapper.jpa;

import com.itmk.system.entity.jpa.JpaCustomer;
import com.itmk.system.entity.mybatis.Customer;
import org.springframework.data.repository.CrudRepository;

public interface LxmJpaCustomerDao2 extends CrudRepository<Customer, Integer> {
}
