package myutil;

public class Child extends Parent{

	// super         & super()      구분되나?
	// 부모참조변수    부모생성자  
	
	
	int c_money;
	public Child() {
		// TODO Auto-generated constructor stub
		super();//Parent() call : 생략되면 부모의 기본생성자를 호출
		System.out.println("--Child()--");
	      
		c_money = 50;
	}
	
	
	public Child(int c_money) {
		super();// Parent() call
		System.out.println("--Child(int)--");
		this.c_money = c_money;
	}
	
	public Child(int c_money,int p_money) {
		super(p_money);// Parent(int) call
		System.out.println("--Child(int,int)--");
		this.c_money = c_money;
	}




	public void display_child() {
		System.out.println("-------- Child ---------");
		System.out.printf("부모가 물려준돈:%d\n", 
				                     super.p_money );
		System.out.printf("내가 소유한 돈:%d\n",
				                     this.c_money);
		System.out.printf("내가 소유한 총 금액:%d\n",
				    super.p_money + this.c_money                   
				);
	}
	
}
