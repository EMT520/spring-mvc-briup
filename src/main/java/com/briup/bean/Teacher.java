package com.briup.bean;

import java.util.List;

/**
 * 教师类
 * 一个老师可以对应多个学生 
 */
public class Teacher {
	private int id;//工号
	private String name;//姓名
	//private Student[] students; 可以使用数组类型表示一个老师可以对应多个学生
	private List<Student> students;
	public Teacher() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
