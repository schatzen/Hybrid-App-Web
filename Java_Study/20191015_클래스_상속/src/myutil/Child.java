package myutil;

public class Child extends Parent {
	
	//super			  &  super()  ���еǳ�?
	//�θ���������(����) 	�θ������

	int c_money;

	public Child() {
		// super(); >> �����Ǹ� �θ��� �⺻�����ڸ� ȣ��
		System.out.println("--Child()--");
		c_money = 50;
	}

	public void display_child() {
		System.out.println("-------Child-------");
		System.out.printf("�θ� ������ �� : %d\n", super.p_money);
		// super �����ص� ��. this.p_money�� ������ ó�����ֱ� ����
		System.out.printf("���� ������ �� : %d\n", this.c_money);
		System.out.printf("���� ������ �� �ݾ� : %d\n", super.p_money + this.c_money);
	}

	public Child(int c_money) {
		super(); // Parent() call
		System.out.println("-------Child(int)-------");
		this.c_money = c_money;
	}

	public Child(int c_money, int p_money) {
		super(p_money); // Parent(int) call �����ص� ������ super�� Parent Ŭ�������� p_money ������
		System.out.println("-------Child(int, int)-------");
		this.c_money = c_money;
	}

}
