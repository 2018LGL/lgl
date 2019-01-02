package com.zking.ssm.controller;

import com.zking.ssm.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;

@Controller
public class HomeController {

    @RequestMapping("home/index.shtml")
    public String toindex(HttpSession session){
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.CHINA);
        return "index";
    }

    @RequestMapping("/localChange")
    public String localChange(@RequestParam String locale,HttpSession session){
        if("en".equals(locale)){
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.US);
        }else{
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.CHINA);
        }
        return "index";
    }

    @RequestMapping("/toHome")
    public String tohome(Book book, HttpServletRequest request,
                         @RequestParam String sex,
                        @RequestParam HashMap<String,Object> params,
                        Model model){
        System.out.println(book);
        System.out.println(request.getContextPath());
        System.out.println(sex);
        System.out.println(params);
        model.addAttribute("params",params);
        return "redirect:tohome1";
    }

    @RequestMapping("/tohome1")
    public String welcome(){
        System.out.println("tohome1");
        return "welcome";
    }



}
