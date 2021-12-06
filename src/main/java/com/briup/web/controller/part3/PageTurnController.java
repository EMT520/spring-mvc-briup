package com.briup.web.controller.part3;

import com.briup.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 第三部分： 3.页面跳转
 *           1.servlet ： 请求对象 响应对象
 *           2.字符串   方法的返回值
 *           3.ModelAndView  方法的返回值
 */
@Controller()
@RequestMapping("pageTurn")
public class PageTurnController {
    /**
     * 通过内部跳转到一个jack.jsp页面
     * @param request
     * @param response
     */
    @RequestMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //项目的根目录 ： localhost:8888/project/
        String path = "/WEB-INF/jsp/jack.jsp";
        request.getRequestDispatcher(path).
                forward(request,response);
       /* PrintWriter writer = response.getWriter();
        writer.println("html中每一行代码");*/
    }

    /**
     * @return 逻辑视图名
     */
    @RequestMapping("/other")
    public String other(){
        //通过内部跳转进行访问
        System.out.println("other....");
        return "jack";
    }
    /**
     * 通过内部跳转到另一个url
     * @param request
     * @param response
     */
    @RequestMapping("/test2")
    public void test2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pageTurn/other";
        request.getRequestDispatcher(path).forward(request,response);
    }
    /**
     * 通过重定向跳转到另一个url
     * @param request
     * @param response
     */
    @RequestMapping("/test3")
    public void test3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 注意: /表示服务器的根目录
         * 访问中 ：
         *  localhost:8888/pageTurn/other  404
         *
         */
        String path = "/pageTurn/other";
        response.sendRedirect(path);
    }

    /**
     *
     * @return 字符串表示跳转到一个页面
     */
    @RequestMapping("/test4")
    public String test4(){
        // /html/login.html
        //视图解析器： /WEB-INF/jsp/jack.jsp
        return "jack";
    }

    /**
     *
     * @return 字符串 内部跳转
     */
    @RequestMapping("/test5")
    public String test5(){
        return "forward:/pageTurn/other";
    }

    /**
     *
     * @return 字符串 重定向
     */
    @RequestMapping("/test6")
    public String test6(){
        return "redirect:/pageTurn/other";
    }

    /**
     *
     * @return 跳转页面
     */
    @RequestMapping("/test7")
    public ModelAndView test7(){
        return new ModelAndView("jack");
    }
    /**
     *
     * @return 内部跳转
     * 第一个斜杆 是项目根目录
     */
    @RequestMapping("/test8")
    public ModelAndView test8(){
        return new ModelAndView("forward:/pageTurn/other");
    }
    /**
     *
     * @return 重定向
     * 第一个斜杆 项目根目录
     */
    @RequestMapping("/test9")
    public ModelAndView test9(){
        return new ModelAndView("redirect:/pageTurn/other");
    }
    /*
       返回值为String: 表示 另一个资源  视图资源  url资源
     */
    @RequestMapping("/hello")
    @ResponseBody
    public Student method(){
        System.out.println("hello......");
        return new Student(1,"jack");
    }
}
