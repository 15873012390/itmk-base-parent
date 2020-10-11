package com.itmk.system.mapper;

import com.itmk.system.entity.Noties;
import org.apache.ibatis.annotations.Mapper;

import javax.swing.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface NotiesDao {
    /**
     * 查询所有用户
     */
    List<Noties> selectAll();

    /**
     * 查询状态  审核中
     * @param state
     * @return
     */
    List<Noties> selectState(Integer state);

    /**
     * 根据时间查询字段
     * @param start_date
     * @param end_date
     * @return
     */
    List<Noties> selectTime(String start_date,String end_date);


    /**
     * 查询状态 已结束
     * @param state
     * @return
     */
    List<Noties> selectendState(Integer state);




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



    int updateByPrimaryKeySelective(Noties record);

    /**
     * 根据ID修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(Noties record);


    /**
     * 根据ID修改状态
     * @param msgId
     * @return
     */
    int updateState(Integer msgId);





    int insertSelective(Noties record);

}