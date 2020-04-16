package mymain;

import java.util.Arrays;

import vo.PersonComp;
import vo.PersonVo;

public class MyMain_Arrays_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] nr = {7,6,5,4,3,2,1};
		
		Arrays.sort(nr);
		
		for(int n: nr) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		
		PersonVo p1 = new PersonVo("�ٱ浿", 23, "���� ���� ����3��");
		PersonVo p2 = new PersonVo("���浿", 22, "���� ���� ����2��");
		PersonVo p3 = new PersonVo("���浿", 24, "���� ���� ����1��");
		PersonVo p4 = new PersonVo("���浿", 21, "���� ���� ����4��");
		PersonVo p5 = new PersonVo("��浿", 25, "���� ���� ����5��");
		
		PersonVo [] p_array = { p1,p2,p3,p4,p5 };
		
		System.out.println("--before sort--");
		for(PersonVo p: p_array) {
			System.out.println(p);
		}
		
		//������ ���ؼ����ϴ� ��ü
		PersonComp comp = new PersonComp();
		
		Arrays.sort(p_array,comp);
		
		System.out.println("===�̸��� ASC(��������) Sort===");
		for(PersonVo p: p_array) {
			System.out.println(p);
		}
		
		//��Ʈ��� ����
		comp.setSort_method(PersonComp.SORT_METHOD_DESC);

		Arrays.sort(p_array,comp);
		
		System.out.println("===�̸��� DESC(��������) Sort===");
		for(PersonVo p: p_array) {
			System.out.println(p);
		}
		
		
		comp.setSort_field(PersonComp.SORT_FIELD_AGE);
		comp.setSort_method(PersonComp.SORT_METHOD_ASC);
		Arrays.sort(p_array,comp);
		
		
		System.out.println("===���̼� ASC(��������) Sort===");
		for(PersonVo p: p_array) {
			System.out.println(p);
		}
		
		
		//comp.setSort_field(PersonComp.SORT_FIELD_AGE);
		comp.setSort_method(PersonComp.SORT_METHOD_DESC);
		Arrays.sort(p_array,comp);
		
		
		System.out.println("===���̼� DESC(��������) Sort===");
		for(PersonVo p: p_array) {
			System.out.println(p);
		}
		
		
		comp.setSort_field(PersonComp.SORT_FIELD_ADDR);
		comp.setSort_method(PersonComp.SORT_METHOD_ASC);
		Arrays.sort(p_array,comp);
		
		
		System.out.println("===�ּҼ� ASC(��������) Sort===");
		for(PersonVo p: p_array) {
			System.out.println(p);
		}
		
		
		//comp.setSort_field(PersonComp.SORT_FIELD_ADDR);
		comp.setSort_method(PersonComp.SORT_METHOD_DESC);
		Arrays.sort(p_array,comp);
		
		
		System.out.println("===�ּҼ� DESC(��������) Sort===");
		for(PersonVo p: p_array) {
			System.out.println(p);
		}
		
		
		//System.out.println( "ABc".compareTo("ABC") ); 
		
		
		
		
	}

}
