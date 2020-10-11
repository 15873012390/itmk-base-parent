package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Noties;
import com.itmk.system.service.NotiesService;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/noties")
public class NotiesController {
    @Autowired
    private NotiesService notiesService;

    /**
     * 查询所有公告
     * @return
     */
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public ResultVo selectAll(){
        return ResultUtils.success("查询成功",notiesService.selectAll());
    }

    /**
     * 插入公告
     * @param
     * @return
     */
    @RequestMapping(value = "/insertById",method = RequestMethod.POST)
    public ResultVo insertById(@RequestBody Noties noties){
       return ResultUtils.success("插入成功",notiesService.insert(noties));
    }

    /**
     * 根据ID查询公告
     * @param msgId
     * @return
     */
    @GetMapping("/selectById")
    public ResultVo selectById(Integer msgId){
       return ResultUtils.success("查询成功",notiesService.selectByPrimaryKey(msgId));
    }
    /**
     * 根据ID删除公告
     * @param msgId
     * @return
     */
    @RequestMapping(value = "/delectById",method = RequestMethod.DELETE)
    public ResultVo delectById(Integer msgId){
        return ResultUtils.success("删除成功",notiesService.deleteByPrimaryKey(msgId));
    }

    /**
     * 查询状态  审核中
     * @param state
     * @return
     */
    @RequestMapping(value = "/selectState",method = RequestMethod.POST)
    public ResultVo selectState(Integer state){
        return ResultUtils.success("查询成功",notiesService.selectState(state));
    }

    /**
     * 查询公告状态 已结束
     * @param state
     * @return
     */
    @RequestMapping(value = "/selectendState",method = RequestMethod.POST)
    public ResultVo selectendState(Integer state){
        return ResultUtils.success("查询成功",notiesService.selectendState(state));
    }

    /**
     * 更新公告
     * @param record
     * @return
     */
    @RequestMapping(value = "/updateByPrimaryKey",method = RequestMethod.POST)
    public  ResultVo updateByPrimaryKey(@RequestBody Noties record){
        return ResultUtils.success("查询成功",notiesService.updateByPrimaryKey(record));
    }

    /**
     * 查询时间段公告
     * @param start_date
     * @param end_date
     * @return
     */
    @RequestMapping(value = "/selectTime",method = RequestMethod.GET)
    public ResultVo selectTime(String start_date,String end_date){
        log.info("我在这个"+start_date+end_date);
        return  ResultUtils.success("查询成功",notiesService.selectTime(start_date,end_date));
    }

    /**
     * 修改 状态
     * @param
     * @return
     */

    @RequestMapping(value = "/selectIdState",method = RequestMethod.POST)
    public ResultVo selectIdState(@RequestBody Integer msgId){
        log.info("ww"+msgId);
        return ResultUtils.success("查询成功",notiesService.updateState(msgId));
    }
}

