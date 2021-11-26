package com.briup.web.controller.part2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 *  2.4 请求头映射
 *  !id 请求头信息中不能包含id=XXX
 *  accept  客户端浏览器可以接收的响应媒体的类型
 *     默认为任意类型
 */
@Controller
@RequestMapping("/headMapping")
public class HeadMappingController {
    @RequestMapping(value = "/test",headers = {"host","!id"})
    public String test(HttpServletRequest request){
        //1.打印出请求头信息
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            System.out.println(name);
        }
        return "jack";
    }
    @RequestMapping(consumes = "application/json",produces = "text/html",value = "/test2")
    public String test2(){
        return "jack";
    }
}
