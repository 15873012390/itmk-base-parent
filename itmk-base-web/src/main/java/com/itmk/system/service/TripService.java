package com.itmk.system.service;

import com.itmk.system.entity.Trip;

import java.util.List;

public interface TripService {

//    添加日程
    int insert(Trip record);

//查询日程
    Trip selectByPrimaryKey(Integer tripId);
//查询所有日程
    List<Trip> selectAll();

////    查询所有日程
//    List<Trip> selectAll();
////    新建日程
//    int insertSelective(Trip record);
////更改日程
//    int updateByPrimaryKeySelective(Trip record);

}
