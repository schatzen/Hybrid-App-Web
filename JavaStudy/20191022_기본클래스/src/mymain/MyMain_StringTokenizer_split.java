package mymain;

import java.util.StringTokenizer;

public class MyMain_StringTokenizer_split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "서울##경기#인천#대전#광주#여수#목포";
		
		//StringTokenizer                      분리기준문자
		StringTokenizer st = new StringTokenizer(str, "#");
		System.out.println(st.countTokens());
		
		System.out.println("--StringTokenizer--");
		while(st.hasMoreTokens()) {//현재 토큰갖고 있냐?
			
			//토큰읽어오고 다음 토큰으로 이동
			String token = st.nextToken();
			System.out.println(token);
		}
		
		System.out.println("--split--");
		String [] sido_array = str.split("#");
		//                          0       1     2
		//String [] sido_array = {"서울",   "","경기","인천","대전",...};
		System.out.println(sido_array.length);
		/*
		for(int i=0;i<sido_array.length;i++) {
			System.out.println(sido_array[i]);
		}
		*/
		for(String sido : sido_array) {
			System.out.println(sido);
		}
		
		
		String fruit_list = "사과,배/참외&수박";
		
		String [] fruit_array = fruit_list.split(",|/|&");
		System.out.println("--multi delimeter--");
		for(String fruit : fruit_array) {
			System.out.println(fruit);
		}
		
		
		
		
		
		
		
		
		
	}

}
