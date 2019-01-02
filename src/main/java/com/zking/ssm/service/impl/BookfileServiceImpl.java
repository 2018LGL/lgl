package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.BookMapper;
import com.zking.ssm.mapper.BookfileMapper;
import com.zking.ssm.model.Book;
import com.zking.ssm.model.Bookfile;
import com.zking.ssm.service.IBookfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BookfileServiceImpl implements IBookfileService {

    @Autowired
    private BookfileMapper bookfileMapper;

    @Autowired
    private BookMapper bookMapper;

    @Transactional
    @Override
    public int insert(Bookfile record, Book book) {
        bookfileMapper.insert(record);
        bookMapper.updatePhotoByBookId(book);
        return 1;
    }

    @Transactional(readOnly = true)
    @Override
    public Bookfile selectByPrimaryKey(String fileId) {
        return bookfileMapper.selectByPrimaryKey(fileId);
    }
}
