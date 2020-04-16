package mymain;

import java.util.Calendar;

public class MyMain_3_Console_시계 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			while(true) {
				//본 코드는 try에서 뺴는 게 나음 ㅎ 
				Calendar c = Calendar.getInstance();
				String strTime = String.format("%02d : %02d :  %02d\n",
						c.get(Calendar.HOUR),
						c.get(Calendar.MINUTE),
						c.get(Calendar.SECOND)
								);
				
				System.out.println(strTime);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //1초 대기
			}
	}

}
