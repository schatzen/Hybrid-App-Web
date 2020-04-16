package mymain.udp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyMain_UDPChat_Broadcast extends JFrame {

	JTextArea  jta_display;//���â
	JTextField jtf_address;//�ּ�â
	JTextField jtf_message;//�޽���â
	
	Font font = new Font("����ü", Font.BOLD, 16);
	
	String nick_name = "ȫ�浿";
	
	//��ſ� ����
	DatagramSocket client;
	
	
	public MyMain_UDPChat_Broadcast() {
		// TODO Auto-generated constructor stub
		super("Broadcastä��");
		
		//���â �ʱ�ȭ
		init_display();
		
		//�Է�â �ʱ�ȭ
		init_input();
		
		//Ű���� �̺�Ʈ �ʱ�ȭ
		init_key_event();
		
		//���� �ʱ�ȭ
		init_socket();

		//��ġ
		setLocation(200, 100);

		//ũ��
		//setSize(300, 300);
		pack();
		

		//�������
		setVisible(true);

		//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_socket() {
		// TODO Auto-generated method stub
		
		try {
			//�����Ʈ �Ҵ�޴´�
			client = new DatagramSocket(5000);
			
			//������ ����
			read_message();
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void read_message() {
		// TODO Auto-generated method stub
		//���ſ� ������ ����
		new Thread() {
			public void run() {
				
				while(true) {
					
					try {
						//�޽��� ���Ŵ��
						byte [] read_buff = new byte[512];
						DatagramPacket dp = new DatagramPacket(
								                        read_buff,
								                        read_buff.length);
						
						//���->���Ź����о����		                  
						client.receive(dp);
						
						//���ŵ� ������ �б�
						byte []  read_data = dp.getData();
						// read_message="ȫ�浿#�ȳ�"
						String read_message = new String(read_data).trim();
						
						String [] msg_array = read_message.split("#");
						//                          0       1  
						//String [] msg_array = {"ȫ�浿","�ȳ�"};
						
						
						String display_message = 
								String.format("[%s]�� ����:\r\n  %s\r\n",
										        msg_array[0],msg_array[1]);
						jta_display.append(display_message);
						
						int position = jta_display.getDocument().getLength();
						jta_display.setCaretPosition(position);
						
						//�޽��� �����..
						//������ �ּ�
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
		
		//�Է��� �޽����� ��������=>��������
		String message = jtf_message.getText().trim();
		if(message.isEmpty()) {//���������
			
			//�Է�â �����
			jtf_message.setText("");
			return;
		}
		
		try {
			//�ۼ��� �޽��� ��Ʈ��ũ ����
			//send_data="��ȭ��#����"
			//          "ȫ�浿#�ȳ�?" 
			String send_data = String.format("%s#%s", nick_name,message);
			//�ּҰ� ������
			//"255.255.255.255" <= Global broadcast�ּ�
			String ip = jtf_address.getText();
			InetAddress ia = InetAddress.getByName(ip);
			
			//���۵����� ����
			//String-> byte [] ����
			byte [] send_buff = send_data.getBytes();
			DatagramPacket dp = 
					new DatagramPacket(send_buff,  
							           send_buff.length,//Data 
							           ia, 5000  //�������ּ�
							           );
			//����
			client.send(dp);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		//�Է�â �����
		jtf_message.setText("");
	}

	private void init_input() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(2, 1));
		
		jtf_address = new JTextField("255.255.255.255");
		jtf_message = new JTextField();
		
		jtf_address.setFont(font);
		jtf_message.setFont(font);
				
		
		p.add(jtf_address);
		p.add(jtf_message);
		
		this.add(p,BorderLayout.SOUTH);
		
		
	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		//Scroll��ų ������Ʈ ����
		JScrollPane jsp = new JScrollPane(jta_display);
		//���âũ�� ����
		jsp.setPreferredSize(new Dimension(300, 400));
		
		this.add(jsp,BorderLayout.CENTER);
		
		//���â �б�����
		jta_display.setEditable(false);
		
		jta_display.setFont(font);
		
		jta_display.append("���⿡ ä�ó��� ���\r\n");
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_UDPChat_Broadcast();
	}
}
