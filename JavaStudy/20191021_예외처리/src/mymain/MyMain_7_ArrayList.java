package mymain;

import java.util.ArrayList;

public class MyMain_7_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// List����=>��������
		// �迭=>��������Ʈ 
		
		//Collection     
		// ��List        <--interface(���Ŵ���)
		//   ��ArrayList <--class(���輭)
		// : �����迭(�ڹ��� ��簴ü�� �������)
		//           (�ڹ��� �ֻ���Ÿ���� Object������ ����) 
		
		ArrayList  list = new ArrayList();
		System.out.printf("list's size()=%d\n", list.size());
		
		
		list.add("���ڿ�");//String            0
		list.add(10);      //int->Integer      1 
		//       10->new Integer(10) 
		list.add(10.5);    //double->Double    2
		//       10.5->new Double(10.5) 
		list.add(true);    //boolean->Boolean  3
		//       true->new Boolean(true)
		
		//Auto-Boxing: ��ü������ �ڵ�����(JDK 1.5 later)
				
		
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
		
		fruit_list.add("���");//0
		fruit_list.add("����");//1
		fruit_list.add("����");//2
		fruit_list.add("��");  //3
		fruit_list.add("����");//4
		
		//   i = 0 1 2 3 4
		for(int i=0;i<fruit_list.size();i++) {
			String fruit = (String) fruit_list.get(i);
			System.out.printf("fruit_list.get(%d)=%s\n",
					                           i,fruit);
		}
		
		//����
		fruit_list.remove(2);
		
		System.out.println("--after remove--");
		
		for(int i=0;i<fruit_list.size();i++) {
			String fruit = (String) fruit_list.get(i);
			System.out.printf("fruit_list.get(%d)=%s\n",
					                           i,fruit);
		}
		
		
		
		
		
		
		
		

	}

}
