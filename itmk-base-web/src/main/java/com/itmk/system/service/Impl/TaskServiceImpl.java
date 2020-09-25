package com.itmk.system.service.Impl;

import com.itmk.system.entity.Task;
import com.itmk.system.mapper.TaskDao;
import com.itmk.system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional  //注入事务管理，保护事务的完整性
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;
    @Override
    public List<Task> getTaskList() {
        return taskDao.getTaskList();
    }

    @Override
    public int insertSelect(Task record) {
        return taskDao.insertSelect(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return taskDao.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Task record) {
        return taskDao.updateByPrimaryKey(record);
    }
}
