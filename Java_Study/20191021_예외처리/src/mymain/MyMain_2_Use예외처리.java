package mymain;

import java.util.Scanner;

public class MyMain_2_Use예외처리 {

	static boolean isNumber(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i); // '1'
			// 숫자형 문자가 아니냐?
			if (!(ch >= '0' && ch <= '9')) // = if(ch<'0' || ch > '9')

				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int su;

		while (true) {

			try {

				// 본 코드 수행
				System.out.print("숫자만 입력하세요 : ");
				String str = scan.next().trim();
				
				
				//아마도 parseInt메소드 내에서 아래와 같이 예외를 던졌다.
				if (isNumber(str) == false)
					throw new NumberFormatException("숫자만 사용하라고...");

				su = Integer.parseInt(str);

				// Exception
				// ㄴ NumberFormatException
				System.out.printf("입력한 수는 [%d] 입니다. \n", su);

			} catch (Exception e) {
				 //e.printStackTrace(); // 발생한 문제를 내부에서 던져준다.
				System.out.println(e.getMessage());

			}

		}

	}

}
