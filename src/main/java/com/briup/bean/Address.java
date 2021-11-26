package com.briup.bean;

/**
 *  地址类
 *  地址信息和学生信息1对1的关系
 */
public class Address {
	private int id;//编号
	private String city;//城市

	public Address() {

	}

	public Address(int id, String city) {
		this.id = id;
		this.city = city;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + "]";
	}
}
