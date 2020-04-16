package mymain.tcp.echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//1.서버소켓생성 : 포트할당받기
        ServerSocket  server = new ServerSocket(7000); 
        System.out.println("--Server대기중--");
        while(true) {
        	
        	Socket child = server.accept();
        	
        	//데이터 수신
        	InputStream is = child.getInputStream();
        	byte [] buff = new byte[100];
        	//len->수신된 데이터 크기
        	int len = is.read(buff);
        	
        	String read_message = new String(buff,0,len);
        	System.out.printf("클라이언트로부터 수신된 데이터:%s\n",read_message);
        	
        	
        	//수신데이터 되돌려준다(에코)
        	//송신스트림 얻기
        	OutputStream os = child.getOutputStream();
        	//String -> byte[]
        	os.write(read_message.getBytes());
        	
        	
        	
        	
        	//상대방 소켓으로부터 주소알아보기
        	InetAddress ia = child.getInetAddress();
        	System.out.printf("[%s] 님 접속요청\n",ia.getHostAddress());
        	        	
        	        	
        	
        }
		
		
	}

}
