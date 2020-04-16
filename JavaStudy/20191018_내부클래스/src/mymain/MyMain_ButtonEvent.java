package mymain;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_ButtonEvent extends JFrame {

	
	//�����λ縻 �̺�Ʈ ó����ü
	//cf) POJO(Plain Old Java Object):�����ڹٰ�ü
	class EngButtonEventObject implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setTitle("Hi Everyone!!");
		}
	}
	
	
	
	public MyMain_ButtonEvent() {
		// TODO Auto-generated constructor stub
		super("��ư�̺�Ʈ����");
 
		//��ġ������ : ������ ����
		GridLayout gl = new GridLayout(5, 1);
		//��ġ����� ����
		this.setLayout(gl);
				
		JButton jbt_kor = new JButton("�ѱ��� �λ縻");
		JButton jbt_eng = new JButton("���� �λ縻");
		JButton jbt_chn = new JButton("�߱��� �λ縻");
		JButton jbt_jpn = new JButton("�Ϻ��� �λ縻");
		JButton jbt_ger = new JButton("���Ͼ� �λ縻");
		
		//����
		this.add(jbt_kor);
		this.add(jbt_eng);
		this.add(jbt_chn);
		this.add(jbt_jpn);
		this.add(jbt_ger);
		
		//��ư �̺�Ʈ ���
		
		// ���� �̺�Ʈ ��
		// �̺�Ʈ�ҽ�.add������(�����ʰ� �غ�� ó����ü)
		ActionListener listener = new ButtonEventObject(this);
		jbt_kor.addActionListener(listener);
		
		//���� ��ư 
		jbt_eng.addActionListener(new EngButtonEventObject());
		
		
		//���ó��� Ŭ����
		class ChnButtonEventObject implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyMain_ButtonEvent.this.setTitle("���Ͽ�");
			}
		}
		
		//�߱��� ��ư
		jbt_chn.addActionListener(new ChnButtonEventObject());
		
		//�Ϻ��� ��ư
		//�͸�(Anoymous)����Ŭ����
		ActionListener jpn_listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setTitle("���۳�������");				
			}
		};
		
		jbt_jpn.addActionListener(jpn_listener);
		
		//���Ͼ� ��ư
		jbt_ger.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setTitle("�ҷ�");
			}
		});
		
		
		
		
		//��ġ
		setLocation(200, 100);

		//ũ��
		setSize(300, 300);

		//�������
		setVisible(true);

		//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_ButtonEvent();
	}
}
