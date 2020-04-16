package mymain;

import myutil.고등학생;
import myutil.중학생;
import myutil.초등학생;
import myutil.학생;

public class MyMain_학생 {

	static void 엄마왈(학생[] s_array) {

		// 다형성(Polymorphism)
		// : 동일한 명령에 대하여 객체마다 자신만의 행위
		for (int i = 0; i < s_array.length; i++) {
			학생 student = s_array[i];
			student.공부한다();
		}

	}

	static void 엄마왈2(학생[] s_array) {

		// 다형성(Polymorphism)
		// : 동일한 명령에 대하여 객체마다 자신만의 행위
		for (학생 student : s_array) {

			student.공부한다();
		}

	}

	public static void main(String[] args) {

		학생[] s_array = { new 초등학생(), new 중학생(), new 고등학생() };

		엄마왈(s_array);

		System.out.println("--개선loop(공부)--");
		엄마왈2(s_array);

		int[] nr = { 1, 2, 3 };

		System.out.println("--첨자이용--");
		for (int i = 0; i < nr.length; i++) {
			int n = nr[i];
			System.out.println(n);
		}

		System.out.println("--개선 loop--");
		for (int n : nr) {
			System.out.println(n);
		}

	}

}
