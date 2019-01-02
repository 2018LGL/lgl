package com.zking.ssm.util;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageAspect {


    /**
     * 语法结构：execution(方法修饰符  方法返回值  方法所属类 匹配方法名 (  方法中的形参表 )  方法申明抛出的异常  )
     "*"  ：代表一个任意类型的参数；
     “..”：代表零个或多个任意类型的参数。
     * @param args
     * @return
     * @throws Throwable
     */
    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable {
        Object[] params=args.getArgs();
        PageBean pageBean=null;
        for (Object param : params) {
            if(param instanceof PageBean){
                pageBean=(PageBean)param;
                break;
            }
        }

        //分页参数设置
        if(null!=pageBean&&pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }
        //执行分页方法
        Object resoult = args.proceed(params);

        //获取分页信息
        if(null!=pageBean&&pageBean.isPagination()){
            List lst = (List)resoult;
            PageInfo pageInfo = new PageInfo(lst);
            System.out.println("当前页码："+pageInfo.getPageNum());
            System.out.println("每页多少条记录："+pageInfo.getPageNum());
            System.out.println("总记录数："+pageInfo.getPageNum());
            pageBean.setTotal(pageInfo.getTotal()+"");
        }
        return resoult;
    }










}
