package com.itmk.system.mapper;

import com.itmk.system.entity.Noties;
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

    /**
     * 根据ID查询
     * @param tripId
     * @return
     */
    Trip selectByPrimaryKey(Integer tripId);

    /**
     * 查询当天所有日程
     * @param trip_start_time
     * @return
     */
    List<Trip> selectByTime(String trip_start_time);


    int updateByPrimaryKeySelective(Trip record);
    /**
     * 根据ID修改日程
     * @param tripId
     * @return
     */
    int updateByPrimaryKey(Trip tripId);

    /**
     * 查询所有
     * @return
     */
    List<Trip> selectAll();
}