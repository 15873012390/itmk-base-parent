package com.itmk.system.controller;

import com.itmk.jwt.JwtUtils;
import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Crmoalog;
import com.itmk.system.entity.SysUser;
import com.itmk.system.service.CrmoalogService;
import com.itmk.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Slf4j
@Controller
@RequestMapping(value = "/api/crmoalog")
public class CrmoalogDaoController {
    @Autowired
    private CrmoalogService crmoalogService;
    @Autowired
    private JwtUtils JwtUtils;
    @Autowired
    private UserService UserService;

    /**
     * 插入工作日志
     * @param crmoalog
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "insertSelective", method = RequestMethod.POST)
    public ResultVo  insertSelective(@RequestBody Crmoalog crmoalog, HttpServletRequest HttpServletRequest){
        String username = JwtUtils.getUsernameFromToken(HttpServletRequest.getHeader("token"));
        SysUser user = UserService.getUserByUserName(username);
        crmoalog.setCreateUserId(user.getId());
        return ResultUtils.success("增加成功",crmoalogService.insertSelective(crmoalog));
    }


    /**
     * 根据logId查询工作日志
     * @param logId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "selectByPrimaryKey", method = RequestMethod.GET)
    public ResultVo selectByPrimaryKey(Integer logId){
        log.info("sss"+logId);
        return ResultUtils.success("查询成功",this.crmoalogService.selectByPrimaryKey(logId));
    }

    /**
     * 根据LogId更改日志信息
     * @param crmoalog
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateByPrimaryKeySelective", method = RequestMethod.GET)
    public ResultVo updateByPrimaryKeySelective(Crmoalog crmoalog){

        return ResultUtils.success("更改成功", crmoalogService.updateByPrimaryKeySelective(crmoalog));

    }

    /**
     * 根据LogId删除工作日志
     * @param logId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteByPrimaryKey", method = RequestMethod.GET)
    public ResultVo deleteByPrimaryKey(Integer logId){

        return ResultUtils.success("删除成功",crmoalogService.deleteByPrimaryKey(logId));
    }

    /**
     * 查询所有
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "selectCrmlist", method = RequestMethod.GET)
    public ResultVo<Crmoalog> selectCrmlist(){

        return ResultUtils.success("查询成功",crmoalogService.selectCrmlist());
    }

}
