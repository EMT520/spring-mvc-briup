package com.briup.service;

import com.briup.bean.User;
import com.briup.dao.IUserDAO;
import com.briup.exception.StudentException;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service层接口的实现类，调用service的方法
 */
@Service //类的对象可以被spring框架创建
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDAO dao;
    @Override
    public User findUserById(Integer id) throws Exception{
        //调用dao层的方法实现查询数据库中数据
        if (id == 0){
            throw new StudentException("用户自定义的service层异常信息");
        }
        return dao.selectUserById(id);
    }
}
