package 알고리즘;

import java.util.Scanner;

public class Bak10820 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		while (scan.hasNextLine()) {
			String str = scan.nextLine();

			int low = 0;
			int up = 0;
			int num = 0;
			int sp = 0;

			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);

				if (ch >= 'A' && ch <= 'A' + 25) {
					up++;
				} else if (ch >= 'a' && ch <= 'a' + 25) {
					low++;
				} else if (ch >= 0 && ch <= 9) {
					num++;
				} else if (ch == ' ') {
					sp++;
				}

			}
			System.out.println(low + " " + up + " " + num + " " + sp);
		}
		scan.close();

	}

}
