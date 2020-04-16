package mymain;

public class MyMain_String불변법칙 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = new String("평소에 잘 살아 개놈아");
		msg = msg.replaceAll("개놈", "***");
		//String msg1 = msg.replaceAll("개놈", "***");
		
		System.out.println(msg);
		//System.out.println(msg1);
		
		
		
	}

}
