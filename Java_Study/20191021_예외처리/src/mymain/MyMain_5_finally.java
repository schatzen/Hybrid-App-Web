package mymain;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyMain_5_finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr = null; // file 읽는 개체
		FileWriter fw = null; // file 쓰는 개체

		try { // 본코드
			fr = new FileReader("a.txt"); // 읽기파일 열기
			fw = new FileWriter("b.txt"); // 쓰기파일 열기
			
			
			while (true) {
				int ch = fr.read(); //이것도 원래 예외처리 해줘야하는데 밑에서 catch했으니까 따로 할 필요 x
				if(ch ==-1) break; //끝까지 읽었으면 빠져나오라
				//읽은 문자를 저장
				fw.write(ch);
			}
			System.out.println("복사완료"); 

		} catch (Exception e) { // 예외가 발생하면

		} finally { //alt + shift + z : try catch block
					//정상적으로 파일  열렸든, 에러가 생기든 파일은 닫아야하니까 이떄 finally로 처리!
			try {
				// 예외발생 유무와 상관없이 무조건 호출
				if (fr != null) fr.close();
				if (fw != null) fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
