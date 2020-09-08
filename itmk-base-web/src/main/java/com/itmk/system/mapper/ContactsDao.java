package com.itmk.system.mapper;

import com.itmk.system.entity.mybatis.Contacts;
import com.itmk.system.vo.AdvancedQueryContactsDataVo;

import java.util.List;

public interface ContactsDao {
    //通过id查询联系人
    public Contacts queryContactsById(Integer conId);
    //查询所有联系人
    public List<Contacts> queryAllContacts();
    //高级查询联系人
    public List<Contacts> queryContactsSenior(AdvancedQueryContactsDataVo advancedQueryContactsDataVo);
}
