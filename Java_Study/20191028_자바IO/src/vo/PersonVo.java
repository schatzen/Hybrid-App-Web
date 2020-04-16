package vo;

import java.io.Serializable;

/*
 * VO 사용하려면
 * 1. getter/setter 정의
 * 2. Constructor는 모두 생략하던지 
 * 	   기본 생성자 + 중복 생성자
 * 3. 직렬객체로 이용하려면 Serializable 인터페이스 기록 //상징적인 목적 이게 있어야 직렬화 가능!
 */

public class PersonVo implements Serializable {

	// 대부분의 객체는 직렬화 가능 but 이미지 같은 몇 개의 객체는 직렬x (네트워크 안된다는 의미)

	String name;
	int age;
	String addr;

	public PersonVo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%s-%d-%s]", name, age, addr);
	}

	public PersonVo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
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
