package mymain;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_FlowLayoutTest extends JFrame {

	public MyMain_FlowLayoutTest() {
		// TODO Auto-generated constructor stub
		super("FlowLayout����");
		
		FlowLayout fl = new FlowLayout(
				            FlowLayout.LEFT,//����
				            20,10  ///����/��������
				            );
		
		//BorderLayout->FlowLayout����
		this.setLayout(fl);
		
		for(int i=0;i<10;i++) {
			
			JButton jbt = new JButton("��ư"+i);
			this.add(jbt);
			
		}
		
		
		
		
		

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
		new MyMain_FlowLayoutTest();
	}
}
