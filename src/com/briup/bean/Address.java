package com.briup.bean;

public class Address {
	private int id;
	private String city;
	public Address() {
		// TODO Auto-generated constructor stub
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
