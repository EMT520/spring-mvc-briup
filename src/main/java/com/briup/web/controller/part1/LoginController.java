package com.briup.web.controller.part1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *  登录功能处理器
 *  实现功能：1.接收用户登录操作的发送的登录名
 *  		2.默认登录成功，实现将登录名保存到session对象中
 */
public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取登录用户名
		String name = request.getParameter("username");
		//2.获取或创建session对象
		HttpSession session = request.getSession();
		//3.session对象中保存用户登录信息
		session.setAttribute("user", name);
		//4.使用响应体返回登录成功字符串
		response.getWriter().append("login ok!");
		//5.如果使用响应对象response作出响应，可以直接返回null、
		return null;
	}
}
