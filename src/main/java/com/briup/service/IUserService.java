package com.briup.service;

import com.briup.bean.User;

/**
 * service层接口，操作User用户的信息
 */
public interface IUserService {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User findUserById(Integer id) throws Exception;
}
