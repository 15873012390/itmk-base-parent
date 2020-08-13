package com.itmk.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;

import com.itmk.system.entity.Contacts;
import com.itmk.system.service.ContactsService;
import com.itmk.system.vo.ContactsVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 联系人管理控制器
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/contacts")
public class ContactsController {
    @Autowired
    private ContactsService contactsService;

    /*
    * 查询联系人（模糊查询，分页)
    * */
    @RequestMapping(value = "getContactsList",method = RequestMethod.POST)
    public ResultVo getContactsList(@RequestBody ContactsVo parm){
        //条件构造器
        QueryWrapper<Contacts> queryWrapper=new QueryWrapper<>();
        if(StringUtils.isNotBlank(parm.getConName())){
            queryWrapper.lambda().like(Contacts::getConName,parm.getConName());
        }
        if(StringUtils.isNotBlank(parm.getConMobile())){
            queryWrapper.lambda().like(Contacts::getConMobile,parm.getConMobile());
        }
        if(StringUtils.isNotBlank(parm.getConTel())){
            queryWrapper.lambda().like(Contacts::getConTel,parm.getConTel());
        }
        //分页
        IPage<Contacts> page=new Page<>();
        page.setCurrent(parm.getCurrentPage());
        page.setSize(parm.getPageSize());
        IPage<Contacts> contactsIPage=contactsService.page(page,queryWrapper);
        return ResultUtils.success("查询联系人成功",contactsIPage);
    }

    /*
    * 新增联系人
    * */
    @RequestMapping(value = "addContacts",method = RequestMethod.POST)
    public ResultVo addContacts(@RequestBody Contacts contacts){
        boolean b=contactsService.save(contacts);
        if(b){
            return ResultUtils.success("新增联系人成功");
        }else{
            return ResultUtils.error("新增联系人失败");
        }
    }
    /*
    * 编辑联系人
    * */
    @RequestMapping(value = "updateContacts",method = RequestMethod.POST)
    public ResultVo updateContacts(@RequestBody Contacts contacts){
        boolean b=contactsService.updateById(contacts);
        if(b){
            return ResultUtils.success("编辑联系人成功");
        }else{
            return ResultUtils.error("编辑联系人失败");
        }
    }
    /*
    * 通过id删除联系人
    * */
    @RequestMapping(value = "deleteContactsById",method = RequestMethod.POST)
    public ResultVo deleteContactsById(@RequestBody Contacts contacts){
        boolean b=contactsService.removeById(contacts.getConId());
        if(b){
            return ResultUtils.success("删除联系人成功");
        }else{
            return ResultUtils.error("删除联系人失败");
        }
    }
}
