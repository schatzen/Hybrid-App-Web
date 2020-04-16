package myutil;

public interface Channel {

	int MIN_CHANNEL = 0;
	int MAX_CHANNEL = 100;
	
	void channelUp();
	void channelDown();
	void setChannel(int ch);
}

