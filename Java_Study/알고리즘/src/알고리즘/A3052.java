package 알고리즘;

import java.util.Scanner;

public class A3052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int count = 0;

		int[] su = new int[10];

		for (int i = 0; i < 10; i++) {
			su[i] = scan.nextInt();

			if (su[i] > 0 && su[i] <= 1000) {
				su[i] = su[i] % 42;
			} else {
				break;

			}

		}

		for (int i = 0; i < 9; i++)
			for (int k = i + 1; k < 10; k++) {
				if (su[i] == su[k]) {
					count++;
					break;

				}

			}

		System.out.println(10 - count);

	}

}
