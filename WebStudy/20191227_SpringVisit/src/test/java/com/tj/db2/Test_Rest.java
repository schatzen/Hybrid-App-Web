package com.tj.db2;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.client.RestTemplate;

public class Test_Rest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		RestTemplate rest = new RestTemplate();
		
		String jsonStr = rest.getForObject("http://localhost:9090/db2/visits",
				                    String.class, 
				                    1);
		System.out.println(jsonStr);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Map map = mapper.readValue(jsonStr, Map.class);
		
		List list = (List)map.get("list");
		
		for(Object ob:list) {
			System.out.println(ob);
		}
		
		
	}

}
