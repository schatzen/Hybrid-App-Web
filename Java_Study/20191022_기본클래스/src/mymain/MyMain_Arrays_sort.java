package mymain;

import java.util.Arrays;

import vo.PersonComp;
import vo.PersonVo;

public class MyMain_Arrays_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nr = { 7, 6, 5, 4, 3, 2, 1 };

		Arrays.parallelSort(nr);

		for (int n : nr) {
			System.out.print(n + " ");
		}
		System.out.println();

		PersonVo p1 = new PersonVo("다길동", 23, "서울 마포구 노고산3동");
		PersonVo p2 = new PersonVo("가길동", 22, "서울 마포구 노고산2동");
		PersonVo p3 = new PersonVo("나길동", 24, "서울 마포구 노고산1동");
		PersonVo p4 = new PersonVo("마길동", 21, "서울 마포구 노고산4동");
		PersonVo p5 = new PersonVo("라길동", 25, "서울 마포구 노고산5동");

		PersonVo[] p_array = { p1, p2, p3, p4, p5 };

		System.out.println("---before sort---");
		for (PersonVo p : p_array) {
			System.out.println(p);
		}

		// Arrays.sort(p_array); 런타임에러 떨어짐 객체를 sorting 할 때는 기준을 정해줘야 함

		// 정렬의 기준 설정하는 객체
		PersonComp comp = new PersonComp();
		Arrays.sort(p_array, comp);

		System.out.println("\r\n--이름순 ASC(오름차순)으로 Sort--");
		for (PersonVo p : p_array)
			System.out.println(p);
		
		comp.setSort_method(PersonComp.SORT_METHOD_DESC);
		Arrays.sort(p_array, comp);
		
		System.out.println("\r\n--이름순 DESC(내림차순)으로 Sort--");
		for (PersonVo p : p_array)
			System.out.println(p);
		
		comp.setSort_field(PersonComp.SORT_FIELD_AGE);
		comp.setSort_method(PersonComp.SORT_METHOD_ASC);
		
		Arrays.sort(p_array, comp);
		
		System.out.println("\r\n--나이순 ASC(오름차순)으로 Sort--");
		for (PersonVo p : p_array)
			System.out.println(p);
		
		comp.setSort_field(PersonComp.SORT_FIELD_AGE);
		comp.setSort_method(PersonComp.SORT_METHOD_DESC);
		
		Arrays.sort(p_array, comp);
		
		System.out.println("\r\n--나이순 DESC(내림차순)으로 Sort--");
		for (PersonVo p : p_array)
			System.out.println(p);

		
		comp.setSort_field(PersonComp.SORT_FIELD_ADDR);
		comp.setSort_method(PersonComp.SORT_METHOD_ASC);
		
		Arrays.sort(p_array, comp);
		
		System.out.println("\r\n--주소순 ASC(오름차순)으로 Sort--");
		for (PersonVo p : p_array)
			System.out.println(p);

		
		comp.setSort_field(PersonComp.SORT_FIELD_ADDR);
		comp.setSort_method(PersonComp.SORT_METHOD_DESC);
		
		Arrays.sort(p_array, comp);
		
		System.out.println("\r\n--주소순 DESC(내림차순)으로 Sort--");
		for (PersonVo p : p_array)
			System.out.println(p);

		
		//System.out.println("ABc".compareTo("ABC")); //A는 아스키코드 65, a는 아스키코드 97

	}
	

}
