package vo;

/*
 3����ü
 
 [�Է�]          [VO]          [DB]
 parameter�� ==  �Ӽ��� ==    �÷���
 name            name         name 
 age             age          age
 addr            addr         addr 
 
*/



public class PersonVo {

	String name;
	int    age;
	String addr;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		//System.out.println("--setName(name)--");
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
