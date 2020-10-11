package com.itmk.system.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * trip
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip implements Serializable {
    /**
     * 日程ID
     */
    @TableId
    private Integer tripId;

    /**
     * 日程主题
     */
    private String tripTheme;

    /**
     * 开始时间
     */
    private Date tripStartTime;

    /**
     * 结束时间
     */
    private Date tripEndTime;

    /**
     * 创建人ID
     */
    private Integer tripCreateUser;

    /**
     * 创建时间
     */
    private Date tripCreateTime;

    /**
     * 更新时间
     */
    private Date tripUpdateTime;

    /**
     * 0不提醒1每天2每周3每月4每年
     */
    private Integer tripType;

    /**
     * 参与人 
     */
    private JSONArray tripAttend;

    /**
     * 地点
     */
    private String tripAddress;

    /**
     * 备注
     */
    private String tripMessage;

    private static final long serialVersionUID = 1L;
}