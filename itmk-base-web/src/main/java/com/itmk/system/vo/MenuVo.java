package com.itmk.system.vo;


import com.itmk.system.entity.Permission;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单返回实体
 */
@Data
public class MenuVo implements Serializable {
    private List<Permission> menuList;
    private List<String> authList;
    private List<Permission> routerList;
    private String token;
    private Long userId;
}