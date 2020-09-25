package com.itmk.system.mapper;

import com.itmk.system.entity.Noties;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotiesDao {
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



    int updateByPrimaryKeySelective(Noties record);

    int updateByPrimaryKey(Noties record);
    int insertSelective(Noties record);

}