package mymain;

import myutil.MyArrayList;

public class MyMain_8_MyArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyArrayList sido_list = new MyArrayList();

		sido_list.add("서울"); // 0
		sido_list.add("경기"); // 1
		sido_list.add("인천"); // 2
		sido_list.add("대전"); // 3
		sido_list.add("대구"); // 4
		sido_list.add("광주"); // 5

		try {
			sido_list.remove(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}

		for (int i = 0; i < sido_list.size(); i++) {

			try {
				// 사용
				String sido = (String) sido_list.get(i);
				System.out.printf("sido[%d] > %s\n", i, sido);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}

		System.out.println("--Program End--");

	}

}
