package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//POJO(Plain Old Java Object):순수자바객체

public class ListAction /* extends Object */ {

	public String execute(HttpServletRequest request,HttpServletResponse response)
	{
        // 원래대로라면.. Dao통해서 목록을 가져와야... 		
		List<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("JSP");
		list.add("Oracle");
		list.add("Android");
		list.add("IOS");
		
		//request binding
		request.setAttribute("list", list);
		
		
		return "list.jsp";//출력해야될 View Page
	}
}
