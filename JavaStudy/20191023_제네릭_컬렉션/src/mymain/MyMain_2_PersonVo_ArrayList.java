package mymain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vo.PersonVo;

public class MyMain_2_PersonVo_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		
		p_list.add( new PersonVo("일길동", 31, "010-111-1234") );//0
		p_list.add( new PersonVo("이길동", 32, "010-222-1234") );//1
		p_list.add( new PersonVo("삼길동", 33, "010-333-1234") );//2
		p_list.add( new PersonVo("사길동", 34, "010-444-1234") );//3
		p_list.add( new PersonVo("오길동", 35, "010-555-1234") );//4
		
		
		//System.out.println(p_list.get(0));
		
		System.out.println("--첨자이용 조회--");
		
		for(int i=0;i< p_list.size();i++) {
			
			PersonVo p = p_list.get(i);
			System.out.println(p);
		}
		
		System.out.println("--개선 loop이용 조회--");
		for(PersonVo p : p_list) {
			System.out.println(p);
		}
		
        //ArrayList 정렬 
		List<Integer> list = new ArrayList<Integer>();
		list.add(6);//0
		list.add(5);//1
		list.add(4);//2
		list.add(3);//3
		
		System.out.println("--before sort--");
		System.out.println(list);
				
		Collections.sort(list);
		
		System.out.println("--after sort--");
		System.out.println(list);
		
		
		
		
		
		
		
	}

}
