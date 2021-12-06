package com.briup.dao;

import com.briup.bean.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class UserDAOImpl implements IUserDAO{
    @Override
    public User selectUserById(Integer id) throws Exception{
        //模拟数据库查询出一个用户信息

        //模拟数据库产生异常
        if(id== 1){
            throw new SQLException("自定义数据库异常");
        }

        return User.getInstance();
    }
}
