package com.itmk.system.mapper;


import com.itmk.system.entity.jpa.JpaSysUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserDao {

    public List<JpaSysUser> queryAll();

    public JpaSysUser queryByUid(@Param("id") int uid);

    public List<JpaSysUser> queryByUserName(@Param("nick_name") String uName);

    public List<JpaSysUser> queryUserBySalesOpport(@Param("timeStart") Date timeStart,
                                             @Param("timeEnd") Date timeEnd,
                                             @Param("possibity") String possibity);

    /**
     * 获得有权限审核的员工
     * @return
     */
    public List<JpaSysUser> getAllUsrList();
}
