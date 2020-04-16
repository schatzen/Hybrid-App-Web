package mymain.tcp.multi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiClient extends JFrame {

	JTextArea     jta_display;
	JTextField    jtf_message;
	JList<String> jlist_user_list;
	
	JButton       jbt_connect;
	boolean       bConnect = false;//현재 연결상태
	
	Font font = new Font("굴림체", Font.BOLD , 18);
	
	String nick_name="고길동";
	
	
	//그리기 기능에 필요한 변수
	JPanel grimPan;
	Image  memPan;//메모리상의 그림판
	
	int thick=5;//선굵기
	int color=0;//Black;
	
	public MultiClient() {
		// TODO Auto-generated constructor stub
		super("MultiChatClient");

		//출력창 초기화
		init_display();
		
		//입력창 초기화
		init_input();
		
		//그림판 초기화
		init_grimpan();
				
		
		//마우스 이벤트
		init_mouse_event();
		
		//접속자 목록
		init_user_list();
		
		//키보드 이벤트 초기화
		init_key_event();		
		
		//위치
		setLocation(200, 100);

		setResizable(false);
		//크기
		//setSize(300, 300);
		pack();

		//보여줘라
		setVisible(true);

		//종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//화면과 호환성있는 메모리상의 윈도우 생성
		memPan = grimPan.createImage(300, 400);
		//그리기 도구 얻는다
		Graphics g = memPan.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, 300, 400);
		
		grimPan.repaint();//paintComonent Call
		
		
		
	}
	
	
	private void init_mouse_event() {
		// TODO Auto-generated method stub
		MouseAdapter adapter  = new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if(bConnect==false)return;
				
				
				Point pt = e.getPoint();
				
				//전송데이터 포장
				String send_data = 
						String.format("DRAW#%d#%d#%d#%d\n", 
								         pt.x,pt.y,thick,color
								);
				
				try {
					
					client.getOutputStream().write(send_data.getBytes());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
			
		};
		
		//grimPan.addMouseListener(adapter);//클릭시
		grimPan.addMouseMotionListener(adapter);//움직일때
	}


	private void init_grimpan() {
		// TODO Auto-generated method stub
		grimPan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub

				//메모리상의 그림판 내용 복사해온다
				g.drawImage(memPan, 0, 0, this);
				
			}
		};
		
		grimPan.setPreferredSize(new Dimension(300,400));
		
		this.add(grimPan,BorderLayout.WEST);
	}

	private void init_key_event() {
		// TODO Auto-generated method stub
		KeyAdapter adapter = new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					send_message();
				}
			}
		};
		jtf_message.addKeyListener(adapter);
	}
	

	protected void send_message() {
		// TODO Auto-generated method stub
		//연결되어있지 않으면 끝내라..
		if(bConnect==false)return;
		
		String message = jtf_message.getText().trim();
		if(message.isEmpty()) {//값이 비어있으면 끝내라..
			jtf_message.setText("");
			return;
		}
		
		//전송데이터 포장: "MSG#대화명#내용"
		String send_data = String.format("MSG#%s#%s\n", 
				                           nick_name,
				                           message);
		//전송
		try {
			
			client.getOutputStream().write(send_data.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        //이전 입력값 지우기
		jtf_message.setText("");
			
		
	}

	private void init_input() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		
		//메시지 입력창
		jtf_message = new JTextField();
		//연결버튼
		jbt_connect = new JButton("연결");
		jbt_connect.setPreferredSize(new Dimension(120, 0));
		
		p.add(jtf_message,BorderLayout.CENTER);
		p.add(jbt_connect,BorderLayout.EAST);
		
		this.add(p,BorderLayout.SOUTH);
		
		//font적용
		jtf_message.setFont(font);
		jbt_connect.setFont(font);
		
		//버튼이벤트
		jbt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				on_connect();
			}
		});
		
		
		//그림판메뉴 추가
		JPanel p1 = new JPanel(new GridLayout(1, 3));
		p1.setPreferredSize(new Dimension(300, 0));
		
		//선굵기 선택(콤보박스)
		Integer []  thick_array= {5,10,15,20,25,30,35,40};
		JComboBox<Integer> jcb_thick = 
				      new JComboBox<Integer>(thick_array);
		p1.add(jcb_thick);
		
		//선색상/지우기 버튼
		JButton jbt_color = new JButton("선색상");
		JButton jbt_clear = new JButton("지우기");
		
		p1.add(jbt_color);
		p1.add(jbt_clear);
				
				
		p.add(p1,BorderLayout.WEST);
		
		
		
		//선굵기 선택시 이벤트
		jcb_thick.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
                //System.out.println(e);
				if(e.getStateChange()==ItemEvent.SELECTED) {
					thick = (int)jcb_thick.getSelectedItem();
					//System.out.println(thick);
				}
			}
		});
		
		//선색상 선택시 이벤트
		jbt_color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			    Color im_color = new Color(color);
			    
				Color res_color = JColorChooser.showDialog(
						                 MultiClient.this, 
						                 "선색상을 선택하세요",
						                 im_color);
				//확인버튼을 누르지 않았으면 끝..
				if(res_color==null) return;
						
				color = res_color.getRGB();
				
			}
		});
		
		
		//지우기 이벤트
		jbt_clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Graphics g = memPan.getGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, 300, 400);
				
				grimPan.repaint();
			}
		});
		
		
		
		
	}

	Socket client;
	
	protected void on_connect() {
		// TODO Auto-generated method stub
		//Toggle처리
		bConnect = !bConnect;
		
		if(bConnect) { //연결작업
			
			try {
				//연결
				client = new Socket("192.168.0.77", 8000);
				
				//IN#홍길동IN#박길동\n
				//입장정보 서버로 전송
				String send_data = String.format("IN#%s\n", nick_name);
				client.getOutputStream().write(send_data.getBytes());
				
				//데이터 수신
				read_message();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else { //끊기작업
			
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		//버튼 캡션변경
		jbt_connect.setText(bConnect ? "끊기" : "연결");
		
		
	}

	BufferedReader br = null;
	private void read_message() {
		// TODO Auto-generated method stub
		try {
			InputStreamReader isr = 
					new InputStreamReader(client.getInputStream());
			br = new BufferedReader(isr);
			
			
			//메시지 수신용 쓰레드
			new Thread() {
				
				public void run() {
					
					while(true) {
					
						try {
							String readStr = br.readLine();
							if(readStr==null)break;//정상종료
							
							String [] msgs = readStr.split("#");
							
							
							if(msgs[0].equals("IN")) {//입장
								//String [] msgs  = {"IN","길동1"};
								String display_data = 
										 String.format("→[%s]님 입장", msgs[1]);
								display_message(display_data);
								
							}else if(msgs[0].equals("OUT")) {//퇴장
								String display_data = 
										 String.format("←[%s]님 퇴장", msgs[1]);
								display_message(display_data);
								
							}else if(msgs[0].equals("LIST")) {//접속자목록수신
								//readStr="LIST#길동1#길동2#길동3#"
								display_user_list(readStr);
								
								
							}else if(msgs[0].equals("MSG")) {//채팅
								String display_data = 
										String.format("[%s]님 말씀:\r\n  %s", 
												      msgs[1],       msgs[2]);
								display_message(display_data);
								
								
							}else if(msgs[0].equals("DRAW")) {//그리기
								//  readStr="DRAW#10#30#5#0"
								//                    x    y  thick  color
								//[] msgs = {"DRAW","10","30","5",   "0"};
								try {
									int x 		= Integer.parseInt(msgs[1]);
									int y 		= Integer.parseInt(msgs[2]);
									int thick 	= Integer.parseInt(msgs[3]);
									int color 	= Integer.parseInt(msgs[4]);
									
									Color thick_color = new Color(color);
									Graphics g = memPan.getGraphics();
									g.setColor(thick_color);
									
									g.fillOval(x-thick/2, y-thick/2, thick, thick);
									
									grimPan.repaint();
									
								} catch (Exception e) {
									// TODO: handle exception
								}
								
								
							}
							
							
							
							
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							break;//서버 비정상종료
						}
					}//end-while
					
					//소켓 Close
					String []  empty_array = new String[0];
					jlist_user_list.setListData(empty_array);
					
					bConnect=false;
					jbt_connect.setText("연결");
					
					
				}
				
			}.start();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	protected void display_message(String message) {
		// TODO Auto-generated method stub
		jta_display.append(message +"\r\n");
		
		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);
		
		
	}

	protected void display_user_list(String readStr) {
		// TODO Auto-generated method stub
		//readStr="LIST#길동1#길동2#길동3#"
		readStr = readStr.replaceAll("LIST#", "");
		//readStr="길동1#길동2#길동3#"
		String [] user_array = readStr.split("#");
		jlist_user_list.setListData(user_array);
		
		
		
	}

	private void init_user_list() {
		// TODO Auto-generated method stub
		jlist_user_list = new JList<String>();
		JScrollPane jsp =new JScrollPane(jlist_user_list);
		jsp.setPreferredSize(new Dimension(120, 0));
		
		this.add(jsp,BorderLayout.EAST);
	}
	
	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);
		jsp.setPreferredSize(new Dimension(300, 400));
		
		this.add(jsp,BorderLayout.CENTER);
		
		//읽기전용
		jta_display.setEditable(false);
		
		//폰트적용
		jta_display.setFont(font);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiClient();
	}
}
