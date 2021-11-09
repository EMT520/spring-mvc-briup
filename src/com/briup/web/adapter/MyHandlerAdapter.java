package com.briup.web.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.LastModified;

public class MyHandlerAdapter implements HandlerAdapter{

	@Override
	public boolean supports(Object handler) {
		//如果处理器类型为自定义类型 MyController
		//返回为true.调用handle方法
		System.out.println("MyHandlerAdapter.supports()...");
		return (handler instanceof MyController);
	}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//调用自定义类型MyController处理器的指定方法
		System.out.println("MyHandlerAdapter.handle");
		return ((MyController)handler).handlerRequest(request, response);
	}

	@Override
	public long getLastModified(HttpServletRequest request, Object handler) {
		if (handler instanceof LastModified) {
			return ((LastModified) handler).getLastModified(request);
		}
		return -1L;
	}

}
