package mymain;



import myutil.Outer1;

public class MyMain_Outer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Outer1 out1 = new Outer1(); // �긦 ���� ������ Outer1���� ����Ŭ���� ����� �� O

		// ������ �ܺΰ�ü�� ���ؼ� ���ΰ�ü ����
		// Outer1.Inner1 inner1 = new Outer1.Inner1(); �̷��� ���� ���� X
		Outer1.Inner1 inner1 = out1.new Inner1();

		Outer1.Inner1 inner1_1 = new Outer1().new Inner1(); // �̷��� ����� ���� ����!

		inner1.display();

		// Inner2 ���� Ŭ������ static�̶� �� �޼ҵ� ����
		Outer1.Inner2 inner2 = new Outer1.Inner2();
		inner2.display();

		// �ǹ������� �̷��� �� ��. �ֳ��ϸ� ���� Ŭ������ �� Ŭ���� �ȿ��� ����Ϸ��� �����ϴ°ű� ����.
		// ���� ����Ŭ������ �ܺο��� �Ȳ����� �ȴ� ��
		
		
		//���� ���� Ŭ���� �׽�Ʈ 
		//��� �̸��� ����
		new Outer1().method();
		
		//�͸� ���� Ŭ���� �׽�Ʈ
		//��� �̸��� ����
		new Outer1().method2();

	}

}
