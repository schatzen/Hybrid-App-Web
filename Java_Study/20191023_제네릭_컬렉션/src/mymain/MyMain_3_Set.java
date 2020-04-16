package mymain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyMain_3_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 순서없이 저장되는 데이터구조
		// HashSet으로 하면 무자가위로 나옴
		// TreeSet은 sort되서 나옴
		Set<String> set = new HashSet<String>(); // HashSet으로 하면 무자가위로 나옴
													// TreeSet은 sort되서 나옴

		set.add("길동3");
		set.add("길동4");
		set.add("길동5");
		set.add("길동1");
		set.add("길동2");

		if (set.add("길동5") == false) // 중복되면 boolean 형으로 나옴
			System.out.println("--추가실패--");

		System.out.println(set); // HashSet : 순서없이 저장되는 것을 확인 TreeSet: sort되서 나오는 것을 확인

		System.out.println("--개선 LOOP이용");
		for (String name : set)
			System.out.println(name);
		
		//Irator : 반복자(컬렉션 보조객체)
		System.out.println("--Iterator 이용--");
		// set => [[길동1, 길동2, 길동3, 길동4, 길동5]
		Iterator<String> it = set.iterator();

		while (it.hasNext()) { // it 값을 가지고 있냐? //hasNext 자세히 알아보기!
			String name = it.next(); // 가져오기
			System.out.println(name);
		}
	}

}
