package mymain.input;

import java.io.IOException;
import java.io.InputStream;

public class MyMain_1_KeyboardInputTest {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Ű���� ��ġ�� �Է½�Ʈ�� ���
		InputStream is = System.in;
		System.out.println("���� : ctrl + z");

		while (true) {
			int ch = is.read();
			// Ctrl + Z ������ -1 ��ȯ
			if (ch == -1) {

				System.out.println("�����մϴ�");
				break;
			}
			System.out.printf("%c", ch);
		}

	}

}
