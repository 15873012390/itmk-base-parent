package com.itmk.system.service;

import com.itmk.system.entity.Noties;

import java.util.List;

public interface NotiesService {
    /**
     * 查询所有用户
     */
    List<Noties> selectAll();

    /**
     * 根据ID删除用户
     * @param msgId
     * @return
     */
    int deleteByPrimaryKey(Integer msgId);

    /**
     * 根据ID插入
     * @param record
     * @return
     */
    int insert(Noties record);
    /**
     * 根据ID查询用户
     * @param msgId
     * @return
     */
    Noties selectByPrimaryKey(Integer msgId);

}
