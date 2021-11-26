package com.briup.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 	登录拦截器：
 * 	当用户 请求任意资源 ： 必须登录系统
	当用户访问/login.html  可以访问该资源
	当用户被拦截之后，我们希望用户返回到登录页面实现登录操作后，在进行访问其他资源。
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	public LoginInterceptor() {
		//观察输出语句的次数，可以得到拦截器对象为单例对象
		System.out.println("创建登录拦截器");
	}
	
	//在每次请求处理前进行拦截验证
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("拦截器进行用户登录验证...");
		/*
			情况1：当用户请求的url为/login 直接通过拦截
		 */
		//获取用户请求报文中请求的url
		String path = request.getServletPath();
		if(path.contains("login")) {
			//如果请求url中包含login,则通过拦截，不进行判断是否登录
			return true;
		}
		/*
			情况2：当用户请求的url为其他请求路径时,判断是否登录
		 */
		//1.根据请求对象获取Session对象
		HttpSession session = request.getSession();
		//2.获取用户登录后保存在session对象中的名字
		Object obj = session.getAttribute("user");
		if(obj == null) {
			//用户未登录,返回信息提示用户未登录
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("用户未登录，请登录后操作");
			//返回false,表示未通过拦截，请求被中断。
			return false;
		}
		System.out.println("通过验证，用户可以访问指定的请求url");
		return true;
	}
}
