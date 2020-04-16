package vo;

public class PersonVo {

	int no;
	String name;
	int age;
	String tel;

	public PersonVo() {

	}

	public PersonVo(int no, String name, int age, String tel) {
		this.no = no;
		this.name = name;
		this.age = age;
		this.tel = tel;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
