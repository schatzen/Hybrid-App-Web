package 알고리즘;

import java.util.Scanner;

public class A2902 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String src = scan.next();

		for (int i = 0; i < src.length(); i++) {

			if (src.charAt(i) >= 'A' && src.charAt(i) <= 'Z') {
				System.out.print(src.charAt(i));

			}

		}
	}

}
