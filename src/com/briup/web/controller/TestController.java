package com.briup.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.接收请求参数
		String id = request.getParameter("id");
		
		//2.创建ModelAndView对象实现返回 
		
		//如果返回为null,我们可以使用响应对象返回数据
		response.setContentType("text/html;charset=utf-8");
		//response.getWriter().append("查询的学生信息为："+id);
		//返回一个jack.jsp页面
		request.setAttribute("username", id);
		String path = "/WEB-INF/jsp/jack.jsp";
		//内部跳转代码
		request.getRequestDispatcher(path)
				.forward(request, response);
		return null;
	}

}
