package com.itmk.system.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 任务实体类
 */
@Data
public class Task {

    private int taskId;               //任务id

    private  String name;        //任务名称

    private int createId;       //创建人id

    private int mainId;        //负责人id

    private Date createTime;   //新建时间

    private Date updateTime;  //更新时间

    private Date startTime;  //开始时间

    private Date stopTime;  //结束时间

    private int priority;  //优先级

    private int status;   //完成状态

    private String description; //任务描述


}
