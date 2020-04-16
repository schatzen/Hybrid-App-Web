package 알고리즘;

import java.util.ArrayList;
import java.util.Scanner;

public class Leet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String src = scan.next();

		ArrayList<Integer> list1 = new ArrayList<Integer>();

		for (int i = 0; i < src.length() - 1; i++) {
			if (src.charAt(i) != src.charAt(i + 1))
				list1.add(i);
		}

		System.out.println((list1.size() / 2) + 1);

	}
}
