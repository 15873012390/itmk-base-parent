package com.itmk.system.mapper;

import com.itmk.system.entity.AddBook;
import com.itmk.system.entity.Task;
import com.itmk.system.vo.QueryTaskVO;

import java.util.List;

public interface TaskDao {
    public List<QueryTaskVO> getTaskList();

    public int  insertSelect(Task record);

    public int  deleteByPrimaryKey(Integer id);

    public int  updateByPrimaryKey(Task record);

    public List<Task>  findTaskByName(Task record);

}
