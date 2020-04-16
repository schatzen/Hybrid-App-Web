package com.tj.ttt;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/test.do")
	@ResponseBody
	public Map test() {
		
		Map map = new HashMap();
		map.put("name", "홍길동");
		map.put("age", 20);
		map.put("addr", "서울 마포 상수");
				
		return map;
	}
	
	
	
	
	
}
