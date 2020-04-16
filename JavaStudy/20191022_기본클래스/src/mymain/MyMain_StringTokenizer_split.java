package mymain;

import java.util.StringTokenizer;

public class MyMain_StringTokenizer_split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "����##���#��õ#����#����#����#����";
		
		//StringTokenizer                      �и����ع���
		StringTokenizer st = new StringTokenizer(str, "#");
		System.out.println(st.countTokens());
		
		System.out.println("--StringTokenizer--");
		while(st.hasMoreTokens()) {//���� ��ū���� �ֳ�?
			
			//��ū�о���� ���� ��ū���� �̵�
			String token = st.nextToken();
			System.out.println(token);
		}
		
		System.out.println("--split--");
		String [] sido_array = str.split("#");
		//                          0       1     2
		//String [] sido_array = {"����",   "","���","��õ","����",...};
		System.out.println(sido_array.length);
		/*
		for(int i=0;i<sido_array.length;i++) {
			System.out.println(sido_array[i]);
		}
		*/
		for(String sido : sido_array) {
			System.out.println(sido);
		}
		
		
		String fruit_list = "���,��/����&����";
		
		String [] fruit_array = fruit_list.split(",|/|&");
		System.out.println("--multi delimeter--");
		for(String fruit : fruit_array) {
			System.out.println(fruit);
		}
		
		
		
		
		
		
		
		
		
	}

}
