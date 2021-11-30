package com.briup.web.controller.part2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  2.3 请求参数映射
 */
@RequestMapping("/paramMapping")
@Controller
public class ParamMappingController {
    /**
     * http://localhost:8888/paramMapping/test
     * 请求参数：username=jack  请求成功
     * 请求参数 ：无  400 错误的请求
     * @return
     */
    @RequestMapping(value = "/test",params = "username")
    public String test(){
        return "jack";
    }

    /**
     * http://localhost:8888/paramMapping/test2
     * 请求参数 ： 无         请求成功
     * 请求参数 ： age=18     400 错误的请求
     * @return
     */
    @RequestMapping(value = "/test2",params = "!age")
    public String test2(){
        return "jack";
    }

    /**
     * http://localhost:8888/paramMapping/test3
     * 请求参数： username=lisi 请求成功
     * 请求参数： username=jack  400 错误的请求
     * @return
     */
    @RequestMapping(value = "/test3",params = "username=lisi")
    public String test3(){
        return "jack";
    }

    /**
     * http://localhost:8888/paramMapping/test4
     * 请求参数： username=jack 或 无  请求成功
     * 请求参数： username=lisi  400 错误的请求
     *
     * @return
     */
    @RequestMapping(value = "/test4",params = "username!=lisi")
    public String test4(){
        return "jack";
    }

    /**
     * http://localhost:8888/paramMapping/test5
     * 请求参数： username=jack&id=1  请求成功
     * 请求参数： 缺少任意一个参数  400 错误的请求
     * @return
     */
    @RequestMapping(value = "/test5",params = {"username","id=1"})
    public String test5(){
        return "jack";
    }
}
