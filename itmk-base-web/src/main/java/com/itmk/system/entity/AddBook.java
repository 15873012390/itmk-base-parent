package com.itmk.system.entity;

import lombok.Data;

/*
* 通讯录实体
* */
@Data
public class AddBook {

    private Long id;
    //手机号
    private String mobile;
    //部门id
    private Long deptId;
    //部门名称
    private String deptName;
    //昵称
    private String loginName;
}
