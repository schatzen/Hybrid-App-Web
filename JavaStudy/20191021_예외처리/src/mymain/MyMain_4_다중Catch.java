package mymain;

import java.io.FileReader;

public class MyMain_4_����Catch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//���ڵ尡 ����
			
			int a = 10,b=1,res;
			
			//JVM���ο��� �Ʒ��� ���� ���ܸ� ����������..
			if(b==0) throw new ArithmeticException("--0���� ������--");
			res = a/b;
			
			String str = "";//new String("");
			//JVM���ο��� �Ʒ��� ���� ���ܸ� ����������..
			if(str==null) throw new NullPointerException("--��ü�ε� ����--");
			int len = str.length();
			System.out.println(len);
			
			
			int [] nr = {1,2,3};
			//JVM���ο��� �Ʒ��� ���� ���ܸ� ����������..
			int index = 0;
			if( index<0 || index>= nr.length)
				throw new ArrayIndexOutOfBoundsException("--�迭 ÷�� �����--");
			
			int n = nr[index];
			
			//FileNotFoundException
		    FileReader fr = new FileReader("a.txt");
		    fr.close();//IOException
		    
		    //ClassCastException
		    Object ob = new Object();
		    Integer nob = (Integer)ob;
		    
		    //catch���� �������� 
		    //  :ū�ڷ���(�ڽ�)->�����ڷ���(�θ�)
		    
		} catch (ArithmeticException e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println("���� ���ܸ� ������ ��� ����:" + e.getMessage());
		}
		
		
	}

}
