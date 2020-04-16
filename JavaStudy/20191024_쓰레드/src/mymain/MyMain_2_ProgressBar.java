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
	
	//�����尡 ����������...���º���
	boolean bRedRunning=true,bGreenRunning=true,bBlueRunning=true;
	
	//ó��Ƚ�� üũ
	int  rCount=0,gCount=0,bCount=0;
	
	public MyMain_2_ProgressBar() {
		// TODO Auto-generated constructor stub
		super("ProgressBar����");

		//��ġ��� ����
		setLayout(new GridLayout(3, 1));
		
		jpb_red 	= new JProgressBar();
		jpb_green 	= new JProgressBar();
		jpb_blue 	= new JProgressBar();
		
		jpb_red.setValue(10);
		jpb_green.setValue(50);
		jpb_blue.setValue(70);
				
		//ProgressBar����
		jpb_red.setForeground(Color.red);
		jpb_green.setForeground(Color.green);
		jpb_blue.setForeground(Color.blue);
		
		//�߰�
		this.add(jpb_red);
		this.add(jpb_green);
		this.add(jpb_blue);
				
		
		//Red�� ���� Thread�Ҵ�(�۾��� �Ҵ�)
		//�͸���Ŭ���� : �ܺ�Ŭ������ ������� ���
		Thread tRed = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					
					//���� �� ������
					int value = jpb_red.getValue();
					value++;//����
					if(value> jpb_red.getMaximum()) value=0;
					
					//����� ���� ����
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
					
					//���� �� ������
					int value = jpb_green.getValue();
					value+=2;//����
					if(value> jpb_green.getMaximum()) value=0;
					
					//����� ���� ����
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
					
					//���� �� ������
					int value = jpb_blue.getValue();
					value+=3;//����
					if(value> jpb_blue.getMaximum()) value=0;
					
					//����� ���� ����
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
		
		
		
		//Ű���� �̺�Ʈ
		KeyListener listener = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e);
				//����Ű��
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_R) {
					//Toggleó��
					bRedRunning = !bRedRunning;
					if(bRedRunning) {//����
					   tRed.resume();//�籸��	
					}else {//����
                       tRed.suspend();//�Ͻ�����						
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
		
		
		
		//��ġ
		setLocation(200, 100);

		//ũ��
		setSize(300, 300);

		//�������
		setVisible(true);

		//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_2_ProgressBar();
	}
}
