package com.briup.exception;

import com.briup.util.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//全局异常处理类：所有web层代码发生异常，都捕获到
@ControllerAdvice
public class TestExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handler(Exception e){
        System.out.println("全局异常处理");
        // 程序运行过程中，遇到的是用户自定义异常，展示用户
        if(e instanceof TeacherException){
            return new Result(10001,e.getMessage());
        }
        return new Result(10001,"程序内部错误,联系管理员");
    }
}
