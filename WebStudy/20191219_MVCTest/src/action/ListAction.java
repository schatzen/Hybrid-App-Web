package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//POJO(Plain Old Java Object):�����ڹٰ�ü

public class ListAction /* extends Object */ {

	public String execute(HttpServletRequest request,HttpServletResponse response)
	{
        // ������ζ��.. Dao���ؼ� ����� �����;�... 		
		List<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("JSP");
		list.add("Oracle");
		list.add("Android");
		list.add("IOS");
		
		//request binding
		request.setAttribute("list", list);
		
		
		return "list.jsp";//����ؾߵ� View Page
	}
}
