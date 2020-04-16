package myutil;

public class TV implements RemoteCon {

	int volume = 0;
	int channel = 9;

	boolean bTvOn = false; // TV켜짐상태
	boolean bSoundOff = false; // TV켜짐상태

	// TV상태를 출력할 메소드
	void display() {
		if (bTvOn == false) {
			System.out.println("===TV OFF 상태===");
			System.out.println();
			return;
		}
		// TV켜진 상태
		System.out.println("--- TV On상태 ---");
		System.out.printf("-채널 : %d\n", channel);
		if (bSoundOff)
			System.out.printf("-볼륨 : 음소거\n");
		else
			System.out.printf("-볼륨 : %d\n", volume);
		System.out.println("----------------");
		System.out.println();

	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		volume++;
		if (volume > Volume.MAX_VOLUME)
			volume = Volume.MAX_VOLUME;

		display();
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		volume--;
		if (volume < Volume.MIN_VOLUME)
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
		if (channel > Channel.MAX_CHANNEL)
			channel = Channel.MIN_CHANNEL;

		display();
	}

	@Override
	public void channelDown() {
		// TODO Auto-generated method stub
		channel--;
		if (channel < Channel.MIN_CHANNEL)
			channel = Channel.MIN_CHANNEL;

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

		// Toggle방식
		bTvOn = !bTvOn;
		display();

	}

}
