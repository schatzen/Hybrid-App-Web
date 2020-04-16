package mymain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyMain_똥피하기 extends JFrame {

	
	JPanel gamePan;
	
	Timer timer;
	
	Me me = new Me();
	
	//키눌림상태
	int key_state;
	
	DungManager dungManager = new DungManager();
	
	
	int collision_count = 0;
	CollisionManager collisionManager;
	
	public MyMain_똥피하기() {
		// TODO Auto-generated constructor stub
		super("똥피하기");

		collisionManager = new CollisionManager(dungManager, this);
		
		//게임판 초기화
		init_gamepan();
		
		//내위치 초기화
		init_me();
		
		//키이벤트 초기화
		init_key_event();
				
		
		//타이머 초기화
		init_timer();
		
		//위치
		setLocation(200, 100);

		//크기고정
		setResizable(false);
		//크기
		//setSize(300, 300);
		pack();

		//보여줘라
		setVisible(true);

		//종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	private void init_key_event() {
		// TODO Auto-generated method stub
		KeyAdapter adapter = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				
				if(key==KeyEvent.VK_LEFT) {
					key_state = key_state | GameConstant.Key.LEFT;
				}else if(key==KeyEvent.VK_RIGHT) {
					key_state = key_state | GameConstant.Key.RIGHT;
				}else if(key==KeyEvent.VK_UP) {
					key_state = key_state | GameConstant.Key.UP;
				}else if(key==KeyEvent.VK_DOWN) {
					key_state = key_state | GameConstant.Key.DOWN;
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				
				if(key==KeyEvent.VK_LEFT) {
					key_state = key_state ^ GameConstant.Key.LEFT;
				}else if(key==KeyEvent.VK_RIGHT) {
					key_state = key_state ^ GameConstant.Key.RIGHT;
				}else if(key==KeyEvent.VK_UP) {
					key_state = key_state ^ GameConstant.Key.UP;
				}else if(key==KeyEvent.VK_DOWN) {
					key_state = key_state ^ GameConstant.Key.DOWN;
				}
			}
			
		};
		
		this.addKeyListener(adapter);
		
	}


	private void init_me() {
		// TODO Auto-generated method stub
		Rectangle pos = new Rectangle(40, 80);
		pos.x = GameConstant.GAMEPAN_W/2 - pos.width/2;
		pos.y = GameConstant.GAMEPAN_H - pos.height-5;
		me.pos = pos;
		me.color = Color.blue;
	}


	private void init_timer() {
		// TODO Auto-generated method stub
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e);
				process();
				//게임화면 그려라
				gamePan.repaint();
			}
		};
		
		//타이머 생성     1/1000
		timer = new Timer( 1, listener);
		timer.start();
		
	}

	protected void process() {
		// TODO Auto-generated method stub

		//똥 만들기
		dungManager.make_dung();
		
		//똥 이동시켜라
		dungManager.move_all();
		
		//타이틀바에 똥갯수 모니터
		//setTitle(dungManager.dung_list.size()+"");
		
		
		//Me를 이동시킨다
		move_me();
		
		//충돌체크
		collisionManager.collision_me_dung();
		
		//충돌횟수 타이틀바 출력
		setTitle("충돌횟수:" + collision_count);
		
		
		
	}


	private void move_me() {
		// TODO Auto-generated method stub
		
		if((key_state&GameConstant.Key.LEFT) == GameConstant.Key.LEFT) {
			me.move_left();
		}else if((key_state&GameConstant.Key.RIGHT) == GameConstant.Key.RIGHT) {
			me.move_right();
		}
		
		
	}


	private void init_gamepan() {
		// TODO Auto-generated method stub
		gamePan = new JPanel() { 
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				g.clearRect(0, 0, GameConstant.GAMEPAN_W, GameConstant.GAMEPAN_H);
				
				//똥 그리기
				dungManager.draw_all(g);
				
				//나 그리기
				me.draw(g);
				
				//충돌횟수 출력
				draw_title(g);
			}
		};
		
		gamePan.setPreferredSize(new Dimension(GameConstant.GAMEPAN_W, GameConstant.GAMEPAN_H));
		this.add(gamePan, BorderLayout.CENTER);
	}

	Font font  = new Font("휴먼옛체", Font.BOLD, 30);
	Font font1 = new Font("휴먼옛체", Font.BOLD, 20);
	
	protected void draw_title(Graphics g) {
		// TODO Auto-generated method stub
		g.setFont(font);
		
		g.setColor(Color.black);
		g.drawString("★똥피하기★", 110+1, 40+1);
		g.setColor(Color.blue);
		g.drawString("★똥피하기★", 110, 40);
		
		
		g.setFont(font1);
		g.setColor(Color.black);
		g.drawString("충돌횟수:"+ collision_count, 280+1, 80+1);
		g.setColor(Color.red);
		g.drawString("충돌횟수:"+ collision_count, 280, 80);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_똥피하기();
	}
}
