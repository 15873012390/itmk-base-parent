package com.itmk.system.service;

import com.itmk.system.entity.Backlogtask;
import com.itmk.system.vo.BackLogTaskVo;
import com.itmk.system.vo.Pager;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Map;

/**
 * 待办任务业务接口
 * @author 廖湘明
 * @data 2020/10/10 18:54
 * @return
 */
public interface BackLogTaskService {
    //根据客户分页
    public Pager queryAllBackLogTaskByCusId(Integer cusId, Integer currentPage, Integer pageSize);
    //添加任务表和任务详情表
    public void AddBackLogTaskAndDetail(BackLogTaskVo backLogTaskVo);
    //刷新待办任务
    public List<Backlogtask> pushBackLogTask(Integer cusId);
    //根据任务id找任务详情
    public Map queryBackLogTaskByBltId(Integer bltid);
    //根据待办任务id修改状态
    public void finishBackTaskEditDetails(Integer bltid);
    //根据待办任务id删除
    public void delBackLogTaskByBltId(Integer bltid);
}
