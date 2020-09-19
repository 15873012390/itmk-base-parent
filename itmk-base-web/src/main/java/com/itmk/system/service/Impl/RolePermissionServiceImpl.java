package com.itmk.system.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmk.system.entity.RolePermission;
import com.itmk.system.mapper.RolePermissionMapper;
import com.itmk.system.service.RolePermissionService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@javax.transaction.Transactional
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {
    @Override
    @Transactional
    @Caching(evict = {@CacheEvict( value = "permission",allEntries = true)},
            put={@CachePut(value = "permission",key = "#roleId")})
    public void saveAssignRole(Long roleId, List<Long> collect) {
        //1.删除该角色原来的全部权限
        QueryWrapper<RolePermission> query = new QueryWrapper<>();
        query.lambda().eq(RolePermission::getRoleId,roleId);
        this.baseMapper.delete(query);
        //2.保存新的权限
        this.baseMapper.saveRolePermissions(roleId,collect);
    }
}
