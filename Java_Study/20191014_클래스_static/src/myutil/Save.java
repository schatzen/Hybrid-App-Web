package myutil;

public class Save {
	
	/*
	static ���� / �޼ҵ� 
		1. �������� : ���α׷� ���۽� 
		2. �����
			- Ŭ������.������
			- Ŭ������.�޼ҵ��
	
	*/
	
	String name;
	int money;

	// �������� (��������)
	public static double rate;

	// �⺻ ������
	public Save() {

	}

	public Save(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}

	public void display() {
		System.out.printf("[%s-%d-%.2f-%d]\n", 
				this.name, // �����ڸ�
				this.money, // �����
				Save.rate, // ����
				(int) (this.money * rate) // ����
		);
	}

}
