package com.briup.bean;

import com.briup.util.DateJsonSerialize;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 学生类
 *
 */
public class Student {
	private int id;//学号 0 Integer null
	private String name;//姓名
	//@DateTimeFormat 可以解决表单接收到的字符串日期参数转换为Date类型
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	//@JsonFormat 可以解决json字符串中 时间字符串20200101 转化为java对象的格式类型
	//@JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
	@JsonSerialize(using = DateJsonSerialize.class)
	private Date dob;//出生日期
	//一个学生对应唯一的一个地址信息
	private Address address;//地址

	public Student() {
	}
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", dob=" + dob +
				", address=" + address +
				'}';
	}
}
