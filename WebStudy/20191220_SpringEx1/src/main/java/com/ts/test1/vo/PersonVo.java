package com.ts.test1.vo;

public class PersonVo {
	
	String name; //property
	int    age;
	String addr;
	
	public PersonVo() {
		// TODO Auto-generated constructor stub
		System.out.println("--PersonVo()--");
	}
	
	public PersonVo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
		
		System.out.println("--PersonVo(name,age,addr)--");
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("--setName(name)--");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
	
}
