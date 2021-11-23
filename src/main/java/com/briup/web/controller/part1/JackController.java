package com.briup.web.controller.part1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 创建控制器类：
 * 要求：1.必须实现一个Controller接口
 *      2.在spring-web-mvc.xml文件中添加处理器配置信息
 */
public class JackController implements Controller{
	/**
	 * 适配器判断处理器对象的接口类型后，调用控制器中该方法
	 * 方法调用需要springMVC框架自动创建JackController对象，
	 * 我们只需要在spring-web-mvc.xml文件中提供类的全限定名即可。
	 * @param request  请求对象
	 * @param response 响应对象
	 * @return 模型视图对象
	 * @throws Exception 异常信息
	 */
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.接收客户端发送的请求参数：请求报文
		String username = request.getParameter("username");
		/*
			2.将多个请求参数封装成java对象 然后调用service方法，传递给service层
			这个代码实现略
		 */

		//3. 根据service的返回结果，作出响应
		ModelAndView mv = new ModelAndView();
		//3.1 添加模型对象中的数据信息：
		mv.addObject("username", username);
		//3.2 设置响应页面的逻辑视图名 jack
		mv.setViewName("jack");

		return mv;
	}
	
}
