package com.itmk.system.mapper.jpa;

import com.itmk.system.entity.mybatis.Contacts;
import org.springframework.data.repository.CrudRepository;

public interface LxmJpaContactsDao extends CrudRepository<Contacts,Integer> {
}
