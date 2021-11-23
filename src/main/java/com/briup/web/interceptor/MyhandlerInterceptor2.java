package com.briup.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 创建一个拦截器，通过拦截
 * @author lining
 *
 */
public class MyhandlerInterceptor2 implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle:"+handler);

		//情况2：
		return  true;//通过拦截，执行剩余的2个方法
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//渲染视图前调用的方法,
		if(modelAndView != null) {
			//可以实现修改模型中的数据
			modelAndView.addObject("username", "lisi");
		}
		System.out.println(modelAndView);
		System.out.println("postHandle");
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion ");
	}

}
