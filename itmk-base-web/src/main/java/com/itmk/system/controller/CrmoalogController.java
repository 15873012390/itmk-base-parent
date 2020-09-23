package com.itmk.system.controller;

import com.itmk.jwt.JwtUtils;
import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Crmoalog;
import com.itmk.system.entity.SysUser;
import com.itmk.system.service.CrmoalogService;
import com.itmk.system.service.UserService;
import com.itmk.system.vo.CrmoalogSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.Console;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping(value = "/api/crmoalog")
public class CrmoalogController {
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
        return ResultUtils.success("查询成功",this.crmoalogService.selectByPrimaryKey(logId));
    }

    /**
     * 更改日志信息
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
    @RequestMapping(value = "deleteByPrimaryKey", method = RequestMethod.DELETE)
    public ResultVo deleteByPrimaryKey(Integer logId){
        return ResultUtils.success("删除成功",crmoalogService.deleteByPrimaryKey(logId));
    }

    /**
     *查所有数据
     * @author HYJ
     * @date 2020/9/22
      * @param
     * @return com.itmk.result.ResultVo<com.itmk.system.entity.Crmoalog>
     */
    @ResponseBody
    @RequestMapping(value = "selectCrmlist", method = RequestMethod.GET)
    public ResultVo<Crmoalog> selectCrmlist(){
        return ResultUtils.success("查询成功",crmoalogService.selectCrmlist());
    }

    /**
     *根据创建时间查询一天数据数据
     * @author HYJ
     * @date 2020/9/20
      * @param
     * @return com.itmk.result.ResultVo<com.itmk.system.entity.Crmoalog>
     */
    @ResponseBody
    @RequestMapping(value = "findCrmOaLogByCreateTime",method = RequestMethod.GET)
    public ResultVo<Crmoalog> findCrmOaLogByCreateTime( String beginTime, String endTime){
        Map<String,String> timeMap=new HashMap<String, String>();
        timeMap.put("beginTime",beginTime);
        timeMap.put("endTime",endTime);
        log.info(beginTime,endTime);
        return ResultUtils.success("查询成功",crmoalogService.findCrmOaLogByCreateTime(timeMap));
    }

    /**
     *日志（日报、周报、月报）类型id查询日志
     * @author HYJ
     * @date 2020/9/22
      * @param  crmoalogVo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findCrmOaLogByType",method = RequestMethod.POST)
    public ResultVo findCrmOaLogByType(@RequestBody CrmoalogSearchVo crmoalogVo){
        return ResultUtils.success("查询成功",crmoalogService.findCrmOaLogByType(crmoalogVo));
    }
    /**
     * createUserId(发表人id)查询
     * @author HYJ
     * @date 2020/9/22
      * @param
     * @return com.itmk.result.ResultVo<com.itmk.system.entity.Crmoalog>
     */
    @ResponseBody
    @RequestMapping(value = "findCrmOaLogByCruId",method = RequestMethod.POST)
    public ResultVo<Crmoalog> findCrmOaLogByCruId(@RequestBody Crmoalog crmoalog){
        log.info(""+crmoalog);
        return  ResultUtils.success("查询成功",crmoalogService.findCrmOaLogByCruId(crmoalog.getCreateUserId()));
    }
}
