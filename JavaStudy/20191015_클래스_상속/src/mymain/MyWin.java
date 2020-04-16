package mymain;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/*
 AWT(Abstract Window Toolkit):��������ð�ü ����
 java.awt.*   
 javax.swing.*
 
 ����������: Frame
 swing        ��JFrame  
  
*/


public class MyWin extends JFrame implements KeyListener{

	//ȭ���ػ󵵸� ������ ����
	int screen_w,screen_h;
	
	
	public MyWin() {
		// TODO Auto-generated constructor stub
		super("�������� ������");// JFrame("Ÿ��Ʋ");
		
		
		//ȭ���ػ� ���ϱ�
		Dimension d =  Toolkit.getDefaultToolkit().getScreenSize();
		screen_w = d.width;
		screen_h = d.height;
		
		//System.out.printf("width=%d height=%d\n",
		//		            screen_w,    screen_h);
				
		//��ġ ����(����ȭ�� ������ ����)
		//                 x     y
		super.setLocation(100, 100);
		
		//ũ�� ����
		super.setSize(300, 300);
		
		//�ش������� �������
		super.setVisible(true);
		
		//������ ũ�� ���� �Ұ�
		super.setResizable(false);
		
		//�����ưó��
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		
		//Ű���� �̺�Ʈ
		//���������쿡�� Ű�� ������ �̺�Ʈ ó����
		//���������쿡�� ����
		this.addKeyListener(this);
				
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyWin();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e);
		int key = e.getKeyCode();//����Ű��
		
		//���������� ��ġ ���ϱ�
		Point pt = this.getLocation();
		int   gan=10;
		//System.out.println(key);
		// VK_ => Virtual Key
		if(key== KeyEvent.VK_LEFT) {
			pt.x = pt.x - gan;
		}else if(key== KeyEvent.VK_RIGHT) {
			pt.x = pt.x + gan;
		}else if(key== KeyEvent.VK_UP) {
			pt.y = pt.y - gan;
		}else if(key== KeyEvent.VK_DOWN) {
			pt.y = pt.y + gan;
		}
		
		//�������� ������?
		if(pt.x < -300) {
			pt.x =screen_w;
		}//���������� ������?
		else if(pt.x > screen_w) {
			pt.x = -300;
		}
		
		//�������� ������?
		if(pt.y < -300) {
			pt.y = screen_h;
		}//�Ʒ��� ������?
		else if(pt.y > screen_h) {
			pt.y = -300;
		}
		
		
		//����� ��ǥ������ �����츦 �� ��ġ
		this.setLocation(pt);
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
