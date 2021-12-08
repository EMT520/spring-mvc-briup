package com.briup.web.controller.part4;

import com.briup.bean.Student;
import com.briup.bean.User;
import com.briup.exception.StudentException;
import com.briup.service.IUserService;
import com.briup.service.UserServiceImpl;
import com.briup.util.Result;
import com.briup.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * web层代码： 处理器类 接收请求 作出响应
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/user/{id}")
    @ResponseBody
    public Map findUserById(@PathVariable Integer id){
        //1.接收参数： springMVC自动将数据绑定到方法参数上，无需获取
        System.out.println("请求参数为："+id);
        //2.调用service层方法，传递参数id，查询user信息
        Map<Object, Object> map = new HashMap<>();
        try {
            //请求成功，返回正确的查询数据
            User user = userService.findUserById(id);
            map.put("data",user);
            map.put("code",10000);
            map.put("msg","查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            //请求失败，将失败的信息告诉前端的访问的用户
            map.put("code",10001);
            map.put("msg","查询失败："+e.getMessage());
        }
        return map;
    }

    /**
     * http://localhost:8888/user/user2/0
     * @return
     */
    @RequestMapping("/findStudent")
    @ResponseBody
    public Result findStudent2(){
        //return new Result(1,"成功");
        //return  new Result(ResultCode.SUCCESS);
        Student student = new Student(1, "tom");
        //return  Result.success(student);
        return  Result.failure(ResultCode.DATA_NONE);
    }
    @RequestMapping("/user2/{id}")
    @ResponseBody
    public Result findUserById2(@PathVariable Integer id){
        try {
            User user = userService.findUserById(id);
            return Result.success(user);
        } catch (Exception e) {
            e.printStackTrace();
            //请求失败，将失败的信息告诉前端的访问的用户
           // Result result = new Result(10001, e.getMessage());
            String msg = "程序内容错误，联系管理员";
            if(e instanceof StudentException){
                msg = e.getMessage();
            }
            return new Result(10001,msg);
        }
    }

}
