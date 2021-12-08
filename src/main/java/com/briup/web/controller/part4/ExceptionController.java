package com.briup.web.controller.part4;

import com.briup.bean.Student;
import com.briup.exception.StudentException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.SQLException;

/**
 *  1. 异常处理
 *  @ExceptionHandler  只能处理当前类中方法抛出异常
 *
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {
    @RequestMapping("/test")
    public String test(String name) throws Exception{
        if(name.equals("jack")){
            //当参数为jack时，模拟抛出自定义运行时异常
            throw new RuntimeException("自定义异常");
        }
        if(name.equals("tom")){
            throw  new StudentException("tom已经注册异常");
        }
        if(name.equals("io")){
            //当参数为io时，模拟抛出IOException异常
            throw new IOException();
        }
        if(name.equals("sql")){
            //当参数为io时，模拟抛出SQLException异常
            throw new SQLException();
        }
        return "jack";
    }
    //处理异常的方法 和 抛出异常的方法 必须 在同一个controller中
    /*
      Exception.class 表示当前类中只要发生任意异常
      都可以捕获到，作出响应操作
     */
    //@ExceptionHandler(Exception.class)
    //@ExceptionHandler(Student.class)
    @ExceptionHandler(StudentException.class)
    public String handlerException(Exception e, Model m){
        System.out.println("调用添加@ExceptionHandler的方法");
        //1.获取异常信息
        String msg = e.getMessage();
        //2.将异常信息添加到模型对象中
        m.addAttribute("msg",msg);
        //3.根据不同的异常类型，返回不同的系统页面
        if(e instanceof IOException){
            return "error_io";
        }

        if (e instanceof SQLException){
            return "error_sql";
        }
        return "error";//默认返回错误提示页面
    }
}