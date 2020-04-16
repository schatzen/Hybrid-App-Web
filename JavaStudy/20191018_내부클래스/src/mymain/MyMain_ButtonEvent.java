package mymain;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_ButtonEvent extends JFrame {

	
	//영어인사말 이벤트 처리객체
	//cf) POJO(Plain Old Java Object):순수자바객체
	class EngButtonEventObject implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setTitle("Hi Everyone!!");
		}
	}
	
	
	
	public MyMain_ButtonEvent() {
		// TODO Auto-generated constructor stub
		super("버튼이벤트연습");
 
		//배치관리자 : 적재방법 설정
		GridLayout gl = new GridLayout(5, 1);
		//배치방법을 설정
		this.setLayout(gl);
				
		JButton jbt_kor = new JButton("한국어 인사말");
		JButton jbt_eng = new JButton("영어 인사말");
		JButton jbt_chn = new JButton("중국어 인사말");
		JButton jbt_jpn = new JButton("일본어 인사말");
		JButton jbt_ger = new JButton("독일어 인사말");
		
		//적재
		this.add(jbt_kor);
		this.add(jbt_eng);
		this.add(jbt_chn);
		this.add(jbt_jpn);
		this.add(jbt_ger);
		
		//버튼 이벤트 등록
		
		// 위임 이벤트 모델
		// 이벤트소스.add리스너(리스너가 준비된 처리객체)
		ActionListener listener = new ButtonEventObject(this);
		jbt_kor.addActionListener(listener);
		
		//영어 버튼 
		jbt_eng.addActionListener(new EngButtonEventObject());
		
		
		//로컬내부 클래스
		class ChnButtonEventObject implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyMain_ButtonEvent.this.setTitle("니하오");
			}
		}
		
		//중국어 버튼
		jbt_chn.addActionListener(new ChnButtonEventObject());
		
		//일본어 버튼
		//익명(Anoymous)내부클래스
		ActionListener jpn_listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setTitle("오겡끼데스까");				
			}
		};
		
		jbt_jpn.addActionListener(jpn_listener);
		
		//독일어 버튼
		jbt_ger.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setTitle("할로");
			}
		});
		
		
		
		
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
		new MyMain_ButtonEvent();
	}
}
