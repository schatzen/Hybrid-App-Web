package mymain;

import myutil.����л�;
import myutil.���л�;
import myutil.�ʵ��л�;
import myutil.�л�;

public class MyMain_�л� {

	static void ������(�л� [] s_array) {
		//������(Polymorphisim)
		// : ������ ��ɿ� ���Ͽ� ��ü���� �ڽŸ��� ����
		for(int i=0;i<s_array.length;i++) { //i = 0 1 2 
			�л� student = s_array[i];
			student.�����Ѵ�();
		}
	}
	
	static void ������2(�л� [] s_array) {
		//������(Polymorphisim)
		// : ������ ��ɿ� ���Ͽ� ��ü���� �ڽŸ��� ����
		for(�л� student: s_array) { 
			student.�����Ѵ�();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		�л� [] s_array = new �л�[]
				          { 
				              new �ʵ��л�(), //0
				              new ���л�(),   //1
				              new ����л�()  //2    
		                  };
		������(s_array);
		
		System.out.println("--����loop(����)--");
		������2(s_array);
		
		//               0     1     2
		//              nr[0] nr[1] nr[2]
		int []   nr = {  1,    2 ,   3 };
		System.out.println("--÷���̿�--");
		for(int i=0;i<nr.length;i++) {
			int n = nr[i];
			System.out.println(n);
		}
		
		System.out.println("--���� loop--");
		for(int n : nr) {
			System.out.println(n);
		}
		
		
		
		
	}

}
