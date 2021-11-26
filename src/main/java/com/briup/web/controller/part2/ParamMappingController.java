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
     *  localhost:8888/paramMapping/test?username=jack
     *  如果没有提供username 请求参数 提示 400 错误 错误的请求参数
     * @return
     */
    @RequestMapping(value = "/test",params = {"username=tom","!id"})
    public String test(){
        return  "jack";
    }
}
