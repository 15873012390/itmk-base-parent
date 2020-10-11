package com.itmk.system.service.Impl;

import com.itmk.system.entity.Trip;
import com.itmk.system.mapper.TripDao;
import com.itmk.system.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripDao tripDao;

    /**
     * 新增日程
     * @param record
     * @return
     */
    @Override
    public int insert(Trip record) {
        return tripDao.insert(record);
    }
    /**
     * 根据ID查询日程
     * @param tripId
     * @return
     */
    @Override
    public Trip selectByPrimaryKey(Integer tripId) {
        return tripDao.selectByPrimaryKey(tripId);
    }
    /**
     * 查询所有日程
     * @return
     */

    @Override
    public List<Trip> selectAll() {
        return tripDao.selectAll();
    }
    /**
     * 根据ID更新日程
     * @param tripId
     * @return
     */
    @Override
    public int updateByPrimaryKey(Trip tripId) {
        return tripDao.updateByPrimaryKey(tripId);
    }

    /**
     * 删除日程
     * @param tripId
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer tripId) {
        return tripDao.deleteByPrimaryKey(tripId);
    }

    /**
     * 查询当天的所有日程
     * @param trip_start_time
     * @return
     */
    @Override
    public List<Trip> selectByTime(String trip_start_time) {
        return tripDao.selectByTime(trip_start_time);
    }


}
