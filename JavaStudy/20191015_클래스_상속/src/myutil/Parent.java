package myutil;

public class Parent extends Object {

	int p_money;
	
	public Parent() {
		// TODO Auto-generated constructor stub
		System.out.println("--Parent()--");
		p_money = 100;
	}

	public Parent(int p_money) {
		super(); //Object()
		System.out.println("--Parent(int)--");
		this.p_money = p_money;
	}
	
	
	
	
}
