package com.itmk.system.vo;

import lombok.Data;
import vo.ParmVo;

@Data
public class CustomerVo extends ParmVo {
    //@Excel(name="客户名称")
    private String cusName;
    //@Excel(name="客户电话")
    private String cusTel;

    private int currentPage;
    private int pageSize;
}
