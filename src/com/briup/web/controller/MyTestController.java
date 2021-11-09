package com.briup.web.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.briup.web.adapter.MyController;

/**
 * 因为自定义了适配器，不需要必须Controller接口
 * 可以实现自定义的控制器接口
 * @author lining
 *
 */
public class MyTestController implements MyController{

	@Override
	public ModelAndView handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取请求参数
		String[] likes = request.getParameterValues("like");
		//2.作出响应：
		response.getWriter().append(Arrays.toString(likes));
		
		return null;
	}

}
