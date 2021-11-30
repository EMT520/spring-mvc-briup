package com.briup.web.controller.part2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *  2.2 URL路径映射
 */
@Controller
@RequestMapping("/urlMapping")
public class UrlMappingController {
    /**
     * value可以指定方法映射的url路径
     * http://localhost:8888/urlMapping/test
     * @return
     */
    @RequestMapping(value = "/test")
    public String test(){
        return "jack";
    }

    /**
     * 多个URL路径可以映射到同一个处理器的功能处理方法
     * http://localhost:8888/urlMapping/test2
     * http://localhost:8888/urlMapping/test3
     * @return
     */
    @RequestMapping(value = {"/test2","/test3"})
    public String test2(){
        return "jack";
    }

    /**
     * 注解中只出现一个参数且参数名为value的话,可以将参数名去掉
     * http://localhost:8888/urlMapping/test4
     * @return
     */
    @RequestMapping("/test4")
    public String test4(){
        return "jack";
    }

    /**
     * 通过@PathVariable可以提取URI模板模式中的{id}中的值
     * http://localhost:8888/urlMapping/test5/202001
     * http://localhost:8888/urlMapping/test5/A0001
     * @param id
     * @return
     */
    @RequestMapping("/test5/{id}")
    public String test5(@PathVariable String id){
        System.out.println("获取URI模板模式中id: "+id);
        return "jack";
    }

    /**
     * http://localhost:8888/urlMapping/test6/1/20210101
     *
     * @param classId
     * @param stuId
     * @return
     */
    @RequestMapping("/test6/{classId}/{stuId}")
    public String test6(@PathVariable String classId,@PathVariable String stuId){
        System.out.println("classId: "+classId);
        System.out.println("stuId: "+stuId);
        return "jack";
    }

    /**
     * 表示任意子路径
     * http://localhost:8888/urlMapping/test7
     * http://localhost:8888/urlMapping/test7/a/b
     * http://localhost:8888/urlMapping/test7/a
     * @param request
     * @return
     */
    @RequestMapping("/test7/**")
    public String test7(HttpServletRequest request){
        String path = request.getServletPath();
        System.out.println("请求路径："+path);
        return "jack";
    }

    /**
     * http://localhost:8888/urlMapping/test8 404错误
     * http://localhost:8888/urlMapping/test8/a  访问成功
     * http://localhost:8888/urlMapping/test8/ab  访问成功
     * @param request 请求对象
     * @return 逻辑视图名
     */
    @RequestMapping("/test8/*")
    public String test8(HttpServletRequest request){
        String path = request.getServletPath();
        System.out.println("请求路径："+path);
        return "jack";
    }

    /**
     * http://localhost:8888/urlMapping/test9/a 访问成功
     * http://localhost:8888/urlMapping/test9/ab  404错误
     * @param request
     * @return
     */
    @RequestMapping("/test9/?")
    public String test9(HttpServletRequest request){
        String path = request.getServletPath();
        System.out.println("请求路径："+path);
        return "jack";
    }

    /**
     * 正则表达式风格的URL路径映射
     * 正确url: http://localhost:8888/urlMapping/method/1
     * 错误url: http://localhost:8888/urlMapping/method/a
     * 错误提示 ：404
     * @param id
     * @return
     */
    @RequestMapping("/method/{id:\\d+}")
    public String method(@PathVariable String id){
        System.out.println("id:"+id);
        return "jack";
    }
}
