package mymain;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_BorderLayoutTest extends JFrame {

	/*
	   BorderLayout : JFrame,JDialog
	   FlowLayout   : JPanel 
	 */
	
	
	public MyMain_BorderLayoutTest() {
		// TODO Auto-generated constructor stub
		super("BorderLayout����");
		//Border�������� ��Ʈ�� ��ġ
		
		JButton jbt_east = new JButton("East");
		JButton jbt_west = new JButton("West");
		
		JButton jbt_south = new JButton("South");
		JButton jbt_north = new JButton("North");
		
		JButton jbt_center = new JButton("Center");
		
		
		//����
		//       Component(��Ʈ��),    ��ġ 
		this.add(jbt_east,         BorderLayout.EAST);
		this.add(jbt_west,         "West");
		
		//            ��ġ            ������Ʈ
		this.add(BorderLayout.SOUTH, jbt_south);
		this.add(     "North",       jbt_north);
		
		this.add(jbt_center,BorderLayout.CENTER);//��ġ���� �����ϸ� Center
		

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
		new MyMain_BorderLayoutTest();
	}
}
