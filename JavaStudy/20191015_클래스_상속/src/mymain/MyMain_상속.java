package mymain;

import myutil.AdvanceCalc;
import myutil.BaseCalc;


public class MyMain_��� {

	static void use_basecalc(BaseCalc bc) {
		//                   BaseCalc bc = ac;  
		//Ctrl + Shift + o : �ڵ�����ȭ
		System.out.println("--only BaseCalc�� ���--");
		int a = 10,b=5,res;
		res = bc.minus(a, b);
		System.out.printf("use_basecalc : %d - %d = %d\n",
				                           a,  b,   res);
		//res = bc.hap(a);
		
	}
	
	static void use_object(Object ob) {
		//                 up-casting(��뿵�� ���)
		//                 Object ob = ac;
		
		int n = 10,res;
		// down-casting(��뿵���� Ȯ��)
		res = ((AdvanceCalc)ob).hap(n);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=10,y=3,res;
		
		AdvanceCalc ac  = new AdvanceCalc();
		
		//use_basecalc
		use_basecalc(ac);
		
		use_object(ac);
				
		
		System.out.println("---main---");
		
		res = ac.plus(x, y);
		System.out.printf("%d + %d = %d\n",x,y,res);
		
		System.out.println(ac.toString());
		
		res = ac.hap(x);
		System.out.printf("%d������ ��=%d\n",x,res);
		
		//
		Object ob = ac;
		
		
		
		//down-casting���ǻ���: 
		BaseCalc bc1 = new BaseCalc();//
		//��ü���� AdvanceCalc����� ����.
		//AdvanceCalc ac1 = (AdvanceCalc)bc1;
		
		
		
		
		
	}

}
