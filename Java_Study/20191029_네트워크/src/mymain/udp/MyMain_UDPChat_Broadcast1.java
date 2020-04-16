package mymain.udp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyMain_UDPChat_Broadcast1 extends JFrame {

	JTextArea jta_display; // 출력창
	JTextField jtf_address; // 주소창
	JTextField jtf_message; // 메세지창

	// 가입된 그룹목록
	JList<String> jlist_group;

	// 가입항목을 저장관리할 객체
	List<String> grouPlist = new ArrayList<String>();

	Font font = new Font("궁서체", Font.PLAIN, 15);

	String nick_name = "국밥충";

	// 통신용 소켓
	MulticastSocket client;

	public MyMain_UDPChat_Broadcast1() throws Exception {
		super("Multicast채팅");
		// 서로 순서 섞이면 안됨. 순서중요!

		// 출력창 초기화
		init_display();

		// 입력창 초기화
		init_input();

		// 키보드 이벤트 초기화
		init_key_event();

		// 소켓 초기화
		init_socket();

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

	private void init_socket() throws IOException {
		// TODO Auto-generated method stub

		try {
			// 통신포트 할당받는다
			client = new MulticastSocket(6000);

			// 데이터 수신
			read_message();

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void read_message() { // thread에게 할당
		new Thread() {
			public void run() {

				while (true) {

					try {
						// 메세지 수신대기
						byte[] read_buff = new byte[512];
						DatagramPacket dp = new DatagramPacket(read_buff, read_buff.length);

						// 대기 -> 수신버퍼부터 읽어오기
						client.receive(dp);

						// 수신된 데이터 읽기
						byte[] read_data = dp.getData();
						// read_message = "홍길동#안녕"
						String read_message = new String(read_data).trim(); // trim을 해야 나머지 공백이 없어짐 바이트 배열이 512라서 공백이 생길
																			// 수 밖에 없음

						String[] msg_array = read_message.split("#");
						// String [] msg_array = {"홍길동","안녕"};

						String display_message = String.format("[%s]님 말씀 : \r\n  %s\r\n", msg_array[0], msg_array[1]);

						jta_display.append(display_message);

						int position = jta_display.getDocument().getLength();
						jta_display.setCaretPosition(position);

						// 전송자 주소

						InetAddress ia = dp.getAddress();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	private void init_key_event() {
		// TODO Auto-generated method stub
		KeyAdapter adapter = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				// super.keyPressed(e);
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_ENTER) {
					send_message(); // 노란버튼인 생성자로 만들기
				}

			}

		};
		jtf_message.addKeyListener(adapter);

	}

	protected void send_message() {
		// TODO Auto-generated method stub

		// 입력한 메세지를 가져오기 + 공백제거
		String message = jtf_message.getText().trim();
		// 입력창이 비어있으면 입력창 지우고 + 끝내라 (안보내겠다는 의미)
		if (message.isEmpty()) {
			jtf_message.setText("");
			return;
		}

		// 작성된 메시지 네트워크 전송

		/*
		 * 네트워크를 위해 사실 이 부분은 필요없다. ㅋ // 출력창 출력 String display_message =
		 * String.format("[%s]님 말씀:\r\n  %s\r\n", nick_name, message);
		 * jta_display.append(display_message);
		 * 
		 * //스크롤 자동으로 내리기 위해 씀! (커서(캐럿)이용!) // 잔체 문서 길이 int position =
		 * jta_display.getDocument().getLength(); // 문서의 끝에 입력 Caret을 위치
		 * jta_display.setCaretPosition(position);
		 */

		try {
			// 작성된 메시지 네트워크 전송
			// send_data="대화명#냐용"
			String send_data = String.format("%s#%s", nick_name, message);

			// 주소 값 얻어오기
			String ip = jtf_address.getText();
			InetAddress ia = InetAddress.getByName(ip);

			// 전송데이터 포장
			// String > byte[] 추출
			byte[] send_buff = send_data.getBytes();
			DatagramPacket dp = new DatagramPacket(send_buff, send_buff.length, // data
					ia, 5000);// 목적지 주소

			// 전송
			client.send(dp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 입력창 지우기
		jtf_message.setText("");

	}

	private void init_input() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(2, 1));
		jtf_address = new JTextField("224.0.0.1"); // 글로벌 브로드캐스팅
		jtf_message = new JTextField();

		jtf_address.setFont(font);
		jtf_message.setFont(font);

		p.add(jtf_address);
		p.add(jtf_message);

		this.add(p, BorderLayout.SOUTH);

	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		// Scroll 시킬 컴포넌트 생성
		JScrollPane jsp = new JScrollPane(jta_display);
		// 출력창크기 지정
		jsp.setPreferredSize(new Dimension(300, 400));

		this.add(jsp, BorderLayout.CENTER);

		// 출력창을 읽기전용으로 바꿈
		jta_display.setEditable(false);

		jta_display.setFont(font);
		jta_display.append("여기에 채팅 내용을 출력하시오\r\n");

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		new MyMain_UDPChat_Broadcast1();
	}

}
