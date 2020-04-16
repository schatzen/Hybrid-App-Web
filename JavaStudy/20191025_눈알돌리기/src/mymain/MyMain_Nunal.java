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

	//상수
	public static final int GAME_W = 400;
	public static final int GAME_H = 600;
	
	static Image back_image,back_image_off;
	static {
		back_image = new ImageIcon("tiger.png").getImage();
		//눈감았을때 이미지
		back_image_off = new ImageIcon("tiger_off.png").getImage();
	}
	
	//그림판 참조변수
	JPanel grimPan;
	
	//눈의 좌표
	Point eye_left=new Point(),eye_right=new Point();
	int   eye_radius;
	
	//눈알 좌표
	Point eyeball_left=new Point(),eyeball_right=new Point();
	int   eyeball_radius;
		
	//눈안에 포인터가 들어왔냐?
	boolean bEyeInPt = false;
	
	
	public MyMain_Nunal() {
		// TODO Auto-generated constructor stub
		super("눈알돌리기");

		//그림판 초기화
		init_grimpan();
		
		//눈좌표 초기화
		init_eye_position();
		
		//눈알좌표 초기화
		init_eyeball_position();
		
		//눈/눈알의 반지름 초기화
		eye_radius     = 50;//GAME_W/4 - 30;
		eyeball_radius = 10;//eye_radius/2;
		
		
		//마우스 이벤트 초기화
		init_mouse_event();
				
		
		//위치
		setLocation(200, 100);

		
		setResizable(false);
		
		//크기
		//package(포장) 
		pack();//자식윈도우를 감싸서 프레임을 입혀라
		//setSize(300, 300);

		
		
		//보여줘라
		setVisible(true);

		//종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub
		// XxxListener   <= interface
		//  ㄴXxxAdapter <= interface추상메소드를 재정의 해놓은 추상클래스  
		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//마우스가 눌린 좌표
				Point pt = e.getPoint();
				//왼쪽눈알 위치계산
				eyeball_left_position(pt);
				//오른쪽눈알 위치계산
				eyeball_right_position(pt);
				
				//그림판을 다시 그려라
				grimPan.repaint();//결과적으로 paintComponent(g) call
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				bEyeInPt = false;
				//눈알의 위치를 중앙배치
				init_eyeball_position();
				
				grimPan.repaint();
				
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				//마우스가 눌린 좌표
				Point pt = e.getPoint();
				//왼쪽눈알 위치계산
				eyeball_left_position(pt);
				//오른쪽눈알 위치계산
				eyeball_right_position(pt);
				
				//그림판을 다시 그려라
				grimPan.repaint();//결과적으로 paintComponent(g) call
			}
		};
		
		//이벤트 등록
		grimPan.addMouseListener(adapter);
		//마우스 움직이는상황의  이벤트 등록 
		grimPan.addMouseMotionListener(adapter);
		
		
	}

	protected void eyeball_right_position(Point pt) {
		// TODO Auto-generated method stub
		//마우스좌표
		int mx = pt.x;
		int my = pt.y;
		
		//중심좌표
		int cx = eye_right.x;
		int cy = eye_right.y;
		
		int x = mx - cx;
		int y = my - cy;
		
		//전체 빗변길이
	    double r = Math.sqrt(x*x + y*y);
	    
	    //비율
	    double rate = eyeball_radius/r;
	    
	    //눈알의 위치 지정
	    eyeball_right.x = (int)(cx + x*rate);
	    eyeball_right.y = (int)(cy + y*rate);
	    
	    //눈안에 들어왔냐?
	    if(!bEyeInPt)
	       bEyeInPt = (r <= eye_radius);
	}

	protected void eyeball_left_position(Point pt) {
		// TODO Auto-generated method stub
		//마우스좌표
		int mx = pt.x;
		int my = pt.y;
		
		//중심좌표
		int cx = eye_left.x;
		int cy = eye_left.y;
		
		int x = mx - cx;
		int y = my - cy;
		
		//전체 빗변길이
	    double r = Math.sqrt(x*x + y*y);
	    
	    //비율
	    double rate = eyeball_radius/r;
	    
	    //눈알의 위치 지정
	    eyeball_left.x = (int)(cx + x*rate);
	    eyeball_left.y = (int)(cy + y*rate);

	    //눈안에 들어왔냐?
	    bEyeInPt = (r <= eye_radius);
	    
		/*
		 * if(r<=eye_radius) bEyeInPt = true; else bEyeInPt = false;
		 */
	}

	private void init_eyeball_position() {
		// TODO Auto-generated method stub
		//눈알중심좌표초기화
		//눈알좌표 <- 눈의좌표
		eyeball_left.x = eye_left.x;
		eyeball_left.y = eye_left.y;
		
		eyeball_right.x = eye_right.x;
		eyeball_right.y = eye_right.y;
	}

	private void init_eye_position() {
		// TODO Auto-generated method stub
	    //왼쪽눈 초기화
		eye_left.x = 94;
		eye_left.y = 205;
		
		//오른쪽눈
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
				
				//배경이미지 그리기
				
				if(bEyeInPt) {//눈안에 마우스포인터가 들어간경우
					g.drawImage(back_image_off, 0, 0, this);
					return;
				}
				
				
				g.drawImage(back_image, 0, 0, this);
				//이전그렸던 내용 지우기
				//g.clearRect(0, 0, GAME_W, GAME_H);
				
				
				draw_eye(g);
				
			}
			
		};
		
		//그림판의 크기지정(예약)
		grimPan.setPreferredSize(new Dimension(GAME_W, GAME_H));
				
		this.add(grimPan);
		
	}

	protected void draw_eye(Graphics g) {
		// TODO Auto-generated method stub
		//눈그리기
		
		//왼쪽눈
		/*
		 * g.drawOval(eye_left.x -eye_radius, eye_left.y -eye_radius, eye_radius*2,
		 * eye_radius*2); //오른쪽눈 g.drawOval(eye_right.x -eye_radius, eye_right.y
		 * -eye_radius, eye_radius*2, eye_radius*2);
		 */
		
		//눈알그리기
		g.setColor(new Color(255,100,0,200));
		//왼쪽눈알
		g.fillOval(eyeball_left.x - eyeball_radius, 
				   eyeball_left.y - eyeball_radius, 
				   eyeball_radius*2,
				   eyeball_radius*2  
				  );
		//오른쪽눈알
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

