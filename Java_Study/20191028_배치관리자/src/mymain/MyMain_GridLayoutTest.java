package mymain;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_GridLayoutTest extends JFrame {

	public MyMain_GridLayoutTest() {
		super("GridLayout 연습");
		// 행우선으로 채워진다

		GridLayout gl = new GridLayout(3, 4);

		// 배치방법 변경 : BorderLayout > GridLayout
		this.setLayout(gl);

		for (int i = 1; i <= 20; i++) {
			String caption = String.format("B_%02d", i);
			JButton jbt = new JButton(caption);
			this.add(jbt);
		}
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

		new MyMain_GridLayoutTest();
	}

}
