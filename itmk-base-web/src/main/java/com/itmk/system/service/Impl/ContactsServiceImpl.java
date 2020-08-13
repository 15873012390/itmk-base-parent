package com.itmk.system.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmk.system.entity.Contacts;
import com.itmk.system.mapper.ContactsMapper;
import com.itmk.system.service.ContactsService;
import org.springframework.stereotype.Service;

@Service
public class ContactsServiceImpl extends ServiceImpl<ContactsMapper, Contacts> implements ContactsService {

}
