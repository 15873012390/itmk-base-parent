package com.itmk.system.mapper;

import com.itmk.system.entity.Crmoalog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CrmoalogDao {
    int deleteByPrimaryKey(Integer logId);

    int insert(Crmoalog crmoalog);

    int insertSelective(Crmoalog crmoalog);

   Crmoalog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(Crmoalog crmoalog);

    int updateByPrimaryKey(Crmoalog record);

    List<Crmoalog> selectCrmlist();
}