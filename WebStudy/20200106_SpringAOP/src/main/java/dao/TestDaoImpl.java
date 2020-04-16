package dao;

import java.util.ArrayList;
import java.util.List;

public class TestDaoImpl  implements TestDao{

	@Override
	public List list() {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		
		list.add("서울");
		list.add("경기");
		list.add("인천");
		list.add("대전");
		list.add("강원");
		
		return list;
	}

}
