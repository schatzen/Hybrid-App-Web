package myutil;

public class TV implements RemoteCon {

	int volume=10;
	int channel = 9;
	boolean bTvOn = false;//TV��������
	boolean bSoundOff = false;//���ҰŻ��� �ƴ�
	
	//TV���¸� ����� �޼ҵ�
	void display() {
		if(bTvOn==false) {
			System.out.println("***TV Off����**");
			return;
		}
		//TV��������
		System.out.println("---TV On����---");
		System.out.printf("-ä��:%d\n",channel);
		if(bSoundOff)
			System.out.println("-����:���Ұ�");
		else	
		    System.out.printf("-����:%d\n",volume);
					
		
		System.out.println("---------------");
	}
	
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		volume++;
		if(volume > Volume.MAX_VOLUME)
			volume = Volume.MAX_VOLUME;
		
		display();
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		volume--;
		if(volume < Volume.MIN_VOLUME)
			volume = Volume.MIN_VOLUME;
		
		display();
	}

	@Override
	public void volumeZero() {
		// TODO Auto-generated method stub
		bSoundOff = !bSoundOff;
		
		display();
	}

	@Override
	public void channelUp() {
		// TODO Auto-generated method stub
		channel++;
		//max_channel->min_channel
		if(channel>Channel.MAX_CHANNEL)
			channel = Channel.MIN_CHANNEL;
		
		display();
	}

	@Override
	public void channelDown() {
		// TODO Auto-generated method stub
		channel--;
		//min_channel->max_channel
		if(channel < Channel.MIN_CHANNEL)
			channel = Channel.MAX_CHANNEL;
		
		display();
	}

	@Override
	public void setChannel(int ch) {
		// TODO Auto-generated method stub
		channel = ch;
		
		display();
	}

	@Override
	public void onOff() {
		// TODO Auto-generated method stub
		//Toggle���  true <-> false
		bTvOn = !bTvOn;
		display();
	}

}
