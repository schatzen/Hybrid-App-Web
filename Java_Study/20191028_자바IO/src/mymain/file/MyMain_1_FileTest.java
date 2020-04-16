package mymain.file;

import java.io.File;

public class MyMain_1_FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("TestFolder");

		if (!file.exists()) {// 존재하지 않으면... 생성
			file.mkdir();

		} else {
			file.delete();
		}

		File f = new File("c:\\Java_Study");
		// 하위 목록 조회
		File[] f_array = f.listFiles();
		for (File ff : f_array) {
			String name = ff.getName(); // 파일명
			long filelen = ff.length(); // 파일크기( byte단위)
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

		File del_f = new File(f, "back_del.txt"); // f는 부모경로 (부모폴더 밑에 하위파일) 여기서는 c드라이브에서 자바스터디로 선언

		if (del_f.exists()) {
			del_f.delete();
			System.out.println("삭제 파일 :" + del_f);
		}

		System.out.println("--완료--");

	}

}
