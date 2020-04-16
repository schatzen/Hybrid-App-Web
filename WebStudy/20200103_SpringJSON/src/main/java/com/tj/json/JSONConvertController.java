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
		map.put("user_name", "ȫ�浿");
		map.put("user_age", 20);
		
		return map;
	}
	
	@RequestMapping("/test_person.do")
	@ResponseBody
	public PersonVo test_person() {
		
		PersonVo p = new PersonVo("�ϱ浿", 30, "010-111-1234");
		
		return p;
	}
	
	
	@RequestMapping("/test_arraylist.do")
	@ResponseBody
	public List test_arraylist() {
		
		List<PersonVo> list = new ArrayList<PersonVo>();
		
		list.add(new PersonVo("�ϱ浿", 21, "010-111-1234"));
		list.add(new PersonVo("�̱浿", 22, "010-211-1234"));
		list.add(new PersonVo("��浿", 23, "010-311-1234"));
		
		return list;
		
	}
	
	/*
	   /test_arraylist.do���
	     
	   [
		   {"name":"�ϱ浿","age":21,"tel":"010-111-1234"},
		   {"name":"�̱浿","age":22,"tel":"010-211-1234"},
		   {"name":"��浿","age":23,"tel":"010-311-1234"}
	   ] 
	 */
	
	@RequestMapping("/test_arraylist2.do")
	@ResponseBody
	public Map test_arraylist2() {
		
		List<PersonVo> list = new ArrayList<PersonVo>();
		
		list.add(new PersonVo("�ϱ浿", 21, "010-111-1234"));
		list.add(new PersonVo("�̱浿", 22, "010-211-1234"));
		list.add(new PersonVo("��浿", 23, "010-311-1234"));
		
		Map map = new HashMap();
		map.put("p_list", list);
		
		return map;
	}
	
	/*
	 
	 {
	   "p_list":
	       [
	         {"name":"�ϱ浿","age":21,"tel":"010-111-1234"},
	         {"name":"�̱浿","age":22,"tel":"010-211-1234"},
	         {"name":"��浿","age":23,"tel":"010-311-1234"}
	       ]
	 }
	  
	 */
	
	/*
	    { 
	      "name" : {"last_name":"ȫ","first_name":"�浿"},
	      "age"  : 20,
	      "tel"  : {"home":"02-111-2345","phone":"010-111-2222"},
	      "hobby": ["����","��ȭ","����"] 
	    }
	 */
	@RequestMapping("/test_question.do")
	@ResponseBody
	public Map test_question() {
		Map map = new HashMap();
		
		Map nameMap = new HashMap();
		nameMap.put("last_name", "ȫ");
		nameMap.put("first_name", "�浿");
		
		map.put("name", nameMap);
		map.put("age", 20);
		
		Map telMap = new HashMap();
		telMap.put("home", "02-111-2345");
		telMap.put("phone", "101-111-2345");
		map.put("tel", telMap);
		
		
		String [] hobby_array = {"����","�","��ȭ"};
		map.put("hobby", hobby_array);
				
		return map;
	}
	
	
	@RequestMapping("/test_set.do")
	@ResponseBody
	public Map test_set() {
		
		Map map = new HashMap();
		
		Set set = new HashSet();
		set.add("���");
		set.add("����");
		set.add("����");
		
		String [] sido_array = {"����","���","��õ"};
		
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
	    "sido_list" :["����","���","��õ"],
	    "book_list" :["Java","JSP","Android","Spring"],
	    "fruit_list":["����","���","����"]
	   }
	*/
	
	
	
	
	
	
	
	
	
	
}
