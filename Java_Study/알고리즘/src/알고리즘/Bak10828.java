package 알고리즘;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bak10828 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		int i = 0;

		String str;

		StackTest stack = new StackTest();

		while (i <= number) {

			str = scan.nextLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			String oper = st.nextToken();
			int num = Integer.parseInt(st.nextToken());

			if (oper.equals("push")) {
				stack.push(num);
				i++;
				continue;

			} else {
				switch ("oper") {

				case "pop":
				case "size":
				case "empty":
				case "top":

				}
			}
		}

	}

	class StackTest{
		public int size;
		public int top;
		public int [] array;
		
		public StackTest(int size) {
			super();
			this.size = size;
			this.top = top;
			this.array = array;
		}
		
		
		
		
		
		
	}

}
