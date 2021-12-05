package com.briup.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 当web层中抛出异常时，统一处理，并返回指定的错误页面
     * @param e
     * @param m
     * @return
     */
    //@ExceptionHandler(value = {Exception.class})
    public String handler(Exception e, Model m){
        System.out.println("全局异常处理方法");
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
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,String> handleException(Exception e){
        System.out.println("全局异常处理，返回json字符串");
        //1.获取异常信息
        String msg = e.getMessage();
        //2.返回json字符串
        Map<String, String> result = new HashMap<>();
        result.put("code","10001");//表示错误的状态码
        result.put("msg",msg);//响应信息
        result.put("data",null);//响应数据为空
        return result;
    }

}
