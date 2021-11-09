package com.briup.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登录拦截器： 
 * 当用户 请求任意资源 ： 必须登录系统
当用户访问/login.html  可以访问该资源 
当用户被拦截之后，我们希望用户返回到登录页面实现登录操作后，在进行访问其他资源。
 * @author lining
 *
 */
public class LoginhandlerInterceptor extends HandlerInterceptorAdapter {
	public LoginhandlerInterceptor() {
		System.out.println("创建登录拦截器");
	}
	
	//重新处理器执行预处理方法前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//当用户请求的url为userLogin 通过拦截
		String path = request.getServletPath();
		if(path.contains("userLogin")) {
			return true;
		}
		//1.根据请求对象获取Session对象
		HttpSession session = request.getSession();
		//2.获取用户登录后保存的名字
		Object obj = session.getAttribute("user");
		if(obj == null) {//用户未登录
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("用户未登录，请登录后操作");
			return false;
		}
		return true;
	}
}
