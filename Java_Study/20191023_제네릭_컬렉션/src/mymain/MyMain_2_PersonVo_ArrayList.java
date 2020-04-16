package mymain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vo.PersonVo;

public class MyMain_2_PersonVo_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<PersonVo> p_list = new ArrayList<PersonVo>();

		p_list.add(new PersonVo("일길동", 31, "010-111-1234"));
		p_list.add(new PersonVo("이길동", 32, "010-222-1234"));
		p_list.add(new PersonVo("삼길동", 33, "010-333-1234"));
		p_list.add(new PersonVo("사길동", 34, "010-444-1234"));
		p_list.add(new PersonVo("오길동", 35, "010-555-1234"));

		// System.out.println(p_list.get(0));
		System.out.println("--첨자이용 조회--");

		for (int i = 0; i < p_list.size(); i++) {
			PersonVo p = p_list.get(i);
			System.out.println(p);
		}

		System.out.println("\r\n--개선 loop 이용 조회--");
		for (PersonVo p : p_list)
			System.out.println(p);

		// ArrayList 정렬
		List<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);

		System.out.println("\r\n--before--");
		System.out.println(list);

		Collections.sort(list); // 오름차순으로 정렬

		System.out.println("\r\n--after sort--");
		System.out.println(list);

	}

}
