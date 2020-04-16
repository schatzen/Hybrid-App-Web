package 알고리즘;

import java.util.Scanner;

public class Bak9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 1; i <= n; i++) {
			String str = scan.next();
			int count = 0;
			char data = ' ';

			for (int k = 0; k < str.length(); k++) {
				data = str.charAt(k);

				if (data == '(') {
					count++;
				} else if (data == ')' && count > 0) {
					count--;
				} else {
					count = 1;
					break;
				}

			}
			if (count == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}