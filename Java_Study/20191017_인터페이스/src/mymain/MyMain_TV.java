package mymain;

import myutil.RemoteCon;
import myutil.TV;
import myutil.Volume;

public class MyMain_TV {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// TV클래스가 아닌 인터페이스를 받았다.
		//	인터페이스   		   = new 클래스();
			RemoteCon remotCon = new TV();
			
			remotCon.onOff();
			
			remotCon.volumeZero();
			remotCon.volumeZero();
			
			remotCon.setChannel(95);
		/*
		 * while(true) { remotCon.channelUp(); Thread.sleep(1000); }
		 */
			
		// RemoteCon애소 Volume만 제어할 수 있는 interface 추출
			Volume volume_interface = remotCon;
			volume_interface.volumeUp();
			
			
	}


}
