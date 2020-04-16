package mymain.tcp.multi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

public class MultiServer extends JFrame {

	JTextArea     jta_display;
	JTextField    jtf_user_count;
	JList<String> jlist_user_list;
			
	Font font = new Font("����ü", Font.BOLD , 18);
	
	//��Ʈ��ũ ���� ����
	ServerSocket server;
	
	List<ReadThread> socketList = new ArrayList<ReadThread>();
	
	//�����ڸ��� ������ ���尴ü
	List<String> userList = new ArrayList<String>();
	
	//����ȭ��ü
	Object syncObj = new Object();
		
	public MultiServer() {
		// TODO Auto-generated constructor stub
		super("��Ƽä�ü���");
		
		//����͸� â
		init_display();
		
		//�����ڼ� ���â
		init_user_count();
		
		//������ ��� ���â
		init_user_list();
		
		//�����ʱ�ȭ
		init_server();
		

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

	private void init_server() {
		// TODO Auto-generated method stub
		
		try {
			server = new ServerSocket(8000);
			
			//���Ӵ�� �� ����ó���ϴ� �۾���(Thread) ����
			new Thread() {
				
				public void run() {
					
					while(true) {
						try {
							//���Ӵ��->��û����->�ڼ��ϻ���->����
							Socket child = server.accept();
							
							//�ڼ����� ���ſ� ���������
							ReadThread rt = new ReadThread(child);
							rt.start();
							
							//���ϸ�ϰ�����ü���� �ִ´�
							socketList.add(rt);
							
							//�����ڼ� ���
							display_user_count();
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				
			}.start();
			
			
			display_message("����������...");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void display_user_count() {
		// TODO Auto-generated method stub
		
		jtf_user_count.setText( socketList.size() + "");
				
	}

	private void display_message(String message) {
		// TODO Auto-generated method stub
		jta_display.append(message + "\r\n");
		
		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);
		
		
	}

	

	
	private void init_user_count() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(1, 3));
		
		JLabel jlb1 = new JLabel("�����ڼ�:", JLabel.RIGHT);
		jtf_user_count = new JTextField("0");
		JLabel jlb2 = new JLabel("(��)");
		
		p.add(jlb1);
		p.add(jtf_user_count);
		p.add(jlb2);
		
		this.add(p,BorderLayout.SOUTH);
		
		//��Ʈ����
		jlb1.setFont(font);
		jlb2.setFont(font);
		jtf_user_count.setFont(font);
		
		//�����ڼ� �߾�����
		jtf_user_count.setHorizontalAlignment(JTextField.CENTER);
		
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
		
		//�б�����
		jta_display.setEditable(false);
		
		//��Ʈ����
		jta_display.setFont(font);
		
		
	}

//--�ڼ����� �޽��� ���ſ� ������
	class ReadThread extends Thread
	{
		Socket child;//�ڼ���
		
		BufferedReader br;//���ſ� IO��ü
		String ip;
		public ReadThread(Socket child) {
			super();
			this.child = child;
			
			try {
				InputStream is        = child.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				
				ip = child.getInetAddress().getHostAddress();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				
				try {
					String readStr = br.readLine();
					if(readStr==null) {
						//System.out.println("--��������--");
						break;//��������
					}
					
					//���ŵ����� �����
					display_message(ip+":"+readStr);
					
					//
					String [] msgs = readStr.split("#");
					//���� => "IN#��浿"
					//                 0       1 
					//        msgs = {"IN","��浿"};
					if(msgs[0].equals("IN")) { //����
						
						synchronized (syncObj) 
						{
							//�����ڸ��� �߰�
							userList.add(msgs[1]);
							
							//�����ڸ���� ������â�� ���
							display_user_list();
							
							//���� ������ ��� ��������ڿ��� ����
							send_user_list();
							
							//������ڿ��� ����޽��� ����
							send_message_all(readStr+"\n");
						}
						
						
						
					}else if(msgs[0].equals("MSG")) {
						//ä���̸�
						synchronized (syncObj) 
						{
							//�弳 filtering
							String [] bad_str = 
								{"����","�ٺ�","�Ļ�"};
							
							for(String bad : bad_str) {
								
								readStr = readStr.replaceAll(bad, "***");
							}
							
							
							send_message_all(readStr+"\n");
						}
						
						
					}else if(msgs[0].equals("DRAW")) {
						//�׸��� �����͸�
						synchronized (syncObj) 
						{
							send_message_all(readStr+"\n");
						}
					}
					
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					//System.out.println("--����������--");
					break;//�����������
				}//1�پ� ����
			}//end-while
			
			//�����Ȳ
			synchronized (syncObj) 
			{
				//���簴ü�� ArrayList���� ÷�ڱ��ϱ�
				int    del_index = socketList.indexOf(this);
				String del_nick_name = userList.get(del_index);
				
				//�����ڸ� ����
				userList.remove(del_index);
				
				
				//���� �������� ������ ����
				socketList.remove(this);
				
				//���峻�� ��Ŭ���̾�Ʈ���� ����
				String send_data = String.format("OUT#%s\n", del_nick_name);
				send_message_all(send_data);
				
				
				//���� ������ ��� ��������ڿ��� ����
				send_user_list();
				
				//�����ڸ�� ����
				display_user_list();
				
				
				//����� ����
				display_user_count();
			}
			
		}//end-run => Thread dead
		
	}
//---End ReadThread	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiServer();
	}

	public void send_user_list() {
	    // TODO Auto-generated method stub
	    //���۸�� ����
		StringBuffer sb = new StringBuffer("LIST#");
		for(String user : userList) {
			sb.append(user);
			sb.append("#");
		}
		sb.append("\n");
		
		//"LIST#�ϱ浿#�̱浿#��浿#\n"
		String send_data = sb.toString();
		
		//������ڿ��� ����
		send_message_all(send_data);
		
		
    }

	private void send_message_all(String send_data) {
		// TODO Auto-generated method stub
		for(int i=0;i<socketList.size();i++) {
			try {
				
				ReadThread rt = socketList.get(i);
				rt.child.getOutputStream().write(send_data.getBytes());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}

	public void display_user_list() {
		// TODO Auto-generated method stub
		String [] user_array = new String[userList.size()];
		//ArrayList ->  Array
		userList.toArray(user_array);
		
		jlist_user_list.setListData(user_array);
		
	}

}
