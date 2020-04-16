package vo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/*
 * VO 사용하려면
 * 1. getter/setter 정의
 * 2. Constructor는 모두 생략하던지 
 * 	   기본 생성자 + 중복 생성자
 * 3. 선택적 직렬화가 가능한 객체로  이용하려면 Externalizable 인터페이스 선언
 */

public class PersonVo2 implements Externalizable {

	// 대부분의 객체는 직렬화 가능 but 이미지 같은 몇 개의 객체는 직렬x (네트워크 안된다는 의미)

	String name;
	// 직렬화에서 제외 (transient 씀 타이앞에)
	int age;
	String addr;

	public PersonVo2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%s-%d-%s]", name, age, addr);
	}

	public PersonVo2(String name, int age, String addr) {
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
	
	//Externalizable 재정의 해주는데 선택안한 데이터는 null뜸

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(name); //string객체인데 object해줌
		out.writeInt(age);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		name = (String) in.readObject();
		age = in.readInt();
	}

}
