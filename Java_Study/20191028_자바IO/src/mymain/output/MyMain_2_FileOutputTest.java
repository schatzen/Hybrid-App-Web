package mymain.output;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class MyMain_2_FileOutputTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 열기
		OutputStream os = new FileOutputStream("a.txt");

		// 쓰기
		String msg = "안녕\n";
		os.write(msg.getBytes());

		os.write(65);

		os.write(48); // '0'

		int n = 123;
		// os.write(n); // '{'이 나옴
		os.write(String.valueOf(n).getBytes());

		// 출력객체 필터링(PrintStream)
		// System.out와 동일한 객체
		PrintStream out = new PrintStream(os);

		String name = "홍길동";
		out.println(); // 줄바꾸기
		out.printf("[%s]님 안녕하세요\n", name);

		int a = 3, b = 2;
		out.printf("%d > %d => %b\n", a, b, a > b);

		out.println(n);

		// 닫기 : 열린 역순
		out.close();
		os.close();

		System.out.println("--쓰기완료--");

	}

}
