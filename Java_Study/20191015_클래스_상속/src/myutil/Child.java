package myutil;

public class Child extends Parent {
	
	//super			  &  super()  구분되나?
	//부모참조변수(대명사) 	부모생성자

	int c_money;

	public Child() {
		// super(); >> 생략되면 부모의 기본생성자를 호출
		System.out.println("--Child()--");
		c_money = 50;
	}

	public void display_child() {
		System.out.println("-------Child-------");
		System.out.printf("부모가 물려준 돈 : %d\n", super.p_money);
		// super 생략해도 됨. this.p_money로 저절로 처리해주기 때문
		System.out.printf("내가 소유한 돈 : %d\n", this.c_money);
		System.out.printf("내가 소유한 총 금액 : %d\n", super.p_money + this.c_money);
	}

	public Child(int c_money) {
		super(); // Parent() call
		System.out.println("-------Child(int)-------");
		this.c_money = c_money;
	}

	public Child(int c_money, int p_money) {
		super(p_money); // Parent(int) call 생략해도 저절로 super인 Parent 클래스에서 p_money 가져옴
		System.out.println("-------Child(int, int)-------");
		this.c_money = c_money;
	}

}
