package com.briup.web.controller.part3;

import com.briup.bean.Student;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *  第三部分 1.数据绑定
 *   1.@ModelAttribute
 *   2.@InitBinder
 *   3.@Scope
 *   4.@RequestBody
 *   5.@ResponseBody
 *   注意： 使用@RequestBody 和 @ResponseBody注解时，需要导入操作json的jackson的3个jar包
 *         jackson-core-2.11.3.jar
 *         jackson-annotations-2.11.3.jar
 *         jackson-databind-2.11.3.jar
 */
@Controller
@RequestMapping("/dataBind2")
@Scope("prototype") //原型模式，每次请求都会创建一个处理器对象，默认是单例对象
public class DataBind2Controller {

     public DataBind2Controller() {
          System.out.println("创建处理器DataBind2Controller对象");
     }
     /**
      * @ModelAttribute 注解用于将方法的返回值绑定到指定的模型属性上
      * @return  返回的字符串添加的到模型属性上
      */
     @ModelAttribute
     public String test(){
          System.out.println("添加@ModelAttribute注解的方法被自动调用");
          return "jack";
     }

     /**
      * 在通过任意url访问映射的方法时,自动调用该方法，
      * @return stringList=[A, B, C]值保存在模型对象中
      */
     @ModelAttribute
     public List<String> test2(){
          return Arrays.asList("A","B","C");
     }

     /**
      * 在通过任意url访问映射的方法时,自动调用该方法，
      * @return  student=Student{id=1, name='jack', dob=null, address=null}值保存在模型对象中
      */
     @ModelAttribute
     public Student test3(){
          return  new Student(1,"jack");
     }

     /**
      * 在通过任意url访问映射的方法时,自动调用该方法，
      * @return name=tom 值保存在模型对象中
      */
     @ModelAttribute("name")
     public String test4(){
          return "tom";
     }
     /**
      * http://localhost:8888/dataBind2/test2
      *  打印模型对象,获取到test test2 test3 方法中的返回值
      * @param model 模型对象
      * @return 逻辑视图名
      */
     @RequestMapping("/test2")
     public String test10(Model model){
          System.out.println(model);//打印出：{string=jack, student=Student{id=1, name='jack', dob=null, address=null}, name=tom, stringList=[A, B, C]}
          return "jack";
     }

     /**
      * http://localhost:8888/dataBind2/test3
      * 如果模型中已经有了指定name的值， @ModelAttribute 还会从模型中取值
      * 如果请求参数中传递 name=jack,也无法获取
      * @param name
      * @return
      */
     @RequestMapping("/test3")
     public String test11(@ModelAttribute("name") String name){
          //打印输出模型对象中的name对应的值tom
          System.out.println(name);
          return "jack";
     }

     /**
      * http://localhost:8888/dataBind2/test4?name=tim
      * @param name 从请求参数中获取值
      * @return
      */
     @RequestMapping("/test4")
     public String test12(@ModelAttribute("name") @RequestParam String name, Model model){
          //打印输出请求参数中的name对应的值tim
          System.out.println(name);
          System.out.println(model);
          return "jack";
     }

     /**
      * 当请求参数中包含字符串时间需要转换为java.util.Date类型的对象时
      * 自动调用@InitBinder方法,将字符串时间转换为Date对象
      * @param wb
      */
     //@InitBinder
     public void StringConvertDate(WebDataBinder wb){
          System.out.println("自动调用@InitBinder方法,将字符串时间转换为Date对象");
          //1.设置字符串转换格式
          SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
          //2.创建时间编辑器对象
          CustomDateEditor editor = new CustomDateEditor(format, true);
          //3.注册时间编辑器对象,将String字符串转换为Date对象
          wb.registerCustomEditor(Date.class,editor);
     }
     /**
      * POST http://localhost:8888/dataBind2/test5
      * 请求体： id=1&name=jack&dob=1996-10-20
      * @param s
      * @return
      */
     @RequestMapping("/test5")
     public String test13(Student s){
          System.out.println(s);//Student{id=101, name='jack', dob=Wed Oct 09 00:00:00 CST 1991, address=null}
          return "jack";
     }





     /**
      * POST http://localhost:8888/dataBind2/addStudent
      * 请求头 : Content-Type:application/json
      * 请求体 : {"id":1,"name":"jack","dob":"1997-10-20","address":{"id":101,"city":"北京"}}
      * @param s 将请求体中的json字符串封装成Student对象,自动注入到方法参数s
      * @return
      */
     @RequestMapping("/addStudent")
     public String test12(@RequestBody Student s){
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
     public Student test13(){
         return new Student(1,"jack");
     }
     /**
      * http://localhost:8888/dataBind2/findStudentDobById
      * 将返回的Student对象转换为json字符串写入到响应体中
      * 默认返回时间类型的为时间戳类型
      * {"id":1,"name":"jack","dob":1637852927915,"address":null}
      * 使用注解@JsonSerialize将Date对象转换为字符串类型
      * {"id":1,"name":"jack","dob":"2021-11-25","address":null}
      * @return json字符串对象到前端
      */
     @RequestMapping("/findStudentDobById")
     @ResponseBody
     public Student test14(){
          Student s = new Student(1, "jack");
          s.setDob(new Date());
          return s;
     }
}
