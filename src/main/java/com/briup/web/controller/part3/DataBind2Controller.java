package com.briup.web.controller.part3;

import com.briup.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  第三部分 1.数据绑定
 *   1.@ModelAttribute
 *   2.@SessionAttributes
 *   3.@InitBinder
 *   4.@Scope
 *   5.@RequestBody
 *   6.@ResponseBody
 */
@Controller
@RequestMapping("/dataBind2")
public class DataBind2Controller {
     /**
      * POST http://localhost:8888/dataBind2/addStudent
      * 请求头 : Content-Type:application/json
      * 请求体 : {"id":1,"name":"jack"}
      * @param s 将请求体中的json字符串封装成Student对象,自动注入到方法参数s
      * @return
      */
     @RequestMapping("/addStudent")
     public String test(@RequestBody Student s){
          System.out.println(s);
          return "jack";
     }
     /**
      * http://localhost:8888/dataBind2/findStudentById
      * 将返回的Student对象转换为json字符串写入到响应体中
      * @return
      */
     @RequestMapping("/findStudentById")
     @ResponseBody
     public Student test2(){
         return new Student(1,"jack");
     }
}
