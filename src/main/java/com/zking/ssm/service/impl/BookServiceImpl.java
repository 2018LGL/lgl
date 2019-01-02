package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.BookMapper;
import com.zking.ssm.model.Book;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Transactional
    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> queryBookPager(Book book, PageBean pageBean) {
        return bookMapper.queryBookPager(book);
    }

    @Override
    public Book selectByPrimaryKey(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

}
