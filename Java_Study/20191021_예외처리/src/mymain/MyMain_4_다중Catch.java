package mymain;

import java.io.FileReader;

public class MyMain_4_����Catch {

	public static void main(String[] args) {

		try { // �� �ڵ尡 ����Ǵ� ����
			int a = 10, b = 1, res;

			if (b == 0)
				throw new ArithmeticException("--0���δ� ������--");

			res = a / b;

			String str = ""; // String str = ""; �ʹ� �ٸ�. ��ü�� ������. length�� ��� 0���� ������

			if (str == null)
				throw new NullPointerException("--�� ��ü�ε� �� �Ϸ��� �ϴ°ž�?--");
			int len = str.length();
			System.out.println(len);

			int[] nr = { 1, 2, 3 };

			int index = 0;
			if (index < 0 || index >= nr.length)
				throw new ArrayIndexOutOfBoundsException("--�迭 ÷�� �����.--");

			int n = nr[index];

			// FileNotFoundException
			FileReader fr = new FileReader("a.txt");
			fr.close(); // IOException ������

			// ClassCastException
			Object ob = new Object();
			Integer nob = (Integer) ob;
			
			
			// catch���� ���� ���� : ū �ڷ���(�ڽ�) -> ���� �ڷ���(�θ�)
			// �����ε� �޼ҵ�� ���� ��..! ����ó���� �޼ҵ�� �ƴ� ��
		} catch (ArithmeticException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (Exception e) { // try���� �߻��Ǵ� ��� ���ܴ� ���⼭ ����. // Exception e �� �� ���� �÷� ���� ��� �ٸ� ���� �ڵ����
								// unrechable �� ����. ��� ���ܸ� �� ����ä�Ƿ�
			// e.printStackTrace();
			System.out.println("���� ���ܸ� ������ ��� ���� :" + e.getMessage());
		}

	}

}
