package com.itmk.system.vo;


import com.itmk.system.entity.mybatis.Customer;
import lombok.Data;

import java.util.Date;

@Data
public class AdvancedQueryContactsDataVo {
    private Integer conId;
    private String conName;
    private String conTel;
    private String conMobile;
    private Date conTimeStart;
    private Date conTimeEnd;
    private String[] conSex;
    private String conPosition;
    private String conRemarks;
    private Integer currentPage;
    private Integer pageSize;
    private Customer customer;

}
