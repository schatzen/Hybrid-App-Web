package mymain.tcp.echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//1.Ŭ���̾�Ʈ����/���ӿ�û
		Socket client  = new Socket("192.168.0.77", 7000);
		
		System.out.println("--���Ἲ��--");
		
		//2.����
		String message = "�ȳ� �ߵ��ƿ���?";
		//�������κ��� ���� ��Ʈ�� ���
		OutputStream os = client.getOutputStream();
		//����: String-> byte[]
		os.write(message.getBytes());
		
		//3.���������� ������ ������ ����
		//���� ��Ʈ�� ȹ��
		InputStream is = client.getInputStream();
		byte [] buff = new byte[100];
		int len = is.read(buff);
		
		String echo_message = new String(buff,0,len);
		
		System.out.printf("�ǵ��ƿ� �޽���:%s\n", echo_message);
		
		
		
		
		
		
	}

}
