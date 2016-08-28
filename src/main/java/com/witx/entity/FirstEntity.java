package com.witx.entity;

public class FirstEntity {
	private int id;
	private String name;
	private int  age;
	private double price;
	
	public FirstEntity() {
		super();
	}

	public FirstEntity(int id, String name, int age, double price) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.price = price;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FirstEntity [id=" + id + ", name=" + name + ", age=" + age + ", price=" + price + "]";
	}
	
	
}
