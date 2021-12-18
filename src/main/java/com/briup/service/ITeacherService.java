package com.briup.service;

import com.briup.bean.Teacher;

import java.sql.SQLException;

public interface ITeacherService {
    Teacher findTeacherByName(String name) throws Exception;
}
