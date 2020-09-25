package com.itmk.system.mapper;

import com.itmk.system.entity.Trip;
import org.apache.ibatis.annotations.Mapper;

import java.awt.*;
import java.util.List;

@Mapper
public interface TripDao {
    /**
     * 删除日程
     * @param tripId
     * @return
     */
    int deleteByPrimaryKey(Integer tripId);

    /**
     * 新增日程
     * @param record
     * @return
     */
    int insert(Trip record);


    int insertSelective(Trip record);


    Trip selectByPrimaryKey(Integer tripId);


    int updateByPrimaryKeySelective(Trip record);

    int updateByPrimaryKey(Trip record);

    /**
     * 查询所有
     * @return
     */
    List<Trip> selectAll();
    }