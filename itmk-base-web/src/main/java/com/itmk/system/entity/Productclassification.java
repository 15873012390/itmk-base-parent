package com.itmk.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * productclassification
 * @author 
 */
@Data
@TableName("productclassification")
public class Productclassification implements Serializable {
    /**
     * 分类id
     */
    //主键
    @TableId
    private Integer claId;

    /**
     * 分类名称
     */
    private String claName;

    /**
     * 上级分类id(0为最高分类 1 为二级分类 数字越大 分类越后)
     */
    private Integer claIdId;

    /**
     * 状态(正常、禁用)
     */
    private String claState;

    /**
     * 添加日期
     */
    private Date claDatetime;

    private static final long serialVersionUID = 1L;
}