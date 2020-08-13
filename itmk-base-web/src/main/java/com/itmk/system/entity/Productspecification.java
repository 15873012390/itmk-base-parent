package com.itmk.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * productspecification
 * @author 
 */
@Data
@TableName("productspecification")
public class Productspecification implements Serializable {
    /**
     * 规格id
     */
    //主键
    @TableId
    private Integer speId;

    /**
     * 产品id
     */
    private Integer proId;

    /**
     * 产品名称(基准规格产品、其他规格产品)
     */
    private String proName;

    /**
     * 规格
     */
    private String speSpecification;

    /**
     * 单位
     */
    private String speUnit;

    /**
     * 单位换算
     */
    private Integer speUnitConversion;

    private static final long serialVersionUID = 1L;
}