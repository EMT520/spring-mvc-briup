package com.briup.service;

import com.briup.bean.Student;
import com.briup.dao.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * serivce层接口的实现类
 */
@Service//通过ioc容器自动创建StudentServiceImpl对象
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private IStudentDAO dao;
    public StudentServiceImpl(){
        System.out.println("创建service层StudentServiceImpl对象");
    }
    @Override
    public Student findStudentById(Integer id) {
        System.out.println("调用service层的方法");
        if (id == 20) {
            throw new RuntimeException("service模拟异常");
        }
        return dao.selectStudentById(id);
    }
}
