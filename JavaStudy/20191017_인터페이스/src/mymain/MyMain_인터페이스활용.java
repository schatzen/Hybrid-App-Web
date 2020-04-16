package mymain;

import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class MyMain_인터페이스활용 extends JFrame {

	public MyMain_인터페이스활용() {
		// TODO Auto-generated constructor stub
		super("인터페이스 활용예제");

		
		//윈도우 이벤트 등록
		WindowListener listener 
		               = new MyWindowEventListener();
		
		//위임이벤트모델(Delegation Event Model)
		
		//this:이벤트소스(대상)
		//addWindowListener(인자): Event등록하는 메소드
		//인자:처리객체
		this.addWindowListener(listener);
		
		
				
		
		//위치
		setLocation(200, 100);

		//크기
		setSize(300, 300);

		//보여줘라
		setVisible(true);

		//종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_인터페이스활용();
	}
}
