package vo;

import java.io.Serializable;

/*
   VO�� ����Ϸ���
   1.getter/setter����
   2.Constructor�� ��λ����ϴ���
     �⺻������(�ʼ�) + �ߺ�������
   3.����ȭ�� ������ ��ü�� �̿��Ϸ��� Serializable
     �������̽� implements ����  
*/

public class PersonVo2 implements Serializable{
	
		
	String name;
	//����ȭ���� ����
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
