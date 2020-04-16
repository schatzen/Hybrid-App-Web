package mymain.tcp.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		// 1.클라이언트 생성 / 접속 요청
		Socket client = new Socket("192.168.0.77", 8000);
		System.out.println("연결성공");

		// 2. 전송
		String message = "131331";                                      

		// 소켓으로부터 전송 스트림 얻기
		OutputStream os = client.getOutputStream();

		// 전송 : String > byte[]
		os.write(message.getBytes());

		// 3. 서버 측에서 전송한 데이터 수신
		// 수신 스트림 획득
		InputStream is = client.getInputStream();
		byte[] buff = new byte[100];
		int len = is.read(buff);

		String echo_message = new String(buff, 0, len);
		System.out.printf("되돌아온 메시지 : %s\n", echo_message);

	}

}
