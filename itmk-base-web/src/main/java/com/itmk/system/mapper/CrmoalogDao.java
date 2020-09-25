package com.itmk.system.mapper;

import com.itmk.system.entity.Crmoalog;
import com.itmk.system.vo.CrmoalogSearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface CrmoalogDao {
    //根据LogId删除日志
    int deleteByPrimaryKey(Integer logId);
    //添加数据
    int insert(Crmoalog crmoalog);
    //添加数据
    int insertSelective(Crmoalog crmoalog);
    //根据LogId查询
   Crmoalog selectByPrimaryKey(Integer logId);
    //更改日志信息
    int updateByPrimaryKeySelective(Crmoalog crmoalog);

    int updateByPrimaryKey(Crmoalog record);
    //查询所有
    List<Crmoalog> selectCrmlist();
    //根据日志创建时间查询
    List<Crmoalog >findCrmOaLogByCreateTime(Map<String,String> timeMap);
    //日志（日报、周报、月报）类型id查询日志
    List<Crmoalog> findCrmOaLogByType(CrmoalogSearchVo crmoalog);
    //根据createUserId查询
    List<Crmoalog> findCrmOaLogByCruId(Long crmoalog);

}