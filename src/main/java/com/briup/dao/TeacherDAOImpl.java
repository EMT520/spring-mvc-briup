package com.briup.dao;

import com.briup.bean.Teacher;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class TeacherDAOImpl implements ITeacherDAO{
    @Override
    public Teacher findTeacherByName(String name) throws SQLException {
        //jdbc代码
        if(name.equals("sql")){
            throw new SQLException("用户自定义的数据库异常");
        }
        return new Teacher(1,name);
    }
}
