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
	JPanel grimPan; // 도화지역할

	Font font = new Font("서울남산 장체EB", Font.BOLD, 20);

	public MyMaib_TestGraphics() {
		super("그림연습");

		// 그림판 생성
		grimPan = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub

				// 배경이미지 그리기
				g.drawImage(back_image, 0, 0, this);

				// font설정
				g.setFont(font);

				// 그림자
				g.setColor(Color.gray);
				g.drawString("그리기 연습", 120 + 1, 30 + 1);

				// 원본글자
				g.setColor(Color.black);
				g.drawString("그리기 연습", 120, 30);

				// 사각형 x y width height
				Color color_rect = new Color(157, 171, 183);
				g.setColor(color_rect);
				g.drawRect(10, 50, 100, 100);

				// 채워서
				g.fillRect(120, 50, 100, 100);

				// 타원
				Color color_oval = new Color(85, 121, 151);
				g.setColor(color_oval);

				g.drawOval(10, 160, 100, 100);

				// 채워서
				g.fillOval(120, 160, 100, 100);

				// 선
				Color color_line = new Color(85, 121, 151);
				g.setColor(color_line);
				g.drawLine(10, 270, 260, 270);

				// gradation (점진적 색상)

				for (int i = 0; i < 256; i++) {
					// 칼라지정
					Color color = new Color(i, 0, i);
					g.setColor(color);
					g.drawLine(10, 280 + i, 260, 280 + i);
				}

			}

		};

		// 배경색 채우기
		// grimPan.setBackground(Color.orange);

		this.add(grimPan);

		// 위치
		setLocation(700, 200);

		// 크기
		setSize(400, 600);

		// 보여줘라
		setVisible(true);

		// 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 그리기 도구 얻기 : 화면 밖으로 나가면 지워져서 다른 방법을 쓸 것임
		// Graphics g = grimPan.getGraphics();
		// g.drawString("그리기연습", 100, 20);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MyMaib_TestGraphics();
	}

}
