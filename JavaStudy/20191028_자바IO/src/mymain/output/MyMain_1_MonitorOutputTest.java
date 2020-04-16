package mymain.output;

import java.io.OutputStream;

public class MyMain_1_MonitorOutputTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//             모니터표준장치명:System.out
		OutputStream os = System.out;
		
		String msg = "안녕\n";
		//String -> byte [] 
		os.write(msg.getBytes());
		
		os.write(65);
		
		os.flush();//출력버퍼내용을 출력장치로 내보내기
		
		
		
		
		
	}

}
