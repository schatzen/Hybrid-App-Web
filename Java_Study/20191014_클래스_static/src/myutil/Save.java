package myutil;

public class Save {
	
	/*
	static 변수 / 메소드 
		1. 생성시점 : 프로그램 시작시 
		2. 사용방법
			- 클래스명.변수명
			- 클래스명.메소드명
	
	*/
	
	String name;
	int money;

	// 정적변수 (공유변수)
	public static double rate;

	// 기본 생성자
	public Save() {

	}

	public Save(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}

	public void display() {
		System.out.printf("[%s-%d-%.2f-%d]\n", 
				this.name, // 저축자명
				this.money, // 저축액
				Save.rate, // 이율
				(int) (this.money * rate) // 이자
		);
	}

}
