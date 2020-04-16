package 알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class Bak11656 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		String[] list = new String[str.length()];

		for (int i = 0; i < str.length(); i++) {
			list[i] = (str.replace(str.substring(0, i), ""));

		}

		Arrays.sort(list);

		for (String output : list)
			System.out.println(output);

	}

}
