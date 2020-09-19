package com.itmk.system.service.Impl;


import com.itmk.system.entity.Crmoalog;
import com.itmk.system.mapper.CrmoalogDao;
import com.itmk.system.service.CrmoalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional//保护数据的完整性
public class CrmoalogServiceImpl implements CrmoalogService {
    @Autowired
    protected CrmoalogDao crmoalogDao;

    @Override
    public int insertSelective(Crmoalog crmoalog) {
        return this.crmoalogDao.insertSelective(crmoalog);
    }

    @Override
    public Crmoalog selectByPrimaryKey(Integer logId){
        return this.crmoalogDao.selectByPrimaryKey(logId);

    }
    @Override
   public int updateByPrimaryKeySelective(Crmoalog crmoalog){

        return this.crmoalogDao.updateByPrimaryKeySelective(crmoalog);
    }
    @Override
    public int deleteByPrimaryKey(Integer logId){
       return this.crmoalogDao.deleteByPrimaryKey(logId);

    }
    @Override
   public List<Crmoalog> selectCrmlist(){
          return this.crmoalogDao.selectCrmlist();

    }
}
