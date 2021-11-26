package com.briup.web.controller.part1;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  测试处理器
 *  1. 当我们直接利用响应对象获取输出流，写出中文字符作出响应体内容时，会发生中文乱码。
 *     解决方式： 设置响应头信息： Content-Type：text/html;charset=utf-8
 */
public class ResponseController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.接收请求参数username
		String id = request.getParameter("id");
		//2.设置响应头，指定响应体的媒体类和编码格式
		response.setContentType("text/html;charset=utf-8");
		//3.添加响应体的内容
		response.getWriter().append("查询的学生信息为："+id);
		//如果返回为null,我们可以使用响应对象的方式返回信息
		return null;
	}
}
