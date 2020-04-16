package mymain.tcp.echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//1.�������ϻ��� : ��Ʈ�Ҵ�ޱ�
        ServerSocket  server = new ServerSocket(7000); 
        System.out.println("--Server�����--");
        while(true) {
        	
        	Socket child = server.accept();
        	
        	//������ ����
        	InputStream is = child.getInputStream();
        	byte [] buff = new byte[100];
        	//len->���ŵ� ������ ũ��
        	int len = is.read(buff);
        	
        	String read_message = new String(buff,0,len);
        	System.out.printf("Ŭ���̾�Ʈ�κ��� ���ŵ� ������:%s\n",read_message);
        	
        	
        	//���ŵ����� �ǵ����ش�(����)
        	//�۽Ž�Ʈ�� ���
        	OutputStream os = child.getOutputStream();
        	//String -> byte[]
        	os.write(read_message.getBytes());
        	
        	
        	
        	
        	//���� �������κ��� �ּҾ˾ƺ���
        	InetAddress ia = child.getInetAddress();
        	System.out.printf("[%s] �� ���ӿ�û\n",ia.getHostAddress());
        	        	
        	        	
        	
        }
		
		
	}

}
