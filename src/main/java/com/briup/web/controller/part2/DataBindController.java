package com.briup.web.controller.part2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 *  第二部分 4.数据绑定
 *  主要学习内容：
 *      1. @RequestParam
 *      2. @PathVariable
 *      3. @CookieValue
 *      4. @RequestHeader
 */
@Controller
@RequestMapping("/dataBind")
public class DataBindController {
    /**
     * 请求参数名与方法参数名相同时，可以实现自动映射，直接获取请求参数值
     * http://localhost:8888/dataBind/test?name=jack
     * @param name  请求参数
     * @return 逻辑视图名
     */
    @RequestMapping("/test")
    public String test(String name){
        System.out.println("name:"+name);
        return "jack";
    }

    /**
     * 1. http://localhost:8888/dataBind/test2
     *    如果没有提供请求参数username,抛出404错误
     * 2. http://localhost:8888/dataBind/test2?username=jack
     *    获取请求中的username参数的值，并注入到test2方法参数name中
     *
     * @param name 请求参数username与方法参数name映射
     * @return 逻辑视图名
     */
    @RequestMapping("/test2")
    public String test2(@RequestParam("username") String name){
        System.out.println("name:"+name);
        return "jack";
    }

    /**
     * 1. http://localhost:8888/dataBind/test3
     *    如果没有提供请求参数username,不会抛出异常，并返回null
     * 2. http://localhost:8888/dataBind/test2?username=jack
     *    获取请求中的username参数的值，并注入到test2方法参数name中
     * @param name 请求参数username与方法参数name映射
     * @return 逻辑视图名
     */
    @RequestMapping("/test3")
    public String test3(@RequestParam(required = false,value = "username") String name){
        System.out.println("name:"+name);
        return "jack";
    }
    @RequestMapping("/method")
    public String method(Integer id){
        System.out.println("id:"+id);
        return "jack";
    }

    /**
     * http://localhost:8888/dataBind/test/202101
     *  请求URL中的模板变量值202101映射到功能处理方法的参数userId
     * @param userId
     * @return
     */
    @RequestMapping("/test/{id}")
    public String test4(@PathVariable("id") String userId){
        System.out.println("userId:"+userId);
        return "jack";
    }

    /**
     * http://localhost:8888/dataBind/test5/jack
     *  1.请求URL中的模板变量值jack映射到功能处理方法的参数name
     *  2.@PathVariabl自动的把数据放到模型中去，页面中可以直接使用EL表达式取值
     *
     * @param username
     * @return
     */
    @RequestMapping("/test5/{username}")
    public String test5(@PathVariable String username){
        System.out.println("username:"+username);
        //观察jsp页面的username值为路径中的模版变量值
        return "jack";
    }

    /**
     * http://localhost:8888/dataBind/test6
     * 1. 如果请求头中不包含JSESSIONID的cookie信息，抛出 HTTP 400错误的请求
     * 2. 如果请求头中包含JSESSIONID的cookie信息，打印出JSESSIONID的值
     * @param jsessionId  session对象的id值
     * @return 逻辑视图名
     */
    @RequestMapping("/test6")
    public String test6(@CookieValue("JSESSIONID") String jsessionId){
        System.out.println("jsessionId:"+jsessionId);
        return "jack";
    }
    //创建session的method
    @RequestMapping("/method2")
    public String method2(HttpSession session){
        System.out.println(session.getId());
        return "jack";
    }
    /**
     * http://localhost:8888/dataBind/test6
     * 1. 如果请求头中不包含JSESSIONID的cookie信息，打印null值
     * 2. 如果请求头中包含JSESSIONID的cookie信息，打印出JSESSIONID的值
     * @param jsessionId  session对象的id值
     * @return 逻辑视图名
     */
    @RequestMapping("/test7")
    public String test7(@CookieValue(required = false,value = "JSESSIONID") String jsessionId){
        System.out.println("jsessionId:"+jsessionId);
        return "jack";
    }

    /**
     * http://localhost:8888/dataBind/test8
     * 获取请求头中 Host: localhost:8888的主机信息
     * @param host 请求头参数自动注入到方法的参数host
     * @return
     */
    @RequestMapping("/test8")
    public String test8(@RequestHeader("host") String host){
        System.out.println("host:"+host);
        return "jack";
    }


}
