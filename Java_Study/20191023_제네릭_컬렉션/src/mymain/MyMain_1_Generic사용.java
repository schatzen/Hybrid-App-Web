package mymain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyMain_1_Generic사용 {

	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub

		List list = new ArrayList();
		list.add("hello");
		list.add(100);
		String msg = (String) list.get(0);

		// 제네릭을 적용한 경우
		List<String> list1 = new ArrayList<String>();
		list1.add("hello");
		//list1.add(100);

		String msg1 = list1.get(0);

		// int는 객체가 아니다. Integer가 객체
		// 컬레션은 변수가 아닌 모든 객체를 저장하는 곳
		// 제네릭은 객체자료형만 지정할 수 있다.
		// List<int> list2 = new ArrayList<int>();
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(100);
		// list2.add("hello");

		// cf) Auto-Boxing
		Integer[] i_ar = { 1, 2, 3 };

		/*
		 * = { new Integer(1), new Integer(2), new Integer(3)}
		 */

		// 내가 만들어 본 MyArrayList 사용
		/*
		 * MyArrayList<String> sido_list = new MyArrayList<String>();
		 * 
		 * sido_list.add("서울"); sido_list.add("경기"); sido_list.add("인천");
		 * sido_list.add("대전"); sido_list.add("대구"); sido_list.add("부산"); //
		 * sido_list.add(100); System.out.println("--시도목록--");
		 * 
		 * for (int i = 0; i < sido_list.size(); i++) { String sido = sido_list.get(i);
		 * System.out.println(sido); }
		 */

		// 로또추첨
		Random rand = new Random();
		MyArrayList<Integer> lotto_list = new MyArrayList<Integer>();
		MyArrayList<Integer> lotto_result_list = new MyArrayList<Integer>();

		// 45개 공 넣기
		for (int i = 1; i < 45; i++) {
			lotto_list.add(i);
		}

		// 추첨
		int count = 7;
		while (count > 0) {

			int index = rand.nextInt(lotto_list.size());

			// 추출된 값
			int su = lotto_list.get(index);
			lotto_result_list.add(su);
			lotto_list.remove(index); // 추출된 공 제거

			count--;
		}

		System.out.println("--추첨결과--");
		for (int i = 0; i < lotto_result_list.size(); i++) {
			System.out.printf("%3d", lotto_result_list.get(i));
		}
	}

}
