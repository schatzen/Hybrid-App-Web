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

	
	JPanel gamePan;
	
	Timer timer;
	
	Me me = new Me();
	
	//Ű��������
	int key_state;
	
	DungManager dungManager = new DungManager();
	
	
	int collision_count = 0;
	CollisionManager collisionManager;
	
	public MyMain_�����ϱ�() {
		// TODO Auto-generated constructor stub
		super("�����ϱ�");

		collisionManager = new CollisionManager(dungManager, this);
		
		//������ �ʱ�ȭ
		init_gamepan();
		
		//����ġ �ʱ�ȭ
		init_me();
		
		//Ű�̺�Ʈ �ʱ�ȭ
		init_key_event();
				
		
		//Ÿ�̸� �ʱ�ȭ
		init_timer();
		
		//��ġ
		setLocation(200, 100);

		//ũ�����
		setResizable(false);
		//ũ��
		//setSize(300, 300);
		pack();

		//�������
		setVisible(true);

		//����
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
				//����ȭ�� �׷���
				gamePan.repaint();
			}
		};
		
		//Ÿ�̸� ����     1/1000
		timer = new Timer( 1, listener);
		timer.start();
		
	}

	protected void process() {
		// TODO Auto-generated method stub

		//�� �����
		dungManager.make_dung();
		
		//�� �̵����Ѷ�
		dungManager.move_all();
		
		//Ÿ��Ʋ�ٿ� �˰��� �����
		//setTitle(dungManager.dung_list.size()+"");
		
		
		//Me�� �̵���Ų��
		move_me();
		
		//�浹üũ
		collisionManager.collision_me_dung();
		
		//�浹Ƚ�� Ÿ��Ʋ�� ���
		setTitle("�浹Ƚ��:" + collision_count);
		
		
		
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
				
				//�� �׸���
				dungManager.draw_all(g);
				
				//�� �׸���
				me.draw(g);
				
				//�浹Ƚ�� ���
				draw_title(g);
			}
		};
		
		gamePan.setPreferredSize(new Dimension(GameConstant.GAMEPAN_W, GameConstant.GAMEPAN_H));
		this.add(gamePan, BorderLayout.CENTER);
	}

	Font font  = new Font("�޸տ�ü", Font.BOLD, 30);
	Font font1 = new Font("�޸տ�ü", Font.BOLD, 20);
	
	protected void draw_title(Graphics g) {
		// TODO Auto-generated method stub
		g.setFont(font);
		
		g.setColor(Color.black);
		g.drawString("�ڶ����ϱ��", 110+1, 40+1);
		g.setColor(Color.blue);
		g.drawString("�ڶ����ϱ��", 110, 40);
		
		
		g.setFont(font1);
		g.setColor(Color.black);
		g.drawString("�浹Ƚ��:"+ collision_count, 280+1, 80+1);
		g.setColor(Color.red);
		g.drawString("�浹Ƚ��:"+ collision_count, 280, 80);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_�����ϱ�();
	}
}
