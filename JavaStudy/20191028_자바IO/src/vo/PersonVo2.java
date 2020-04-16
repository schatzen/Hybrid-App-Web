package vo;

import java.io.Serializable;

/*
   VO로 사용하려면
   1.getter/setter정의
   2.Constructor는 모두생략하던지
     기본생성자(필수) + 중복생성자
   3.직렬화가 가능한 객체로 이용하려면 Serializable
     인터페이스 implements 선언  
*/

public class PersonVo2 implements Serializable{
	
		
	String name;
	//직렬화에서 제외
	transient int    age;
	String addr;
	
	public PersonVo2() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PersonVo2(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%s-%d-%s]", name,age,addr);
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
	
}
