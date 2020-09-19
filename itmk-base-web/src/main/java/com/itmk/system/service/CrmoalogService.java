package com.itmk.system.service;

import com.itmk.system.entity.Crmoalog;

import java.util.List;

public interface CrmoalogService {
    int insertSelective(Crmoalog crmoalog);

    Crmoalog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(Crmoalog crmoalog);

    int deleteByPrimaryKey(Integer logId);

    List<Crmoalog> selectCrmlist();
}
