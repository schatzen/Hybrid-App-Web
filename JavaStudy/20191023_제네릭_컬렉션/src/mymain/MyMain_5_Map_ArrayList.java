package mymain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.PersonVo;

public class MyMain_5_Map_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		Map<String, PersonVo> p_map 
		           = new HashMap<String, PersonVo>();
		
		for(int i=1;i<=100;i++) {
			String name = String.format("길동_%03d", i);
			int    age  = 20 + i%11;
			String tel  = String.format("010-%d11-1234", (i%8)+1);
			//System.out.println(tel);
			PersonVo p = new PersonVo(name, age, tel);
			//ArrayList에 추가
			p_list.add(p);
			//Map에 추가
			//         K    V
			p_map.put(name, p);
		}
		
		
		//검색
		String search_name="길동_100";
		//ArrayList를 이용해서 검색(순차검색)
		int count=0;
		for(int i=0;i< p_list.size();i++) {
			
			count++;
			PersonVo p = p_list.get(i);
			//해당객체 찾은경우
			if(p.getName().equals(search_name)) {
				System.out.printf("검색횟수:%d\n",count);
				System.out.println(p);
				break;
			}
		}
		
		//Map을 이용해서 검색
		PersonVo p1 = p_map.get(search_name);
		System.out.printf("[%s] 검색결과: %s\n",search_name,p1);
			
		
		
		
	}

}
