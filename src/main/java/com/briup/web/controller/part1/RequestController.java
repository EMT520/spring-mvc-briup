package com.briup.web.controller.part1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *  测试处理器
 *  1. 通过内容跳转的返回jack.jsp页面到浏览器
 */
public class RequestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.接收请求参数
		String username = request.getParameter("username");
		//2.返回一个jack.jsp页面
		request.setAttribute("username", username);
		String path = "/WEB-INF/jsp/jack.jsp";
		//3.实现内部跳转
		request.getRequestDispatcher(path).forward(request, response);
		//如果返回为null,我们可以使用内部跳转的方式返回页面
		return null;
	}
}
