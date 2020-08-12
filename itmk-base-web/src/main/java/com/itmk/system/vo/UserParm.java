package com.itmk.system.vo;

import lombok.Data;
import vo.ParmVo;

@Data
public class UserParm extends ParmVo {
    private String email;
    private int pageSize;
    private String loginName;
    private String mobile;
    private int currentPage;
    private String deptId;
}
