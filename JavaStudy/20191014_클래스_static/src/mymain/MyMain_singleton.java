package mymain;

import java.util.Calendar;

import myutil.MySingleton;

public class MyMain_singleton {

	
	static void �ձ�����(int i) {
		//MySingleton ms = new MySingleton();
		
		MySingleton ms = MySingleton.getInstance();
		
		int res = ms.hap(i);
		System.out.printf("%d�������� : %d\n",i,res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		for(int i=1;i<=10;i++) {
			
			//singleton
			Calendar c = Calendar.getInstance();
			
			MyMain_singleton.�ձ�����(i);
			
		}
		
		
	}

}
