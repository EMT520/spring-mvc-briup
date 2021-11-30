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
    /**
     * http://localhost:8888/headMapping/test
     * 请求头必须携带 username
     * 不携带username请求头,提示400 错误的请求
     * @return
     */
    @RequestMapping(value = "/test",headers = "username")
    public String test(){
        return "jack";
    }

    /**
     * http://localhost:8888/headMapping/test2
     *
     * 请求头中携带age时，提示404 未找到
     * @return
     */
    @RequestMapping(value = "/test2",headers = "!age")
    public String test2(){
        return "jack";
    }

    /**
     * http://localhost:8888/headMapping/test3
     * 请求头： username=lisi   请求成功
     *
     * 请求头： username=jack   404错误 未找到
     * @return
     */
    @RequestMapping(value = "/test3",headers = "username=lisi")
    public String test3(){
        return "jack";
    }

    /**
     * http://localhost:8888/headMapping/test4
     * 请求头： username=lisi   404错误 未找到
     * 请求头： 不包含 username 或 username=jack 请求成功
     * @return
     */
    @RequestMapping(value = "/test4",headers = "username!=lisi")
    public String test4(){
        return "jack";
    }

    /**
     * http://localhost:8888/headMapping/test5
     * 请求头： 必须提供 username age  请求成功
     * 请求头： 只提供username    404错误
     *
     * @return
     */
    @RequestMapping(value = "/test5",headers = {"username","age"})
    public String test5(){
        return "jack";
    }

    /**
     * http://localhost:8888/headMapping/test6
     * 请求头： content-Type:application/json  访问成功
     * 请求头： content-Type:text/html 提示 415 不支持的媒体类型错误
     * @return
     */
    @RequestMapping(value = "/test6",consumes = "application/json")
    public String test6(){
        return "jack";
    }

    /**
     * http://localhost:8888/headMapping/test7
     * 请求头： Accept： application/json  请求成功
     * 请求头： Accept: text/html  406 不可接受的错误
     * @return 逻辑视图名
     */
    @RequestMapping(value = "/test7",produces = "application/json")
    public String test7(){
        return "jack";
    }
}
