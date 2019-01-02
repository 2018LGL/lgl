package com.zking.ssm.service;

import com.zking.ssm.model.Book;
import com.zking.ssm.model.Bookfile;

public interface IBookfileService {

    int insert(Bookfile record, Book book);

    Bookfile selectByPrimaryKey(String fileId);

}