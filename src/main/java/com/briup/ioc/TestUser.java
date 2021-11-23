package com.briup.ioc;

import com.briup.bean.User;

/**
 * 测试user类的单例模式
 */
public class TestUser {
	public static void main(String[] args) {
		//User u = new User(); 编译错误，表示user构造器私有，user对象不能任意创建，
		User u = User.getInstance();
		User u2 = User.getInstance();
		//返回true表示整个程序运行过程中有且只有一个User对象。
		System.out.println(u == u2);//true
	}
}
