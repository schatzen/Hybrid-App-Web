package mymain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMain_TestGraphics extends JFrame {

	static Image back_image;
	static {
		//�̹��� �ε�..
		back_image = new ImageIcon("back.jpg").getImage();
	}
	
	JPanel grimPan;//��ȭ������
	
	Font font = new Font("�޸տ�ü", Font.BOLD, 30);
	
	public MyMain_TestGraphics() {
		// TODO Auto-generated constructor stub
		super("�׸�����");

		//�׸��� ����
		grimPan = new JPanel() { 
			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				//����̹��� �׸���
				g.drawImage(back_image, 0, 0, this);
				
				
				//font����
				g.setFont(font);
                //�׸��� 				
				g.setColor(Color.black);
				g.drawString("�׸��⿬��", 100+2, 30+2);
				//��������
				g.setColor(Color.red);
				g.drawString("�׸��⿬��", 100, 30);
				
				//�簢��
				g.setColor(Color.blue);
				//�׵θ��� x   y  width height
				g.drawRect(10, 50, 100, 100);
				
				//ä����
				g.fillRect(120, 50, 100, 100);
				
				//Ÿ��
				g.setColor(Color.green);
				//�׵θ�
				g.drawOval(10, 160, 100, 100);
				//ä����
				g.fillOval(120, 160, 100, 100);
				
				//��
				g.setColor(Color.red);
				
				g.drawLine(10, 270, 260, 270);
				
				//gradation(����������)
				for(int i=0;i<256;i++) {// i = 0 ~255
					//Į������
					Color color = new Color(i,0,0);
					g.setColor(color);
					g.drawLine(10, 280+i, 260, 280+i);
				}
				
				
			}
			
		};
		//grimPan.setBackground(Color.green);
		this.add(grimPan);
		
		
		
		//��ġ
		setLocation(200, 100);

		//ũ��
		setSize(400, 600);

		//�������
		setVisible(true);

		//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�׸��� ���� ���
		//Graphics g = grimPan.getGraphics();
		//g.drawString("�׸��⿬��", 0, 20);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_TestGraphics();
	}
}
