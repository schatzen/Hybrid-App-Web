package mymain;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_FlowLayoutTest extends JFrame {

	public MyMain_FlowLayoutTest() {
		// TODO Auto-generated constructor stub
		super("FlowLayout연습");
		
		FlowLayout fl = new FlowLayout(
				            FlowLayout.LEFT,//정렬
				            20,10  ///수평/수직간격
				            );
		
		//BorderLayout->FlowLayout변경
		this.setLayout(fl);
		
		for(int i=0;i<10;i++) {
			
			JButton jbt = new JButton("버튼"+i);
			this.add(jbt);
			
		}
		
		
		
		
		

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
		new MyMain_FlowLayoutTest();
	}
}
