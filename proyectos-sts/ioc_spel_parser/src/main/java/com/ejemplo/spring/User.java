package com.ejemplo.spring;

public class User {
	
	private int edad;
	private String name;
	private String country;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int edad, String name, String country) {
		super();
		this.edad = edad;
		this.name = name;
		this.country = country;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [edad=" + edad + ", name=" + name + ", country=" + country
				+ "]";
	}
	
	
	
}