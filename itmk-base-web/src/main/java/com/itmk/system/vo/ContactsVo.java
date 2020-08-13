package com.itmk.system.vo;

import lombok.Data;
import vo.ParmVo;

@Data
public class ContactsVo extends ParmVo {
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
    private int currentPage;
    private int pageSize;
}
