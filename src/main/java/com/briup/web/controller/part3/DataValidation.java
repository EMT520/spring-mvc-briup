package com.briup.web.controller.part3;

import com.briup.bean.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 数据验证：
 *  1.导入hibernate-validator相关jar包
 */
@Controller
@RequestMapping("/dataValidation")
public class DataValidation {
    /**
     * http://localhost:8888/dataValidation/test
     * 正确的请求参数 ：
     *  id=1&name=jack&dob=1997-12-17&age=18
     * 错误参数
     * 1.没有提供参数id
     *   name=jack&dob=1997-12-17&age=18
     * 2.没有提供参数name
     *   id=1&dob=1997-12-17&age=18
     * 3.日期大于今天
     *   id=1&name=jack&dob=2027-12-17&age=18
     * 4.年龄小于18
     *   id=1&dob=1997-12-17&age=17
     * @param t  教师对象
     * @param br 如果请求参数值不满足设置的验证条件，将错误信息保存在BindingResult对象中
     * @return  响应体字符串
     */
    @RequestMapping("/test")
    @ResponseBody
    public String test(@Valid Teacher t, BindingResult br){
        if(br.hasErrors()){
            //打印验证错误的提示信息
            br.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
            return "error data param";//错误提示
        }
        return "success data param";//正确提示
    }

    /**
     * 使用post表单提交新增教师的信息
     * POST http://localhost:8888/dataValidation/test2
     * 请求头 Content-Type:application/x-www-form-urlencoded
     * @param t
     * @param br
     * @return 视图
     */
    @RequestMapping("/test2")
    public String test2(@Valid Teacher t, BindingResult br){
        if(br.hasErrors()){
            //打印验证错误的提示信息
            br.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
            return "valid";//错误提示页面
        }
        return "jack";//正确提示
    }
}
