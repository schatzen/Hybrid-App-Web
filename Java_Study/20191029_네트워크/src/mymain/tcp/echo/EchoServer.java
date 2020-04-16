package mymain.tcp.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 1. �������ϻ��� : ��Ʈ�Ҵ�ޱ�
		ServerSocket server = new ServerSocket(7000);
		System.out.println("--Server �����--");

		while (true) { // ���� api�� ��ǲƮƮ���� �ƿ���Ʈ�� (�ۼ��� ���)�� �� ������ �ִ�.
			Socket child = server.accept(); // accept�� client�� ����ϰ� �ִٰ� ���������� ������

			// ������ ����
			InputStream is = child.getInputStream();
			byte[] buff = new byte[100];
			// len > ���ŵ� ������ ũ�� "�ȳ�" ���� ��� 4byte
			int len = is.read(buff);

			String read_message = new String(buff, 0, len);
			System.out.printf("Ŭ���̾�Ʈ�κ��� ���ŵ� ������  : %s\n", read_message);

			// ���ŵ����� �ǵ����ش� (����)
			// �۽Ž�Ʈ�� ���    
			OutputStream os = child.getOutputStream();
			// String > byte[]
			os.write(read_message.getBytes());

			// ����(Client) �������κ��� �ּ� �˾ƺ���
			// InetAddress ia = child.getInetAddress();
			// System.out.printf("[%s]�� ���ӿ�û\n", ia.getHostAddress());
		}
	}

}
