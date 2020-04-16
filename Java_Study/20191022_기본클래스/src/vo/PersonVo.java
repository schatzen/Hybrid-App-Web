package vo;

/*
	VO(Value Object)
	: ���� ��������ϴ� ��ü
	
	of) DTO(Data Transfer Object) : ���������� (��) ��ü
		 TO(Transfer Object)
	class PersonDTO {}
*/

public class PersonVo {

	String name;
	int age;
	String addr;

	public PersonVo() {

	}

	public PersonVo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%s-%d-%s]", name, age, addr);
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
