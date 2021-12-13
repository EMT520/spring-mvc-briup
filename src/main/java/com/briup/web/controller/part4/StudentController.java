package com.briup.web.controller.part4;

import com.briup.bean.Student;
import com.briup.service.IStudentService;
import com.briup.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //添加到目标类上，创建出目标对象
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private IStudentService service;//自动装配IOC容器中类型为IStudentService的对象

    @RequestMapping("/student/{id}")
    @ResponseBody
    public Result findStudentById(@PathVariable Integer id){
        Student s = service.findStudentById(id);
        return Result.success(s);
    }
}
