package myutil;

public class Parent extends Object {
	
	int p_money;
	public Parent() { //parent�� �⺻�����ڸ� ����� �����ε�޼ҵ带 �������, �ƿ� �ȸ������ �ؾ��Ѵ�
					  //�ڽ��� ���������!
		System.out.println("--parent()--");
		p_money = 100;
	}
	
	public Parent(int p_money) {
		super(); //Object() call
		System.out.println("--parent(int)--");
		this.p_money = p_money;
	}

	
	
}
