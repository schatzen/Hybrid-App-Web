package mymain.serial;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;

import vo.PersonVo;

public class MyMain_3_SerializableTest3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * 
		 * Map infoMap = new HashMap();
		 * 
		 * infoMap.put("name", "박길동"); infoMap.put("company", "공무원"); infoMap.put("age",
		 * 20);
		 * 
		 * String[] hobby_array = { "낚시", "운동", "독서" }; infoMap.put("hobby",
		 * hobby_array);
		 * 
		 * List<PersonVo> friend_list = new ArrayList<PersonVo>(); friend_list.add(new
		 * PersonVo("친구1", 20, "노고산동")); friend_list.add(new PersonVo("친구2", 19,
		 * "노고산동")); friend_list.add(new PersonVo("친구3", 21, "노고산동"));
		 * infoMap.put("friend", friend_list);
		 * 
		 * 
		 * // 1. 저장
		 * 
		 * FileOutputStream fos = new FileOutputStream("map_list.dat");
		 * 
		 * // Filtering : ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * 
		 * // 저장 oos.writeObject(infoMap);
		 * 
		 * // 닫기 : 열거역순 oos.close(); fos.close();
		 * 
		 * 
		 * System.out.println("--저장완료--");
		 */

		// 2. 읽기

		// 역직렬화( 파일읽기 > 객체복원)
		FileInputStream fis = new FileInputStream("map_list.dat");

		// byte stream > Object Stream(역직렬화) filtering
		ObjectInputStream ois = new ObjectInputStream(fis);

		// 파일읽기 > 객체로 복원
		// List pp = (ArrayList) ois.readObject(); // 모든 객체를 받아야하므로 Object로 반환하게 됨 그래서
		// 캐스팅을 해줘야함
		Map pp = (Map) ois.readObject();

		System.out.println("복원된 객체 ");

		System.out.println("이름:" + (String) pp.get("name"));
		System.out.println("직장:" + (String) pp.get("company"));
		System.out.println("나이:" + (Integer) pp.get("age"));

		String[] hobby_array2 = (String[]) pp.get("hobby");
		List<PersonVo> friend_list2 = (List<PersonVo>) pp.get("friend");

		for (String hobby : hobby_array2)
			System.out.println(hobby);
		for (PersonVo p : friend_list2)
			System.out.println(p);

		// 닫기 :열린역순
		ois.close();
		fis.close();

	}

}
