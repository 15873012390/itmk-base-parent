package com.itmk.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * product
 * @author 
 */
@Data
@TableName("product")
public class Product implements Serializable {
    /**
     * 产品id
     */
    //主键
    @TableId
    private Integer proId;

    /**
     * 分类id
     */
    private Integer claId;

    /**
     * 产品名称
     */
    private String proName;

    /**
     * 产品图片
     */
    private String proImage;

    /**
     * 型号
     */
    private String proMode;

    /**
     * 状态(上架、下架)
     */
    private String proState;

    /**
     * 价格
     */
    private BigDecimal proPrice;

    /**
     * 成本价格
     */
    private BigDecimal proCostprice;

    /**
     * 单位
     */
    private String proUnit;

    /**
     * 产品条形码
     */
    private Integer proBarcode;

    /**
     * 重量(重量后加kg\g)
     */
    private String proWeight;

    /**
     * 权限分组(成品、半成品、原料)
     */
    private String proGroup;

    /**
     * 产品建立时间
     */
    private Date proDate;

    /**
     * 使用年限
     */
    private String durableYears;

    /**
     * 备注
     */
    private String proRemark;

    /**
     * 是否删除状态(1是、2否)
     */
    private Integer proDelState;

    /**
     * 产品说明
     */
    private String proExplain;

    /**
     * 明细概要
     */
    private String proDetailedProfile;

    private static final long serialVersionUID = 1L;
}