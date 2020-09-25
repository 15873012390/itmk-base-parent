package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Noties;
import com.itmk.system.service.NotiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        log.info("查询成功");
        return ResultUtils.success("查询成功",notiesService.selectAll());
    }

    /**
     * 插入公告
     * @param
     * @return
     */
    @RequestMapping(value = "/insertById",method = RequestMethod.POST)
    public ResultVo insertById(@RequestBody Noties noties){
        log.info("插入成功！"+noties);
       return ResultUtils.success("插入成功",notiesService.insert(noties));
    }

    /**
     * 根据ID查询公告
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectById",method = RequestMethod.POST)
    public ResultVo selectById(Integer id){
        log.info("查询成功");
       return ResultUtils.success("查询成功",notiesService.selectByPrimaryKey(id));
    }


    /**
     * 根据ID删除公告
     * @param id
     * @return
     */
    @RequestMapping(value = "/delectById",method = RequestMethod.DELETE)
    public ResultVo delectById(Integer id){
        log.info("删除成功");
        return ResultUtils.success("删除成功",notiesService.deleteByPrimaryKey(id));
    }
}

