package com.itmk.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itmk.system.entity.RolePermission;


import java.util.List;

public interface RolePermissionService extends IService<RolePermission> {
    /**
     * 分配权限保存
     * @param
     */
    void saveAssignRole(Long roleId, List<Long> collect);
}
