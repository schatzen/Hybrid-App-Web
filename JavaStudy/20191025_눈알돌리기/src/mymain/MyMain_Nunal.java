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

public class MyMain_Nunal extends JFrame {

	//���
	public static final int GAME_W = 400;
	public static final int GAME_H = 600;
	
	static Image back_image,back_image_off;
	static {
		back_image = new ImageIcon("tiger.png").getImage();
		//���������� �̹���
		back_image_off = new ImageIcon("tiger_off.png").getImage();
	}
	
	//�׸��� ��������
	JPanel grimPan;
	
	//���� ��ǥ
	Point eye_left=new Point(),eye_right=new Point();
	int   eye_radius;
	
	//���� ��ǥ
	Point eyeball_left=new Point(),eyeball_right=new Point();
	int   eyeball_radius;
		
	//���ȿ� �����Ͱ� ���Գ�?
	boolean bEyeInPt = false;
	
	
	public MyMain_Nunal() {
		// TODO Auto-generated constructor stub
		super("���˵�����");

		//�׸��� �ʱ�ȭ
		init_grimpan();
		
		//����ǥ �ʱ�ȭ
		init_eye_position();
		
		//������ǥ �ʱ�ȭ
		init_eyeball_position();
		
		//��/������ ������ �ʱ�ȭ
		eye_radius     = 50;//GAME_W/4 - 30;
		eyeball_radius = 10;//eye_radius/2;
		
		
		//���콺 �̺�Ʈ �ʱ�ȭ
		init_mouse_event();
				
		
		//��ġ
		setLocation(200, 100);

		
		setResizable(false);
		
		//ũ��
		//package(����) 
		pack();//�ڽ������츦 ���μ� �������� ������
		//setSize(300, 300);

		
		
		//�������
		setVisible(true);

		//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub
		// XxxListener   <= interface
		//  ��XxxAdapter <= interface�߻�޼ҵ带 ������ �س��� �߻�Ŭ����  
		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//���콺�� ���� ��ǥ
				Point pt = e.getPoint();
				//���ʴ��� ��ġ���
				eyeball_left_position(pt);
				//�����ʴ��� ��ġ���
				eyeball_right_position(pt);
				
				//�׸����� �ٽ� �׷���
				grimPan.repaint();//��������� paintComponent(g) call
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				bEyeInPt = false;
				//������ ��ġ�� �߾ӹ�ġ
				init_eyeball_position();
				
				grimPan.repaint();
				
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				//���콺�� ���� ��ǥ
				Point pt = e.getPoint();
				//���ʴ��� ��ġ���
				eyeball_left_position(pt);
				//�����ʴ��� ��ġ���
				eyeball_right_position(pt);
				
				//�׸����� �ٽ� �׷���
				grimPan.repaint();//��������� paintComponent(g) call
			}
		};
		
		//�̺�Ʈ ���
		grimPan.addMouseListener(adapter);
		//���콺 �����̴»�Ȳ��  �̺�Ʈ ��� 
		grimPan.addMouseMotionListener(adapter);
		
		
	}

	protected void eyeball_right_position(Point pt) {
		// TODO Auto-generated method stub
		//���콺��ǥ
		int mx = pt.x;
		int my = pt.y;
		
		//�߽���ǥ
		int cx = eye_right.x;
		int cy = eye_right.y;
		
		int x = mx - cx;
		int y = my - cy;
		
		//��ü ��������
	    double r = Math.sqrt(x*x + y*y);
	    
	    //����
	    double rate = eyeball_radius/r;
	    
	    //������ ��ġ ����
	    eyeball_right.x = (int)(cx + x*rate);
	    eyeball_right.y = (int)(cy + y*rate);
	    
	    //���ȿ� ���Գ�?
	    if(!bEyeInPt)
	       bEyeInPt = (r <= eye_radius);
	}

	protected void eyeball_left_position(Point pt) {
		// TODO Auto-generated method stub
		//���콺��ǥ
		int mx = pt.x;
		int my = pt.y;
		
		//�߽���ǥ
		int cx = eye_left.x;
		int cy = eye_left.y;
		
		int x = mx - cx;
		int y = my - cy;
		
		//��ü ��������
	    double r = Math.sqrt(x*x + y*y);
	    
	    //����
	    double rate = eyeball_radius/r;
	    
	    //������ ��ġ ����
	    eyeball_left.x = (int)(cx + x*rate);
	    eyeball_left.y = (int)(cy + y*rate);

	    //���ȿ� ���Գ�?
	    bEyeInPt = (r <= eye_radius);
	    
		/*
		 * if(r<=eye_radius) bEyeInPt = true; else bEyeInPt = false;
		 */
	}

	private void init_eyeball_position() {
		// TODO Auto-generated method stub
		//�����߽���ǥ�ʱ�ȭ
		//������ǥ <- ������ǥ
		eyeball_left.x = eye_left.x;
		eyeball_left.y = eye_left.y;
		
		eyeball_right.x = eye_right.x;
		eyeball_right.y = eye_right.y;
	}

	private void init_eye_position() {
		// TODO Auto-generated method stub
	    //���ʴ� �ʱ�ȭ
		eye_left.x = 94;
		eye_left.y = 205;
		
		//�����ʴ�
		eye_right.x = 284;
		eye_right.y = 207;
		
	}

	private void init_grimpan() {
		// TODO Auto-generated method stub
		grimPan  = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				//Dimension d = this.getSize();
				//System.out.printf("W:%d H:%d\n",d.width,d.height);
				
				//����̹��� �׸���
				
				if(bEyeInPt) {//���ȿ� ���콺�����Ͱ� �����
					g.drawImage(back_image_off, 0, 0, this);
					return;
				}
				
				
				g.drawImage(back_image, 0, 0, this);
				//�����׷ȴ� ���� �����
				//g.clearRect(0, 0, GAME_W, GAME_H);
				
				
				draw_eye(g);
				
			}
			
		};
		
		//�׸����� ũ������(����)
		grimPan.setPreferredSize(new Dimension(GAME_W, GAME_H));
				
		this.add(grimPan);
		
	}

	protected void draw_eye(Graphics g) {
		// TODO Auto-generated method stub
		//���׸���
		
		//���ʴ�
		/*
		 * g.drawOval(eye_left.x -eye_radius, eye_left.y -eye_radius, eye_radius*2,
		 * eye_radius*2); //�����ʴ� g.drawOval(eye_right.x -eye_radius, eye_right.y
		 * -eye_radius, eye_radius*2, eye_radius*2);
		 */
		
		//���˱׸���
		g.setColor(new Color(255,100,0,200));
		//���ʴ���
		g.fillOval(eyeball_left.x - eyeball_radius, 
				   eyeball_left.y - eyeball_radius, 
				   eyeball_radius*2,
				   eyeball_radius*2  
				  );
		//�����ʴ���
		g.fillOval(eyeball_right.x - eyeball_radius, 
				   eyeball_right.y - eyeball_radius, 
				   eyeball_radius*2,
				   eyeball_radius*2  
				  );
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_Nunal();
	}
}

