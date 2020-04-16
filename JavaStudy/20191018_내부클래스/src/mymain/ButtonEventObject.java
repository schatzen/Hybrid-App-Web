package mymain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventObject implements ActionListener{

	
	MyMain_ButtonEvent frame;
	
	public ButtonEventObject(MyMain_ButtonEvent frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("--한국어 인사말 알려줘--");
		frame.setTitle("안녕하세요");
	    
	}

}
