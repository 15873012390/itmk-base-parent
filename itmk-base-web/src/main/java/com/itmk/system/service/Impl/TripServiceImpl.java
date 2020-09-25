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
     * 查询日程
     * @param tripId
     * @return
     */
    @Override
    public Trip selectByPrimaryKey(Integer tripId) {
        return tripDao.selectByPrimaryKey(tripId);
    }
//查询所有日程


    @Override
    public List<Trip> selectAll() {
        return tripDao.selectAll();
    }


}
