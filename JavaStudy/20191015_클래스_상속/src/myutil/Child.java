package myutil;

public class Child extends Parent{

	// super         & super()      ���еǳ�?
	// �θ���������    �θ������  
	
	
	int c_money;
	public Child() {
		// TODO Auto-generated constructor stub
		super();//Parent() call : �����Ǹ� �θ��� �⺻�����ڸ� ȣ��
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
		System.out.printf("�θ� �����ص�:%d\n", 
				                     super.p_money );
		System.out.printf("���� ������ ��:%d\n",
				                     this.c_money);
		System.out.printf("���� ������ �� �ݾ�:%d\n",
				    super.p_money + this.c_money                   
				);
	}
	
}
