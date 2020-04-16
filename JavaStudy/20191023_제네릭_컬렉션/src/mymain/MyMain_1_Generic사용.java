package mymain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import myutil.MyArrayList;

public class MyMain_1_Generic��� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//���׸��� ������� �������
		List list = new ArrayList();
		list.add("hello");
		list.add(100);
		//casting�ؼ� ����ؾ� �ȴ�
		String msg = (String) list.get(0);
		
		
		//���׸��� ������ ���:String��ü�� ���尡��
		List<String> list1 = new ArrayList<String>();
		list1.add("hello");
		//list1.add(new Integer(100));
		String msg1 = list1.get(0);
		
		// ���׸��� ��ü�ڷ����� ������ �� �ִ�
		//List<int> list2 = new ArrayList<int>();
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);// 10-> new Integer(10)
		//list2.add("hello");
		
		//cf)Auto-Boxing
		Integer [] i_ar = { 1,2,3 };
		/*
		                = {
		                    new Integer(1),
		                    new Integer(2),
		                    new Integer(3)  
		                  };
		 */
		
	    //���� ���� MyArrayList���
		MyArrayList<String> sido_list 
		                  = new MyArrayList<String>();
		sido_list.add("����");
		sido_list.add("���");
		sido_list.add("��õ");
		sido_list.add("����");
		sido_list.add("�뱸");
		sido_list.add("�λ�");
		//sido_list.add(100);
		System.out.println("--�õ����--");
		for(int i=0;i<sido_list.size();i++) {
			
			String sido = sido_list.get(i);
			System.out.println(sido);
		}
		
			
		//�ζ���÷
		Random rand = new Random();
		MyArrayList<Integer> lotto_list 
		                  = new MyArrayList<Integer>();
		MyArrayList<Integer> lotto_result_list 
                          = new MyArrayList<Integer>();
		//45�� �� �ֱ�
		for(int i=1;i<=45;i++) {
			lotto_list.add(i);
		}
		
		//lotto_list���屸��
		// 0 1 2 3 4 .... 44 <=index
		// 1 2 3 4 5 .... 45 <=value
				
		//��÷
		int count=7;
		while(count>0) {
			
			int index = rand.nextInt(lotto_list.size());
			//����Ȱ� ��� ����Ʈ�� �ֱ�
			// int = Integer ( Unboxing )
			int su = lotto_list.get(index);//����� ����ȣ
			lotto_result_list.add(su);
			lotto_list.remove(index);//����Ȱ� ����
						
			count--;
		}
		
		System.out.println("--��÷���--");
		for(int i=0;i<lotto_result_list.size();i++) {
			System.out.printf("%3d", 
					    lotto_result_list.get(i));
		}
		System.out.println();
		
		
		
		
	}

}
