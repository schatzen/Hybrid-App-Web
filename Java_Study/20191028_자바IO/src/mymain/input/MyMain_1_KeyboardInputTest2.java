package mymain.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_1_KeyboardInputTest2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Ű���� ��ġ�� �Է½�Ʈ�� ���
		InputStream is = System.in;

		// byte stream -> char stream ���� ����
		InputStreamReader isr = new InputStreamReader(is); // �ѱ��� �� ������ ���� is�� char�� �������� // reader�� ���۴����� char�̱� ����
		System.out.println("���� : ctrl + z");

		while (true) {
			int ch = isr.read(); // InputStream�� �ƴ϶� Reader�� ���� �о����
			// Ctrl + Z ������ -1 ��ȯ
			if (ch == -1) {

				System.out.println("�����մϴ�");
				break;
			}
			System.out.printf("%c", ch);
		}

	}

}
