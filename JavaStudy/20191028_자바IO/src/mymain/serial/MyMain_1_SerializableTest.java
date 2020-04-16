package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vo.PersonVo;

public class MyMain_1_SerializableTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		PersonVo p = 
			new PersonVo("홍길동", 20, "서울 마포구 노고산동");
		//화일저장
		FileOutputStream fos = new FileOutputStream("person.dat");
		
		//직렬화 객체로 Filtering(포장)
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//객체저장
		oos.writeObject(p);		
		
		//닫기: 열기역순
		oos.close();
		fos.close();
		System.out.println("--저장완료--");
		*/
		
		//역직렬화(화일읽기->객체복원)
		FileInputStream fis = new FileInputStream("person.dat");
		
		//byte stream-> Object Stream(역직렬화) Filtering
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//화일읽기->객체로 복원
		PersonVo pp =  (PersonVo) ois.readObject();
		
		System.out.println("복원된 객체: " + pp);
		
		//닫기:열린역순
		ois.close();
		fis.close();
		
		
		
		
	}

}
