package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.PersonVo;

public class MyMain_3_SerializableTest3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
     /*
		Map infoMap 
		         = new HashMap();
		
		infoMap.put("name", "박길동");
		infoMap.put("company", "공무원");
		infoMap.put("age", 20);
		String [] hobby_array = {"낚시","운동","독서"};
		infoMap.put("hobby", hobby_array);
		
		List<PersonVo> friend_list = new ArrayList<PersonVo>();
		friend_list.add(new PersonVo("친구1", 20, "노고산동"));
		friend_list.add(new PersonVo("친구2", 21, "노고산동"));
		friend_list.add(new PersonVo("친구3", 19, "노고산동"));
		infoMap.put("friend", friend_list);
		
		//1. 저장
		FileOutputStream fos = new FileOutputStream("infoMap.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(infoMap);
		
		oos.close();
		fos.close();
	*/
				
		//2. 읽기
		FileInputStream fis = new FileInputStream("infoMap.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//역직렬화(복원)
		Map readMap = (Map) ois.readObject();
		
		//Map으로부터 값 읽어오기
		String name = (String) readMap.get("name");
		int age = (int) readMap.get("age");
		String company = (String) readMap.get("company");
		String [] hobby_array2 = (String[]) readMap.get("hobby");
		List<PersonVo> friend_list2 = (List<PersonVo>) readMap.get("friend");
				
		System.out.println("--복원된 데이터--");
		System.out.printf("이름:%s\n",name);
		System.out.printf("나이:%d\n",age);
		System.out.printf("회사:%s\n",company);
		System.out.printf("취미:");
		for(String hobby : hobby_array2) {
			System.out.print(hobby + " ");
		}
		System.out.println();
		
		System.out.printf("친구:");
		for(PersonVo friend : friend_list2) {
			System.out.print(friend.getName()+ " ");
		}
		
		System.out.println();
		
		
		
		
		
		
		
		ois.close();
		fis.close();
		
		
		
	}

}
