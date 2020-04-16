package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Test2Dao;
import dao.TestDao;

public class TestServiceImpl implements TestService {

	TestDao  test_dao;
	Test2Dao test2_dao; 
	
	public void setTest_dao(TestDao test_dao) {
		this.test_dao = test_dao;
	}

	public void setTest2_dao(Test2Dao test2_dao) {
		this.test2_dao = test2_dao;
	}



	@Override
	public Map list() {
		// TODO Auto-generated method stub
		
		//long start = System.currentTimeMillis();
		
		List sido_list 	= test_dao.list();
		List fruit_list = test2_dao.list();
		
		Map map = new HashMap();
		map.put("sido_list",  sido_list);
		map.put("fruit_list", fruit_list);
		
		try {
			Thread.sleep(1234);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//long end = System.currentTimeMillis();
		//System.out.println("����ð�:" + (end-start) +"(ms)");
		
		
		return map;
	}

}
