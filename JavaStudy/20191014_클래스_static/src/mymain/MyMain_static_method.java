package mymain;

import myutil.MyMath;

public class MyMain_static_method {

	/*
	  static method�� ��ü��������
	  Ŭ������.�޼ҵ��()����Ѵ�
	  MyMath�뵵: ���񽺱��(Method)�� ó���ϴ� ��ü
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=10,b=5,res;
		res = MyMath.plus(a, b);
		
	    System.out.printf("%d + %d = %d\n",a,b,res);
	    
	    //��ü������ ���� ���ϵ��� ����(private������)
	    //MyMath mm = new MyMath();
	   
	    
	    res = MyMath.max(a, b);
	    System.out.printf("%d,%d�� ū���� %d\n",a,b,res);
	    
	    //����API max���
	    //Math m = new Math();
	    
	    res = Math.max(a, b);
	    System.out.printf("%d,%d�� ū���� %d\n",a,b,res);
	    		
		
	}

}
