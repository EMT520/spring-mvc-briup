package com.briup.web.controller.part1;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@Component
@RequestMapping("/api")
public class HelloController {
	//RequestMapping
	@RequestMapping("/hi")
	public ModelAndView hello() {
		System.out.println("调用hello()");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jack");
		mv.addObject("username", "wangwu");
		return mv;
	}
	//http://localhost:8888/springMVC_0102/api/test
	@RequestMapping(value = {"/test","/test4"})
	public String test(Model m) {
		//设置模型的数据
		m.addAttribute("username", "zhangsan");
		return "hello";//返回逻辑视图名
	}
	@RequestMapping("/test2")
	public void test2(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//通过响应对象返回页面信息，字符串信息
		String id = request.getParameter("id");
		response.getWriter().append("test ok "+id);
	}
	
}
