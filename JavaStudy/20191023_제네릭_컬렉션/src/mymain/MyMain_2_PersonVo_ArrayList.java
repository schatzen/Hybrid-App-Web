package mymain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vo.PersonVo;

public class MyMain_2_PersonVo_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		
		p_list.add( new PersonVo("�ϱ浿", 31, "010-111-1234") );//0
		p_list.add( new PersonVo("�̱浿", 32, "010-222-1234") );//1
		p_list.add( new PersonVo("��浿", 33, "010-333-1234") );//2
		p_list.add( new PersonVo("��浿", 34, "010-444-1234") );//3
		p_list.add( new PersonVo("���浿", 35, "010-555-1234") );//4
		
		
		//System.out.println(p_list.get(0));
		
		System.out.println("--÷���̿� ��ȸ--");
		
		for(int i=0;i< p_list.size();i++) {
			
			PersonVo p = p_list.get(i);
			System.out.println(p);
		}
		
		System.out.println("--���� loop�̿� ��ȸ--");
		for(PersonVo p : p_list) {
			System.out.println(p);
		}
		
        //ArrayList ���� 
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
