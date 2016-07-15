package es.curso.etiquetas.beans;

import java.util.Arrays;

public class User {
	
	private String name;
	private String address;
	private String password;
	private String password2;
	private boolean subscribe;
	private String [] frameworks;
	private char sex;
	private int number;
	private String country;
	private String [] jSkills;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPassword2() {
		return password2;
	}


	public void setPassword2(String password2) {
		this.password2 = password2;
	}


	public boolean isSubscribe() {
		return subscribe;
	}


	public void setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
	}


	public String[] getFrameworks() {
		return frameworks;
	}


	public void setFrameworks(String[] frameworks) {
		this.frameworks = frameworks;
	}


	public char getSex() {
		return sex;
	}


	public void setSex(char sex) {
		this.sex = sex;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String[] getjSkills() {
		return jSkills;
	}


	public void setjSkills(String[] jSkills) {
		this.jSkills = jSkills;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + ", password=" + password + ", password2=" + password2
				+ ", subscribe=" + subscribe + ", frameworks=" + Arrays.toString(frameworks) + ", sex=" + sex
				+ ", number=" + number + ", country=" + country + ", jSkills=" + Arrays.toString(jSkills) + "]";
	}

	
}
