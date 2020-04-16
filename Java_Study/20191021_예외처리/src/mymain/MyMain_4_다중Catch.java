package mymain;

import java.io.FileReader;

public class MyMain_4_다중Catch {

	public static void main(String[] args) {

		try { // 본 코드가 수행되는 구간
			int a = 10, b = 1, res;

			if (b == 0)
				throw new ArithmeticException("--0으로는 못나눠--");

			res = a / b;

			String str = ""; // String str = ""; 와는 다름. 객체는 존재함. length할 경우 0으로 떨어짐

			if (str == null)
				throw new NullPointerException("--빈 객체인데 뭘 하려고 하는거야?--");
			int len = str.length();
			System.out.println(len);

			int[] nr = { 1, 2, 3 };

			int index = 0;
			if (index < 0 || index >= nr.length)
				throw new ArrayIndexOutOfBoundsException("--배열 첨자 벗어났어.--");

			int n = nr[index];

			// FileNotFoundException
			FileReader fr = new FileReader("a.txt");
			fr.close(); // IOException 떨어짐

			// ClassCastException
			Object ob = new Object();
			Integer nob = (Integer) ob;
			
			
			// catch절의 나열 순서 : 큰 자료형(자식) -> 작은 자료형(부모)
			// 오버로드 메소드오 같은 논리..! 예외처리가 메소드는 아님 ㅋ
		} catch (ArithmeticException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (Exception e) { // try에서 발생되는 모든 예외는 여기서 받음. // Exception e 를 맨 위에 올려 놓을 경우 다른 예외 코드들은
								// unrechable 뜰 것임. 모든 예외를 다 가로채므로
			// e.printStackTrace();
			System.out.println("위의 예외를 제외한 모든 예외 :" + e.getMessage());
		}

	}

}
