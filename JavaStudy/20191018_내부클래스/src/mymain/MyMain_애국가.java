package mymain;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyMain_�ֱ��� extends JFrame {

	JTextArea jta_display;
	
	public MyMain_�ֱ���() {
		// TODO Auto-generated constructor stub
		super("�ֱ���");

		//��ġ��� ����
		this.setLayout(new GridLayout(5, 1));
		
		jta_display = new JTextArea();
		jta_display.setEditable(false);//�����Ұ�(�б�����)
		
		jta_display.setText("���⿡\r\n�ֱ�����\r\n�־��ּ���");
		
		
		JButton jbt_1 = new JButton("�ֱ��� 1��");
		JButton jbt_2 = new JButton("�ֱ��� 2��");
		JButton jbt_3 = new JButton("�ֱ��� 3��");
		JButton jbt_4 = new JButton("�ֱ��� 4��");
		
		this.add(jta_display);
		this.add(jbt_1);
		this.add(jbt_2);
		this.add(jbt_3);
		this.add(jbt_4);
		
		//�ֱ��� 1��
		jbt_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jta_display.setText("���ع��� ��λ���\r\n������ �൵��..");
			}
		});
		
		//�ֱ��� 2��
		jbt_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jta_display.setText("�������� ���ҳ���\r\nö���� �θ���...");
			}
		});
		
		
		
		
		//��ġ
		setLocation(200, 100);

		//ũ��
		setSize(300, 400);

		//�������
		setVisible(true);

		//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_�ֱ���();
	}
}
