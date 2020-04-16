package mymain;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyMain_5_finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr = null;//파일읽는 객체
		FileWriter fw = null;//파일쓰는 객체
		
		try {
			//본코드
			fr = new FileReader("a.txt");//읽기화일 열기
			fw = new FileWriter("b.txt");//쓰기화일 열기
			
			while(true) {
				int ch = fr.read();
				if(ch==-1)break;
				//읽은문자를 저장
				fw.write(ch);
			}
			
			System.out.println("--복사완료--");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			//예외가 발생되면
			
			
		} finally {
			try {
				//예외발생 유무와 상관없이 무조건 처리
				if(fr!=null)fr.close();
				if(fw!=null)fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
