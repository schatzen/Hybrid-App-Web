package mymain;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_4_Signal_Synchronized_Method extends JFrame {

	JButton jbt_red, jbt_yellow, jbt_blue;

	// �� ��ȣ���� ���� �Ѵ� ������
	class SignalRunnable implements Runnable {

// synchronized(this) : method ����ȭ�� ������ü
		synchronized void redOn() { // synchronized(this) void �̷��� ������ ��,,!
			// Red On
			jbt_red.setBackground(Color.red);
			jbt_yellow.setBackground(Color.gray);
			jbt_blue.setBackground(Color.gray);

			// Title
			jbt_red.setText("O");
			jbt_yellow.setText("X");
			jbt_blue.setText("X");

		}

		synchronized void yellowOn() {

			// Yellow On
			jbt_red.setBackground(Color.gray);
			jbt_yellow.setBackground(Color.yellow);
			jbt_blue.setBackground(Color.gray);

			jbt_red.setText("X");
			jbt_yellow.setText("O");
			jbt_blue.setText("X");

		}

		synchronized void blueOn() {

			// Blue On
			jbt_red.setBackground(Color.gray);
			jbt_yellow.setBackground(Color.gray);
			jbt_blue.setBackground(Color.blue);

			jbt_red.setText("X");
			jbt_yellow.setText("X");
			jbt_blue.setText("O");

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			String name = Thread.currentThread().getName();

			while (true) {

				if (name.equals("R")) {

					// �Ӱ迵��(Critical Section)
					// : �����ڿ��� ���Ǵ� ����

					redOn();

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (name.equals("Y")) {

					yellowOn();

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (name.equals("B")) {

					blueOn();

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

		}

	}

	public MyMain_4_Signal_Synchronized_Method() {
		super("��ȣ��");

		// ��ġ��� ����
		setLayout(new GridLayout(1, 3));

		// �� ��ư ����
		jbt_red = new JButton("Red On");
		jbt_yellow = new JButton("Yellow On");
		jbt_blue = new JButton("Blue Off");

		// ������
		jbt_red.setBackground(Color.red);
		jbt_yellow.setBackground(Color.yellow);
		jbt_blue.setBackground(Color.blue);

		this.add(jbt_red);
		this.add(jbt_yellow);
		this.add(jbt_blue);

		// �� ��ȣ���� ���� �Ѵ� Thread ��ü ����
		Runnable runnable = new SignalRunnable();

		Thread tRed = new Thread(runnable, "R");
		Thread tYellow = new Thread(runnable, "Y");
		Thread tBlue = new Thread(runnable, "B");

		tRed.start();
		tYellow.start();
		tBlue.start();

		// ��ġ
		setLocation(700, 300);

		// ũ��
		setSize(400, 130);

		// �������
		setVisible(true);

		// ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MyMain_4_Signal_Synchronized_Method();
	}

	public void run() {
		// TODO Auto-generated method stub

	}

}
