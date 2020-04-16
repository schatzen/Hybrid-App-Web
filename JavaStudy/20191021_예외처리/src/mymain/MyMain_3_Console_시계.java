package mymain;

import java.util.Calendar;

public class MyMain_3_Console_시계 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			
			Calendar c = Calendar.getInstance();
			String strTime = String.format("%02d:%02d:%02d\n", 
					    c.get(Calendar.HOUR),
					    c.get(Calendar.MINUTE),
					    c.get(Calendar.SECOND)
					);
			System.out.print(strTime);
			
			try {
				Thread.sleep(1000);//1초 대기
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

}
