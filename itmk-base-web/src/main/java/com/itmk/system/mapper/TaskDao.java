package com.itmk.system.mapper;

import com.itmk.system.entity.Task;

import java.util.List;

public interface TaskDao {
    public List<Task> getTaskList();

    public int  insertSelect(Task record);

    public int  deleteByPrimaryKey(Integer id);

    public int  updateByPrimaryKey(Task record);

}
