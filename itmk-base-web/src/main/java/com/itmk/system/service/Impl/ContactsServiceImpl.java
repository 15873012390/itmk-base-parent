package com.itmk.system.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.mybatis.Contacts;
import com.itmk.system.mapper.ContactsDao;
import com.itmk.system.mapper.ContactsMapper;
import com.itmk.system.mapper.jpa.LxmJpaContactsDao;
import com.itmk.system.service.ContactsService;
import com.itmk.system.vo.AdvancedQueryContactsDataVo;
import com.itmk.system.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactsServiceImpl extends ServiceImpl<ContactsMapper, com.itmk.system.entity.Contacts> implements ContactsService {
    @Autowired
    private ContactsDao contactsDao;
    @Autowired
    private LxmJpaContactsDao jcontactsDao;

    @Override
    public Pager<Contacts> queryAllContacts(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Contacts> list= contactsDao.queryAllContacts();
        PageInfo<Contacts> pageInfo=new PageInfo<>(list);
        return new Pager<Contacts>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public Contacts queryContactsById(Integer conId) {
        return this.contactsDao.queryContactsById(conId);
    }


    public void saveContacts(Contacts contacts){
        this.jcontactsDao.save(contacts);
    }

    @Override
    public Pager<Contacts> queryContactsSenior(AdvancedQueryContactsDataVo advancedQueryContactsDataVo) {
        PageHelper.startPage(advancedQueryContactsDataVo.getCurrentPage(),advancedQueryContactsDataVo.getPageSize());
        List<Contacts> list= contactsDao.queryContactsSenior(advancedQueryContactsDataVo);
        PageInfo<Contacts> pageInfo=new PageInfo<>(list);
        return new Pager<Contacts>(pageInfo.getTotal(),pageInfo.getList());
    }
}
