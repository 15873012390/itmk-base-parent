package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.AddBook;
import com.itmk.system.entity.Customer;
import com.itmk.system.entity.SysUser;
import com.itmk.system.service.AddBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 通讯录管理控制器
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/addBook")
public class AddBookController {
    @Autowired
    private AddBookService  addBookService;

    /**
     * 查询所有联系人
     * @return
     */
    @GetMapping("/getAddBookList")
    public ResultVo getAddBookList(){
        return ResultUtils.success("查询通讯录成功",this.addBookService.getAddBookList());

    }

    /**
     * 根据id查询联系人
     * @return
     */
    @GetMapping("/findAddBookById")
    public ResultVo findAddBookById(Integer id){
        return ResultUtils.success("查询成功",addBookService.findAddBookById(id));
    }

    /**
     * 根据ID删除联系人
     * @param id
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/deleteAddBookById", method = RequestMethod.GET)
    public ResultVo deleteAddBookById(Integer id){
        return ResultUtils.success("删除成功",addBookService.deleteAddBookById(id));
    }
    /**
     * 根据姓名查询联系人
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findAddBookByName", method = RequestMethod.GET)
    public ResultVo findAddBookByName(String loginName){
        return  ResultUtils.success("查询成功",addBookService.findAddBookByName(loginName));
    }

    /**
     * 根据部门姓名查询联系人
     * @param
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/findAddBookByDname", method = RequestMethod.GET)
    public ResultVo findAddBookByDname(AddBook record){
        return ResultUtils.success("查询成功",addBookService.findAddBookByDname(record));
    }

    @ResponseBody
    @RequestMapping(value = "/updateAddKey",method = RequestMethod.PUT)
    public ResultVo updateAddKey(@RequestBody AddBook record){
        return ResultUtils.success("更新成功",addBookService.updateAddKey(record));
    }
}
