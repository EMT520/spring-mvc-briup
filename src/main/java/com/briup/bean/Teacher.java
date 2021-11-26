package com.briup.bean;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * 教师类
 * 一个老师可以对应多个学生 
 */
public class Teacher {
	@NotNull(message = "工号不能为空")
	private Integer id;//工号
	@Past(message = "出生日期不能大于现在时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	@NotBlank(message = "名字不能为空")
	private String name;//姓名
	private int salary;
	@Min(value = 18,message = "年龄不能小于18岁")
	private int age;//入职最小年龄
	//private Student[] students; 可以使用数组类型表示一个老师可以对应多个学生
	private List<Student> students;
	public Teacher() {
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
}
