package mymain;

import myutil.RemoteCon;
import myutil.TV;
import myutil.Volume;

public class MyMain_TV {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        //    �������̽�    =  new Ŭ����()
		RemoteCon remoteCon =  new TV();
		
		remoteCon.onOff();//�ѱ�
		remoteCon.onOff();//����
		remoteCon.onOff();//�ѱ�
		remoteCon.volumeZero();//���Ұ�(On)
		remoteCon.volumeZero();//���Ұ�(Off)
		
		//������ 100���ø���
		for(int i=0;i<100;i++)
			remoteCon.volumeUp();
		
		//������ 200�� ������
		for(int i=0;i<200;i++)
			remoteCon.volumeDown();
		
		
		remoteCon.setChannel(95);
		
		/*
		 * while(true) { remoteCon.channelUp(); Thread.sleep(1000); }
		 */
		
		//RemoteCon���� Volume�� ������ �� �ִ� 
		//interface�� ����
		Volume volume_interface = remoteCon;
		volume_interface.volumeUp();
		
		volume_interface.volumeZero();//���Ұ�
		volume_interface.volumeZero();//���Ұ� ����

		
		
		
        
	}

}
