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
		//이미지 로드..
		back_image = new ImageIcon("back.jpg").getImage();
	}
	
	JPanel grimPan;//도화지역할
	
	Font font = new Font("휴먼옛체", Font.BOLD, 30);
	
	public MyMain_TestGraphics() {
		// TODO Auto-generated constructor stub
		super("그림연습");

		//그림판 생성
		grimPan = new JPanel() { 
			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				//배경이미지 그리기
				g.drawImage(back_image, 0, 0, this);
				
				
				//font설정
				g.setFont(font);
                //그림자 				
				g.setColor(Color.black);
				g.drawString("그리기연습", 100+2, 30+2);
				//원본글자
				g.setColor(Color.red);
				g.drawString("그리기연습", 100, 30);
				
				//사각형
				g.setColor(Color.blue);
				//테두리만 x   y  width height
				g.drawRect(10, 50, 100, 100);
				
				//채워서
				g.fillRect(120, 50, 100, 100);
				
				//타원
				g.setColor(Color.green);
				//테두리
				g.drawOval(10, 160, 100, 100);
				//채워서
				g.fillOval(120, 160, 100, 100);
				
				//선
				g.setColor(Color.red);
				
				g.drawLine(10, 270, 260, 270);
				
				//gradation(점진적색상)
				for(int i=0;i<256;i++) {// i = 0 ~255
					//칼라지정
					Color color = new Color(i,0,0);
					g.setColor(color);
					g.drawLine(10, 280+i, 260, 280+i);
				}
				
				
			}
			
		};
		//grimPan.setBackground(Color.green);
		this.add(grimPan);
		
		
		
		//위치
		setLocation(200, 100);

		//크기
		setSize(400, 600);

		//보여줘라
		setVisible(true);

		//종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//그리기 도구 얻기
		//Graphics g = grimPan.getGraphics();
		//g.drawString("그리기연습", 0, 20);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_TestGraphics();
	}
}
