package com.itmk.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmk.system.entity.Permission;
import com.itmk.system.mapper.PermissionMapper;
import com.itmk.system.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Override
    public List<Permission> getPermissionListByUserId(Long userId) {
        return this.baseMapper.getPermissionListByUserId(userId);
    }

    @Override
    public List<Permission> getPermissionListByRoleId(Long roleId) {
        return this.baseMapper.getPermissionListByRoleId(roleId);
    }
}
