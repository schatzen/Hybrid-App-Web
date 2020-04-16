package mymain.output;

import java.io.IOException;
import java.io.OutputStream;

public class MyMain_1_MonitorOutputTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 모니터 표준장치명 : System.out
		OutputStream os = System.out;

		String msg = "안녕\n";

		// String > byte[] 변환
		os.write(msg.getBytes());
		
		os.write(65);	//아스키 코드값
		os.flush();//출력버퍼내용을 출력장치로 내보내기
		
	}

}
