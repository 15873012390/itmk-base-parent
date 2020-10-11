package com.itmk.system.service;

import com.itmk.system.entity.Noties;

import java.util.List;
import java.util.Map;

public interface NotiesService {
    /**
     * 查询所有用户
     */
    List<Noties> selectAll();

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    List<Noties> selectTime(String start_date,String end_date);
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
    /**
     * 查询状态 审核中
     * @param state
     * @return
     */
    List<Noties> selectState(Integer state);

    /**
     * 查询状态 已结束
     * @param state
     * @return
     */
    List<Noties> selectendState(Integer state);

    /**
     * 更新公告
     * @param record
     * @return
     */
    int updateByPrimaryKey(Noties record);

    /**
     * 更新状态
     * @param msgId
     * @return
     */
    int updateState(Integer msgId);

}
