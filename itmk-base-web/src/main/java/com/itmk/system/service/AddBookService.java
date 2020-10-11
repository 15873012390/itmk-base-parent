package com.itmk.system.service;

import com.itmk.system.entity.AddBook;

import java.util.List;

/*
* 通讯录接口
* */
public interface AddBookService {
    //查找联系人列表
    public List<AddBook> getAddBookList();
    //根据id查找联系人
    public AddBook findAddBookById(Integer id);
    //根据姓名查找联系人
    public List<AddBook> findAddBookByName(String loginName);
   //根据部门名称查找联系人
    public AddBook findAddBookByDname(AddBook record);
    //根据删除联系人
    public int deleteAddBookById(Integer id);

    public int  updateAddKey(AddBook record);
}
