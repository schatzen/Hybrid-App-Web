package mymain;

import myutil.RemoteCon;
import myutil.TV;
import myutil.Volume;

public class MyMain_TV {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        //    인터페이스    =  new 클래스()
		RemoteCon remoteCon =  new TV();
		
		remoteCon.onOff();//켜기
		remoteCon.onOff();//끄기
		remoteCon.onOff();//켜기
		remoteCon.volumeZero();//음소거(On)
		remoteCon.volumeZero();//음소거(Off)
		
		//볼륨을 100번올리기
		for(int i=0;i<100;i++)
			remoteCon.volumeUp();
		
		//볼륨을 200번 내리기
		for(int i=0;i<200;i++)
			remoteCon.volumeDown();
		
		
		remoteCon.setChannel(95);
		
		/*
		 * while(true) { remoteCon.channelUp(); Thread.sleep(1000); }
		 */
		
		//RemoteCon에서 Volume만 제어할 수 있는 
		//interface만 추출
		Volume volume_interface = remoteCon;
		volume_interface.volumeUp();
		
		volume_interface.volumeZero();//음소거
		volume_interface.volumeZero();//음소거 해제

		
		
		
        
	}

}
