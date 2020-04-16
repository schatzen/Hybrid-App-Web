package mymain.tcp.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 1. 서버소켓생성 : 포트할당받기
		ServerSocket server = new ServerSocket(7000);
		System.out.println("--Server 대기중--");

		while (true) { // 소켓 api는 인풋트트림과 아웃스트림 (송수신 기능)둘 다 가지고 있다.
			Socket child = server.accept(); // accept는 client를 대기하고 있다가 접속정보를 가져옴

			// 데이터 수신
			InputStream is = child.getInputStream();
			byte[] buff = new byte[100];
			// len > 수신된 데이터 크기 "안녕" 같은 경우 4byte
			int len = is.read(buff);

			String read_message = new String(buff, 0, len);
			System.out.printf("클라이언트로부터 수신된 데이터  : %s\n", read_message);

			// 수신데이터 되돌려준다 (에코)
			// 송신스트림 얻기    
			OutputStream os = child.getOutputStream();
			// String > byte[]
			os.write(read_message.getBytes());

			// 상대방(Client) 소켓으로부터 주소 알아보기
			// InetAddress ia = child.getInetAddress();
			// System.out.printf("[%s]님 접속요청\n", ia.getHostAddress());
		}
	}

}
