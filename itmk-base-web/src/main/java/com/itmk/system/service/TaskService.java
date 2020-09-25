package com.itmk.system.service;

import com.itmk.system.entity.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getTaskList();

    public int  insertSelect(Task record);

    public int  deleteByPrimaryKey(Integer id);

    public int  updateByPrimaryKey(Task record);
}
