package com.itmk.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itmk.system.entity.SysUser;
import com.itmk.system.entity.UserRole;
import com.itmk.system.entity.jpa.JpaSysUser;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表mapper接口
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    JpaSysUser findById(@Param("id") Long id);
}
