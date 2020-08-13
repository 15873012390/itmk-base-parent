package com.itmk.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * contacts
 * @author 
 */
@Data
@TableName("contacts")
public class Contacts implements Serializable {
    /**
     * 联系人ID
     */
    //主键
    @TableId
    private Integer conId;

    /**
     * 客户id
     */
    private Integer cusId;

    /**
     * 联系人名称
     */
    private String conName;

    /**
     * 固定电话
     */
    private String conTel;

    /**
     * 手机
     */
    private String conMobile;

    /**
     * 创建时间
     */
    private Date conTime;

    /**
     * 联系人性别
     */
    private String conSex;

    /**
     * 职位
     */
    private String conPosition;

    /**
     * 备注
     */
    private String conRemarks;

    /**
     * 联系人照片
     */
    private String conImg;

    private static final long serialVersionUID = 1L;
}