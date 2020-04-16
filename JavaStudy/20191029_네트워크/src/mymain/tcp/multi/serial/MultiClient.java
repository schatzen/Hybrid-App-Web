package mymain.tcp.multi.serial;

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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	boolean       bConnect = false;//���� �������
	Socket client;
	
	//����ȭ ó����ü
	ObjectInputStream  ois = null;
	ObjectOutputStream oos = null;
	
	
	Font font = new Font("����ü", Font.BOLD , 18);
	
	String nick_name="��浿";
	
	
	//�׸��� ��ɿ� �ʿ��� ����
	JPanel grimPan;
	Image  memPan;//�޸𸮻��� �׸���
	
	int thick=5;//������
	int color=0;//Black;
	
	public MultiClient() {
		// TODO Auto-generated constructor stub
		super("MultiChatClient");

		//���â �ʱ�ȭ
		init_display();
		
		//�Է�â �ʱ�ȭ
		init_input();
		
		//�׸��� �ʱ�ȭ
		init_grimpan();
				
		
		//���콺 �̺�Ʈ
		init_mouse_event();
		
		//������ ���
		init_user_list();
		
		//Ű���� �̺�Ʈ �ʱ�ȭ
		init_key_event();		
		
		//��ġ
		setLocation(200, 100);

		setResizable(false);
		//ũ��
		//setSize(300, 300);
		pack();

		//�������
		setVisible(true);

		//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//ȭ��� ȣȯ���ִ� �޸𸮻��� ������ ����
		memPan = grimPan.createImage(300, 400);
		//�׸��� ���� ��´�
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
				
				try {
					
					Data data = new Data();
					data.protocol=Data.DRAW;
					data.x = pt.x;
					data.y = pt.y;
					data.thick = thick;
					data.color = color;
					
					oos.writeObject(data);
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
			
		};
		
		//grimPan.addMouseListener(adapter);//Ŭ����
		grimPan.addMouseMotionListener(adapter);//�����϶�
	}


	private void init_grimpan() {
		// TODO Auto-generated method stub
		grimPan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub

				//�޸𸮻��� �׸��� ���� �����ؿ´�
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
		//����Ǿ����� ������ ������..
		if(bConnect==false)return;
		
		String message = jtf_message.getText().trim();
		if(message.isEmpty()) {//���� ��������� ������..
			jtf_message.setText("");
			return;
		}
		
		
		//����
		try {
			
			Data data = new Data();
			data.protocol = Data.MSG;
			data.nick_name = nick_name;
			data.message = message;
			
			oos.writeObject(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        //���� �Է°� �����
		jtf_message.setText("");
			
		
	}

	private void init_input() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		
		//�޽��� �Է�â
		jtf_message = new JTextField();
		//�����ư
		jbt_connect = new JButton("����");
		jbt_connect.setPreferredSize(new Dimension(120, 0));
		
		p.add(jtf_message,BorderLayout.CENTER);
		p.add(jbt_connect,BorderLayout.EAST);
		
		this.add(p,BorderLayout.SOUTH);
		
		//font����
		jtf_message.setFont(font);
		jbt_connect.setFont(font);
		
		//��ư�̺�Ʈ
		jbt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				on_connect();
			}
		});
		
		
		//�׸��Ǹ޴� �߰�
		JPanel p1 = new JPanel(new GridLayout(1, 3));
		p1.setPreferredSize(new Dimension(300, 0));
		
		//������ ����(�޺��ڽ�)
		Integer []  thick_array= {5,10,15,20,25,30,35,40};
		JComboBox<Integer> jcb_thick = 
				      new JComboBox<Integer>(thick_array);
		p1.add(jcb_thick);
		
		//������/����� ��ư
		JButton jbt_color = new JButton("������");
		JButton jbt_clear = new JButton("�����");
		
		p1.add(jbt_color);
		p1.add(jbt_clear);
				
				
		p.add(p1,BorderLayout.WEST);
		
		
		
		//������ ���ý� �̺�Ʈ
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
		
		//������ ���ý� �̺�Ʈ
		jbt_color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			    Color im_color = new Color(color);
			    
				Color res_color = JColorChooser.showDialog(
						                 MultiClient.this, 
						                 "�������� �����ϼ���",
						                 im_color);
				//Ȯ�ι�ư�� ������ �ʾ����� ��..
				if(res_color==null) return;
						
				color = res_color.getRGB();
				
			}
		});
		
		
		//����� �̺�Ʈ
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

	
	
	protected void on_connect() {
		// TODO Auto-generated method stub
		//Toggleó��
		bConnect = !bConnect;
		
		if(bConnect) { //�����۾�
			
			try {
				//����
				client = new Socket("192.168.0.77", 8100);
				
				//����ȭ ó�� ��ü ����
				//������ϰ� Cross�� ����
				// oos -> ois
				// ois -> oos
				oos = new ObjectOutputStream(client.getOutputStream());
				ois = new ObjectInputStream(client.getInputStream());
				
				
				//IN#ȫ�浿IN#�ڱ浿\n
				//�������� ������ ����
				//String send_data = String.format("IN#%s\n", nick_name);
				//client.getOutputStream().write(send_data.getBytes());
				Data data = new Data();
				data.protocol = Data.IN;
				data.nick_name = nick_name;
				//��������
				oos.writeObject(data);
				
				//������ ����
				read_message();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else { //�����۾�
			
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		//��ư ĸ�Ǻ���
		jbt_connect.setText(bConnect ? "����" : "����");
		
		
	}

	
	private void read_message() {
		// TODO Auto-generated method stub
			
		//�޽��� ���ſ� ������
		new Thread() {
			
			public void run() {
				
				while(true) {
				
					try {
						
						Data data = (Data) ois.readObject();
						
						if(data==null)break;//��������
						
						if(data.protocol==Data.IN) {//����
							
							String display_data = 
									 String.format("��[%s]�� ����", data.nick_name);
							display_message(display_data);
							
						}else if(data.protocol==Data.OUT) {//����
							String display_data = 
									 String.format("��[%s]�� ����", data.nick_name);
							display_message(display_data);
							
						}else if(data.protocol==Data.LIST) {//�����ڸ�ϼ���
							
							display_user_list(data);
							
							
						}else if(data.protocol==Data.MSG) {//ä��
							String display_data = 
									String.format("[%s]�� ����:\r\n  %s", 
											      data.nick_name,  data.message);
							display_message(display_data);
							
							
						}else if(data.protocol==Data.DRAW) {//�׸���

							try {
								int x 		= data.x;
								int y 		= data.y;
								int thick 	= data.thick;
								int color 	= data.color;
								
								Color thick_color = new Color(color);
								Graphics g = memPan.getGraphics();
								g.setColor(thick_color);
								
								g.fillOval(x-thick/2, y-thick/2, thick, thick);
								
								grimPan.repaint();
								
							} catch (Exception e) {
								// TODO: handle exception
							}
							
							
						}
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						break;//���� ����������
					}
				}//end-while
				
				//���� Close
				String []  empty_array = new String[0];
				jlist_user_list.setListData(empty_array);
				
				bConnect=false;
				jbt_connect.setText("����");
				
				
			}
			
		}.start();
			
	}

	protected void display_message(String message) {
		// TODO Auto-generated method stub
		jta_display.append(message +"\r\n");
		
		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);
		
		
	}

	protected void display_user_list(Data data) {
		// TODO Auto-generated method stub
		
		String [] user_array = new String[data.userList.size()];
		data.userList.toArray(user_array);
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
		
		//�б�����
		jta_display.setEditable(false);
		
		//��Ʈ����
		jta_display.setFont(font);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiClient();
	}
}
