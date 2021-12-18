package com.briup.web.controller.part4;

import com.briup.bean.Student;
import com.briup.bean.Teacher;
import com.briup.service.ITeacherService;
import com.briup.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TeacherController {
    @Autowired //自动注入 获取ioc容器中类型相同的对象
    private ITeacherService service;//= new TeacherServiceImpl();
    @RequestMapping("/teacher/{id}")
    @ResponseBody
    public Teacher findTeacherById(@PathVariable Integer id) throws Exception{
        //当方法发生异常：
       // System.out.println(1/0);
        if(id == 0){
            throw new RuntimeException("学号不为0的异常");
        }
        if(id == 1){
            System.out.println(1/0);
        }
        if(id == 3){
            throw new IOException("自定义IO异常");
        }
        if(id == 4){
          throw new SQLException("自定义数据库异常");
        }
        return new Teacher(1,"jack");
    }
    //@ExceptionHandler(IOException.class)
    public String method(){
        return "error_io";
    }
   // @ExceptionHandler(SQLException.class)
    public String method2(){
        return "error_sql";
    }

    //@ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model m){
        //当当前类中方法发生错误,自动该方法
        String msg = e.getMessage();
        if (e instanceof ArithmeticException){
            msg = "程序内部错误，请联系管理员";
        }

        m.addAttribute("msg",msg);
        return "error";//逻辑视图名
    }
    //当异常发生时，返回错误的json格式的字符串
    //@ExceptionHandler(Exception.class)
    //@ResponseBody
    public Map handleException2(Exception e){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code",1001);
        map.put("msg","程序错误:"+e.getMessage());
        map.put("data",null);
        return map;
    }
    @RequestMapping("/findTeacherByName")
    @ResponseBody
    public Result findTeaherByName(String name) throws Exception{
        //获取参数信息： 自动数据绑定 url?name=jack
        //2.调用service的代码
        Teacher t = service.findTeacherByName(name);
        return Result.success(t);
    }
}
