package mymain;

import myutil.RemoteCon;
import myutil.TV;
import myutil.Volume;

public class MyMain_TV {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// TVŬ������ �ƴ� �������̽��� �޾Ҵ�.
		//	�������̽�   		   = new Ŭ����();
			RemoteCon remotCon = new TV();
			
			remotCon.onOff();
			
			remotCon.volumeZero();
			remotCon.volumeZero();
			
			remotCon.setChannel(95);
		/*
		 * while(true) { remotCon.channelUp(); Thread.sleep(1000); }
		 */
			
		// RemoteCon�ּ� Volume�� ������ �� �ִ� interface ����
			Volume volume_interface = remotCon;
			volume_interface.volumeUp();
			
			
	}


}
