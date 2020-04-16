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

public class MyMain_����2 extends JFrame {
	
	static Image back_image,back_image_off;
	static {
		back_image = new ImageIcon("fruit.jpg").getImage();
		back_image_off = new ImageIcon("closed.jpg").getImage();
	}

	// ���
	public static final int GAME_W = 400;
	public static final int GAME_H = 600;

	JPanel grimPan;

	// ���� ��ǥ
	Point eye_left = new Point(), eye_right = new Point();
	int eye_radius;

	// ���� ��ǥ
	Point eyeball_left = new Point(), eyeball_right = new Point();
	int eyeball_radius;

	public MyMain_����2() {
		super("���� ������");

		// �׸��� �ʱ�ȭ
		init_grimPan();

		// �� ��ǥ �ʱ�ȭ
		init_eye_position();

		// ���� ��ǥ �ʱ�ȭ
		init_eyeball_position();

		// ��&������ ������ �ʱ�ȭ
		eye_radius = GAME_W / 4- 30;
		eyeball_radius = eye_radius / 2;

		// ���콺 �̺�Ʈ �ʱ�ȭ
		init_mouse_event();

		// ��ġ
		setLocation(200, 100);

		// packing��/�Ŀ� ���� �޶��� > �� ���� �ؾ���
		setResizable(false);

		// ũ��
		// package();
		pack(); // �ڽ������츦 ���μ� �������� ������
		// setSize(300, 300);

		// �������
		setVisible(true);

		// ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub
		// XxxListener <interface
		// ��XxxAdapter <interface�߻�޼ҵ带 ������ �س��� �߻�Ŭ����
		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e);
				// ���콺�� ���� ��ǥ
				Point pt = e.getPoint();
				// ���� ���� ��ġ���
				eyeball_left_position(pt);
				// ������ ���� ��ġ���
				eyeball_right_position(pt);

				// �׸����� �ٽ� �׷���
				grimPan.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				// ���콺�� ���� ��ǥ
				Point pt = e.getPoint();
				// ���� ���� ��ġ���
				eyeball_left_position(pt);
				// ������ ���� ��ġ���
				eyeball_right_position(pt);

				// �׸����� �ٽ� �׷���
				grimPan.repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		};

		// �̺�Ʈ ���
		grimPan.addMouseListener(adapter);
		// ���콺 �����̴� ��Ȳ�� �̺�Ʈ���
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
		// ���� �߽� ��ǥ �ʱ�ȭ
		eyeball_left.x = eye_left.x;
		eyeball_left.y = eye_left.y;

		eyeball_right.x = eye_right.x;
		eyeball_right.y = eye_right.y;

	}

	private void init_eyeball_position() {
		// TODO Auto-generated method stub
		// ���� �� �ʱ�ȭ
		eye_left.x = GAME_W / 4;
		eye_left.y = GAME_H / 2;

		// ������ �� �ʱ�ȭ
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

				// ����̹��� �׸���

				// �׷ȴ� ���� �����
				g.clearRect(0, 0, GAME_W, GAME_H);
				draw_eye(g);
			}
		};

		// �׸����� ũ�� ����
		grimPan.setPreferredSize(new Dimension(GAME_W, GAME_H));

		this.add(grimPan);

	}

	protected void draw_eye(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(back_image, 0, 0, this);

		// �� �׸���

		// ���� ��
		g.drawOval(eye_left.x - eye_radius, 
				eye_left.y - eye_radius, 
				eye_radius * 2, 
				eye_radius * 2);

		// ������ ��
		g.drawOval(eye_right.x - eye_radius, 
				eye_right.y - eye_radius, 
				eye_radius * 2, 
				eye_radius * 2);

		// ���˱׸���
		g.setColor(Color.black);
		// ���� ����
		g.setColor(Color.black);
		g.drawLine(31, 298, 171, 298);
		
		
		// ������ ����
		g.setColor(Color.black);
		g.drawLine(230, 298, 370, 298);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MyMain_����2();
	}

}
