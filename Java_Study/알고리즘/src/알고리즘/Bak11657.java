package 알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class Bak11657 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		String[] array = new String[str.length()];

		array[0] = str;

		for (int i = 1; i < str.length(); i++) {

			array[i] = str.substring(i);

		}

		Arrays.sort(array);

		for (String output : array)
			System.out.println(output);
	}

}
