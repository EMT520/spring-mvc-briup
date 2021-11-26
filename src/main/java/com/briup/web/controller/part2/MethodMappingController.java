package com.briup.web.controller.part2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 2.2 请求方法映射
 */
@Controller
@RequestMapping("/methodMapping")
public class MethodMappingController {
    /**
     *  不指定method的值 。默认支持所有的请求方式
     *  GET localhost:8888/methodMapping/test
     *  POST : 405 错误的请求方式 不支持 POST
     * 只能通过get方式请求
     * @return
     */
    @RequestMapping( method = RequestMethod.GET,value = "/test")
    public String test(){
        return "jack";
    }
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST},value = "/test2")
    public String test2(){
        System.out.println("test2方法可以被get和post请求方式访问");
        return "jack";
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/test3")
    public void test3(){
        //jsp 不支持 delete请求 ，通过响应对象响应信息 不返回jsp页面
    }
}
