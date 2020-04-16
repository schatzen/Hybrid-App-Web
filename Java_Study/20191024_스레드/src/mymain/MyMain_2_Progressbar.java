package mymain;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class MyMain_2_Progressbar extends JFrame {

	JProgressBar jpb_red;
	JProgressBar jpb_green;
	JProgressBar jpb_blue;
	
	
	//�����尡 ����������.. ���º���
	boolean bRedRunning = true, bGreenRunning = true, bBlueRunning = true;

	public MyMain_2_Progressbar() {
		super("DEEP BREATHE");

		// ��ġ��� ����
		setLayout(new GridLayout(3, 1));

		jpb_red = new JProgressBar();
		jpb_green = new JProgressBar();
		jpb_blue = new JProgressBar();

		jpb_red.setValue(10);
		jpb_green.setValue(50);
		jpb_blue.setValue(70);

		// ProgressBar ����
		jpb_red.setForeground(Color.red);
		jpb_green.setForeground(Color.green);
		jpb_blue.setForeground(Color.blue);

		// �߰�
		this.add(jpb_red);
		this.add(jpb_green);
		this.add(jpb_blue);

		// Red�� ���� Thread�Ҵ� (�۾��� �Ҵ�)
		// �͸� ���� Ŭ���� : �ܺ� Ŭ������ ��� ��� ���
		Thread tRed = new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					// ���� �� ������
					int value = jpb_red.getValue();
					value++; // ����
					if (value > jpb_red.getMaximum())
						value = 0;

					// ����� ���� ����
					jpb_red.setValue(value);

					try {
						sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		};

		Thread tGreen = new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					// ���� �� ������
					int value = jpb_green.getValue();
					value++; // ����
					if (value > jpb_green.getMaximum())
						value = 0;

					// ����� ���� ����
					jpb_green.setValue(value);

					try {
						sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		};

		Thread tBlue = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					int value = jpb_blue.getValue();
					value++;
					if (value > jpb_blue.getMaximum())
						value = 0;

					jpb_blue.setValue(value);

					try {
						sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		tRed.start();
		tGreen.start();
		tBlue.start();

		// Ű���� �̺�Ʈ ! KeyListener�� ���� �˾Ƶα�! �������̽��� �߻�ȭ ����!
		/*
		 * KeyAdapter adapter = new KeyAdapter() {
		 * 
		 * @Override public void keyPressed(KeyEvent arg0) { // TODO Auto-generated
		 * method stub super.keyPressed(arg0); }
		 * 
		 * };
		 */

		KeyListener listener = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_R) {
					// Toggle ó��
					if (bRedRunning = !bRedRunning) { // ����
						tRed.resume(); // �籸��
					} else { // ����
						tRed.suspend();
					}

				} else if (key == KeyEvent.VK_G) {

					if (bGreenRunning = !bGreenRunning) { // ����
						tGreen.resume(); // �籸��
					} else { // ����
						tGreen.suspend();
					}

				} else if (key == KeyEvent.VK_B) {
					if (bBlueRunning = !bBlueRunning) { // ����
						tBlue.resume(); // �籸��
					} else { // ����
						tBlue.suspend();
					}
				}
			}

		};

		this.addKeyListener(listener);

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

		new MyMain_2_Progressbar();
	}

}
