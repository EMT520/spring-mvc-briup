package com.briup.dao;

import com.briup.bean.Teacher;

import java.sql.SQLException;

public interface ITeacherDAO {
    Teacher findTeacherByName(String name) throws SQLException;
}
