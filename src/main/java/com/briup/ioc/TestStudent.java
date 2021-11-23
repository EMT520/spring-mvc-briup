package com.briup.ioc;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.bean.Address;
import com.briup.bean.Student;

/**
 * 编写代码实现通过使用spring框架读取xml配置文件的信息实现IOC功能
 * IOC: 控制反转，将对象的创建以及对象依赖关系反转给Spring 容器，程序本身不进行维护。
 * 注意： 原来由我们自己手动创建并维护的对象，现在都可以交给Spring的IOC容器去进行管理维护
 * 反射：反射是java中提供的一种机制，它允许我们在程序运行的时候，动态获取一个类中的基本信息，并且可
 * 以调用类中的属性、方法、构造器。
 */
public class TestStudent {
	public static void main(String[] args) throws Exception {
		//1.我们自己手动创建并维护一个学生对象
		Student s = new Student();
		s.setId(1);
		s.setName("jack");
		s.setAddress(new Address(102,"上海"));
		System.out.println(s);
		//2.我们利用反射知识点创建一个学生对象
		Class<?> c = Class.forName("com.briup.bean.Student");
		Object s2 = c.newInstance();
		//反射中设置值
		Method method = c.getMethod("setId", int.class);
		method.invoke(s2, 2);
		Method method2 = c.getMethod("setName", String.class);
		method2.invoke(s2, "tom");
		System.out.println(s2);
		//2.使用spring框架的IOC创建并管理一个student对象
		//spring读取xml文件，根据bean标签中class属性使用反射创建对象
		//1.spring框架读取xml文件 进行解析.返回IOC容器对象
		ApplicationContext container = new ClassPathXmlApplicationContext("spring-web-mvc-ioc.xml");
		//2.获取IOC容器保存bean对象
		Object s3 = container.getBean("s3");
		System.out.println(s3);
		Object a = container.getBean("addr");
		System.out.println(a);
		}
}
