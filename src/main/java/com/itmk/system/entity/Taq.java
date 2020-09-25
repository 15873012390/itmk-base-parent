package com.itmk.system.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * task
 * @author 
 */
@Data
public class Taq implements Serializable {
    /**
     * 任务表
     */
    private Integer taskId;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 创建人ID
     */
    private Long createUserId;

    /**
     * 负责人ID
     */
    private Long mainUserId;

    /**
     * 新建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date stopTime;

    /**
     * 优先级 从大到小 3高 2中 1低
     */
    private Integer priority;

    /**
     * 完成状态 1正在进行2延期3归档 5结束
     */
    private Integer status;

    /**
     * 描述
     */
    private String description;

    private static final long serialVersionUID = 1L;
}