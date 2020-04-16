package mymain.file;

import java.io.File;

public class MyMain_1_FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("TestFolder");

		if (!file.exists()) {// �������� ������... ����
			file.mkdir();

		} else {
			file.delete();
		}

		File f = new File("c:\\Java_Study");
		// ���� ��� ��ȸ
		File[] f_array = f.listFiles();
		for (File ff : f_array) {
			String name = ff.getName(); // ���ϸ�
			long filelen = ff.length(); // ����ũ��( byte����)
			String kind = "";

			if (ff.isDirectory())
				kind = "D";

			else if (ff.isFile())
				kind += "F";

			if (ff.isHidden())
				kind += "H";

			// if (ff.isAbsolute())
			// kind += "A";

			System.out.printf("[%s] %s(%d)\n", kind, name, filelen);

		}

		File del_f = new File(f, "back_del.txt"); // f�� �θ��� (�θ����� �ؿ� ��������) ���⼭�� c����̺꿡�� �ڹٽ��͵�� ����

		if (del_f.exists()) {
			del_f.delete();
			System.out.println("���� ���� :" + del_f);
		}

		System.out.println("--�Ϸ�--");

	}

}
