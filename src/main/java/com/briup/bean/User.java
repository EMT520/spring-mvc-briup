package com.briup.bean;

/**
 *  设计user类实现单例模式
 *  单例模式：一个类有且仅有一个实例，并且自行实例化向整个系统提供。
 */
public class User {
	private int id;
	private String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
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

	//定义静态属性，保证在程序运行中只有一个User对象
	private static User user;
	private User() {
		System.out.println("user...");
	}
	public static User getInstance() {
		if(user == null) {
			user = new User(1,"jack");
		}
		return user;
	}
}
