package com.briup.service;

import com.briup.bean.Teacher;
import com.briup.dao.ITeacherDAO;
import com.briup.exception.TeacherException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service//bean
public class TeacherServiceImpl implements ITeacherService{
    @Autowired//ioc中获取该对象
    private ITeacherDAO dao;
    @Override
    public Teacher findTeacherByName(String name) throws Exception {
        //调用dao层的代码
        if(name.equals("tom")){
            //用户名不存在，密码错误...
            throw new TeacherException("该用户不存在");
        }
        Teacher t = dao.findTeacherByName(name);
        return t;
    }
}
