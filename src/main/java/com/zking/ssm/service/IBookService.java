package com.zking.ssm.service;

import com.zking.ssm.model.Book;
import com.zking.ssm.util.PageBean;

import java.util.List;

public interface IBookService {


    int insert(Book record);

    List<Book> queryBookPager(Book book, PageBean pageBean);

    Book selectByPrimaryKey(Integer id);

}