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
     * 插入公告
     * @param trip
     * @return
     */

    @RequestMapping(value = "/insertTrip",method = RequestMethod.POST)
    public ResultVo insert(@RequestBody Trip trip){
        log.info("插入成功");
        return ResultUtils.success("插入成功",tripService.insert(trip));
    }

//    @RequestMapping(value = "/select_by_Id",method = RequestMethod.POST)
//    public ResultVo select_by_Id(Integer integer){
//        return ResultUtils.success("查询成功",tripService.selectByPrimaryKey(integer));
//    }
//

    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public ResultVo selectAll(){
        log.info("查询成功");
        return ResultUtils.success("查询成功",tripService.selectAll());
    }
    /**
//     * 查询日程
//     * @return
//     */
//    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
//    public ResultVo selectAll(){
//        return ResultUtils.success("插入成功",tripService.selectAll());
//    }
//
//    /**
//     * 插入成功
//     * @param trip
//     * @return
//     */
//    @RequestMapping(value = "/insertTrip",method = RequestMethod.POST)
//    public ResultVo insertTrip(@RequestBody Trip trip){
//        return ResultUtils.success("插入成功",tripService.insertSelective(trip));
//    }
//
//    /**
//     * 更新成功
//     * @param trip
//     * @return
//     */
//    @RequestMapping(value = "/updateKey",method = RequestMethod.POST)
//    public ResultVo updateKey(Trip trip){
//        return ResultUtils.success("更新成功",+tripService.updateByPrimaryKeySelective(trip));
//    }
}
