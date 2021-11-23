package com.briup.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 拦截器
 * @author lining
 *
 */
public class ThreadInterceptor extends HandlerInterceptorAdapter{
	//private String name;
	//使用 ThreadLocal类创建的对象 ，每个线程独立拥有一个当前对象 ，之间不会受到影响 
	private ThreadLocal<String> threadLocal = new ThreadLocal<>();
	//url请求-->线程1调用 pre方法
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1.获取到请求参数值，设置共享数据
		String name = request.getParameter("username");
		threadLocal.set(name);
		System.out.println(Thread.currentThread().getName()+":"+name);
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//将线程进行睡眠
		Thread.sleep(10000);
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//通过线程1获取线程1设置的参数值
		System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
	}
}
