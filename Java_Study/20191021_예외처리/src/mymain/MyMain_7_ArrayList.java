package mymain;

import java.awt.List;
import java.util.ArrayList;

public class MyMain_7_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// List구조 > 선형구조
		// 배열 > 인접 리스트

		// Collection
		// ㄴ List (List까지 인터페이스 : 사용매뉴얼)
		// ㄴ ArrayList (클래스 : 설계서)
		// : 동적배열 (자바의 모든 객체를 저장관리)
		// (자바의 최상위 타입인 Object형으로 저장) : 자바의 모든 타입을 저장하기위해서

		ArrayList list = new ArrayList(); 

		list.add("문자열"); // String 0
		list.add(10); // int > Integer 1
		// 10 > new Integer(10)
		list.add(10.5); // double > Double 2
		// 10.5 > new Double(10.5)
		list.add(true); // boolean > Boolean 3
		// true > new Boolean(true)

		// Auto-Boxing : 객체형으로 자동 포장 (JDK 1.5 later)

		System.out.printf("list's size() = %d\n", list.size());

		// String str = list.get(0); > 첨자가 0인 String 배열 빼오려고 하나, type이 안맞다.
		String str = (String) list.get(0); // > 따라서 이렇게 다운캐스팅해줘야 한다.
		Integer nob = (Integer) list.get(1);
		double d = (double) list.get(2);

		Double dob = 1.0; // Double 객체형, double은 기본형. 서로 타입이 다르다. 그러나 Auto-Boxing을 자바 측에서 해줌
							// new Double(1.0) 해준거임

		// Auto-Unboxing
		double dd = dob; // dob.doubleValue();

		System.out.println(str);
		System.out.println(nob);
		System.out.println(d);

		ArrayList fruit_list = new ArrayList();

		fruit_list.add("사과"); // 0
		fruit_list.add("수박"); // 1
		fruit_list.add("참외"); // 2
		fruit_list.add("딸기"); // 3
		fruit_list.add("포도"); // 4

		for (int i = 0; i < fruit_list.size(); i++) {
			String fruit = (String) fruit_list.get(i);
			System.out.printf("fruit_list.get(%d) = %s\n", i, fruit);
		}

		// 삭제
		fruit_list.remove(2);

		System.out.println("\r\n---after remove---");

		for (int i = 0; i < fruit_list.size(); i++) {
			String fruit = (String) fruit_list.get(i);
			System.out.printf("fruit_list.get(%d) = %s\n", i, fruit);
		}

	}

}
