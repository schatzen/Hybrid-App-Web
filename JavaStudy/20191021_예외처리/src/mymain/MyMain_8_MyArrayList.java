package mymain;

import myutil.MyArrayList;

public class MyMain_8_MyArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArrayList sido_list = new MyArrayList();
		
		sido_list.add("����");//0
		sido_list.add("���");//1
		sido_list.add("��õ");//2
		sido_list.add("����");//3
		sido_list.add("�뱸");//4
		sido_list.add("����");//5
		
		System.out.println(sido_list.size());
		
		for(int i=0;i<=sido_list.size();i++) {
			
			try {
				//���
				String sido = (String) sido_list.get(i);
				System.out.printf("sido[%d]=>%s\n",i,sido);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		
		//�������� index=3
		try {
			sido_list.remove(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("--after remove(index:3)--");
		for(int i=0;i<sido_list.size();i++) {
			
			try {
				//���
				String sido = (String) sido_list.get(i);
				System.out.printf("sido[%d]=>%s\n",i,sido);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("--Program End--");
		
		
		
		
	}

}
