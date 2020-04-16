package vo;

import java.io.Serializable;

/*
 * VO ����Ϸ���
 * 1. getter/setter ����
 * 2. Constructor�� ��� �����ϴ��� 
 * 	   �⺻ ������ + �ߺ� ������
 * 3. ���İ�ü�� �̿��Ϸ��� Serializable �������̽� ��� //��¡���� ���� �̰� �־�� ����ȭ ����!
 */

public class PersonVo implements Serializable {

	// ��κ��� ��ü�� ����ȭ ���� but �̹��� ���� �� ���� ��ü�� ����x (��Ʈ��ũ �ȵȴٴ� �ǹ�)

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
