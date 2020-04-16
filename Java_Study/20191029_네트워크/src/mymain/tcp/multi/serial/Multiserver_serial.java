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

	// ��Ʈ��ũ ���� ����
	ServerSocket server;

	List<ReadThread> socketList = new ArrayList<ReadThread>();

	// �����ڸ��� ���������尴ü
	List<String> userList = new ArrayList<String>();

	Font font = new Font("���ü", Font.BOLD, 18);

	// ����ȭ��ü
	Object syncObj = new Object(); // ����ó�� ������ ����ó�� �� �� �ֵ���. �ݴ��Ȳ�� ��������

	public Multiserver_serial() {
		super("��Ƽä�ü���");

		// ����͸� â
		init_display();

		// �����ڼ� ���â
		init_user_count();

		// ������ ��� ���â
		init_user_list();

		// �����ʱ�ȭ
		init_server();

		// ��ġ
		setLocation(200, 100);

		// ũ��
		// setSize(300, 300);
		pack();

		// �������
		setVisible(true);

		// ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// ---�ڼ����� �޽��� ���ſ� ������---
	class ReadThread extends Thread {
		Socket child; // ������

		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;

		public ReadThread(Socket child) {
			this.child = child;

			try {

				ois = new ObjectInputStream(child.getInputStream());
				oos = new ObjectOutputStream(child.getOutputStream());

				// BufferedReader br = new BufferedReader( new
				// InputStreamReader(child.getInputStream));�� ����

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
						// ��������
						break;

					// ���ŵ����� �����
					String display_msg = String.format("[%s] : [%d][%s][%s]", data.protocol, data.nick_name,
							data.message);
					display_message(display_msg);

					//
					// ���� > "IN#��浿"
					// msgs = {"IN","��浿"};
					if (data.protocol == Data.IN) { // �����ϸ�

						synchronized (syncObj) {
							// �����ڸ��� �߰�
							userList.add(data.nick_name);

							// ������ ����� ������ â�� ���
							display_user_list();

							// ���� ������ ��� ��� �����ڿ��� ����
							send_user_list();

							// ��� ����ڿ��� ����޽��� ����
							send_message_all(data);
						}

					} else if (data.protocol == Data.MSG) { // ä���̸�
						synchronized (syncObj) {

							// �弳 filtering
							String[] bad_str = { "����", "�ٺ�", "�Ļ�" };

							for (String bad : bad_str) {
								data.message = data.message.replaceAll(bad, "***");
							}
							send_message_all(data);
						}

					} else if (data.protocol == Data.DRAW) { // �׸��� �����͸�
						synchronized (syncObj) {
							send_message_all(data);
						}

					}

				} catch (Exception e) { // �����ʿ��� ���������� �������� �� (ex.��������x, �����ư�� �ƴ� �ݱ� ��ư ������ ��)
					// null�� ���� �ȵǰ� exception���� �� �׷��� break;!
					// TODO Auto-generated catch block
					// e.printStackTrace();
					break;
				} // 1�پ� ����

			} // end-while

			// �����Ȳ
			synchronized (syncObj) {

				// ���� ��ü�� ArrayList���� ÷��
				int del_Index = socketList.indexOf(this);
				String del_nick_name = userList.get(del_Index);

				// �����ڸ� ����
				userList.remove(del_Index);

				// ���� �������� ������ ����
				socketList.remove(this);

				// ���峻�� �� Ŭ���̾�Ʈ���� ����
				Data data = new Data();
				data.protocol = Data.OUT;
				data.nick_name = del_nick_name;
				send_message_all(data);

				// ���� ������ ��� ��� �����ڿ��� ����
				send_user_list();

				// �����ڸ�� ����
				display_user_list();

				// ����� ����
				display_user_count();

			}

		}// end-run > Thread�� �״� ����
	}

	private void init_server() {
		// TODO Auto-generated method stub
		try {
			server = new ServerSocket(8100);

			// ���Ӵ�� �� ����ó���ϴ� �۾���(Thread) ����
			new Thread() {
				public void run() {

					while (true) {
						try {

							// ���Ӵ�� > ��û���� > �ڼ��ϻ��� > ����
							Socket child = server.accept();

							// �ڼ����� ���ſ� ���������
							ReadThread rt = new ReadThread(child);
							rt.start();

							// ���ϸ�ϰ�����ü���� �ִ´�
							socketList.add(rt);

							// �����ڼ� ���
							display_user_count();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}.start();

			display_message("�������� ��...");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void send_user_list() {
		Data data = new Data();
		data.protocol = Data.LIST;
		data.userList = userList;

		// ��� ����ڿ��� ����
		send_message_all(data);

	}

	private void send_message_all(Data data) {
		// TODO Auto-generated method stub
		for (int i = 0; i < socketList.size(); i++) {
			try { // �� ����� �ȹ޾Ƶ� ��� �޼����� ���۵Ǿ� �Ǵϱ� ReadThread rt���� ������ ����ó���Ѵ�.
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
		JLabel jlb1 = new JLabel("�����ڼ�: ", JLabel.RIGHT);
		jtf_user_count = new JTextField("0");
		JLabel jlb2 = new JLabel("(��)");

		p.add(jlb1);
		p.add(jtf_user_count);
		p.add(jlb2);

		this.add(p, BorderLayout.SOUTH);

		// ��Ʈ����
		jlb1.setFont(font);
		jlb2.setFont(font);
		jtf_user_count.setFont(font);

		// �����ڼ� �߾�����
		jtf_user_count.setHorizontalAlignment(JTextField.RIGHT);

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

		new Multiserver_serial();
	}

}
