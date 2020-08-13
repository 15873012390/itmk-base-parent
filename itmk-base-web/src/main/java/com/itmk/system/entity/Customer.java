package com.itmk.system.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * customer
 * @author 
 */
@Data
public class Customer implements Serializable {
    /**
     * 客户Id
     */
    private Integer cusId;

    /**
     * 客户名称
     */
    private String cusName;

    /**
     * 所有者Id
     */
    private Integer uId;

    /**
     * 客户等级（1.高 2.较高 3.中 4.较低 5.低）
     */
    private String cusLevel;

    /**
     * 客户地址
     */
    private String cusAddr;

    /**
     * 客户电话
     */
    private String cusTel;

    /**
     * 客户来源
     */
    private String cusSource;

    /**
     * 创建时间
     */
    private Date cusCreationTime;

    /**
     * 更新时间
     */
    private Date cusUpdateTime;

    /**
     * 信用等级
     */
    private String cusCredit;

    /**
     * 邮编
     */
    private String cusZip;

    /**
     * 传真
     */
    private String cusFax;

    /**
     * 生命周期(1.一次性 2.重复购买 3.长期合作）
     */
    private String cusLifeCycle;

    /**
     * 国家或区域
     */
    private String cusCountry;

    /**
     * 省份
     */
    private String cusProvince;

    /**
     * 城市
     */
    private String cusCity;

    /**
     * 区县
     */
    private String cusDistrict;

    /**
     * 客户状态("1.正常 2.
预警 3.流失"）
     */
    private String cusState;

    /**
     * 定级(1.特级 2.大单 3.正常 4.小单）
     */
    private String cusGrading;

    /**
     * 备注
     */
    private String cusRemarks;

    private static final long serialVersionUID = 1L;
}