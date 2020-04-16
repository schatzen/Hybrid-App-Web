package mymain;

import java.util.ArrayList;

public class MyMain_7_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// List구조=>선형구조
		// 배열=>인접리스트 
		
		//Collection     
		// ㄴList        <--interface(사용매뉴얼)
		//   ㄴArrayList <--class(설계서)
		// : 동적배열(자바의 모든객체를 저장관리)
		//           (자바의 최상위타입인 Object형으로 저장) 
		
		ArrayList  list = new ArrayList();
		System.out.printf("list's size()=%d\n", list.size());
		
		
		list.add("문자열");//String            0
		list.add(10);      //int->Integer      1 
		//       10->new Integer(10) 
		list.add(10.5);    //double->Double    2
		//       10.5->new Double(10.5) 
		list.add(true);    //boolean->Boolean  3
		//       true->new Boolean(true)
		
		//Auto-Boxing: 객체형으로 자동포장(JDK 1.5 later)
				
		
		System.out.printf("list's size()=%d\n", list.size());
		
		String str  = (String) list.get(0);
		Integer nob = (Integer) list.get(1);
		double  d   = (double)(Double)list.get(2);
		
		//Auto-Boxing
		Double dob = 1.0;// new Double(1.0)
		
		//Auto-Unboxing
		double dd = dob;// dob.doubleValue();
		
		System.out.println(str);
		System.out.println(nob);
		System.out.println(d);
		
		
		ArrayList fruit_list = new ArrayList();
		
		fruit_list.add("사과");//0
		fruit_list.add("참외");//1
		fruit_list.add("수박");//2
		fruit_list.add("배");  //3
		fruit_list.add("딸기");//4
		
		//   i = 0 1 2 3 4
		for(int i=0;i<fruit_list.size();i++) {
			String fruit = (String) fruit_list.get(i);
			System.out.printf("fruit_list.get(%d)=%s\n",
					                           i,fruit);
		}
		
		//삭제
		fruit_list.remove(2);
		
		System.out.println("--after remove--");
		
		for(int i=0;i<fruit_list.size();i++) {
			String fruit = (String) fruit_list.get(i);
			System.out.printf("fruit_list.get(%d)=%s\n",
					                           i,fruit);
		}
		
		
		
		
		
		
		
		

	}

}
