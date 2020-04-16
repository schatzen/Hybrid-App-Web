package mymain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMain_눈알2 extends JFrame {
	
	static Image back_image,back_image_off;
	static {
		back_image = new ImageIcon("fruit.jpg").getImage();
		back_image_off = new ImageIcon("closed.jpg").getImage();
	}

	// 상수
	public static final int GAME_W = 400;
	public static final int GAME_H = 600;

	JPanel grimPan;

	// 눈의 좌표
	Point eye_left = new Point(), eye_right = new Point();
	int eye_radius;

	// 눈알 좌표
	Point eyeball_left = new Point(), eyeball_right = new Point();
	int eyeball_radius;

	public MyMain_눈알2() {
		super("눈알 돌리기");

		// 그림판 초기화
		init_grimPan();

		// 눈 좌표 초기화
		init_eye_position();

		// 눈알 좌표 초기화
		init_eyeball_position();

		// 눈&눈알의 반지름 초기화
		eye_radius = GAME_W / 4- 30;
		eyeball_radius = eye_radius / 2;

		// 마우스 이벤트 초기화
		init_mouse_event();

		// 위치
		setLocation(200, 100);

		// packing전/후에 따라 달라짐 > 꼭 전에 해야함
		setResizable(false);

		// 크기
		// package();
		pack(); // 자식윈도우를 감싸서 프레임을 입혀라
		// setSize(300, 300);

		// 보여줘라
		setVisible(true);

		// 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub
		// XxxListener <interface
		// ㄴXxxAdapter <interface추상메소드를 재정의 해놓은 추상클래스
		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e);
				// 마우스가 눌린 좌표
				Point pt = e.getPoint();
				// 왼쪽 눈알 위치계산
				eyeball_left_position(pt);
				// 오른쪽 눈알 위치계산
				eyeball_right_position(pt);

				// 그림판을 다시 그려라
				grimPan.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				// 마우스가 눌린 좌표
				Point pt = e.getPoint();
				// 왼쪽 눈알 위치계산
				eyeball_left_position(pt);
				// 오른쪽 눈알 위치계산
				eyeball_right_position(pt);

				// 그림판을 다시 그려라
				grimPan.repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		};

		// 이벤트 등록
		grimPan.addMouseListener(adapter);
		// 마우스 움직이는 상황의 이벤트등록
		grimPan.addMouseMotionListener(adapter);
	}

	protected void eyeball_left_position(Point pt) {
		// TODO Auto-generated method stub
		
	}

	protected void eyeball_right_position(Point pt) {
		// TODO Auto-generated method stub
		
	}

	private void init_eye_position() {
		// TODO Auto-generated method stub
		// 눈알 중심 좌표 초기화
		eyeball_left.x = eye_left.x;
		eyeball_left.y = eye_left.y;

		eyeball_right.x = eye_right.x;
		eyeball_right.y = eye_right.y;

	}

	private void init_eyeball_position() {
		// TODO Auto-generated method stub
		// 왼쪽 눈 초기화
		eye_left.x = GAME_W / 4;
		eye_left.y = GAME_H / 2;

		// 오른쪽 눈 초기화
		eye_right.x = GAME_W / 4 * 3;
		eye_right.y = GAME_H / 2;

	}

	private void init_grimPan() {
		// TODO Auto-generated method stub
		grimPan = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub

				// Dimension d = this.getSize();
				// System.out.printf("WL:%d H:%d\n", d.width, d.height);

				// 배경이미지 그리기

				// 그렸던 내용 지우기
				g.clearRect(0, 0, GAME_W, GAME_H);
				draw_eye(g);
			}
		};

		// 그림판의 크기 지정
		grimPan.setPreferredSize(new Dimension(GAME_W, GAME_H));

		this.add(grimPan);

	}

	protected void draw_eye(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(back_image, 0, 0, this);

		// 눈 그리기

		// 왼쪽 눈
		g.drawOval(eye_left.x - eye_radius, 
				eye_left.y - eye_radius, 
				eye_radius * 2, 
				eye_radius * 2);

		// 오른쪽 눈
		g.drawOval(eye_right.x - eye_radius, 
				eye_right.y - eye_radius, 
				eye_radius * 2, 
				eye_radius * 2);

		// 눈알그리기
		g.setColor(Color.black);
		// 왼쪽 눈알
		g.setColor(Color.black);
		g.drawLine(31, 298, 171, 298);
		
		
		// 오른쪽 눈알
		g.setColor(Color.black);
		g.drawLine(230, 298, 370, 298);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MyMain_눈알2();
	}

}
