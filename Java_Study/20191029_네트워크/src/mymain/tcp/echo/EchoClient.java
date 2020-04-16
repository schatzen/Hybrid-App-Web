package mymain.tcp.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		// 1.Ŭ���̾�Ʈ ���� / ���� ��û
		Socket client = new Socket("192.168.0.77", 8000);
		System.out.println("���Ἲ��");

		// 2. ����
		String message = "131331";                                      

		// �������κ��� ���� ��Ʈ�� ���
		OutputStream os = client.getOutputStream();

		// ���� : String > byte[]
		os.write(message.getBytes());

		// 3. ���� ������ ������ ������ ����
		// ���� ��Ʈ�� ȹ��
		InputStream is = client.getInputStream();
		byte[] buff = new byte[100];
		int len = is.read(buff);

		String echo_message = new String(buff, 0, len);
		System.out.printf("�ǵ��ƿ� �޽��� : %s\n", echo_message);

	}

}
