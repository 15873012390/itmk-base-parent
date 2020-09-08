package com.itmk.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;

import com.itmk.system.entity.mybatis.Contacts;
import com.itmk.system.service.ContactsService;
import com.itmk.system.vo.AdvancedQueryContactsDataVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vo.ParmVo;

import java.util.Arrays;

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
    * 查询全部联系人
    * */
    /*@GetMapping(value = "query_all_contacts")
    public ResultVo getAllContacts(ParmVo parm){
        //分页
        IPage<com.itmk.system.entity.Contacts> page=new Page<>();
        page.setCurrent(parm.getCurrentPage());
        page.setSize(parm.getpageSize());
        IPage<com.itmk.system.entity.Contacts> contactsIPage=contactsService.page(page);
        return ResultUtils.success("查询联系人成功",contactsIPage);
    }*/

    /**
     * 查询所有联系人
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_all_contacts")
    public ResultVo queryAllContacts(Integer currentPage, Integer pageSize){
        return ResultUtils.success("查询成功",this.contactsService.queryAllContacts(currentPage,pageSize));
    }

    /*
    * 新增联系人
    * */
    @RequestMapping(value = "addContacts",method = RequestMethod.POST)
    public ResultVo addContacts(@RequestBody com.itmk.system.entity.Contacts contacts){
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
    public ResultVo updateContacts(@RequestBody com.itmk.system.entity.Contacts contacts){
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
    @DeleteMapping(value = "delete_contacts_by_id")
    public ResultVo deleteContactsById(Integer conId){
        boolean b=contactsService.removeById(conId);
        if(b){
            return ResultUtils.success("删除联系人成功");
        }else{
            return ResultUtils.error("删除联系人失败");
        }
    }

    /**
     * 根据数据查询联系人
     * @param sex
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/query_contacts_by_sex")
    public ResultVo queryContactsBySex(String sex,Integer currentPage, Integer pageSize){
        QueryWrapper<com.itmk.system.entity.Contacts> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(com.itmk.system.entity.Contacts::getConSex,sex);
        IPage<com.itmk.system.entity.Contacts> page=new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        IPage<com.itmk.system.entity.Contacts> contactsIPage=contactsService.page(page,queryWrapper);
        return ResultUtils.success("查询联系人成功",contactsIPage);
    }


    /**
     * 根据id搜索联系人
     * @param id
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/search_contacts_by_id")
    public ResultVo searchContactsById(Integer id,Integer currentPage, Integer pageSize){
        QueryWrapper<com.itmk.system.entity.Contacts> query=new QueryWrapper();
        query.lambda().eq(com.itmk.system.entity.Contacts::getConId,id);
        IPage<com.itmk.system.entity.Contacts> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        IPage<com.itmk.system.entity.Contacts> contactsIPage=contactsService.page(page,query);
        return ResultUtils.success("查询成功",contactsIPage);
    }


    /**
     * 通过id查找联系人
     * @param id
     * @return
     */
    @GetMapping("/query_contacts_by_id")
    public ResultVo queryContactsById(Integer id){
        Contacts contacts=contactsService.queryContactsById(id);
        log.info("sss",contacts);
        return ResultUtils.success("查询成功",contacts);
    }



    /**
     * 根据名称模糊搜索联系人
     * @param name
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ResponseBody
    @GetMapping("/query_contacts_by_name")
    public ResultVo queryContactsByName(String name,Integer currentPage, Integer pageSize){
        QueryWrapper<com.itmk.system.entity.Contacts> query=new QueryWrapper();
        query.lambda().like(com.itmk.system.entity.Contacts::getConName,name);
        IPage<com.itmk.system.entity.Contacts> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        IPage<com.itmk.system.entity.Contacts> contactsIPage=contactsService.page(page,query);
        return ResultUtils.success("查询成功",contactsIPage);
    }

    /**
     * 添加/修改联系人
     * @param contacts
     * @return
     */
    @PostMapping("/add_and_update_contacts") //restful风格
    public ResultVo addAndUpdateCustomer(@RequestBody Contacts contacts){
        this.contactsService.saveContacts(contacts);
        return ResultUtils.success("操作成功");
    }

    /*
     * 通过ids批量删除联系人
     * */
    @DeleteMapping(value = "delete_contacts_byids")
    public ResultVo deleteContactsByIds(Integer[] conIds){
        boolean b=contactsService.removeByIds(Arrays.asList(conIds));
        if(b){
            return ResultUtils.success("删除联系人成功");
        }else{
            return ResultUtils.error("删除联系人失败");
        }
    }

    /**
     * 高级查询联系人
     * @param advancedQueryContactsDataVo
     * @return
     */
    @PostMapping("/query_contacts_senior")
    public ResultVo queryContactsSenior(@RequestBody AdvancedQueryContactsDataVo advancedQueryContactsDataVo){

        return ResultUtils.success("操作成功",this.contactsService.queryContactsSenior(advancedQueryContactsDataVo));
    }
}
