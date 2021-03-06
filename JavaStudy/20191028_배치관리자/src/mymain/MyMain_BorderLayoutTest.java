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
		super("BorderLayout연습");
		//Border기준으로 컨트롤 배치
		
		JButton jbt_east = new JButton("East");
		JButton jbt_west = new JButton("West");
		
		JButton jbt_south = new JButton("South");
		JButton jbt_north = new JButton("North");
		
		JButton jbt_center = new JButton("Center");
		
		
		//적재
		//       Component(컨트롤),    위치 
		this.add(jbt_east,         BorderLayout.EAST);
		this.add(jbt_west,         "West");
		
		//            위치            컴포넌트
		this.add(BorderLayout.SOUTH, jbt_south);
		this.add(     "North",       jbt_north);
		
		this.add(jbt_center,BorderLayout.CENTER);//위치정보 생략하면 Center
		

		//위치
		setLocation(200, 100);

		//크기
		setSize(300, 300);

		//보여줘라
		setVisible(true);

		//종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_BorderLayoutTest();
	}
}
