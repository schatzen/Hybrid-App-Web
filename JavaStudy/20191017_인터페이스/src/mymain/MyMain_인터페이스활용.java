package mymain;

import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class MyMain_�������̽�Ȱ�� extends JFrame {

	public MyMain_�������̽�Ȱ��() {
		// TODO Auto-generated constructor stub
		super("�������̽� Ȱ�뿹��");

		
		//������ �̺�Ʈ ���
		WindowListener listener 
		               = new MyWindowEventListener();
		
		//�����̺�Ʈ��(Delegation Event Model)
		
		//this:�̺�Ʈ�ҽ�(���)
		//addWindowListener(����): Event����ϴ� �޼ҵ�
		//����:ó����ü
		this.addWindowListener(listener);
		
		
				
		
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
		new MyMain_�������̽�Ȱ��();
	}
}
