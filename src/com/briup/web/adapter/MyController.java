package com.briup.web.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MyController {
	//定义抽象方法表示操作请求和响应对象
	ModelAndView handlerRequest(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
