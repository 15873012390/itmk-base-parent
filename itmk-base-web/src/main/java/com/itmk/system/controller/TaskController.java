package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Task;
import com.itmk.system.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/task")
public class TaskController {
    @Autowired
    private TaskService  taskService;

    /**
     * 查询所有任务
     * @return
     */
    @GetMapping("/getTaskList")
    public ResultVo getTaskList(){
        return ResultUtils.success("查询任务成功",this.taskService.getTaskList());
    }

    /**
     * 增加任务
     * @param record
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "insertSelect",method = RequestMethod.GET)
    public  ResultVo insertSelect(@RequestBody Task record ){
        return  ResultUtils.success("增加成功",taskService.insertSelect(record));
    }

    /**
     * 根据id删除任务
     * @param id
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/deleteByPrimaryKey",method = RequestMethod.GET)
    public ResultVo  deleteByPrimaryKey(Integer id){
        System.out.println("aaaa");
        return ResultUtils.success("删除成功",taskService.deleteByPrimaryKey(id));
    }

    /**
     * 根据id更新任务
     * @param record
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "updateByPrimaryKey",method = RequestMethod.GET)
    public ResultVo updateByPrimaryKey(@RequestBody Task record){
        System.out.println("bbbbb");
        return ResultUtils.success("更新成功",taskService.updateByPrimaryKey(record));
    }

}
