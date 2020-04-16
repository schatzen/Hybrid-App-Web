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
	
	Font font = new Font("굴림체", Font.BOLD, 40);
	
	Color color_me = new Color(241, 234, 127);
	Color color_count = new Color(216, 174, 71);

	JPanel gamePan;

	Timer timer;

	Me me = new Me();

	// 키 눌림 상태
	int key_state;

	DungManager dungManager = new DungManager();

	int collision_count = 0;
	CollisionManager collisionManager;

	public MyMain_똥피하기() {
		super("똥 피하기");

		collisionManager = new CollisionManager(dungManager, this);

		// 게임판 초기화
		init_gamepan();

		// 내 위치 초기화
		init_me();

		// 키 이벤트 초 기화
		init_key_event();

		// 타이머 초기화
		init_timer();

		// 위치
		setLocation(200, 100);

		// 크기
		// setSize(300, 300);
		pack();

		// 보여줘라
		setVisible(true);

		// 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_key_event() {
		// TODO Auto-generated method stub
		KeyAdapter adapter = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_LEFT) {
					key_state = key_state | GameConstatnt.Key.LEFT;
				} else if (key == KeyEvent.VK_RIGHT) {
					key_state = key_state | GameConstatnt.Key.RIGHT;
				} else if (key == KeyEvent.VK_UP) {
					key_state = key_state | GameConstatnt.Key.UP;
				} else if (key == KeyEvent.VK_DOWN) {
					key_state = key_state | GameConstatnt.Key.DOWN;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_LEFT) {
					key_state = key_state ^ GameConstatnt.Key.LEFT;
				} else if (key == KeyEvent.VK_RIGHT) {
					key_state = key_state ^ GameConstatnt.Key.RIGHT;
				} else if (key == KeyEvent.VK_UP) {
					key_state = key_state ^ GameConstatnt.Key.UP;
				} else if (key == KeyEvent.VK_DOWN) {
					key_state = key_state ^ GameConstatnt.Key.DOWN;
				}
			}

		};

		this.addKeyListener(adapter);

	}

	private void init_me() {
		// TODO Auto-generated method stub

		Rectangle pos = new Rectangle(40, 70);
		pos.x = GameConstatnt.GAMEPAN_W / 2 - pos.width / 2;
		pos.y = GameConstatnt.GAMEPAN_H - pos.height - 10;

		me.pos = pos;
		me.color = color_me;

	}

	private void init_timer() {
		// TODO Auto-generated method stub
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// System.out.println(e);

				process();

				gamePan.repaint();

			}

		};

		// 타이머 생성 1/1000 단위로 위에 것을 콜함
		timer = new Timer(1, listener);
		timer.start();

	}

	protected void process() {
		// TODO Auto-generated method stub

		// 똥 만들기
		dungManager.make_dung();

		// 똥 이돋시켜라
		dungManager.move_all();

		// 타이틀바에 개수 모니터
		setTitle(dungManager.dungList.size() + " ");

		// Me를 이동시킨다
		move_me();

		// 충돌체크
		collisionManager.collision_me_dung();

		// 충돌횟수 출력
		setTitle("충돌횟수 : " + collision_count);

	}

	private void move_me() {
		// TODO Auto-generated method stub

		if (key_state == GameConstatnt.Key.LEFT) {
			me.move_left();
		} else if (key_state == GameConstatnt.Key.RIGHT) {
			me.move_right();

		}

	}

	private void init_gamepan() {
		// TODO Auto-generated method stub
		gamePan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				g.clearRect(0, 0, GameConstatnt.GAMEPAN_W, GameConstatnt.GAMEPAN_H);

				// 똥 그리기
				dungManager.draw_all(g);

				// 나 그릭
				me.draw(g);
				
				//똥 카운트
				g.setFont(font);
				g.setColor(color_count);
				g.drawString(""+collision_count,190,50);
				
				
			}
		};
		gamePan.setPreferredSize(new Dimension(GameConstatnt.GAMEPAN_W, GameConstatnt.GAMEPAN_H));
		this.add(gamePan, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MyMain_똥피하기();
	}

}
