package com.itmk.system.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * crmoalog
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Crmoalog implements Serializable {
    private Integer logId;

    /**
     * 日志类型（1日报，2周报，3月报）
     */
    private Integer categoryId;

    /**
     * 日志标题
     */
    private String title;

    /**
     * 日志内容
     */
    private String content;

    /**
     * 明日工作内容
     */
    private String tomorrow;

    /**
     * 遇到问题
     */
    private String question;

    /**
     * 创建人ID
     */
    private Long createUserId;
    /**
     *功能描述
    *员工名
     */
    private String userName;

    /**
     * 创建时间
     */
    private Date  createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 通知人
     */
    private String sendUserIds;

    /**
     * 通知部门
     */
    private String sendDeptIds;

    /**
     * 已读人
     */
    private String readUserIds;
    /**
     * 日志图片
     */
    private  String conImg;
    private static final long serialVersionUID = 1L;
}