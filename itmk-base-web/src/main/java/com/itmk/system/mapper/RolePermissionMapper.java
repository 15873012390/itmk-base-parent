package com.itmk.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itmk.system.entity.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    //批量新增权限
    boolean saveRolePermissions(@Param("roleId") Long roleId, @Param("perIds") List<Long> perIds);
}
