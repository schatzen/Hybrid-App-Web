package mymain.tcp.multi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Practive_server1 extends JFrame {

	JTextArea jta;
	JTextField jtf_user_count;
	JList<String> jlist;

	public Practive_server1() {
		super("DEEP BREATHE");

		init_display();
		init_user_list();
		init_user_count();
		// init_server();

		// 위치
		setLocation(200, 100);

		// 크기
		//setSize(300, 300);
		pack();

		// 보여줘라
		setVisible(true);

		// 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_user_count() {
		// TODO Auto-generated method stub

		JPanel p = new JPanel(new GridLayout(1, 3));
		JLabel jlb1 = new JLabel("접속자 수 : ", JLabel.RIGHT);
		jtf_user_count = new JTextField("0");
		JLabel jlb2 = new JLabel("(명)");

		p.add(jlb1);
		p.add(jtf_user_count);
		p.add(jlb2);
		
		this.add(p,BorderLayout.SOUTH);

		jtf_user_count.setHorizontalAlignment(JTextField.CENTER);

	}

	private void init_user_list() {
		// TODO Auto-generated method stub
		jlist = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist);
		jsp.setPreferredSize(new Dimension(120,0));
		
		this.add(jsp,BorderLayout.EAST);
		

	}

	private void init_display() {
		// TODO Auto-generated method stub
		
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setPreferredSize(new Dimension(300,400));
		
		this.add(jsp,BorderLayout.CENTER);
		
		
		jta.setEditable(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Practive_server1();
	}

}
