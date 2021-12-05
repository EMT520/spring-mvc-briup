package com.briup.web.controller.part4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @ControllerAdvice + @ExceptionHandler 实现全局异常处理
 *
 */
@Controller
@RequestMapping("/exception2")
public class Exception2Controller{

    @RequestMapping("/test")
    public String test(String name) throws Exception {
        if(name.equals("jack")){
            //当参数为jack时，模拟抛出自定义运行时异常
            throw new RuntimeException("自定义异常");
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

}
