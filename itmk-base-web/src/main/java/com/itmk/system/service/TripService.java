package com.itmk.system.service;

import com.itmk.system.entity.Trip;

import java.util.List;

public interface TripService {

    /**
     * 添加日程
     * @param record
     * @return
     */
    int insert(Trip record);

    /**
     * 根据ID查询日程
     * @param tripId
     * @return
     */
    Trip selectByPrimaryKey(Integer tripId);

    /**
     * 查询所有日程
     * @return
     */
    List<Trip> selectAll();

    /**
     * 根据ID修改日程
     * @param tripId
     * @return
     */
    int updateByPrimaryKey(Trip tripId);

    /**
     * 删除日程
     * @param tripId
     * @return
     */
    int deleteByPrimaryKey(Integer tripId);

    /**
     * 查询当天的所有日程
     * @param trip_start_time
     * @return
     */
    List<Trip> selectByTime(String trip_start_time);
}
