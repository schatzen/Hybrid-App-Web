package mymain;

public class MyMain_static�ʱ�ȭ {

	// static �ʱ�ȭ
	static {
		System.out.println("0.���� �Ҹ�, ���� ���� ȣ���!");

		// 1. DB Driver Loading ...
		// 2. ���α׷��� �ʿ��� �ڿ�(Resource)
		// Resource : �̹��� ����... resource�� �������� �������� �޸𸮿� �÷����ƾ� ��밡���� ���ϵ��� ���� (���밡����
		// ����)

		/*
		 * ���� ������ ���� �� �̸� �̹����� ���� �ʱ�ȭ ��Ű�� ���� ��, ���θ޼ҵ� ���� static�� �̸� �غ��� �� o ���� �濬 �����ϱ�
		 * ���� �̸� ��� ������ �س��� ��! ���� �޼ҵ忡 �÷� ���� ���� �濬�����ϰ� ��� �����ϴ� ��!
		 */
	}

	public static void main(String[] args) { // ����ƽ �޼ҵ�
		// TODO Auto-generated method stub

		System.out.println("1.���� ���� ���� ȣ���");

	}

	static {
		System.out.println("0-1.���� �Ҹ�, ���� ���� ȣ���!");
	}

}
