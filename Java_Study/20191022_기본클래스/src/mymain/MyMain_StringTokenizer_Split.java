package mymain;

import java.util.StringTokenizer;

public class MyMain_StringTokenizer_Split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "����##���#��õ#����#����#����#����";

		// StringTokenizer : ��ū�� �������� �и� (��ū�̶�, �и����ع��ڷ� ���� ������ �����͸� ����)
												// �и����ع���
		StringTokenizer st = new StringTokenizer(str, "#");
		System.out.println(st.countTokens());

		System.out.println("--StringTokenizer--");
		while (st.hasMoreTokens()) { // ���� ��ū ���� �ֳ�?

			// ��ū �о���� ���� ��ū���� �̵�
			String token = st.nextToken();
			System.out.println(token);
		}

		System.out.println("\r\n--Split--"); // �и����� �������� �и�
		String[] sido_array = str.split("#");
		// String [] sido_array = {"����","��õ","����",...};

		System.out.println(sido_array.length);
		for (int i = 0; i < sido_array.length; i++) {
			System.out.println(sido_array[i]);
		}
		System.out.println();

		for (String sido : sido_array) {
			System.out.println(sido);
		}

		System.out.println("\r\n--Multi delim--");
		String fruit_list = "���,��/����&����";
		String[] fruit_array = fruit_list.split(",|/|&");

		for (String fruit : fruit_array)
			System.out.println(fruit);

	}

}
