package com.itmk.system.vo;

import lombok.Data;
import vo.ParmVo;

@Data
public class ProductclassificationVo extends ParmVo {
    /**
     * 分类名称
     */
    private String claName;
    /**
     * 页容量
     */
    private int pageSize;
    /**
     * 当前页
     */
    private int currentPage;
}
