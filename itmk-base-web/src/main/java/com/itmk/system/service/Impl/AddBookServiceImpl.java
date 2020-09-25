package com.itmk.system.service.Impl;

import com.itmk.system.entity.AddBook;
import com.itmk.system.mapper.AddBookDao;
import com.itmk.system.service.AddBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional  //注入事务管理，保护事务的完整性
public class AddBookServiceImpl implements AddBookService {
    @Autowired
    private AddBookDao addBookDao;

    @Override
    public List<AddBook> getAddBookList() {

        return this.addBookDao.getAddBookList();
    }

    @Override
    public AddBook findAddBookById(Integer id) {

        return this.addBookDao.findAddBookById(id);
    }

    @Override
    public List<AddBook> findAddBookByName(String loginName) {

        return  this.addBookDao.findAddBookByName(loginName);
    }

    @Override
    public AddBook findAddBookByDname(AddBook record) {
        return this.addBookDao.findAddBookByDname(record);
    }

    @Override
    public int deleteAddBookById(Integer id) {
        return this.addBookDao.deleteAddBookById(id);
    }


}
