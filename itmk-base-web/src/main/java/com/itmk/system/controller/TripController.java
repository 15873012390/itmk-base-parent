package com.itmk.system.controller;

import com.itmk.result.ResultUtils;
import com.itmk.result.ResultVo;
import com.itmk.system.entity.Trip;
import com.itmk.system.service.TripService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    /**
     * 插入日程
     * @param trip
     * @return
     */
    @RequestMapping(value = "/insertTrip",method = RequestMethod.POST)
    public ResultVo insert(@RequestBody Trip trip){
        return ResultUtils.success("插入成功",tripService.insert(trip));
    }


    @RequestMapping(value = "/selectTime",method = RequestMethod.GET)
    public ResultVo selectTime(String trip_start_time){
        log.info("时间段"+trip_start_time);
        return ResultUtils.success("插入成功",tripService.selectByTime(trip_start_time));
    }
    /**
     *根据ID查询日程1
     * @param tripId
     * @return
     */
    @GetMapping("/select_ById")
    public ResultVo select_By_Id(Integer tripId){
        return ResultUtils.success("查询成功",tripService.selectByPrimaryKey(tripId));
    }

    /**
     * 查询所有日程
     * @return
     */
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public ResultVo selectAll(){
        return ResultUtils.success("查询成功",tripService.selectAll());
    }

    /**
     * 更新日程
     * @param tripId
     * @return
     */
    @RequestMapping(value = "/updateById",method = RequestMethod.POST)
    public  ResultVo updateById(@RequestBody Trip tripId){
        return ResultUtils.success("更新成功"+tripService.updateByPrimaryKey(tripId));
    }

    /**
     * 根据ID删除日程
     * @param tripId
     * @return
     */
    @RequestMapping(value = "/delectById",method = RequestMethod.DELETE)
    public  ResultVo delectById(Integer tripId){
        return ResultUtils.success("删除成功"+tripService.deleteByPrimaryKey(tripId));
    }
}
