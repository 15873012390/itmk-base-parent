package com.itmk.system.mapper;

import com.itmk.system.entity.AddBook;
import com.itmk.system.entity.SysUser;
import com.itmk.system.entity.Task;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface AddBookDao {
    public List<AddBook> getAddBookList();

    public AddBook findAddBookById(Integer id);

    public List<AddBook> findAddBookByName(String loginName);

    public AddBook findAddBookByDname(AddBook record);

    public int deleteAddBookById(Integer id);

    public int  updateAddKey(AddBook record);
}
