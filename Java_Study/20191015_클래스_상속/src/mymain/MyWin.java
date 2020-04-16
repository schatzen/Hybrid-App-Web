package mymain;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/*
AWT(Abstract Window Toolkit) : 윈도우 관련 객체 설계
java.awt.*
javax.swing.*

메인 윈도우: Frame(상단 메뉴와 같이 가장 큰 틀의 윈도우)
swing   	ㄴJFrame


*/

public class MyWin extends JFrame implements KeyListener {

	// 화면 해상도를 저장할 변수
	int screen_w, screen_h;

	public MyWin() { // 초기화할 공간

		super("Take A Deep Breathe"); // JFrame("타이틀") > 더 정확히는 Frame() 생성자 ㅎㅎ

		// 화면 해상도 구하기
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		screen_w = d.width;
		screen_h = d.height;

		System.out.printf("width = %d height = %d\n", screen_w, screen_h);

		// 위치 지정(바탕화면 윈도우 기준)
		// x y
		super.setLocation(400, 200);

		// Toolkit.웅앵~ 은 객체없이 만들 수 있는 static 메소드

		// 크기 지정
		super.setSize(300, 300);

		// 해당 윈도우 보여줘라
		super.setVisible(true);

		// 윈도우 크기 변경 불가
		super.setResizable(false);

		// 종료버튼 처리
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 키보드 이벤트
		// 현재 윈도우에서 키가 눌리면 이벤트 처리를
		// 현재 윈도우에게 위임
		this.addKeyListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MyWin(); // 기본생성자 생성

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// System.out.println(e);
		int key = e.getKeyCode(); // 눌린 키 값

		// 현재 윈도우 위치 구하기
		Point pt = this.getLocation();
		int gan = 10;

		// System.out.println();
		if (key == KeyEvent.VK_LEFT) { // KeyEvent.VK_웅앵 : 가상 키 값 통일
			pt.x = pt.x - gan;
		} else if (key == KeyEvent.VK_RIGHT) {
			pt.x = pt.x + gan;
		} else if (key == KeyEvent.VK_UP) {
			pt.y = pt.y - gan;
		} else if (key == KeyEvent.VK_DOWN) {
			pt.y = pt.y + gan;
		}

		// 변경된 좌표 값으로 윈도우를 재위치
		this.setLocation(pt); // super로 쓰나 this로 쓰나 큰 상관X

		// 왼 쪽으로 나갔냐?
		if (pt.x < -300) {
			pt.x = 1920;
		} else if (pt.x > 1920) {
			pt.x = -300;
		} else if (pt.y > 1080) {
			pt.y = -300;
		} else if (pt.y < -300) {
			pt.y = 1080;
		}

		this.setLocation(pt);

		// 위 쪽으로 나갔냐?

		// 아래로 나갔냐?

		// 위로 나갔냐??

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
