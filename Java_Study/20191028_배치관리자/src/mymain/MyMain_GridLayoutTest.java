package mymain;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_GridLayoutTest extends JFrame {

	public MyMain_GridLayoutTest() {
		super("GridLayout ����");
		// ��켱���� ä������

		GridLayout gl = new GridLayout(3, 4);

		// ��ġ��� ���� : BorderLayout > GridLayout
		this.setLayout(gl);

		for (int i = 1; i <= 20; i++) {
			String caption = String.format("B_%02d", i);
			JButton jbt = new JButton(caption);
			this.add(jbt);
		}
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

		new MyMain_GridLayoutTest();
	}

}
