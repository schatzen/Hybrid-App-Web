package mymain;

import java.util.Calendar;

public class MyMain_3_Console_�ð� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			while(true) {
				//�� �ڵ�� try���� ���� �� ���� �� 
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
				} //1�� ���
			}
	}

}
