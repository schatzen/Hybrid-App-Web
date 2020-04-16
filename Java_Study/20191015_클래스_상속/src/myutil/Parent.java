package myutil;

public class Parent extends Object {
	
	int p_money;
	public Parent() { //parent는 기본생성자를 만들고 오버로드메소드를 만들던지, 아예 안만들던지 해야한다
					  //자식이 만들어지면!
		System.out.println("--parent()--");
		p_money = 100;
	}
	
	public Parent(int p_money) {
		super(); //Object() call
		System.out.println("--parent(int)--");
		this.p_money = p_money;
	}

	
	
}
