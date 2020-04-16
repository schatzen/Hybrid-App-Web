package mymain;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class MyMain_2_ProgressBar extends JFrame {

	JProgressBar jpb_red;
	JProgressBar jpb_green;
	JProgressBar jpb_blue;
	
	//쓰레드가 구동중인지...상태변수
	boolean bRedRunning=true,bGreenRunning=true,bBlueRunning=true;
	
	//처리횟수 체크
	int  rCount=0,gCount=0,bCount=0;
	
	public MyMain_2_ProgressBar() {
		// TODO Auto-generated constructor stub
		super("ProgressBar연습");

		//배치방법 변경
		setLayout(new GridLayout(3, 1));
		
		jpb_red 	= new JProgressBar();
		jpb_green 	= new JProgressBar();
		jpb_blue 	= new JProgressBar();
		
		jpb_red.setValue(10);
		jpb_green.setValue(50);
		jpb_blue.setValue(70);
				
		//ProgressBar색상
		jpb_red.setForeground(Color.red);
		jpb_green.setForeground(Color.green);
		jpb_blue.setForeground(Color.blue);
		
		//추가
		this.add(jpb_red);
		this.add(jpb_green);
		this.add(jpb_blue);
				
		
		//Red를 진행 Thread할당(작업자 할당)
		//익명내부클래스 : 외부클래스의 모든멤버을 사용
		Thread tRed = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					
					//현재 값 얻어오기
					int value = jpb_red.getValue();
					value++;//증가
					if(value> jpb_red.getMaximum()) value=0;
					
					//변경된 값을 설정
					jpb_red.setValue(value);
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					rCount++;
					setTitle(String.format("R:%d G:%d B:%d", 
							                rCount,gCount,bCount
							));
				}
			}
		};
		tRed.start();
		
		
		
		Thread tGreen = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					
					//현재 값 얻어오기
					int value = jpb_green.getValue();
					value+=2;//증가
					if(value> jpb_green.getMaximum()) value=0;
					
					//변경된 값을 설정
					jpb_green.setValue(value);
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					gCount++;
					setTitle(String.format("R:%d G:%d B:%d", 
							                rCount,gCount,bCount
							));
				}
			}
		};
		tGreen.start();
		
		
		Thread tBlue = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					
					//현재 값 얻어오기
					int value = jpb_blue.getValue();
					value+=3;//증가
					if(value> jpb_blue.getMaximum()) value=0;
					
					//변경된 값을 설정
					jpb_blue.setValue(value);
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					bCount++;
					setTitle(String.format("R:%d G:%d B:%d", 
							                rCount,gCount,bCount
							));
				}
			}
		};
		tBlue.start();
		
		
		
		//키보드 이벤트
		KeyListener listener = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e);
				//눌린키값
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_R) {
					//Toggle처리
					bRedRunning = !bRedRunning;
					if(bRedRunning) {//구동
					   tRed.resume();//재구동	
					}else {//정지
                       tRed.suspend();//일시정지						
					}
					
				}else if(key==KeyEvent.VK_G) {
					bGreenRunning = !bGreenRunning;
					if(bGreenRunning) {
						tGreen.resume();
					}else {
						tGreen.suspend();
					}
					
				}else if(key==KeyEvent.VK_B) {
					
					bBlueRunning = !bBlueRunning;
					if(bBlueRunning) {
						tBlue.resume();
					}else {
						tBlue.suspend();
					}
				} 
			}
		};
		
		this.addKeyListener(listener);		
		
		
		
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
		new MyMain_2_ProgressBar();
	}
}
