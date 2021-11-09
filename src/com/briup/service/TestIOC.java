package com.briup.service;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.bean.Address;
import com.briup.bean.Student;

public class TestIOC {
	public static void main(String[] args) throws Exception {
		//1.创建一个学生对象 
		Student s = new Student();
		s.setId(1);
		s.setName("jack");
		s.setAddress(new Address(102,"上海"));
		System.out.println(s);
		//2.反射创建一个学生对象
		Class<?> c = Class.forName("com.briup.bean.Student");
		Object s2 = c.newInstance();
		//反射中设置值
		Method method = c.getMethod("setId", int.class);
		method.invoke(s2, 2);
		Method method2 = c.getMethod("setName", String.class);
		method2.invoke(s2, "tom");
		
		
		
		System.out.println(s2);
		//2.使用spring框架创建一个student对象
		//spring读取xml文件，根据bean标签中class属性使用反射创建对象
		
		//1.spring框架读取xml文件 进行解析.返回IOC容器对象
		ApplicationContext container = new ClassPathXmlApplicationContext("spring-web-mvc4.xml");
		//2.获取IOC容器保存bean对象
		Object s3 = container.getBean("s3");
		System.out.println(s3);
		Object a = container.getBean("addr");
		System.out.println(a);
		}
}
