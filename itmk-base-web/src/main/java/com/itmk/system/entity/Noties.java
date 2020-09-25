package com.itmk.system.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * noties
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Noties implements Serializable {
    /**
     * 公告Id
     */
    private Integer msgId;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String message;
    /**
     * 通知部门
     */
    private String deptId;

    /**
     * 通知人
     */
    private String departId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 已读用户
     */
    private String readUserIds;

    private String createUserId;
//    /**
//     * 公告状态
//     */
//    private  int state;

    private static final long serialVersionUID = 1L;
}