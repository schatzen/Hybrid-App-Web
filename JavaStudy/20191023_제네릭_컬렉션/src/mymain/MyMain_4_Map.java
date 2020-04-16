package mymain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class TestGeneric<K,V>
{
	Set<K> key;
	
}


public class MyMain_4_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> telMap 
		           = new HashMap<Integer, String>();
		//단축번호
		//         Key,  Value
		telMap.put(1  , "010-111-1111");
		telMap.put(2  , "010-211-1111");
		telMap.put(3  , "010-311-1111");
		telMap.put(4  , "010-411-1111");
		telMap.put(5  , "010-511-1111");
		
		int short_no = 1;//단축번호
		
		//map으로부터 단축번호에 해당되는 전화번호(Value)
		String tel = telMap.get(short_no);
		System.out.printf("단축번호 %d : %s\n",short_no,tel);
		
		//전체를 조회
		//Map에 저장된 키의 집합을 얻어오기
		Set<Integer> telSet = telMap.keySet();
		
		System.out.println(telSet);
		
		System.out.println("--Map 전체데이터 출력--");
		//JDK1.5 later
		for(Integer key : telSet) {
			String value = telMap.get(key);
			System.out.printf("단축번호 %d : %s\n",key,value);
		}
		
		
		

	}

}
