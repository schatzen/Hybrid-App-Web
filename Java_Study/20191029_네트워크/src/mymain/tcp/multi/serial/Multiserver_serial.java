package mymain.tcp.multi.serial;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Multiserver_serial extends JFrame {

	JTextArea jta_display;
	JTextField jtf_user_count;
	JList<String> jlist_user_list;

	// 네트워크 관련 변수
	ServerSocket server;

	List<ReadThread> socketList = new ArrayList<ReadThread>();

	// 접속자명을 관리할저장객체
	List<String> userList = new ArrayList<String>();

	Font font = new Font("고딕체", Font.BOLD, 18);

	// 동기화객체
	Object syncObj = new Object(); // 입장처리 끝내고 퇴장처리 할 수 있도록. 반대상황도 마찬가지

	public Multiserver_serial() {
		super("멀티채팅서버");

		// 모니터링 창
		init_display();

		// 접속자수 출력창
		init_user_count();

		// 접속자 목록 출력창
		init_user_list();

		// 서버초기화
		init_server();

		// 위치
		setLocation(200, 100);

		// 크기
		// setSize(300, 300);
		pack();

		// 보여줘라
		setVisible(true);

		// 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// ---자소켓의 메시지 수신용 스레드---
	class ReadThread extends Thread {
		Socket child; // 지소켓

		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;

		public ReadThread(Socket child) {
			this.child = child;

			try {

				ois = new ObjectInputStream(child.getInputStream());
				oos = new ObjectOutputStream(child.getOutputStream());

				// BufferedReader br = new BufferedReader( new
				// InputStreamReader(child.getInputStream));와 같음

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					Data data = (Data) ois.readObject();
					if (data == null)
						// 정상종료
						break;

					// 수신데이터 모니터
					String display_msg = String.format("[%s] : [%d][%s][%s]", data.protocol, data.nick_name,
							data.message);
					display_message(display_msg);

					//
					// 입장 > "IN#고길동"
					// msgs = {"IN","고길동"};
					if (data.protocol == Data.IN) { // 입장하면

						synchronized (syncObj) {
							// 접속자명을 추가
							userList.add(data.nick_name);

							// 접속자 목록을 오른쪽 창에 출력
							display_user_list();

							// 현재 접속자 목록 모든 접속자에게 전송
							send_user_list();

							// 모든 사용자에게 입장메시지 전달
							send_message_all(data);
						}

					} else if (data.protocol == Data.MSG) { // 채팅이면
						synchronized (syncObj) {

							// 욕설 filtering
							String[] bad_str = { "개놈", "바보", "식빵" };

							for (String bad : bad_str) {
								data.message = data.message.replaceAll(bad, "***");
							}
							send_message_all(data);
						}

					} else if (data.protocol == Data.DRAW) { // 그림판 데이터면
						synchronized (syncObj) {
							send_message_all(data);
						}

					}

				} catch (Exception e) { // 상대방쪽에서 비정상으로 종료했을 때 (ex.와이파이x, 종료버튼이 아닌 닫기 버튼 눌렀을 때)
					// null로 전달 안되고 exception으로 뜸 그래서 break;!
					// TODO Auto-generated catch block
					// e.printStackTrace();
					break;
				} // 1줄씩 수신

			} // end-while

			// 퇴장상황
			synchronized (syncObj) {

				// 현재 객체가 ArrayList에서 첨자
				int del_Index = socketList.indexOf(this);
				String del_nick_name = userList.get(del_Index);

				// 접속자명도 삭제
				userList.remove(del_Index);

				// 현재 구동중인 스레드 제거
				socketList.remove(this);

				// 퇴장내용 각 클라이언트에게 전송
				Data data = new Data();
				data.protocol = Data.OUT;
				data.nick_name = del_nick_name;
				send_message_all(data);

				// 현재 접속자 목록 모든 접속자에게 전송
				send_user_list();

				// 접속자명단 갱신
				display_user_list();

				// 사용자 갱신
				display_user_count();

			}

		}// end-run > Thread가 죽는 시점
	}

	private void init_server() {
		// TODO Auto-generated method stub
		try {
			server = new ServerSocket(8100);

			// 접속대기 및 연결처리하는 작업자(Thread) 생성
			new Thread() {
				public void run() {

					while (true) {
						try {

							// 접속대기 > 요청수락 > 자소켓생성 > 연결
							Socket child = server.accept();

							// 자소켓의 수신용 스레드생성
							ReadThread rt = new ReadThread(child);
							rt.start();

							// 소켓목록관리객체에게 넣는다
							socketList.add(rt);

							// 접속자수 출력
							display_user_count();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}.start();

			display_message("서버구동 중...");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void send_user_list() {
		Data data = new Data();
		data.protocol = Data.LIST;
		data.userList = userList;

		// 모든 사용자에게 전송
		send_message_all(data);

	}

	private void send_message_all(Data data) {
		// TODO Auto-generated method stub
		for (int i = 0; i < socketList.size(); i++) {
			try { // 한 사람이 안받아도 계속 메세지가 전송되야 되니까 ReadThread rt부터 블록잡아 예외처리한다.
				ReadThread rt = socketList.get(i);
				rt.oos.writeObject(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void display_user_list() {
		// TODO Auto-generated method stub
		String[] user_array = new String[userList.size()];
		// ArrayList > Array
		userList.toArray(user_array);

		jlist_user_list.setListData(user_array);

	}

	protected void display_user_count() {
		// TODO Auto-generated method stub
		jtf_user_count.setText(socketList.size() + "");

	}

	private void display_message(String message) {
		// TODO Auto-generated method stub
		jta_display.append(message + "\r\n");
		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);

	}

	private void init_user_list() {
		// TODO Auto-generated method stub
		jlist_user_list = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist_user_list);

		jsp.setPreferredSize(new Dimension(120, 0));

		this.add(jsp, BorderLayout.EAST);

	}

	private void init_user_count() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(1, 3));
		JLabel jlb1 = new JLabel("접속자수: ", JLabel.RIGHT);
		jtf_user_count = new JTextField("0");
		JLabel jlb2 = new JLabel("(명)");

		p.add(jlb1);
		p.add(jtf_user_count);
		p.add(jlb2);

		this.add(p, BorderLayout.SOUTH);

		// 폰트적용
		jlb1.setFont(font);
		jlb2.setFont(font);
		jtf_user_count.setFont(font);

		// 접속자수 중앙정렬
		jtf_user_count.setHorizontalAlignment(JTextField.RIGHT);

	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);
		jsp.setPreferredSize(new Dimension(300, 400));

		this.add(jsp, BorderLayout.CENTER);

		// 읽기 전용
		jta_display.setEditable(false);

		// 폰트적용
		jta_display.setFont(font);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Multiserver_serial();
	}

}
