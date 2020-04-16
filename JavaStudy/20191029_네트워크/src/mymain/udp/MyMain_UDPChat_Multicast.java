package mymain.udp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyMain_UDPChat_Multicast extends JFrame {

	JTextArea  jta_display;//출력창
	JTextField jtf_address;//주소창
	JTextField jtf_message;//메시지창
	
	//가입된 그룹목록
	JList<String> jlist_group; 
	
	//가입항목(주소)을 저장관리할 객체
	List<String> group_list = new ArrayList<String>();
	
	
	
	Font font = new Font("굴림체", Font.BOLD, 16);
	
	String nick_name = "홍길동";
	
	//통신용 소켓
	MulticastSocket client;
	
	
	public MyMain_UDPChat_Multicast() {
		// TODO Auto-generated constructor stub
		super("Multicast채팅");
		
		//출력창 초기화
		init_display();
		
		//입력창 초기화
		init_input();
		
		//그룹목록창 초기화
		init_group_list();
		
		
		//키보드 이벤트 초기화
		init_key_event();
		
		//소켓 초기화
		init_socket();

		//위치
		setLocation(200, 100);

		//크기
		//setSize(300, 300);
		pack();
		

		//보여줘라
		setVisible(true);

		//종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_group_list() {
		// TODO Auto-generated method stub
		jlist_group = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist_group);
		jsp.setPreferredSize(new Dimension(120, 0));
		
		this.add(jsp,BorderLayout.EAST);
		
		jlist_group.setFont(font);
		
		
		//Sample Data 넣어봄...
		//String [] join_array = {"224.0.0.1","224.0.0.2","224.0.0.3"};
		//jlist_group.setListData(join_array);
		
		
		
	}

	private void init_socket() {
		// TODO Auto-generated method stub
		
		try {
			//통신포트 할당받는다
			client = new MulticastSocket(6000);
			
			//데이터 수신
			read_message();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void read_message() {
		// TODO Auto-generated method stub
		//수신용 쓰레드 생성
		new Thread() {
			public void run() {
				
				while(true) {
					
					try {
						//메시지 수신대기
						byte [] read_buff = new byte[512];
						DatagramPacket dp = new DatagramPacket(
								                        read_buff,
								                        read_buff.length);
						
						//대기->수신버퍼읽어오기		                  
						client.receive(dp);
						
						//수신된 데이터 읽기
						byte []  read_data = dp.getData();
						// read_message="홍길동#안녕"
						String read_message = new String(read_data).trim();
						
						String [] msg_array = read_message.split("#");
						//                          0       1  
						//String [] msg_array = {"홍길동","안녕"};
						
						
						String display_message = 
								String.format("[%s]님 말씀:\r\n  %s\r\n",
										        msg_array[0],msg_array[1]);
						jta_display.append(display_message);
						
						int position = jta_display.getDocument().getLength();
						jta_display.setCaretPosition(position);
						
						//메시지 모니터..
						//전송자 주소
						InetAddress ia = dp.getAddress();
						System.out.printf("[%s]: %s\n",ia.getHostAddress(),read_message);
						
						
						
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
				//System.out.println(e);
				int key = e.getKeyCode();
				
				if(key==KeyEvent.VK_ENTER) {
					send_message();
				}
			}
		};
		
		jtf_message.addKeyListener(adapter);
		
	}

	protected void send_message() {
		// TODO Auto-generated method stub
		
		//입력한 메시지를 가져오기=>공백제거
		String message = jtf_message.getText().trim();
		if(message.isEmpty()) {//비어있으면
			
			//입력창 지우기
			jtf_message.setText("");
			return;
		}
		
		try {
			//작성된 메시지 네트워크 전송
			//send_data="대화명#내용"
			//          "홍길동#안녕?" 
			String send_data = String.format("%s#%s", nick_name,message);
			//주소값 얻어오기
			//"255.255.255.255" <= Global broadcast주소
			String ip = jtf_address.getText();
			InetAddress ia = InetAddress.getByName(ip);
			
			//전송데이터 포장
			//String-> byte [] 추출
			byte [] send_buff = send_data.getBytes();
			DatagramPacket dp = 
					new DatagramPacket(send_buff,  
							           send_buff.length,//Data 
							           ia, 6000  //목적지주소
							           );
			//전송
			client.send(dp);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		//입력창 지우기
		jtf_message.setText("");
	}

	private void init_input() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(3, 1));
		
		jtf_address = new JTextField("224.0.0.2");
		jtf_message = new JTextField();
		
		jtf_address.setFont(font);
		jtf_message.setFont(font);
				
		
		p.add(jtf_address);
		
		//가입/탈퇴버튼
		JPanel p1 = new JPanel(new GridLayout(1, 2));
		JButton jbt_join = new JButton("가입");
		JButton jbt_leave= new JButton("탈퇴");
		
		p1.add(jbt_join);
		p1.add(jbt_leave);
		p.add(p1);
		
		p.add(jtf_message);
		
		this.add(p,BorderLayout.SOUTH);
		
		
		//가입/탈퇴 버튼 클릭이벤트
		jbt_join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				group_join();
			}
		});
		
		jbt_leave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				group_leave();
			}
		});
		
		
	}

	protected void group_leave() {
		// TODO Auto-generated method stub
		String ip = jlist_group.getSelectedValue();
		if(ip==null) {
			JOptionPane.showMessageDialog(this, "삭제할 그룹주소를 선택하세요");
			return;
		}
		
		//System.out.println(ip);
		//삭제확인 여부 확인
		int result = JOptionPane.showConfirmDialog(
				        this,  //부모윈도우 
				        "정말 탈퇴하시겠습니까?", 
				        "그룹탈퇴", 
				        JOptionPane.YES_NO_OPTION);
		
		//System.out.println(result);
		//"예"가 아니면 끝내라..
		if(result != JOptionPane.YES_OPTION) return;
		
		
		//탈퇴작업
		try {
			
			InetAddress ia = InetAddress.getByName(ip);
			client.leaveGroup(ia);
			
			//ArrayList항목을 제거
			group_list.remove(ip);
			
			//오른쪽(East)창에 가입목록 출력
			//ArrayList->Array추출
			String [] group_array = new String[group_list.size()];
			group_list.toArray(group_array);
			
			jlist_group.setListData(group_array);
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	protected void group_join() {
		// TODO Auto-generated method stub
		String ip = jtf_address.getText().trim();
		if(ip.isEmpty()) {//주소가 비어있으면
		
			JOptionPane.showMessageDialog(this, "가입/탈퇴할 주소를 입력하세요");
			jtf_address.setText("224.0.0.1");
			return;
		}
		
		//가입여부 확인
		if(group_list.contains(ip)) {
			JOptionPane.showMessageDialog(this, "이미 가입된 주소입니다");
			return;
		}
		
		try {
			//가입시킴
			InetAddress ia = InetAddress.getByName(ip);
			client.joinGroup(ia);
			
			//가입주소 추가
			group_list.add(ip);
			
			//오른쪽(East)창에 가입목록 출력
			//ArrayList->Array추출
			String [] group_array = new String[group_list.size()];
			group_list.toArray(group_array);
			
			jlist_group.setListData(group_array);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		//Scroll시킬 컴포넌트 생성
		JScrollPane jsp = new JScrollPane(jta_display);
		//출력창크기 지정
		jsp.setPreferredSize(new Dimension(300, 400));
		
		this.add(jsp,BorderLayout.CENTER);
		
		//출력창 읽기전용
		jta_display.setEditable(false);
		
		jta_display.setFont(font);
		
		jta_display.append("여기에 채팅내용 출력\r\n");
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_UDPChat_Multicast();
	}
}
