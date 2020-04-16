package mymain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMaib_TestGraphics extends JFrame {

	static Image back_image;
	static {
		back_image = new ImageIcon("image3.jpg").getImage();
	}
	JPanel grimPan; // ��ȭ������

	Font font = new Font("���ﳲ�� ��üEB", Font.BOLD, 20);

	public MyMaib_TestGraphics() {
		super("�׸�����");

		// �׸��� ����
		grimPan = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub

				// ����̹��� �׸���
				g.drawImage(back_image, 0, 0, this);

				// font����
				g.setFont(font);

				// �׸���
				g.setColor(Color.gray);
				g.drawString("�׸��� ����", 120 + 1, 30 + 1);

				// ��������
				g.setColor(Color.black);
				g.drawString("�׸��� ����", 120, 30);

				// �簢�� x y width height
				Color color_rect = new Color(157, 171, 183);
				g.setColor(color_rect);
				g.drawRect(10, 50, 100, 100);

				// ä����
				g.fillRect(120, 50, 100, 100);

				// Ÿ��
				Color color_oval = new Color(85, 121, 151);
				g.setColor(color_oval);

				g.drawOval(10, 160, 100, 100);

				// ä����
				g.fillOval(120, 160, 100, 100);

				// ��
				Color color_line = new Color(85, 121, 151);
				g.setColor(color_line);
				g.drawLine(10, 270, 260, 270);

				// gradation (������ ����)

				for (int i = 0; i < 256; i++) {
					// Į������
					Color color = new Color(i, 0, i);
					g.setColor(color);
					g.drawLine(10, 280 + i, 260, 280 + i);
				}

			}

		};

		// ���� ä���
		// grimPan.setBackground(Color.orange);

		this.add(grimPan);

		// ��ġ
		setLocation(700, 200);

		// ũ��
		setSize(400, 600);

		// �������
		setVisible(true);

		// ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �׸��� ���� ��� : ȭ�� ������ ������ �������� �ٸ� ����� �� ����
		// Graphics g = grimPan.getGraphics();
		// g.drawString("�׸��⿬��", 100, 20);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MyMaib_TestGraphics();
	}

}
