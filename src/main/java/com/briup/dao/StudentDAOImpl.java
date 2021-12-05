package com.briup.dao;

import com.briup.bean.Student;
import org.springframework.stereotype.Repository;

@Repository//通过ioc容器自动创建StudentDAOImpl对象
public class StudentDAOImpl implements IStudentDAO{
    public StudentDAOImpl(){
        System.out.println("创建DAO层StudentDAOImpl对象");
    }
    @Override
    public Student selectStudentById(Integer id) {
        return new Student(id,"lisi");
    }
}
