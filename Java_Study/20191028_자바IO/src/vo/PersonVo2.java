package vo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/*
 * VO ����Ϸ���
 * 1. getter/setter ����
 * 2. Constructor�� ��� �����ϴ��� 
 * 	   �⺻ ������ + �ߺ� ������
 * 3. ������ ����ȭ�� ������ ��ü��  �̿��Ϸ��� Externalizable �������̽� ����
 */

public class PersonVo2 implements Externalizable {

	// ��κ��� ��ü�� ����ȭ ���� but �̹��� ���� �� ���� ��ü�� ����x (��Ʈ��ũ �ȵȴٴ� �ǹ�)

	String name;
	// ����ȭ���� ���� (transient �� Ÿ�̾տ�)
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
	
	//Externalizable ������ ���ִµ� ���þ��� �����ʹ� null��

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(name); //string��ü�ε� object����
		out.writeInt(age);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		name = (String) in.readObject();
		age = in.readInt();
	}

}
