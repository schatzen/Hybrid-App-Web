package controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	Map<String, String> actionMap = new HashMap<String, String>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String location = config.getInitParameter("location");
		String filename = config.getInitParameter("filename");
		//System.out.printf("%s%s", location,filename);;
		
		//XML Parser
		SAXBuilder sb = new SAXBuilder();
		// /WEB-INF/ =>절대경로 얻어오기
		String path = config.getServletContext().getRealPath(location);
		File f = new File(path, filename);
		//System.out.println(f);
		try {
			Document doc =  sb.build(f);
			Element  root =doc.getRootElement();
			
			List<Element> list = root.getChildren("action");
			
			for(Element action : list) {
				String name = action.getAttributeValue("name");
				String class_name = action.getAttributeValue("class");
				
				//System.out.println(name + "/" + class_name);
				actionMap.put(name, class_name);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uri = request.getRequestURI();
		//String url = request.getRequestURL().toString();
		//System.out.println("url:" + url);
		//System.out.println("uri:" + uri);
		
		// 0123456789012345678901234
		// /20191219_MVCTest/*.do
		// /20191219_MVCTest/list.do
		// /20191219_MVCTest/view.do?book=Java
		// /20191219_MVCTest/delete.do?book=Java
		
		//  /위치를 뒤쪽부터 검색
		int index = uri.lastIndexOf("/");
		
		String im = uri.substring(0,index);
		index = im.lastIndexOf("/");
		
		//System.out.println(index);
		String cmd = uri.substring(index).replace(".do", "");
		//System.out.println(cmd);
		
		
		String result_page="";
		
		String class_name=actionMap.get(cmd);
		if(class_name==null || class_name.isEmpty()) return;
				
		
		try {
			
			Class c = Class.forName(class_name);
			Object ob = c.newInstance();
			Method method = c.getDeclaredMethod("execute",HttpServletRequest.class, HttpServletResponse.class);
			result_page = (String)method.invoke(ob, request,response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//목록조회
		/*
		 * if(cmd.equals("list")) {
		 * 
		 * ListAction action = new ListAction(); 
		 * result_page = action.execute(request,response);
		 * 
		 * }else if(cmd.equals("view")) {
		 * 
		 * ViewAction action = new ViewAction(); result_page = action.execute(request,
		 * response);
		 * 
		 * }else if(cmd.equals("delete")) {
		 * 
		 * DeleteAction action = new DeleteAction(); result_page =
		 * action.execute(request, response); }
		 */
		
		
		
		if(result_page.isEmpty())return;
		
		if(result_page.contains("responseBody:")) {
			 
			// result_page = "redirect:list.do"
			result_page = result_page.replace("responseBody:", "");
			
			response.setContentType("text/plain; chraset=utf-8;");
			response.getWriter().print(result_page);
	        
		}else if(result_page.contains("redirect:")) {
		 
			// result_page = "redirect:list.do"
			result_page = result_page.replace("redirect:", "");
			//redirect
	        response.sendRedirect(result_page);
	        
		}else {
		
			//forward
			RequestDispatcher disp 
			  = request.getRequestDispatcher(result_page);
	        disp.forward(request, response);
	        
		}
		
		
		
        
        
        
		
		
		
		
		
	}
}