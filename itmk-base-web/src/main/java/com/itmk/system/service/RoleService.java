package com.itmk.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itmk.system.entity.SysRole;
import com.itmk.system.entity.UserRole;


/**
 * 角色管理serivce层
 */
public interface RoleService extends IService<SysRole> {
    /**
     * 根据用户id查询角色id
     * @param userId
     * @return
     */
    UserRole getRoleIdByUserId(Long userId);

    /**
     * 分配权限保存
     * @param userRole
     */
    void assingRole(UserRole userRole);
}
