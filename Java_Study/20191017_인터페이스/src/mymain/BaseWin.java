package mymain;

import javax.swing.JFrame;

public class BaseWin extends JFrame {

	public BaseWin() {
		super("DEEP BREATHE");

		// ��ġ
		setLocation(200, 100);

		// ũ��
		setSize(300, 300);

		// �������
		setVisible(true);

		// ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new BaseWin();
	}

}
