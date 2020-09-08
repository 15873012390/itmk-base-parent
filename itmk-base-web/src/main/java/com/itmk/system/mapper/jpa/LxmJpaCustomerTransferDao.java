package com.itmk.system.mapper.jpa;


import com.itmk.system.entity.mybatis.Customertransfer;
import org.springframework.data.repository.CrudRepository;

public interface LxmJpaCustomerTransferDao extends CrudRepository<Customertransfer, Integer> {
}
