package mymain.output;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class MyMain_2_FileOutputTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// ����
		OutputStream os = new FileOutputStream("a.txt");

		// ����
		String msg = "�ȳ�\n";
		os.write(msg.getBytes());

		os.write(65);

		os.write(48); // '0'

		int n = 123;
		// os.write(n); // '{'�� ����
		os.write(String.valueOf(n).getBytes());

		// ��°�ü ���͸�(PrintStream)
		// System.out�� ������ ��ü
		PrintStream out = new PrintStream(os);

		String name = "ȫ�浿";
		out.println(); // �ٹٲٱ�
		out.printf("[%s]�� �ȳ��ϼ���\n", name);

		int a = 3, b = 2;
		out.printf("%d > %d => %b\n", a, b, a > b);

		out.println(n);

		// �ݱ� : ���� ����
		out.close();
		os.close();

		System.out.println("--����Ϸ�--");

	}

}
