package com.briup.dao;

import com.briup.bean.User;

public interface IUserDAO {
    User selectUserById(Integer id) throws Exception;
}
