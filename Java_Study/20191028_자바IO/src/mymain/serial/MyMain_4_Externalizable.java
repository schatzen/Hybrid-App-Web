package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vo.PersonVo;
import vo.PersonVo2;

public class MyMain_4_Externalizable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 직렬화

		
		 PersonVo2 p = new PersonVo2("홍길동",20,"서울 마포구"); //파일저장
		 FileOutputStream fos =new FileOutputStream("person2.dat");
		  
		  //직렬화 객체로 Filtering(포장) 
		  ObjectOutputStream oos = new ObjectOutputStream(fos);
		  
		  //갹채조정
		  oos.writeObject(p);
		  
		 //덛가 :열거역순 
		  oos.close(); fos.close();
		 

		// 역직렬화( 파일읽기 > 객체복원)
		FileInputStream fis = new FileInputStream("person2.dat");

		// byte stream > Object Stream(역직렬화) filtering
		ObjectInputStream ois = new ObjectInputStream(fis);

		// 파일읽기 > 객체로 복원
		PersonVo2 pp = (PersonVo2) ois.readObject(); // 모든 객체를 받아야하므로 Object로 반환하게 됨 그래서 캐스팅을 해줘야함

		System.out.println("복원된 객체 :" + pp);

		// 닫기 :열린역순
		ois.close();
		fis.close();

	}

}
