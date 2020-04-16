package mymain;

import java.io.FileReader;

public class MyMain_4_다중Catch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//본코드가 수행
			
			int a = 10,b=1,res;
			
			//JVM내부에서 아래와 같이 예외를 던졌을꺼다..
			if(b==0) throw new ArithmeticException("--0으로 못나눠--");
			res = a/b;
			
			String str = "";//new String("");
			//JVM내부에서 아래와 같이 예외를 던졌을꺼다..
			if(str==null) throw new NullPointerException("--빈객체인데 뭐해--");
			int len = str.length();
			System.out.println(len);
			
			
			int [] nr = {1,2,3};
			//JVM내부에서 아래와 같이 예외를 던졌을꺼다..
			int index = 0;
			if( index<0 || index>= nr.length)
				throw new ArrayIndexOutOfBoundsException("--배열 첨자 벗어났어--");
			
			int n = nr[index];
			
			//FileNotFoundException
		    FileReader fr = new FileReader("a.txt");
		    fr.close();//IOException
		    
		    //ClassCastException
		    Object ob = new Object();
		    Integer nob = (Integer)ob;
		    
		    //catch절의 나열순서 
		    //  :큰자료형(자식)->작은자료형(부모)
		    
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
			System.out.println("위의 예외를 제외한 모든 예외:" + e.getMessage());
		}
		
		
	}

}
