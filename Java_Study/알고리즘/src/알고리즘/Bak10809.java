package 알고리즘;

import java.util.Scanner;

public class Bak10809 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String input = scan.next();
		char[] input_array = new char[input.length()];

		for (int i = 0; i < input_array.length; i++) {
			input_array[i] = input.charAt(i);
		}

		int count = 0;
		int[] array = new int[26];
		char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };

		for (int i = 0; i < array.length; i++)
			array[i] = -1;

		for (int i = 0; i < input_array.length; i++) {
			for (int k = 0; k < alpha.length; k++) {
				if (input_array[i] == alpha[k]) {
					if (array[k] != -1) {
						count++;
						break;
					}
					array[k] = count;
					count++;

					break;

				}
			}
		}
		for(int output : array)
			System.out.println(output);

	}
}
