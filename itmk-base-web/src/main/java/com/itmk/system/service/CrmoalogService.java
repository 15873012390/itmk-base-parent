package com.itmk.system.service;

import com.itmk.system.entity.Crmoalog;
import com.itmk.system.vo.CrmoalogSearchVo;

import java.util.List;
import java.util.Map;

/**
 *功能描述 日志业务接口
 * @author HYJ
 * @date 2020/9/21
  * @param null
 * @return
 */
public interface CrmoalogService {
    int insertSelective(Crmoalog crmoalog);

    Crmoalog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(Crmoalog crmoalog);

    int deleteByPrimaryKey(Integer logId);

    List<Crmoalog> selectCrmlist();
    //查询日志通过时间
    List<Crmoalog >findCrmOaLogByCreateTime(Map<String,String> timeMap);
    //多个条件（发表人 时间段 日志）查询日志
    List<Crmoalog> findCrmOaLogByType(CrmoalogSearchVo crmoalog);
    ///根据createUserId查询
    List<Crmoalog> findCrmOaLogByCruId(Long crmoalog);
}
