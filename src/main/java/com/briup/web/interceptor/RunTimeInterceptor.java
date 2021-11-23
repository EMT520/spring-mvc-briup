package com.briup.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RunTimeInterceptor implements HandlerInterceptor{
	private ThreadLocal<Long> start = new ThreadLocal<>();
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//记录开始拦截的时间
		start.set(System.currentTimeMillis());
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Thread.sleep(3000);
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//结束时间-开始时间=执行时间
		long end = System.currentTimeMillis();
		long time = end - start.get();
		System.out.println(handler.getClass().getName()+"执行时间："+time);
	}
}
