package com.zking.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.ssm.model.Book;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest extends BaseTestCase{

    @Autowired
    private IBookService bookService;

    @Override
    public void setUp() {
        super.setUp();
    }

    @Test
    public void insert() {
        book.setBookname("你好中国");
        book.setBooktype("爱国");
        book.setPrice(1000f);
        bookService.insert(book);

    }

    @Test
    public void queryBookPager() {
        PageBean pageBean = new PageBean();
        book.setBookname("1");
        pageBean.setPage(2);
        pageBean.setRows(5);
        //pageBean.setPagination(false);


        /*if(null!=pageBean&&pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }*/


        List<Book> books = bookService.queryBookPager(book, pageBean);
        /*if(null!=pageBean&&pageBean.isPagination()){
            PageInfo pageInfo = new PageInfo(books);
            System.out.println("当前页码："+pageInfo.getPageNum());
            System.out.println("每页多少条记录："+pageInfo.getPageNum());
            System.out.println("总记录数："+pageInfo.getPageNum());
            pageBean.setTotal(pageInfo.getTotal()+"");
        }
        System.out.println("PageBean的总记录数："+pageBean.getTotal());*/


        for (Book book1 : books) {
            System.out.println(book1);
        }

        System.out.println("--------------------");
        List<Book> books1 = bookService.queryBookPager(book, pageBean);
        for (Book book1 : books1) {
            System.out.println(book1);
        }
    }

    @Test
    public void selectSingele(){
        Book book = bookService.selectByPrimaryKey(1);
        System.out.println(book);
        System.out.println("-------------------------");
        Book book1 = bookService.selectByPrimaryKey(1);
        System.out.println(book1);

    }
}