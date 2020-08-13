package com.itmk.system.vo;

import lombok.Data;
import vo.ParmVo;

@Data
public class ProductVo extends ParmVo {
    /**
     * 产品名称
     */
    private String proName;

    private int currentPage;
    private int pageSize;
}
