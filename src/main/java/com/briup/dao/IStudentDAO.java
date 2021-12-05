package com.briup.dao;

import com.briup.bean.Student;
import org.springframework.stereotype.Repository;

/**
 * dao层的接口
 */
public interface IStudentDAO {
    /**
     * 根据学号查询数据库中的学生信息
     * @param id 学号
     * @return
     */
    Student selectStudentById(Integer id);
}
