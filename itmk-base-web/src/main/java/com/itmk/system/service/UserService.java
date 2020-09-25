package com.itmk.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itmk.system.entity.SysUser;

import javax.transaction.Transactional;

/**
 * 用户service
 */
@Transactional
public interface UserService extends IService<SysUser> {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SysUser getUserByUserName(String username);
}
