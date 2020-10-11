package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Backlogtask;
import com.itmk.system.service.BackLogTaskService;
import com.itmk.system.vo.BackLogTaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *功能描述 待办任务控制层
 * @author 廖湘明
 * @date 2020/10/10
 */
@RestController
@RequestMapping(value = "/api/BackLogTask")
public class BackLogTaskController {
    @Autowired
    private BackLogTaskService backLogTaskService;

    /**
     *功能描述 新增待办任务
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @PostMapping("/add_backlogtask_and_detail")
    public ResultVo AddBackLogTaskAndDetail(@RequestBody BackLogTaskVo backLogTaskVo){
        this.backLogTaskService.AddBackLogTaskAndDetail(backLogTaskVo);
        return ResultUtils.success("新增待办任务");
    }
    /**
     *功能描述 刷新待办任务
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @GetMapping("/push_backLogTask_by_cusid")
    public ResultVo pushBackLogTask(Integer cusId){
        return ResultUtils.success("刷新待办任务",this.backLogTaskService.pushBackLogTask(cusId));
    }
    /**
     *功能描述 通过id查询待办任务
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @GetMapping("/query_back_log_task_by_bltid")
    public ResultVo queryBackLogTaskByBltId(Integer bltid){
        return ResultUtils.success("通过id查询待办任务",this.backLogTaskService.queryBackLogTaskByBltId(bltid));
    }
    /**
     *功能描述 结束待办任务
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @GetMapping("/finish_back_task_edit_details")
    public ResultVo finishBackTaskEditDetails(Integer bltid){
        this.backLogTaskService.finishBackTaskEditDetails(bltid);
        return ResultUtils.success("结束待办任务");
    }
    /**
     *功能描述 查询所有待办任务
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @GetMapping("/query_all_backLogTask_bycusId")
    public ResultVo queryAllBackLogTaskByCusId(Integer cusId,Integer currentPage,Integer pageSize){
        return ResultUtils.success("查询所有待办任务",this.backLogTaskService.queryAllBackLogTaskByCusId(cusId,currentPage,pageSize));
    }
    /**
     *功能描述 删除待办任务
     * @author 廖湘明
     * @date 2020/10/10
     * @param
     * @return
     */
    @DeleteMapping("/del_back_log_task_by_bltId")
    public ResultVo delBackLogTaskByBltId(Integer bltid){
        this.backLogTaskService.delBackLogTaskByBltId(bltid);
        return ResultUtils.success("删除待办任务");
    }
}

