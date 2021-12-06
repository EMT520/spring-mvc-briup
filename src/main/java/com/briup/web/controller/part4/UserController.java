package com.briup.web.controller.part4;

import com.briup.bean.User;
import com.briup.service.IUserService;
import com.briup.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
