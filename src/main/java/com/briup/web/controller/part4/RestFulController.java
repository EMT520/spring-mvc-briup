package com.briup.web.controller.part4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestFulController {
    @GetMapping("/test")
    public String method(){
        return "jack";
    }

}
