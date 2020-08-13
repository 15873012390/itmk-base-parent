package com.itmk.system.vo;

import lombok.Data;

@Data
public class ProductspecificationVo {
    /**
     * 产品名称(基准规格产品、其他规格产品)
     */
    private String proName;

    private int currentPage;
    private int pageSize;
}
