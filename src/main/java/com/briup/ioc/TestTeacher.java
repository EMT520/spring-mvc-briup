package com.briup.ioc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.bean.Student;
import com.briup.bean.Teacher;

/**
 * 编写xml文件和代码，解决对象的集合属性的注入
 * 使用的标签为：<list></list>
 *
 */
public class TestTeacher {
	public static void main(String[] args) {
		//1.手动实现：一个jack老师负责管理tom bob rose3位同学
		Student s = new Student(1,"tom");
		Student s2 = new Student(2, "bob");
		Student s3 = new Student(3, "rose");
		
		Teacher t = new Teacher();
		t.setId(101);
		t.setName("jack");
		List<Student> list = new ArrayList();
		list.add(s);
		list.add(s2);
		list.add(s3);
		t.setStudents(list);
		System.out.println(t);
		//使用spring IOC功能实现：一个jack老师负责管理tom bob rose3位同学：
		// 创建对象 管理对象 对象之间的依赖问题
		ApplicationContext container = new ClassPathXmlApplicationContext("spring-web-mvc-ioc.xml");
		//2.根据bean对象的名字获取对应的对象
		Object o = container.getBean("t");
		System.out.println(o);
		//java8 lambda表达式 遍历学生信息
		Teacher  t2 = (Teacher) o;
		t2.getStudents()
		  .stream()
		  .forEach(stu -> System.out.println(stu));
	}
}
