package com.tj.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVo;

@Controller
public class JSONConvertController {

	@RequestMapping("/test_map.do")
	@ResponseBody
	public Map test_map() {
		
		Map map = new HashMap();
		map.put("user_id", "hong");
		map.put("user_name", "홍길동");
		map.put("user_age", 20);
		
		return map;
	}
	
	@RequestMapping("/test_person.do")
	@ResponseBody
	public PersonVo test_person() {
		
		PersonVo p = new PersonVo("일길동", 30, "010-111-1234");
		
		return p;
	}
	
	
	@RequestMapping("/test_arraylist.do")
	@ResponseBody
	public List test_arraylist() {
		
		List<PersonVo> list = new ArrayList<PersonVo>();
		
		list.add(new PersonVo("일길동", 21, "010-111-1234"));
		list.add(new PersonVo("이길동", 22, "010-211-1234"));
		list.add(new PersonVo("삼길동", 23, "010-311-1234"));
		
		return list;
		
	}
	
	/*
	   /test_arraylist.do결과
	     
	   [
		   {"name":"일길동","age":21,"tel":"010-111-1234"},
		   {"name":"이길동","age":22,"tel":"010-211-1234"},
		   {"name":"삼길동","age":23,"tel":"010-311-1234"}
	   ] 
	 */
	
	@RequestMapping("/test_arraylist2.do")
	@ResponseBody
	public Map test_arraylist2() {
		
		List<PersonVo> list = new ArrayList<PersonVo>();
		
		list.add(new PersonVo("일길동", 21, "010-111-1234"));
		list.add(new PersonVo("이길동", 22, "010-211-1234"));
		list.add(new PersonVo("삼길동", 23, "010-311-1234"));
		
		Map map = new HashMap();
		map.put("p_list", list);
		
		return map;
	}
	
	/*
	 
	 {
	   "p_list":
	       [
	         {"name":"일길동","age":21,"tel":"010-111-1234"},
	         {"name":"이길동","age":22,"tel":"010-211-1234"},
	         {"name":"삼길동","age":23,"tel":"010-311-1234"}
	       ]
	 }
	  
	 */
	
	/*
	    { 
	      "name" : {"last_name":"홍","first_name":"길동"},
	      "age"  : 20,
	      "tel"  : {"home":"02-111-2345","phone":"010-111-2222"},
	      "hobby": ["낚시","영화","독서"] 
	    }
	 */
	@RequestMapping("/test_question.do")
	@ResponseBody
	public Map test_question() {
		Map map = new HashMap();
		
		Map nameMap = new HashMap();
		nameMap.put("last_name", "홍");
		nameMap.put("first_name", "길동");
		
		map.put("name", nameMap);
		map.put("age", 20);
		
		Map telMap = new HashMap();
		telMap.put("home", "02-111-2345");
		telMap.put("phone", "101-111-2345");
		map.put("tel", telMap);
		
		
		String [] hobby_array = {"낚시","운동","영화"};
		map.put("hobby", hobby_array);
				
		return map;
	}
	
	
	@RequestMapping("/test_set.do")
	@ResponseBody
	public Map test_set() {
		
		Map map = new HashMap();
		
		Set set = new HashSet();
		set.add("사과");
		set.add("참외");
		set.add("포도");
		
		String [] sido_array = {"서울","경기","인천"};
		
		List<String> book_list = new ArrayList<String>();
		book_list.add("Java");
		book_list.add("JSP");
		book_list.add("Android");
		book_list.add("Spring");
		
		map.put("fruit_list", set);      //Set
		map.put("sido_list", sido_array);//Array
		map.put("book_list", book_list); //ArrayList
				
		return map;
	}
	
	/*
	   {
	    "sido_list" :["서울","경기","인천"],
	    "book_list" :["Java","JSP","Android","Spring"],
	    "fruit_list":["포도","사과","참외"]
	   }
	*/
	
	
	
	
	
	
	
	
	
	
}
