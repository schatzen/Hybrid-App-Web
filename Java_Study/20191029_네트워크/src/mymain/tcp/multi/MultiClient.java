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

	JTextArea jta_display;
	JTextField jtf_message;
	JList<String> jlist_user_list;

	JButton jbt_connect;
	boolean bConnect = false; // ���� �������

	Font font = new Font("�ü�ü", Font.BOLD, 18);
	String nick_name = "�Ļ�";

	// �׸��� ��ɿ� �ʿ��� ����
	JPanel grimPan;
	Image memPan;// �޸𸮻��� �׸���

	int thick = 5; // �� ����
	int color = 0; // Black

	public MultiClient() {
		super("MultiClient");

		// ���â �ʱ�ȭ
		init_display();

		// �Է�â �ʱ�ȭ
		init_input();

		// �׸��� �ʱ�ȭ
		init_grimpan();

		// ���콺 �̺�Ʈ (�׸��� ��������� ������ ��)
		init_mouse_event();

		// ������ ���
		init_user_list();

		// Ű���� �̺�Ʈ �ʱ�ȭ
		init_key_event();

		// ��ġ
		setLocation(200, 100);

		setResizable(false); // pack() �ڿ� ����
		// ũ��
		// setSize(300, 300);
		pack();

		// �������
		setVisible(true); // ���� ��� �����찡 ȭ��� ���÷��̰� �Ǵ� ��Ȳ

		// ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ȭ��� ȣȯ���ִ� �޸𸮻��� ������ ���� ( setVisible �� �Ϸ�� ������ �����ؾ� ��)
		memPan = grimPan.createImage(300, 400);
		Graphics g = memPan.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, 300, 400);

		grimPan.repaint();

	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub
		// ����Ͷ� �����ʸ� �߻�ȭ��,,,�׷���
		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				if (bConnect == false) {
					return;
				}
				Point pt = e.getPoint();

				// �ӽ� �׸���
				Graphics g = memPan.getGraphics();
				Color color2 = new Color(color);
				g.setColor(color2);

				g.fillOval(pt.x - thick / 2, pt.y - thick / 2, thick, thick);

				// ȭ�鿡 �ű��
				grimPan.repaint();

				// ���۵������� ����
				String send_data = String.format("DRAW#%d#%d#%d#%d\n", pt.x, pt.y, thick, color);
				try {
					client.getOutputStream().write(send_data.getBytes());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		};
		// grimPan.addMouseListener(adapter); //Ŭ���� (adapter�� pressed ������ ���� �ŹǷ� �Ƚᵵ��)
		grimPan.addMouseMotionListener(adapter); // ������ ��

	}

	private void init_grimpan() {
		// TODO Auto-generated method stub
		grimPan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				// �޸𸮻��� �׸��� ���� �����ؿ´�
				g.drawImage(memPan, 0, 0, this);
			}
		};
		grimPan.setPreferredSize(new Dimension(300, 400));
		this.add(grimPan, BorderLayout.WEST);

	}

	private void init_key_event() {
		// TODO Auto-generated method stub
		KeyAdapter adapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					send_message();

				}
			}
		};
		jtf_message.addKeyListener(adapter); // ����

	}

	protected void send_message() {
		// TODO Auto-generated method stub
		// ����Ǿ����� ������ ������
		if (bConnect == false)
			return;

		String message = jtf_message.getText().trim();
		if (message.isEmpty()) {// ���� ��������� ������..
			jtf_message.setText("");
			return;
		}

		// ���۵����� ���� : "MSG#��ȭ��#����"
		String send_data = String.format("MSG#%s#%s\n", nick_name, message);

		try {
			client.getOutputStream().write(send_data.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ���� �Է°� �����
		jtf_message.setText("");
	}

	private void init_input() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());

		// �޽��� �Է�â
		jtf_message = new JTextField();

		// �����ư
		jbt_connect = new JButton("����");
		jbt_connect.setPreferredSize(new Dimension(120, 0));

		p.add(jtf_message, BorderLayout.CENTER);
		p.add(jbt_connect, BorderLayout.EAST);

		this.add(p, BorderLayout.SOUTH);

		// font ����
		jtf_message.setFont(font);
		jbt_connect.setFont(font);

		// ��ư �̺�Ʈ
		jbt_connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				on_connect();

			}
		});

		// �׸��Ǹ޴� �߰�
		JPanel p1 = new JPanel(new GridLayout(1, 3));
		p1.setPreferredSize(new Dimension(300, 0));

		// ������ ����(�޺��ڽ�)
		Integer[] thick_array = { 5, 10, 15, 20, 25, 30, 35, 40 };

		JComboBox<Integer> jcb_thick = new JComboBox<Integer>(thick_array);
		p1.add(jcb_thick);

		// �� ���� /����� ��ư
		JButton jbt_color = new JButton("������");
		JButton jbt_clear = new JButton("�����");

		p1.add(jbt_color);
		p1.add(jbt_clear);
		p.add(p1, BorderLayout.WEST);

		// ������ ���ý� �̺�Ʈ
		jcb_thick.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				// System.out.println(e);

				if (e.getStateChange() == ItemEvent.SELECTED) {// �� ���� ���õǰ� �Ϸ��� deselec/select �Ѵ� ���õǼ�
					thick = (int) jcb_thick.getSelectedItem();
					// System.out.println(thick);
				}
			}
		});

		// �� ���� ���ý� �̺�Ʈ
		jbt_color.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color im_color = new Color(color);
				Color res_color = JColorChooser.showDialog(MultiClient.this, "�� ������ �����ϼ���", im_color);
				if (res_color == null)
					return;

				// Ȯ�� ��ư�� ������ �ʾ��� �� ������
				color = res_color.getRGB();

			}
		});

		// ����� �̺�Ʈ
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
		// Toggle ó��
		bConnect = !bConnect;

		if (bConnect) { // �����۾�
			try {
				// ����
				client = new Socket("192.168.0.77", 8000);

				// �������� ������ ����
				String send_data = String.format("IN#%s\n", nick_name); // \n�� �־������! �������� bufferedReader�� �б⶧��
				client.getOutputStream().write(send_data.getBytes());

				// ������ ����
				read_message();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else { // �����۾�
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// ��ư ĸ�Ǻ���
		jbt_connect.setText(bConnect ? "����" : "����");

	}

	BufferedReader br = null;

	private void read_message() {
		// TODO Auto-generated method stub
		try {
			InputStreamReader isr = new InputStreamReader(client.getInputStream());
			br = new BufferedReader(isr);

			// �޽��� ���ſ� ������
			new Thread() {

				public void run() {
					while (true) {
						try {
							String readStr = br.readLine();
							if (readStr == null)
								break; // ��������

							String[] msgs = readStr.split("#");

							if (msgs[0].equals("IN")) { // ����
								// String [] msgs = {"IN","�浿1"};
								String display_data = String.format("��[%s]�� ����", msgs[1]);
								display_message(display_data);

							} else if (msgs[0].equals("OUT")) { // ����
								String display_data = String.format("��[%s]�� ����", msgs[1]);
								display_message(display_data);

							} else if (msgs[0].equals("LIST")) { // �����ڸ��
								// readStr="LIST#�ϱ浿#�̱浿#��浿#"
								display_user_list(readStr);

							} else if (msgs[0].equals("MSG")) { // ä��
								String display_data = String.format("[%s]�� : \n%s", msgs[1], msgs[2]);
								display_message(display_data);

							} else if (msgs[0].equals("DRAW")) {// �׸���
								// readStr = "DRAW#10#30#5%0"
								// x y thick color
								// [] msgs = {"DRAW","10","30","5","0"};
								int x = Integer.parseInt(msgs[1]);
								int y = Integer.parseInt(msgs[2]);
								int thick = Integer.parseInt(msgs[3]);
								int color1 = Integer.parseInt(msgs[4]);

								Color thick_color = new Color(color1);
								Graphics g = memPan.getGraphics();
								g.setColor(thick_color);
								// W H
								g.fillOval(x - thick / 2, y - thick / 2, thick, thick);
								grimPan.repaint();

							}

						} catch (IOException e) {
							// TODO Auto-generated catch block
							// e.printStackTrace();
							break; // ���� ������ �����
						}
					} // end-while

					// ���� close
					String[] empty_array = new String[0];
					jlist_user_list.setListData(empty_array);
					bConnect = false;
					jbt_connect.setText("����");

				}
			}.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void display_message(String message) {
		// TODO Auto-generated method stub
		jta_display.append(message + "\n");

		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);

	}

	protected void display_user_list(String readStr) {
		// TODO Auto-generated method stub
		readStr = readStr.replace("LIST#", "");
		// readStr="�ϱ浿#�̱浿#��浿#"
		String[] user_array = readStr.split("#");
		jlist_user_list.setListData(user_array);

	}

	private void init_user_list() {
		// TODO Auto-generated method stub
		jlist_user_list = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist_user_list);
		jsp.setPreferredSize(new Dimension(120, 0));

		this.add(jsp, BorderLayout.EAST);

	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);
		jsp.setPreferredSize(new Dimension(300, 400));

		this.add(jsp, BorderLayout.CENTER);

		// �б� ����
		jta_display.setEditable(false);

		// ��Ʈ����
		jta_display.setFont(font);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MultiClient();
	}

}
