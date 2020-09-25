package com.itmk.system.service.Impl;


import com.itmk.system.entity.Noties;
import com.itmk.system.mapper.NotiesDao;
import com.itmk.system.service.NotiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotiesServiceImpl  implements NotiesService {
    @Autowired
    private NotiesDao notiesDao;

    /**
     * 查询所有公告
     * @return
     */
    @Override
    public List<Noties> selectAll() {
        return notiesDao.selectAll();
    }

    /**
     * 添加公告
     * @param
     * @return
     */
    @Override
    public int insert(Noties record) {
        return notiesDao.insert(record);
    }

    /**
     * 根据ID查询公告
     * @param msgId
     * @return
     */
    @Override
    public Noties selectByPrimaryKey(Integer msgId) {
        return notiesDao.selectByPrimaryKey(msgId);
    }

    /**
     * 根据ID删除公告
     * @param msgId
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer msgId) {
        return notiesDao.deleteByPrimaryKey(msgId);
    }


}
