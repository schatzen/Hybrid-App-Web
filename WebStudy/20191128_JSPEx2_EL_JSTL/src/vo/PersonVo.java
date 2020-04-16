package vo;

/*
 3위일체
 
 [입력]          [VO]          [DB]
 parameter명 ==  속성명 ==    컬럼명
 name            name         name 
 age             age          age
 addr            addr         addr 
 
*/

public class PersonVo {

	String name;
	int    age;
	String addr;
	
	
	public PersonVo() {
		// TODO Auto-generated constructor stub
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
		//System.out.println("--setName(name)--");
		this.name = name;
	}
	public int getAge() {
		//System.out.println("--getAge() call");
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
