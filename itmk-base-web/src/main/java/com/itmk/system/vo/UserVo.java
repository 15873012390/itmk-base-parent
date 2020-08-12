package com.itmk.system.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserVo {
    //登录名
    private String username;
    //手机号
    private String mobile;
    //头像
    //邮箱
    private String email;
    //部门名称
    private String deptName;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //0:男 1：女
    private String sex;
    //角色
    private String Role;
}
