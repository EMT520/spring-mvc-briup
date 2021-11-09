package com.briup.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 创建控制器： 必须实现一个Controller接口
 * @author lining
 *
 */
public class JackController implements Controller{

	//当适配器根据规则自动调用控制器中该方法
	// 该方法调用需要创建JackController对象
	//  通过spring框架自动创建该对象，提供类的全限定名
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.接收客户端发送的请求参数：请求报文
		//request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		
		//2.参数封装java对象 传递给service
		
		
		//3. 根据service的返回结果，作出响应
		ModelAndView mv = new ModelAndView();
		System.out.println(mv);
		//设置模型中的数据信息：
		mv.addObject("username", username);
		//设置响应信息中页面的逻辑视图名 jack.jsp
		mv.setViewName("jack");
		return mv;
	}
	
}
