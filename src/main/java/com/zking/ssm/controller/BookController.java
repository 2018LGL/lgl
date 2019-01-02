package com.zking.ssm.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zking.ssm.model.Book;
import com.zking.ssm.model.Btype;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @ModelAttribute
    public void init(Model model){
        System.out.println("init");
        List<Btype> lst = new ArrayList<>();
        lst.add(new Btype("休闲","休闲"));
        lst.add(new Btype("无敌","无敌"));
        lst.add(new Btype("计算机","计算机"));
        model.addAttribute("btypes",lst);
        Book book = new Book();
        model.addAttribute("book",book);
    }

    @RequestMapping("/toadd")
    public String toAdd(Model model){
        System.out.println("toadd");
        return "book/addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(@Validated(value = {Book.group.add.class}) Book book, BindingResult bindingResult, Model model){

        System.out.println(book);
        if(bindingResult.hasErrors()){
            System.out.println("errors");
            return "/book/addBook";
        }else{
            int insert = bookService.insert(book);
            return "redirect:toadd";
        }
    }

    @RequestMapping("/bookList")
    public String bookLst(Book book, HttpServletRequest request, Model model){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        List<Book> books = bookService.queryBookPager(book, pageBean);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("rows",books);
        return "book/bookList";
    }

    @RequestMapping("/bookList1")
    @ResponseBody
    public Map<String,Object> bookLst1(Book book, HttpServletRequest request){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        List<Book> books = bookService.queryBookPager(book, pageBean);

        Map<String,Object> map = new HashMap<>();
        map.put("rows",books);
        map.put("total",pageBean.getTotal());
        return map;
    }

    @RequestMapping("/SingleBook")
    @ResponseBody
    public Book toEntity(@RequestParam Integer id){
        Book book = bookService.selectByPrimaryKey(id);
        book.setTime(new Date());
        return book;
    }



    @RequestMapping("/toUpload")
    public String toUpload(@RequestParam Integer id,Model model){
        model.addAttribute("bookId",id);
        return "book/bookUpload";
    }

}
