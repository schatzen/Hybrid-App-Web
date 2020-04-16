package mymain;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/*
 AWT(Abstract Window Toolkit):윈도우관련객체 설계
 java.awt.*   
 javax.swing.*
 
 메인윈도우: Frame
 swing        ㄴJFrame  
  
*/


public class MyWin extends JFrame implements KeyListener{

	//화면해상도를 저장할 변수
	int screen_w,screen_h;
	
	
	public MyWin() {
		// TODO Auto-generated constructor stub
		super("내가만든 윈도우");// JFrame("타이틀");
		
		
		//화면해상도 구하기
		Dimension d =  Toolkit.getDefaultToolkit().getScreenSize();
		screen_w = d.width;
		screen_h = d.height;
		
		//System.out.printf("width=%d height=%d\n",
		//		            screen_w,    screen_h);
				
		//위치 지정(바탕화면 윈도우 기준)
		//                 x     y
		super.setLocation(100, 100);
		
		//크기 지정
		super.setSize(300, 300);
		
		//해당윈도우 보여줘라
		super.setVisible(true);
		
		//윈도우 크기 변경 불가
		super.setResizable(false);
		
		//종료버튼처리
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		
		//키보드 이벤트
		//현재윈도우에서 키가 눌리면 이벤트 처리를
		//현재윈도우에게 위임
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
		int key = e.getKeyCode();//눌린키값
		
		//현재윈도우 위치 구하기
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
		
		//왼쪽으로 나갔냐?
		if(pt.x < -300) {
			pt.x =screen_w;
		}//오른쪽으로 나갔냐?
		else if(pt.x > screen_w) {
			pt.x = -300;
		}
		
		//윗쪽으로 나갔냐?
		if(pt.y < -300) {
			pt.y = screen_h;
		}//아래로 나갔냐?
		else if(pt.y > screen_h) {
			pt.y = -300;
		}
		
		
		//변경된 좌표값으로 윈도우를 재 위치
		this.setLocation(pt);
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
