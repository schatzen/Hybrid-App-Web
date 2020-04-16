package mymain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class MyMain_6_자동리소스닫기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//JDK7.0 later지원 
		try(
				FileReader fr = new FileReader("a.txt");
				FileWriter fw = new FileWriter("c.txt")
				//현재열린 2개의 리소스를 자동으로 닫아준다		
		   ){
			
			//본코드 수행
			while(true) {
				int ch = fr.read();
				if(ch==-1)break;
				//읽은문자를 저장
				fw.write(ch);
			}
			
			System.out.println("--복사완료--");
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
