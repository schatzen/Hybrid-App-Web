package mymain;

import javax.swing.JFrame;

public class BaseWin extends JFrame {

	public BaseWin() {
		super("DEEP BREATHE");

		// 위치
		setLocation(200, 100);

		// 크기
		setSize(300, 300);

		// 보여줘라
		setVisible(true);

		// 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new BaseWin();
	}

}
