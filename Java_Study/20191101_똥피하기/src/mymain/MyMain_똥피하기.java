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

public class MyMain_�����ϱ� extends JFrame {
	
	Font font = new Font("����ü", Font.BOLD, 40);
	
	Color color_me = new Color(241, 234, 127);
	Color color_count = new Color(216, 174, 71);

	JPanel gamePan;

	Timer timer;

	Me me = new Me();

	// Ű ���� ����
	int key_state;

	DungManager dungManager = new DungManager();

	int collision_count = 0;
	CollisionManager collisionManager;

	public MyMain_�����ϱ�() {
		super("�� ���ϱ�");

		collisionManager = new CollisionManager(dungManager, this);

		// ������ �ʱ�ȭ
		init_gamepan();

		// �� ��ġ �ʱ�ȭ
		init_me();

		// Ű �̺�Ʈ �� ��ȭ
		init_key_event();

		// Ÿ�̸� �ʱ�ȭ
		init_timer();

		// ��ġ
		setLocation(200, 100);

		// ũ��
		// setSize(300, 300);
		pack();

		// �������
		setVisible(true);

		// ����
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

		// Ÿ�̸� ���� 1/1000 ������ ���� ���� ����
		timer = new Timer(1, listener);
		timer.start();

	}

	protected void process() {
		// TODO Auto-generated method stub

		// �� �����
		dungManager.make_dung();

		// �� �̵����Ѷ�
		dungManager.move_all();

		// Ÿ��Ʋ�ٿ� ���� �����
		setTitle(dungManager.dungList.size() + " ");

		// Me�� �̵���Ų��
		move_me();

		// �浹üũ
		collisionManager.collision_me_dung();

		// �浹Ƚ�� ���
		setTitle("�浹Ƚ�� : " + collision_count);

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

				// �� �׸���
				dungManager.draw_all(g);

				// �� �׸�
				me.draw(g);
				
				//�� ī��Ʈ
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

		new MyMain_�����ϱ�();
	}

}
