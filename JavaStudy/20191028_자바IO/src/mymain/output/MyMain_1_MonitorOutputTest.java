package mymain.output;

import java.io.OutputStream;

public class MyMain_1_MonitorOutputTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//             �����ǥ����ġ��:System.out
		OutputStream os = System.out;
		
		String msg = "�ȳ�\n";
		//String -> byte [] 
		os.write(msg.getBytes());
		
		os.write(65);
		
		os.flush();//��¹��۳����� �����ġ�� ��������
		
		
		
		
		
	}

}
