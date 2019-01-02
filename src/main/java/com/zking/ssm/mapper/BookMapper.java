package com.zking.ssm.mapper;

import com.zking.ssm.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> queryBookPager(Book book);

    int updatePhotoByBookId(Book book);


}