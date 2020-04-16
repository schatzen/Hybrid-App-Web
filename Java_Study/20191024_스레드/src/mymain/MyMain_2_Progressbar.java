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
	
	
	//스레드가 구동중인지.. 상태변수
	boolean bRedRunning = true, bGreenRunning = true, bBlueRunning = true;

	public MyMain_2_Progressbar() {
		super("DEEP BREATHE");

		// 배치방법 변경
		setLayout(new GridLayout(3, 1));

		jpb_red = new JProgressBar();
		jpb_green = new JProgressBar();
		jpb_blue = new JProgressBar();

		jpb_red.setValue(10);
		jpb_green.setValue(50);
		jpb_blue.setValue(70);

		// ProgressBar 색상
		jpb_red.setForeground(Color.red);
		jpb_green.setForeground(Color.green);
		jpb_blue.setForeground(Color.blue);

		// 추가
		this.add(jpb_red);
		this.add(jpb_green);
		this.add(jpb_blue);

		// Red를 진행 Thread할당 (작업자 할당)
		// 익명 내부 클래스 : 외부 클래스의 모든 멤버 사용
		Thread tRed = new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					// 현재 값 얻어오기
					int value = jpb_red.getValue();
					value++; // 증가
					if (value > jpb_red.getMaximum())
						value = 0;

					// 변경된 값을 설정
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
					// 현재 값 얻어오기
					int value = jpb_green.getValue();
					value++; // 증가
					if (value > jpb_green.getMaximum())
						value = 0;

					// 변경된 값을 설정
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

		// 키보드 이벤트 ! KeyListener와 차이 알아두기! 인터페이스와 추상화 차이!
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
					// Toggle 처리
					if (bRedRunning = !bRedRunning) { // 구동
						tRed.resume(); // 재구동
					} else { // 정지
						tRed.suspend();
					}

				} else if (key == KeyEvent.VK_G) {

					if (bGreenRunning = !bGreenRunning) { // 구동
						tGreen.resume(); // 재구동
					} else { // 정지
						tGreen.suspend();
					}

				} else if (key == KeyEvent.VK_B) {
					if (bBlueRunning = !bBlueRunning) { // 구동
						tBlue.resume(); // 재구동
					} else { // 정지
						tBlue.suspend();
					}
				}
			}

		};

		this.addKeyListener(listener);

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

		new MyMain_2_Progressbar();
	}

}
