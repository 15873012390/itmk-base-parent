package com.itmk.system.service.Impl;


import com.itmk.system.entity.Noties;
import com.itmk.system.mapper.NotiesDao;
import com.itmk.system.service.NotiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class NotiesServiceImpl  implements NotiesService {
    @Autowired
    private NotiesDao notiesDao;

    /**
     * 查询所有公告1
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
     * 查询公告状态
     * @param state
     * @return
     */
    @Override
    public List<Noties> selectState(Integer state) {
        return notiesDao.selectState(state);
    }

    /**
     * 查询公告状态 已结束
     * @param state
     * @return
     */
    @Override
    public List<Noties> selectendState(Integer state) {
        return notiesDao.selectendState(state);
    }

    /**
     * 根据ID删除公告
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return notiesDao.deleteByPrimaryKey(id);
    }

    /**
     * 根据时间查询字段
     * @param start_date
     * @param end_date
     * @return
     */
    @Override
    public List<Noties> selectTime(String start_date, String end_date) {
        return notiesDao.selectTime(start_date,end_date);
    }


    /**
     * 根据ID修改公告
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(Noties record) {
        return notiesDao.updateByPrimaryKey(record);
    }

    /**
     * 根据ID修改状态
     * @param msgId
     * @return
     */
    @Override
    public int updateState(Integer msgId) {
        return notiesDao.updateState(msgId);
    }

}
