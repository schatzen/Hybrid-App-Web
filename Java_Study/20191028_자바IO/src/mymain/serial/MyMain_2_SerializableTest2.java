package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import vo.PersonVo;

public class MyMain_2_SerializableTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 직렬화 안되는 객체 중 하나
		// Image image;
		/*
		 * 
		 * List<PersonVo> p_list = new ArrayList<PersonVo>(); p_list.add(new
		 * PersonVo("일길동", 20, "서울 마포구 노고산1동")); p_list.add(new PersonVo("이길동", 21,
		 * "서울 마포구 노고산2동")); p_list.add(new PersonVo("삼길동", 22, "서울 마포구 노고산3동"));
		 * p_list.add(new PersonVo("사길동", 23, "서울 마포구 노고산4동")); p_list.add(new
		 * PersonVo("오길동", 24, "서울 마포구 노고산5동"));
		 * 
		 * FileOutputStream fos = new FileOutputStream("person_list.dat");
		 * 
		 * // Filtering : ObjectOutputStream ObjectOutputStream oos = new
		 * ObjectOutputStream(fos);
		 * 
		 * // 저장 oos.writeObject(p_list);
		 * 
		 * // 닫기 : 열거역순 oos.close(); fos.close();
		 * 
		 * System.out.println("--저장완료--");
		 */

		// 역직렬화( 파일읽기 > 객체복원)
		FileInputStream fis = new FileInputStream("person_list.dat");

		// byte stream > Object Stream(역직렬화) filtering
		ObjectInputStream ois = new ObjectInputStream(fis);

		// 파일읽기 > 객체로 복원
		//List pp = (ArrayList) ois.readObject(); // 모든 객체를 받아야하므로 Object로 반환하게 됨 그래서 캐스팅을 해줘야함
		List<PersonVo> pp = (List<PersonVo>) ois.readObject();

		//System.out.println("복원된 객체 :" + pp);
		System.out.println("복원된 객체");
		for(PersonVo p : pp) {
			System.out.println(p);
		}

		// 닫기 :열린역순
		ois.close();
		fis.close();

	}

}
