package mymain;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_3_Signal_Synchronized extends JFrame {

	JButton jbt_red,jbt_yellow,jbt_blue;

	//각신호등의 불의 켜는 쓰레드
	class SignalRunnable extends Object implements Runnable
	{
		//동기화 관리(통제) 객체
		Object syncObj = new Object();
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			String name = Thread.currentThread().getName();
			
			while(true) {
			
				if(name.equals("R")) {
					
					//임계영역(Critical Section)
					//: 공유자원이 사용되는 영역
					
				    synchronized (syncObj) 
				    {
						//Red On
						jbt_red.setBackground(Color.red);
						jbt_yellow.setBackground(Color.gray);
						jbt_blue.setBackground(Color.gray);
						
						//Title
						jbt_red.setText("O");
						jbt_yellow.setText("X");
						jbt_blue.setText("X");
				    }
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
										
				}else if(name.equals("Y")) {
					
					synchronized (syncObj) 
				    {
						//Yellow On
						jbt_red.setBackground(Color.gray);
						jbt_yellow.setBackground(Color.yellow);
						jbt_blue.setBackground(Color.gray);
						
						//Title
						jbt_red.setText("X");
						jbt_yellow.setText("O");
						jbt_blue.setText("X");
				    }
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else if(name.equals("B")) {
					
					synchronized (syncObj) 
				    {
						//Blue On
						jbt_red.setBackground(Color.gray);
						jbt_yellow.setBackground(Color.gray);
						jbt_blue.setBackground(Color.blue);
						
						//Title
						jbt_red.setText("X");
						jbt_yellow.setText("X");
						jbt_blue.setText("O");
				    }
					
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
	
	
	public MyMain_3_Signal_Synchronized() {
		// TODO Auto-generated constructor stub
		super("신호등");
		
		//배치방법변경
		setLayout(new GridLayout(1, 3));
		
		//각버튼 생성
		jbt_red = new JButton("Red On");
		jbt_yellow = new JButton("Yellow On");
		jbt_blue = new JButton("Blue On");
		
		//배경색상
		jbt_red.setBackground(Color.red);
		jbt_yellow.setBackground(Color.yellow);
		jbt_blue.setBackground(Color.blue);
		
		this.add(jbt_red);
		this.add(jbt_yellow);
		this.add(jbt_blue);
			
		
		//각신호등의 불을켜는 Thread객체 생성
		Runnable runnable = new SignalRunnable();
		
		Thread tRed    = new Thread(runnable,"R");
		Thread tYellow = new Thread(runnable,"Y");
		Thread tBlue   = new Thread(runnable,"B");
		
		tRed.start();
		tYellow.start();
		tBlue.start();
		

		//위치
		setLocation(200, 100);

		//크기
		setSize(300, 150);

		//보여줘라
		setVisible(true);

		//종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_3_Signal_Synchronized();
	}
}
