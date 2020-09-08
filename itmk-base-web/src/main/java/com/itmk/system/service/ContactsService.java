package com.itmk.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itmk.system.entity.mybatis.Contacts;
import com.itmk.system.vo.AdvancedQueryContactsDataVo;
import com.itmk.system.vo.Pager;

import java.util.List;


/*
 * 联系人管理业务接口
 * */
public interface ContactsService extends IService<com.itmk.system.entity.Contacts> {
    //查询所有联系人
    public Pager<Contacts> queryAllContacts(Integer currentPage, Integer pageSize);
    //通过id查询联系人
    public Contacts queryContactsById(Integer conId);
    //添加/修改联系人
    public void saveContacts(Contacts contacts);
    //高级查询联系人
    public Pager<Contacts> queryContactsSenior(AdvancedQueryContactsDataVo advancedQueryContactsDataVo);

}
