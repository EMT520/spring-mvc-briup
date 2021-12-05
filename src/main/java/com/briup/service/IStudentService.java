package com.briup.service;

import com.briup.bean.Student;

/**
 * service层接口
 */
public interface IStudentService {
    /**
     * 根据学号返回学生信息
     * @param id
     * @return
     */
    Student findStudentById(Integer id);
}
