package com.briup.web.controller.part2;

import com.briup.bean.Student;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * 3 方法参数
 *   1. HttpServletRequest 和 HttpServletResponse
 *   2. InputStream/OutputStream 和 Reader/Writer
 *   3. HttpSession
 *   4. 值对象（Value Object）
 *   5. Model、Map、ModelMap
 *   6. HttpEntity<T>和ResponseEntity<T>
 */
@Controller
@RequestMapping("/methodParam")
public class MethodParamController {
    /**
     * http://localhost:8888/methodParam/test?id=1&name=jack
     * @param request 请求对象
     * @param response 响应对象
     */
    @RequestMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.使用请求对象获取请求参数
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        //2.使用请求对象获取请求头信息
        String host = request.getHeader("host");
        String UserAgent = request.getHeader("User-Agent");
        //3.使用请求对象获取session对象
        HttpSession session = request.getSession();
        //4.使用响应对象响应信息
        response.getWriter().append("hello world");
    }

    /**
     *  post请求  http://localhost:8888/methodParam/test2
     *  请求体参数： id=1&name=jack
     * @param in 字节输入流
     * @param out 字节输出流
     */
    @RequestMapping("/test2")
    public void test2(InputStream in, OutputStream out) throws IOException {
        //1.将字节流转换为字符串流
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while((line = br.readLine()) != null){
            System.out.println("请求体信息："+line);
        }
        //2.使用输出流对象返回字符串
        out.write("hello world".getBytes());
    }

    /**
     * http://localhost:8888/methodParam/test3
     * //1.当请求头中不包含jsessionid时，自动注入新的session对象给test3方法
     * //2.当请求头中包含jsessionid时，自动注入jsessionid对应的session对象给test3方法
     * @param session 会话对象
     * @return 逻辑视图名
     */
    @RequestMapping("/test3")
    public String test3(HttpSession session){
        // 使用不同的浏览器访问，查看打印session对象是否是同一个对象,原因是什么?
        System.out.println(session);
        return "jack";
    }

    /**
     *  post请求  http://localhost:8888/methodParam/test4
     *  请求体： id:1&name:tom&address.id:101&address.city:北京
     * @param s  请求体中参数被自动封装到Student对象中，需要参数名和属性名字一致
     * @return 逻辑视图名
     */
    @RequestMapping("/test4")
    public String test4(Student s){
        System.out.println(s);
        return "jack";
    }

    /**
     * http://localhost:8888/methodParam/test5
     * @param m m2 m3 注入的是三个不同的类型参数，但三者是同一个对象
     * @return
     */
    @RequestMapping("/test5")
    public String test5(Model m, ModelMap m2, Map m3){
        //1. m m2 m3 是同一个对象
        System.out.println(m == m2);
        System.out.println(m2 == m3);
        /*
            2.设置不同的模型数据，在视图中通过el表达式获取
            ${m} ${m2} ${m3}
         */
        m.addAttribute("m","tom");
        m.addAttribute("m2","jack");
        m.addAttribute("m3","bob");
        return "jack";
    }

    /**
     * POST请求 ： http://localhost:8888/methodParam/test5
     * 请求体： id=1&name=jack
     * @param httpEntity 可以获取请求中各个部分的内容
     * @return
     */
    @RequestMapping("/test6")
    public String test6(HttpEntity<String> httpEntity){
        //1.获取请求体信息
        String body = httpEntity.getBody();
        System.out.println("请求体："+body);
        //2.获取请求头信息，遍历并打印
        HttpHeaders headers = httpEntity.getHeaders();
        headers.entrySet().forEach(h -> System.out.println(h));
        return "jack";
    }

    /**
     * http://localhost:8888/methodParam/test7
     * @return  响应信息实体对象
     */
    @RequestMapping("/test7")
    public ResponseEntity<String> test7(){
        //1.创建请求头对象
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text","html", Charset.forName("utf-8")));
        //2.设置请求体
        String body = "hello world";
        ResponseEntity<String> entity = new ResponseEntity<String>(body,headers,HttpStatus.OK);
        return entity;
    }
}
