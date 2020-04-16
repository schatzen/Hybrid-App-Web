package mymain;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyMain_애국가 extends JFrame {

	JTextArea jta_display;
	
	public MyMain_애국가() {
		// TODO Auto-generated constructor stub
		super("애국가");

		//배치방법 변경
		this.setLayout(new GridLayout(5, 1));
		
		jta_display = new JTextArea();
		jta_display.setEditable(false);//편집불가(읽기전용)
		
		jta_display.setText("여기에\r\n애국가를\r\n넣어주세요");
		
		
		JButton jbt_1 = new JButton("애국가 1절");
		JButton jbt_2 = new JButton("애국가 2절");
		JButton jbt_3 = new JButton("애국가 3절");
		JButton jbt_4 = new JButton("애국가 4절");
		
		this.add(jta_display);
		this.add(jbt_1);
		this.add(jbt_2);
		this.add(jbt_3);
		this.add(jbt_4);
		
		//애국가 1절
		jbt_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jta_display.setText("동해물과 백두산이\r\n마르고 닮도록..");
			}
		});
		
		//애국가 2절
		jbt_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jta_display.setText("남산위에 저소나무\r\n철갑을 두른듯...");
			}
		});
		
		
		
		
		//위치
		setLocation(200, 100);

		//크기
		setSize(300, 400);

		//보여줘라
		setVisible(true);

		//종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_애국가();
	}
}
