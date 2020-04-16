package dao;

import java.util.ArrayList;
import java.util.List;

public class Test2DaoImpl  implements Test2Dao{

	@Override
	public List list() {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.add("사과");
		list.add("참외");
		list.add("포도");
		list.add("수박");
		list.add("딸기");
		
		return list;
	}

}
